package com.epson.epos2_printer.ui

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.epson.epos2_printer.DiscoveryActivity
import com.epson.epos2_printer.R
import com.epson.epos2_printer.repository.QRepository
import com.epson.epos2_printer.utils.Constants
import com.epson.epos2_printer.utils.Constants.BASE_URL
import com.epson.epos2_printer.utils.Constants.BASE_URL_LOCAL
import com.epson.epos2_printer.utils.Constants.BRANCH_AUTH
import com.epson.epos2_printer.utils.Constants.BRANCH_AUTH_ID
import com.epson.epos2_printer.utils.Constants.BRANCH_AUTH_NAME
import com.epson.epos2_printer.utils.Constants.BRANCH_DEFAULT_VALUE
import com.epson.epos2_printer.utils.Constants.LOCAL_DATABASE
import com.epson.epos2_printer.utils.Constants.LOCAL_SERVER_NAME
import com.epson.epos2_printer.utils.Constants.LOCAL_SERVER_NAME_AUTH
import com.epson.epos2_printer.utils.Constants.SERVER_AUTH
import com.epson.epos2_printer.utils.Constants.SERVER_NAME
import com.epson.epos2_printer.utils.Constants.SERVER_NAME_AUTH
import com.epson.epos2_printer.utils.NothingSelectedSpinnerAdapter
import com.epson.epos2_printer.utils.Resource
import com.epson.epos2_printer.viewmodel.QViewModel
import com.epson.epos2_printer.viewmodel.QViewModelProviderFactory
import com.jakewharton.processphoenix.ProcessPhoenix
import com.shashank.sony.fancytoastlib.FancyToast
import com.yariksoffice.lingver.Lingver
import kotlinx.android.synthetic.main.activity_setting_new.*
import java.util.*
import kotlin.collections.ArrayList


class SettingActivity : AppCompatActivity() {

    private lateinit var viewModel: QViewModel

    private val REQUEST_PERMISSION = 100
    var arrayBranches: ArrayList<Int> = ArrayList()
    var branchSelected = -1
    private var branchCheck = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

      requestRuntimePermission()
        // settingLanguage()
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)


        setContentView(R.layout.activity_setting_new)

        //show toast message todo
       // updateBranchPreference(1,"jahra")




        val qRepository = QRepository()
        val viewModelProviderFactory =
                QViewModelProviderFactory(
                        application,
                        qRepository
                )
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(QViewModel::class.java)

        clickListener()
        mSwitchLocal.isChecked = getServerPreference()

        //settingServerName()

        setObserver()
        viewModel.getBranchesApi()
        spinnerListener()

        settingBranchName()

   /*     if(isCanWriteSettings(this))
            setupLight(this,255)//0~255
        else
            requestCanWriteSettings(this)*/

    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(isCanWriteSettings(this))
            setupLight(this,255)//0~255
        else
            requestCanWriteSettings(this)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        //This is used to hide/show 'Status Bar' & 'System Bar'. Swip bar to get it as visible.
        val decorView = window.decorView
        if (hasFocus) {
            decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
        }
    }

    override fun onResume() {
        super.onResume()
        try {
            val decorView = window.decorView
            decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
        } catch (e: Exception) {
            Log.d("TAG", "onResume: Exception 1-4 ")
            e.printStackTrace()
        }
    }

    fun setupLight(context: Context, light: Int) {
        try {
            val brightnessMode = Settings.System.getInt(
                context.contentResolver,
                Settings.System.SCREEN_BRIGHTNESS_MODE
            )
            if (brightnessMode == Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC) {
                Settings.System.putInt(
                    context.contentResolver,
                    Settings.System.SCREEN_BRIGHTNESS_MODE,
                    Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL
                )
            }
            Settings.System.putInt(
                context.contentResolver,
                Settings.System.SCREEN_BRIGHTNESS,
                light
            )
        } catch (e: Exception) {
            Log.e("setupLight","Exception $e")
        }
    }

    fun isCanWriteSettings(context: Context): Boolean {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M || Settings.System.canWrite(context)
    }


    fun requestCanWriteSettings(activity: Activity){
        if (isCanWriteSettings(context = activity))
            return //not need
        try {
            val intent = Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS)
            intent.data = Uri.parse("package:" + activity.packageName)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            activity.startActivityForResult(intent, 0)
        }catch (e: Exception){
            Log.e("requestCanWriteSettings","requestCanWriteSettings $e")
        }
    }

    //******************************************* clickListener ******************************************************
    private fun clickListener() {
        mSwitchLocal.setOnClickListener {
            var getServer = getServerPreference()
            updateServerPreference(!getServer)
           // updateServerPreference(mSwitchLocal.isChecked)

            var arrayBranchesName: ArrayList<String> = ArrayList()
            val adapter: ArrayAdapter<String> =
                    ArrayAdapter<String>(this, R.layout.spinner_item_text, arrayBranchesName)
            adapter.setDropDownViewResource(R.layout.spinner_item_allign)

            val mNothing = NothingSelectedSpinnerAdapter(
                    adapter,
                    R.layout.nothing_selected,
                    this
            )
            mSpBranches.adapter = mNothing

            updateBranchPreference(BRANCH_DEFAULT_VALUE, "")
            viewModel.getBranchesApi()
         //   settingServerName()
        }
        mToolbar.setNavigationOnClickListener {
            setResult(Activity.RESULT_OK)
            finish()
        }

        mConfigurePrinter.setOnClickListener {
            val intent = Intent(
                    this, DiscoveryActivity::class.java
            )
            startActivity(intent)
        }
        mDefault.setOnClickListener {
            ProcessPhoenix.triggerRebirth(this);
        }

    /*    mPort.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {

                if (mPort.text.toString().trim().isNotEmpty())
                    mPort.hideKeyboard()
                if (getServerPreference()) {
                    updateLocalServerNamePreference(mPort.text.toString().trim())
                } else {
                    updateServerNamePreference(mPort.text.toString().trim())
                }

                true

            } else false
        }*/
    }

    private fun spinnerListener() {
        mSpBranches.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
                if (branchCheck == 1) {
                    if (arrayBranches.size > 0) {
                        if (position != 0) {
                            branchSelected = arrayBranches[position - 1]
                            showToastInfo("Branch Selected with id $branchSelected")
                            updateBranchPreference(branchSelected, mSpBranches.selectedItem.toString())
                            settingBranchName()
                        } else {
                            branchSelected = -1
                        }
                    }
                }
                if (branchCheck == 0) {
                    branchCheck = 1
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }


    //******************************************* observer ******************************************************
    private fun setObserver() {
        viewModel.branches.observe(this, Observer { response ->

            when (response) {
                is Resource.Success -> {
                    if (response.data != null) {
                        val arrayBranchesName: ArrayList<String> = ArrayList()
                        arrayBranches =  ArrayList()
                        for (list in response.data) {
                            list.Branch_IsActive?.let {
                                if (list.Branch_IsActive!!) {
                                    if (list.Branch_PK_ID != null && list.Branch_Name_EN != null) {
                                        arrayBranches.add(list.Branch_PK_ID!!)
                                        arrayBranchesName.add(list.Branch_Name_EN.toString())
                                    }
                                }
                            }
                        }
                        if (arrayBranchesName.isNotEmpty()) {
                            settingBranchesSpinner(arrayBranchesName)
                        } else {
                            showToastInfo("No Active Branches are found")
                        }
                    } else {
                        showToastInfo("No Branches are found")
                    }
                }

                is Resource.Error -> {
                    showToastFail(response.message.toString())
                }

            }


        })
    }


    //******************************************* setting Spinner ******************************************************
    private fun settingBranchesSpinner(spinnerArray: List<String?>?) {
        if (spinnerArray != null) {
            if (spinnerArray.isNotEmpty()) {
                val adapter: ArrayAdapter<String> =
                        ArrayAdapter<String>(this, R.layout.spinner_item_text, spinnerArray)!!
                adapter.setDropDownViewResource(R.layout.spinner_item_allign)

                val mNothing = NothingSelectedSpinnerAdapter(
                        adapter,
                        R.layout.nothing_selected,
                        this
                )
                mSpBranches.adapter = mNothing
            }
        }
    }


    private fun showToastSuccess(message: String) {
        FancyToast.makeText(
                this, message, FancyToast.LENGTH_SHORT,
                FancyToast.SUCCESS, false
        ).show()
    }

    private fun showToastFail(message: String) {
        FancyToast.makeText(
                this, message, FancyToast.LENGTH_SHORT,
                FancyToast.ERROR, false
        ).show()
    }

    private fun showToastInfo(message: String) {
        FancyToast.makeText(
                this, message, FancyToast.LENGTH_SHORT,
                FancyToast.INFO, false
        ).show()
    }


    //**************************************************************************** language ************************************************************************
    private fun settingLanguage() {
        if (Locale.getDefault().displayLanguage != Constants.DISPLAY_LNG_ENGLISH) {
            Lingver.getInstance().setLocale(this, Constants.LNG_ENGLISH)
            val intent = Intent(
                    this, SettingActivity::class.java
            )
            startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK))
        }
    }

    private fun settingBranchName() {
        val name = getPreference()
        if (name != null && name.isNotEmpty()) {
            mSelectedBranch.text = "Selected Branch $name"
            mSelectedBranch.visibility = View.VISIBLE
        } else {
            mSelectedBranch.visibility = View.GONE
        }

        val id = getPreferenceId()
        if (id != null && id != BRANCH_DEFAULT_VALUE) {
            mSelectedBranchId.text = "Selected Branch id $id"
            mSelectedBranchId.visibility = View.VISIBLE
        } else {
            mSelectedBranchId.visibility = View.GONE
        }

        try {
            val versionName: String = getPackageManager()
                    .getPackageInfo(getPackageName(), 0).versionName

            val versionCode = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                getPackageManager()
                        .getPackageInfo(getPackageName(), 0).longVersionCode
            } else {
                0
            }


            if (versionName != null && versionName.isNotEmpty()) {
                mVersionName.text = "Version Name $versionName $versionCode"
                mVersionName.visibility = View.VISIBLE
            } else {
                mVersionName.visibility = View.GONE
            }
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()

        }
    }

 /*   private fun settingServerName() {
        if (getServerPreference()) {
            mPort.setText(getServerLocalNamePreference())
        } else {
            mPort.setText(getServerNamePreference())
        }
    }*/

    //******************************************* prefrence ***********************************
    private fun getPreference(): String? {
        val pref = applicationContext.getSharedPreferences(
                BRANCH_AUTH,
                0
        ) // 0 - for private mode

        return pref.getString(BRANCH_AUTH_NAME, "")

    }

    //******************************************* prefrence ***********************************
    private fun getPreferenceId(): Int? {
        val pref = applicationContext.getSharedPreferences(
                BRANCH_AUTH,
                0
        ) // 0 - for private mode

        return pref.getInt(BRANCH_AUTH_ID, BRANCH_DEFAULT_VALUE);

    }

    private fun getServerPreference(): Boolean {
        val pref = applicationContext.getSharedPreferences(
                SERVER_AUTH,
                0
        ) // 0 - for private mode

        return pref.getBoolean(LOCAL_DATABASE, false)

    }

    private fun getServerLocalNamePreference(): String? {
        val pref = applicationContext.getSharedPreferences(
                LOCAL_SERVER_NAME_AUTH,
                0
        ) // 0 - for private mode

        return pref.getString(LOCAL_SERVER_NAME, BASE_URL_LOCAL)

    }

    private fun getServerNamePreference(): String? {
        val pref = applicationContext.getSharedPreferences(
                SERVER_NAME_AUTH,
                0
        ) // 0 - for private mode

        return pref.getString(SERVER_NAME, BASE_URL)

    }

    //************************************************ update preference ********************************
    private fun updateBranchPreference(id: Int, name: String) {
        val pref = applicationContext.getSharedPreferences(
                BRANCH_AUTH,
                0
        ) // 0 - for private mode
        val editor = pref.edit()
        editor.putInt(BRANCH_AUTH_ID, id)
        editor.putString(BRANCH_AUTH_NAME, name)
        editor.apply() // commit changes
    }

    private fun updateServerPreference(bol: Boolean) {
        val pref = applicationContext.getSharedPreferences(
                SERVER_AUTH,
                0
        ) // 0 - for private mode
        val editor = pref.edit()
        editor.putBoolean(LOCAL_DATABASE, bol)
        editor.apply() // commit changes
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

/*    private fun updateLocalServerNamePreference(name: String) {
        val pref = applicationContext.getSharedPreferences(
                LOCAL_SERVER_NAME_AUTH,
                0
        ) // 0 - for private mode
        val editor = pref.edit()
        editor.putString(LOCAL_SERVER_NAME, name)
        editor.apply() // commit changes
    }

    private fun updateServerNamePreference(name: String) {
        val pref = applicationContext.getSharedPreferences(
                SERVER_NAME_AUTH,
                0
        ) // 0 - for private mode
        val editor = pref.edit()
        editor.putString(SERVER_NAME, name)
        editor.apply()
    }


    //************************************************ set default *************************************
    private fun setDefault(){
        updateLocalServerNamePreference(BASE_URL_LOCAL)
        updateServerNamePreference(BASE_URL)
        updateServerPreference(false)
        mSwitchLocal.isChecked = false
        settingServerName()
    }*/
 */
}