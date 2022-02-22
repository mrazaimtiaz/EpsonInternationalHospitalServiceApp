package com.epson.epos2_printer.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.epson.epos2_printer.R;
import com.epson.epos2_printer.models.DeviceItem;
import com.google.android.material.appbar.MaterialToolbar;
import com.shashank.sony.fancytoastlib.FancyToast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import static com.epson.epos2_printer.utils.Constants.BLUETOOTH_AUTH;
import static com.epson.epos2_printer.utils.Constants.BLUETOOTH_NAME;

public class MyScannerActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    BluetoothAdapter BTAdapter;

    private ArrayList<HashMap<String, String>> mPrinterList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_scanner);

        Log.d("TAG", "onCreate: called scanner");


        MaterialToolbar materialToolbar = findViewById(R.id.mToolbar);

        materialToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mPrinterList = new ArrayList<HashMap<String, String>>();
        SimpleAdapter mPrinterListAdapter = new SimpleAdapter(this, mPrinterList, R.layout.list_at,
                new String[]{"PrinterName", "Target"},
                new int[]{R.id.PrinterName, R.id.Target});
        ListView list = (ListView)findViewById(R.id.lstReceiveData);
        list.setAdapter(mPrinterListAdapter);
        list.setOnItemClickListener(this);


        BTAdapter = BluetoothAdapter.getDefaultAdapter();
        // Phone does not support Bluetooth so let the user know and exit.
        if (BTAdapter == null) {
            new AlertDialog.Builder(this)
                    .setTitle("Not compatible")
                    .setMessage("Your phone does not support Bluetooth")
                    .setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            System.exit(0);
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();


        }else{


            Log.d("DEVICELIST", "Super called for DeviceListFragment onCreate\n");
            ArrayList<DeviceItem> deviceItemList = new ArrayList<DeviceItem>();

            Set<BluetoothDevice> pairedDevices = BTAdapter.getBondedDevices();

            Log.d("TAG", "run: mDiscoveryListener called size " + pairedDevices.size());
            if (pairedDevices.size() > 0) {
                for (BluetoothDevice deviceInfo : pairedDevices) {
                    HashMap<String, String> item = new HashMap<String, String>();
                    item.put("PrinterName", deviceInfo.getName());
                    item.put("Target", deviceInfo.getAddress());

                    Log.d("TAG", "run: mDiscoveryListener called 1 " + deviceInfo.getAddress() + "  " + deviceInfo.getName());
                    mPrinterList.add(item);
                    mPrinterListAdapter.notifyDataSetChanged();
                }
            }



        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent = new Intent();

        HashMap<String, String> item  = mPrinterList.get(position);

        updateBluetoothPreference("BT:" + item.get("Target"));

        showToastSuccess("Printer Selected");
     /*   Intent intent1 = new Intent(this,MainActivity.class);
        startActivity(intent1);*/
        setResult(RESULT_OK, intent);

        finish();
    }

    //************************************************ update preference ********************************
    private void updateBluetoothPreference(String name) {
        SharedPreferences pref = getApplicationContext().getSharedPreferences(
                BLUETOOTH_AUTH,
                0
        ); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(BLUETOOTH_NAME, name);
        editor.apply(); // commit changes
    }

    private void showToastSuccess( String message) {
        FancyToast.makeText(
                this, message, FancyToast.LENGTH_SHORT,
                FancyToast.SUCCESS, false
        ).show();
    }
}