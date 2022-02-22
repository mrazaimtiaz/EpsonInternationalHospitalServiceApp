package com.epson.epos2_printer.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.epson.epos2.printer.Printer
import com.epson.epos2_printer.R
import com.epson.epos2_printer.utils.Constants
import com.epson.epos2_printer.utils.Constants.BLUETOOTH_AUTH
import com.epson.epos2_printer.utils.Constants.BLUETOOTH_NAME
import com.shashank.sony.fancytoastlib.FancyToast
import kotlinx.android.synthetic.main.activity_manual.*

class ManualActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manual)

        if(getAddressNamePreference() != Constants.BRANCH_DEFAULT_VALUE.toString()){
            mBTAddress.setText(getAddressNamePreference())
        }
        clickListener()
    }

    private fun clickListener(){

        mToolbar.setNavigationOnClickListener {
            finish()
        }

        mBtnBt.setOnClickListener {
            if(mBTAddress.text.isNotEmpty()){
                updateBluetoothPreference(mBTAddress.text.toString().trim())
                showToastInfo("Added BT Address")
                finish()
            }
        }

    }

    private fun showToastInfo(message: String) {
        FancyToast.makeText(
                this, message, FancyToast.LENGTH_SHORT,
                FancyToast.INFO, false
        ).show()
    }


    private fun getAddressNamePreference(): String? {
        val pref = applicationContext.getSharedPreferences(
                BLUETOOTH_AUTH,
                0
        ) // 0 - for private mode

        return pref.getString(BLUETOOTH_NAME, Constants.BRANCH_DEFAULT_VALUE.toString());

    }

    private fun updateBluetoothPreference(name: String) {
        val pref = applicationContext.getSharedPreferences(
                BLUETOOTH_AUTH,
                0
        ) // 0 - for private mode
        val editor = pref.edit()
        editor.putString(BLUETOOTH_NAME, name)
        editor.apply() // commit changes
    }
}