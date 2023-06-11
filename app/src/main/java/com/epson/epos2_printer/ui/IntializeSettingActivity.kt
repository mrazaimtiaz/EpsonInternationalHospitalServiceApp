package com.epson.epos2_printer.ui

import android.Manifest
import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import androidx.annotation.NonNull
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.epson.epos2_printer.DiscoveryActivity
import com.epson.epos2_printer.R
import com.jakewharton.processphoenix.ProcessPhoenix
import kotlinx.android.synthetic.main.activity_intialize_setting.*
import kotlinx.android.synthetic.main.activity_intialize_setting.mConfigurePrinter
import kotlinx.android.synthetic.main.activity_intialize_setting.mDefault
import kotlinx.android.synthetic.main.activity_intialize_setting.mToolbar
import kotlinx.android.synthetic.main.activity_setting_new.*

class IntializeSettingActivity : AppCompatActivity() {

    private val REQUEST_PERMISSION = 100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intialize_setting)


        requestRuntimePermission()


        mToolbar.setNavigationOnClickListener {
            setResult(Activity.RESULT_OK)
            finish()
        }
        mDefault.setOnClickListener {
            val intent = Intent(
                    this, SettingActivity::class.java
            )
            startActivityForResult(intent,900)
        }
        mRestart.setOnClickListener {
            ProcessPhoenix.triggerRebirth(this);
        }

        mOpenDeviceSetting.setOnClickListener {
            val intent = Intent(Settings.ACTION_SETTINGS)
            startActivity(intent)
        }

        mConfigurePrinter.setOnClickListener {
            val intent = Intent(
                    this, DiscoveryActivity::class.java
            )
            startActivity(intent)
        }

        mOpenApp.setOnClickListener {
            try {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$packageName")))
            } catch (e: ActivityNotFoundException) {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$packageName")))
            }
        }
    }

    //******************************** permission *****************************
    private  fun requestRuntimePermission() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return
        }
        val permissionStorage: Int = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        val permissionLocation: Int = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
        val permissionLocationBackground: Int = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_BACKGROUND_LOCATION)
        val requestPermissions: MutableList<String> = java.util.ArrayList()
        if (permissionStorage == PackageManager.PERMISSION_DENIED) {
            requestPermissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }
        if (permissionLocation == PackageManager.PERMISSION_DENIED) {
            requestPermissions.add(Manifest.permission.ACCESS_COARSE_LOCATION)
        }
        if(permissionLocationBackground == PackageManager.PERMISSION_DENIED){
            requestPermissions.add(Manifest.permission.ACCESS_BACKGROUND_LOCATION)
        }
        if (!requestPermissions.isEmpty()) {
            ActivityCompat.requestPermissions(this, requestPermissions.toTypedArray(), REQUEST_PERMISSION)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, @NonNull permissions: Array<String>, @NonNull grantResults: IntArray) {
        if (requestCode != REQUEST_PERMISSION || grantResults.isEmpty()) {
            return
        }
        val requestPermissions: MutableList<String> = java.util.ArrayList()
        for (i in permissions.indices) {
            if (permissions[i] == Manifest.permission.WRITE_EXTERNAL_STORAGE && grantResults[i] == PackageManager.PERMISSION_DENIED) {
                requestPermissions.add(permissions[i])
            }
            if (permissions[i] == Manifest.permission.ACCESS_COARSE_LOCATION && grantResults[i] == PackageManager.PERMISSION_DENIED) {
                requestPermissions.add(permissions[i])
            }
        }
        if (!requestPermissions.isEmpty()) {
            ActivityCompat.requestPermissions(this, requestPermissions.toTypedArray(),REQUEST_PERMISSION)
        }
    }
}