package com.epson.epos2_printer.ui

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Point
import android.os.BatteryManager
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Base64
import android.util.Log
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.epson.epos2.Epos2Exception
import com.epson.epos2.discovery.Discovery
import com.epson.epos2.discovery.DiscoveryListener
import com.epson.epos2.discovery.FilterOption
import com.epson.epos2.printer.Printer
import com.epson.epos2.printer.PrinterStatusInfo
import com.epson.epos2.printer.ReceiveListener
import com.epson.epos2.printer.StatusChangeListener
import com.epson.epos2_printer.R
import com.epson.epos2_printer.ShowMsg
import com.epson.epos2_printer.adapter.ServiceAdapter
import com.epson.epos2_printer.api.RetrofitInstance
import com.epson.epos2_printer.api.RetrofitInstanceLocal
import com.epson.epos2_printer.models.IsService
import com.epson.epos2_printer.models.Services
import com.epson.epos2_printer.repository.QRepository
import com.epson.epos2_printer.utils.Constants
import com.epson.epos2_printer.utils.Constants.BLUETOOTH_AUTH
import com.epson.epos2_printer.utils.Constants.BLUETOOTH_NAME
import com.epson.epos2_printer.utils.Constants.BRANCH_DEFAULT_VALUE
import com.epson.epos2_printer.utils.Constants.DELAY_BRANCH_SERVICES
import com.epson.epos2_printer.utils.Constants.DELAY_CHECK_BRANCH
import com.epson.epos2_printer.utils.Constants.DISPLAY_LNG_ARABIC
import com.epson.epos2_printer.utils.Constants.EXTRA_BRANCH_ID
import com.epson.epos2_printer.utils.Constants.EXTRA_CHECKED_NUMBER
import com.epson.epos2_printer.utils.Constants.EXTRA_ERROR
import com.epson.epos2_printer.utils.Constants.EXTRA_ERROR_EN
import com.epson.epos2_printer.utils.Constants.EXTRA_MOBILE_NUMBER
import com.epson.epos2_printer.utils.Constants.INT_ARABIC
import com.epson.epos2_printer.utils.Constants.INT_ENGLISH
import com.epson.epos2_printer.utils.GridItemDecoration
import com.epson.epos2_printer.utils.Resource
import com.epson.epos2_printer.viewmodel.BackEndViewModel
import com.epson.epos2_printer.viewmodel.BackEndViewModelProviderFactory
import com.epson.epos2_printer.viewmodel.QViewModel
import com.epson.epos2_printer.viewmodel.QViewModelProviderFactory
import com.shashank.sony.fancytoastlib.FancyToast
import com.starmicronics.starioextension.ICommandBuilder
import com.starmicronics.starioextension.StarIoExt
import com.starmicronics.starioextension.StarIoExt.Emulation
import kotlinx.android.synthetic.main.activity_service.*
import kotlinx.android.synthetic.main.activity_setting_new.*
import kotlinx.android.synthetic.main.item_services.view.*
import kotlinx.coroutines.*
import java.io.IOException
import java.net.URL
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.roundToInt


class ServiceActivity : AppCompatActivity(), ReceiveListener,StatusChangeListener {

    var count: Int = 0
    private lateinit var viewModel: QViewModel
    private lateinit var serviceAdapter: ServiceAdapter



   // private var branchId = BRANCH_DEFAULT_VALUE
    private var branchId = 1
    private var checkedNumber = false
    private var mobileNumber: String? = ""

    var serviceTimer: Long = 0
    var branchTimer: Long = 0

    private val REQUEST_PERMISSION = 100

    private val DISCONNECT_INTERVAL = 500 //millseconds


    var address: String = BRANCH_DEFAULT_VALUE.toString()

    var mPrinter: Printer? = null


    private var mFilterOption: FilterOption? = null

    private var mPrinterList: java.util.ArrayList<HashMap<String, String>>? = null



/*    private val mDiscoveryListener = DiscoveryListener { deviceInfo ->
        runOnUiThread {
            val item = HashMap<String, String>()
            item["PrinterName"] = deviceInfo.deviceName
            item["Target"] = deviceInfo.target
            Log.d("TAG", "run: mDiscoveryListener called 1")
            //mPrinterList.add(item)
           // mPrinterListAdapter.notifyDataSetChanged()
        }
    }*/





/*
    private val mCallback = SendCallback { communicationResult ->
        try {

            val dialog = CommonAlertDialogFragment.newInstance("CommResultDialog")
            dialog.setTitle("Communication Result2222")
            dialog.setMessage(Communication.getCommunicationResultMessage(communicationResult))
            dialog.setPositiveButton("OK")
        } catch (e: Exception) {
            Log.d("TAG", "onResume: Exception 1 ")
            e.printStackTrace()
        }
    }
*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val size = Point()
        requestWindowFeature(Window.FEATURE_NO_TITLE)

        this.windowManager.defaultDisplay.getSize(size)
        requestRuntimePermission()
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.activity_service)

        //screensavercode
        startTimer()


        val qRepository = QRepository()
        val viewModelProviderFactory =
                QViewModelProviderFactory(
                        application,
                        qRepository
                )
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(QViewModel::class.java)

        lateinit var backEndViewModel: BackEndViewModel

       /* val backEndViewModelProviderFactory =
            BackEndViewModelProviderFactory(
                application,
                qRepository
            )
        backEndViewModel = ViewModelProvider(this, backEndViewModelProviderFactory).get(
            BackEndViewModel::class.java)


        Log.d("TAG", "called backend: ")
        backEndViewModel.setDispenserSettings()

        CoroutineScope(Dispatchers.Main).launch {
            delay(DELAY_CHECK_BRANCH)
            backEndViewModel.getCounter()
            backEndViewModel.sendDisplayMessage()
            backEndViewModel.timerDisplay()
        }*/

        mobileNumber = intent.getStringExtra(EXTRA_MOBILE_NUMBER)
        checkedNumber = intent.getBooleanExtra(EXTRA_CHECKED_NUMBER, false)
       // branchId = intent.getIntExtra(EXTRA_BRANCH_ID, BRANCH_DEFAULT_VALUE)

        setupRecyclerView()
      //  Log.d("TAG", "onCreate: printer status ${mPrinter?.status?.let { makeErrorMessage(it) }}")
        clickListener()
        observer()
        if (branchId != BRANCH_DEFAULT_VALUE) {
            viewModel.getServices(branchId)
        } else {
        //   setIntentError(getString(R.string.choose_a_branch_admin))
        }


        if (branchId != BRANCH_DEFAULT_VALUE)
            viewModel.isBranchOpen(branchID = branchId)

       mFilterOption = FilterOption()
       mFilterOption?.setDeviceType(Discovery.TYPE_PRINTER)
       mFilterOption?.setEpsonFilter(Discovery.FILTER_NAME)

        try {

            Discovery.start(this, mFilterOption,  DiscoveryListener { deviceInfo ->
                runOnUiThread {
                    val item = HashMap<String, String>()
                    item["PrinterName"] = deviceInfo.deviceName
                    item["Target"] = deviceInfo.target
                    Log.d("TAG", "run: mDiscoveryListener called 1 ${ item["Target"]}")

                        item["Target"]?.let { updateBluetoothPreference(it) }

                    mPrinterList?.add(item)
                    // mPrinterListAdapter.notifyDataSetChanged()
                }
            })




        } catch (e: java.lang.Exception) {
         //   ShowMsg.showException(e, "start", this)
        }


        initializeObject()

        try {
            com.epson.epos2.Log.setLogSettings(this, com.epson.epos2.Log.PERIOD_TEMPORARY, com.epson.epos2.Log.OUTPUT_STORAGE, null, 0, 1, com.epson.epos2.Log.LOGLEVEL_LOW)
        } catch (e: java.lang.Exception) {
            ShowMsg.showException(e, "setLogSettings", this)
        }


        val batteryStatus: Intent? = IntentFilter(Intent.ACTION_BATTERY_CHANGED).let { ifilter ->
            this.registerReceiver(null, ifilter)
        }
        val status: Int = batteryStatus?.getIntExtra(BatteryManager.EXTRA_STATUS, -1) ?: -1
        val isCharging: Boolean = status == BatteryManager.BATTERY_STATUS_CHARGING
                || status == BatteryManager.BATTERY_STATUS_FULL

// How are we charging?
        val chargePlug: Int = batteryStatus?.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1) ?: -1
        val usbCharge: Boolean = chargePlug == BatteryManager.BATTERY_PLUGGED_USB
        val acCharge: Boolean = chargePlug == BatteryManager.BATTERY_PLUGGED_AC


        val batteryPct: Float? = batteryStatus?.let { intent ->
            val level: Int = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
            val scale: Int = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
            level * 100 / scale.toFloat()
        }
        CoroutineScope(Dispatchers.Main).launch{
            delay(800)
            if(isCharging){
                viewModel.sendTabletStatus(branchId,"Device Battery", batteryPct.toString() + " Charging")
            }else{
                viewModel.sendTabletStatus(branchId,"Device Battery", batteryPct.toString() + " Not Charging")
            }
        }



        /*      if(getBoolNamePreference()){
                  Log.d("TAG", "onCreate: int the preference  ")
                  CoroutineScope(Dispatchers.Main).launch {
                      updateBoolPreference(false)
                      if (!connectPrinter()) {
                          mPrinter!!.clearCommandBuffer()
                      }
                      Log.d("TAG", "print: called 4")
                  }

          }*/
        sendVersion()
        val intent = Intent(
                this, IntializeActivity::class.java
        )
        startActivity(intent)
    }


//screensavercode
    val timer = object: CountDownTimer(Constants.DELAY_SCREENSAVER, 1000) {
        override fun onTick(millisUntilFinished: Long) {}

        override fun onFinish() {
            Log.d("TAG", "onFinish: called ")
            finish()
            val intent = Intent(
                this@ServiceActivity, ScreenSaverActivity::class.java
            )
            startActivityForResult(intent,900)
            // startActivity(intent)

        }
    }


    private fun cancelTimer() {
        try {
            CoroutineScope(Dispatchers.IO).launch {
                timer.cancel()
            }
        } catch (E: java.lang.Exception) {

        }

    }

    private fun startTimer() {
        try {
            CoroutineScope(Dispatchers.IO).launch {
                timer.start()
            }
        } catch (E: java.lang.Exception) {

        }
    }

        override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        // dismiss shown snackbar if user tapped anywhere outside snackbar
            //screensavercode
            cancelTimer()
            //screensavercode
            startTimer()

        // call super
        return super.dispatchTouchEvent(ev)
    }


    fun sendVersion(){
        try {
            var versionName: String = getPackageManager()
                .getPackageInfo(getPackageName(), 0).versionName

            val versionCode = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                getPackageManager()
                    .getPackageInfo(getPackageName(), 0).longVersionCode
            } else {
                0
            }

            if (versionName != null && versionName.isNotEmpty()) {
                versionName = "Version:$versionName $versionCode"
            } else {
                versionName = "Version Name Not Found"
            }
            Log.d("TAG", "sendVersion: called version $versionName")
            viewModel.sendTabletStatus(branchId,"Version Number", versionName)

        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
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


    //************************************************ update preference ********************************

    private fun initializeObject(): Boolean {
        try {
            mPrinter = Printer(1,
                    0,
                    this)
        } catch (e: java.lang.Exception) {
            ShowMsg.showException(e, "Printer", this)
            return false
        }
        mPrinter?.setReceiveEventListener(this)

     //   Log.d("TAG", "onCreate: printer status 2 ${mPrinter?.status?.let { makeErrorMessage(it) }}")
        return true
    }

    override fun onDestroy() {
      //  finalizeObject()
        cancelTimer()
        super.onDestroy()
        while (true) {
            try {
                Discovery.stop()
                break
            } catch (e: Epos2Exception) {
                if (e.errorStatus != Epos2Exception.ERR_PROCESSING) {
                    break
                }
            }
        }
       // mFilterOption = null
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        if (requestCode != REQUEST_PERMISSION || grantResults.size == 0) {
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
            ActivityCompat.requestPermissions(this, requestPermissions.toTypedArray(), REQUEST_PERMISSION)
        }
    }


    private fun finalizeObject() {
        if (mPrinter == null) {
            return
        }
        mPrinter?.setReceiveEventListener(null)
        mPrinter?.setStatusChangeEventListener(null)
        mPrinter = null
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        //screensavercode
        cancelTimer()
        startTimer()
        try {
            if (branchId != BRANCH_DEFAULT_VALUE) {
                viewModel.getServices(branchId)
                viewModel.isBranchOpen(branchID = branchId)
            }
        } catch (e: Exception) {
            Log.d("TAG", "onResume: Exception 9 ")
            e.printStackTrace()
        }
    }

    override fun onResume() {
        Log.d("TAG", "onResume: first $count")

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
            Log.d("TAG", "onResume: Exception 9 ")
            e.printStackTrace()
        }
        count++
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        var result: Boolean
        when (event.keyCode) {
            KeyEvent.KEYCODE_MENU -> result = true
            KeyEvent.KEYCODE_VOLUME_UP -> result = true
            KeyEvent.KEYCODE_VOLUME_DOWN -> result = true
            KeyEvent.KEYCODE_BACK -> result = true
            KeyEvent.KEYCODE_HOME -> result = true

            else -> result = super.dispatchKeyEvent(event)
        }
        return true
    }


    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        //This is used to hide/show 'Status Bar' & 'System Bar'. Swip bar to get it as visible.
        try {
            val decorView = window.decorView
            if (hasFocus) {
                decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
            }
        } catch (e: Exception) {
            Log.d("TAG", "onResume: Exception 10 ")

            e.printStackTrace()
        }

    }

    //*********************************************************************** RECYCLER VIEW ***************************************************************************
    private fun setupRecyclerView(
    ) {
        try {
            serviceAdapter = ServiceAdapter()
            mRecyclerView.adapter = serviceAdapter
            mRecyclerView.layoutManager = GridLayoutManager(this, 2)
            mRecyclerView.addItemDecoration(GridItemDecoration(10, 2))
        } catch (e: Exception) {
            Log.d("TAG", "onResume: Exception 110 ")
            e.printStackTrace()
        }

    }

    //********************************************** click listener **********************************************
    @SuppressLint("ClickableViewAccessibility")
    private fun clickListener() {
        var then: Long = 0
        mTextQuestion.setOnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    then = System.currentTimeMillis()
                }
                MotionEvent.ACTION_UP -> {
                    if ((System.currentTimeMillis() - then) > 4000) {
                        FancyToast.makeText(
                            this,
                            getString(R.string.setting_activity),
                            FancyToast.LENGTH_SHORT,
                            FancyToast.INFO,
                            false
                        ).show()
                        /* val intent = Intent(
                                 this, SettingActivity::class.java
                         )*/
                        ////screensavercode
                        cancelTimer()

                        val intent = Intent(
                            this, ServiceActivity::class.java
                        )
                        startActivityForResult(intent,900)

                        /*         val intent = Intent(
                                     this, IntializeSettingActivity::class.java
                                 )
                                 startActivityForResult(intent, 900)*/

                    }
                }
            }
            true
        }

        mWithSpecialNeed.setOnClickListener {
            try {
                mSpecialNeedRadio.performClick()
            } catch (e: Exception) {
                Log.d("TAG", "onResume: Exception 112 ")
                e.printStackTrace()
            }
        }

        serviceAdapter.setOnItemClickListener { services, view ->
            showProgress()
            if (checkedNumber) {
                if (Locale.getDefault().displayLanguage != DISPLAY_LNG_ARABIC)
                    services.Services_PK_ID?.let {

                        viewModel.getBookTicket("", it, mSpecialNeedRadio.isChecked, false, INT_ENGLISH, -1, branchId, branchId)
                    }
                else
                    services.Services_PK_ID?.let { viewModel.getBookTicket("", it, mSpecialNeedRadio.isChecked, false, INT_ARABIC, -1, branchId, branchId) }

            } else {
                if (Locale.getDefault().displayLanguage != DISPLAY_LNG_ARABIC)
                    services.Services_PK_ID?.let { viewModel.getBookTicket(mobileNumber.toString(), it, mSpecialNeedRadio.isChecked, false, INT_ENGLISH, -1, branchId, branchId) }
                else
                    services.Services_PK_ID?.let { viewModel.getBookTicket(mobileNumber.toString(), it, mSpecialNeedRadio.isChecked, false, INT_ARABIC, -1, branchId, branchId) }
            }
           /* CoroutineScope(Dispatchers.Main).launch {
                delay(9000)
                view.mServiceBtn.isEnabled = true
                hideProgress()
            }*/
        }


    }


    //********************************************** observer **********************************************

    private fun observer() {
        viewModel.getServices.observe(this, Observer { response ->
            when (response) {
                is Resource.Success -> {
                    try {
                        if (response.data != null && response.data.isNotEmpty()) {
                            val serviceList: ArrayList<Services> = ArrayList()
                            Log.d("TAG", "observer: completed")
                            CoroutineScope(Dispatchers.IO).launch {
                                try {
                                    for (list in response.data) {
                                        Log.d("TAG", "observer: called 1")
                                        list.Services_PK_ID?.let {
                                            if (getServerPreference()) {
                                                val value = RetrofitInstanceLocal.api.getWorkingHourService(branchId, it)

                                                Log.d("TAG", "observer: called 1 ${value.isSuccessful}")
                                                if (value.isSuccessful) {
                                                    val data: List<IsService>? = value.body()
                                                    Log.d("TAG", "observer: called 2 $data")

                                                    if (data != null) {
                                                        for (enabledList in data) {
                                                            Log.d("TAG", "observer: called 1 ${enabledList.IsEnabled}")
                                                            if (enabledList.IsEnabled!!) {
                                                                serviceList.add(list)
                                                            }
                                                        }
                                                    }
                                                }
                                            } else {
                                                val value = RetrofitInstance.api.getWorkingHourService(branchId, it)

                                                Log.d("TAG", "observer: called 1 ${value.isSuccessful}")
                                                if (value.isSuccessful) {
                                                    val data: List<IsService>? = value.body()
                                                    Log.d("TAG", "observer: called 2 $data")

                                                    if (data != null) {
                                                        for (enabledList in data) {
                                                            Log.d("TAG", "observer: called 1 ${enabledList.IsEnabled}")
                                                            if (enabledList.IsEnabled!!) {
                                                                serviceList.add(list)
                                                            }
                                                        }
                                                    }
                                                }
                                            }

                                        }
                                    }
                                } catch (e: Exception) {
                                    Log.d("TAG", "onResume: Exception 214 ")
                                    e.printStackTrace()
                                }
                                if (serviceList.isNotEmpty()) {
                                    withContext(Dispatchers.Main) {
                                        try {
                                            mTextN0Data.visibility = View.GONE
                                            serviceAdapter.differ.submitList(serviceList)
                                        } catch (e: Exception) {
                                            Log.d("TAG", "onResume: Exception 213 ")
                                            e.printStackTrace()
                                        }
                                    }
                                } else {
                                    withContext(Dispatchers.Main) {
                                        try {
                                            serviceAdapter.differ.submitList(serviceList)
                                            mTextN0Data.visibility = View.VISIBLE
                                        } catch (e: Exception) {
                                            Log.d("TAG", "onResume: Exception 212 ")
                                            e.printStackTrace()
                                        }
                                    }
                                }
                                callRecursionServices()
                            }

                        } else {
                            try {
                                mTextN0Data.visibility = View.VISIBLE
                                callRecursionServices()
                            } catch (e: Exception) {
                                Log.d("TAG", "onResume: Exception 215 ")
                                e.printStackTrace()
                            }
                        }
                    } catch (e: Exception) {
                        Log.d("TAG", "onResume: Exception 11 ")

                        e.printStackTrace()
                    }
                }

                is Resource.Error -> {
                    try {

                        viewModel.sendLog(branchId,response.message.toString() + "(getServices)")
                        CoroutineScope(Dispatchers.Main).launch {
                            try {
                                showToastInfo(response.message.toString())
                                delay(DELAY_BRANCH_SERVICES)
                                if (branchId != BRANCH_DEFAULT_VALUE)
                                    viewModel.getServices(branchId)
                            } catch (e: Exception) {
                                Log.d("TAG", "onResume: Exception 40 ")
                                e.printStackTrace()
                            }
                        }
                    } catch (e: java.lang.Exception) {
                        Log.d("TAG", "onResume: Exception 14 ")
                        e.printStackTrace()
                    }
                    /* try {
                         setIntentError(response.message.toString())
                     } catch (e: Exception) {
                         Log.d("TAG", "onResume: Exception 12 ")
                         e.printStackTrace()
                     }*/
                }
            }
        })

        viewModel.isBranchOpen.observe(this, Observer { response ->
            when (response) {
                is Resource.Success -> {
                    try {
                        if (response.data != null && response.data.isNotEmpty()) {
                            for (list in response.data) {
                                if( list.IsOnBreak == null){
                                    list.IsOnBreak = false
                                }
                                if (list.IsOpen != null && list.IsOnBreak != null) {
                                    if (list.IsOpen!! && !list.IsOnBreak!!) {
                                        CoroutineScope(Dispatchers.Main).launch {
                                            try {
                                                delay(DELAY_CHECK_BRANCH)
                                                if (branchId != BRANCH_DEFAULT_VALUE)
                                                    viewModel.isBranchOpen(branchId)
                                            } catch (e: Exception) {
                                                Log.d("TAG", "onResume: Exception 45 ")
                                                e.printStackTrace()
                                            }
                                        }
                                    } else {
                                        try {
                                            //screensavercode
                                            cancelTimer()
                                            val intent = Intent(
                                                    this, ErrorActivity::class.java
                                            )
                                            if(list.msgAr.toString() == "null"){
                                                list.msgAr = "الفرع مغلق"
                                            }
                                            if(list.msgEn.toString() == "null"){
                                                list.msgEn = "The branch is closed"
                                            }
                                            intent.putExtra(EXTRA_ERROR, list.msgAr ?: "الفرع مغلق")
                                            intent.putExtra(EXTRA_ERROR_EN, list.msgEn ?: "The branch is closed")
                                            intent.putExtra(EXTRA_BRANCH_ID, branchId)
                                            startActivityForResult(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP), 900)
                                            //  startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP))
                                        } catch (e: Exception) {
                                            android.util.Log.d("TAG", "onResume: Exception 217 ")
                                            e.printStackTrace()
                                        }
                                    }
                                }
                            }
                        } else {
                            CoroutineScope(Dispatchers.Main).launch {
                                try {
                                    delay(DELAY_CHECK_BRANCH)
                                    if (branchId != BRANCH_DEFAULT_VALUE)
                                        viewModel.isBranchOpen(branchId)
                                } catch (e: Exception) {
                                    Log.d("TAG", "onResume: Exception 478 ")
                                    e.printStackTrace()
                                }
                            }
                        }
                    } catch (e: Exception) {
                        Log.d("TAG", "onResume: Exception 13 ")

                        e.printStackTrace()
                    }
                }

                is Resource.Error -> {
                    try {
                        viewModel.sendLog(branchId,response.message.toString() + "(isBranchOpen)")
                        CoroutineScope(Dispatchers.Main).launch {
                            try {
                                showToastInfo(response.message.toString())
                                delay(DELAY_CHECK_BRANCH)
                                if (branchId != BRANCH_DEFAULT_VALUE)
                                    viewModel.isBranchOpen(branchId)
                            } catch (e: Exception) {
                                Log.d("TAG", "onResume: Exception 40 ")
                                e.printStackTrace()
                            }
                        }
                    } catch (e: java.lang.Exception) {
                        Log.d("TAG", "onResume: Exception 14 ")

                        e.printStackTrace()
                    }

                }
            }
        })

        viewModel.getBookTicket.observe(this, Observer { response ->
            when (response) {
                is Resource.Loading -> {

                }
                is Resource.Success -> {

                    try {
                        var value = getAddressNamePreference()
                        if (value != null) {
                            address = value

                            if (address == BRANCH_DEFAULT_VALUE.toString()) {
                                hideProgress()
                                throw java.lang.Exception()
                            } else {

                                if (response.data != null) {
                                    for (list in response.data) {

                                        Log.d("TAG", "observer: 3 ")
                                        if (Locale.getDefault().displayLanguage != DISPLAY_LNG_ARABIC)
                                            list.NewPKID?.let {
                                                viewModel.getTicket(it, INT_ENGLISH)

                                            }
                                        else
                                            list.NewPKID?.let { viewModel.getTicket(it, INT_ARABIC) }

                                    }
                                }else{
                                    hideProgress()
                                }
                            }
                        } else {
                            hideProgress()
                            throw java.lang.Exception()
                        }

                    } catch (e: java.lang.Exception) {
                        hideProgress()
                        mPrinter?.status?.let { makeErrorMessage(it)?.let { it1 ->
                            viewModel.sendLog(branchId,it1)
                            setIntentError(it1) } }

                    }


                    Log.d("TAG", "observer: $address");
                    /*  var context: Context = this
                      var commands: ByteArray
                      val settingManager = PrinterSettingManager(this)
                      val settings = settingManager.printerSettings

                      //Log.d("TAG", "print: " + settings.getModelIndex());

                      try {
                          Log.d("TAG", "observer: 1 ${settings.portName} ${settings.portSettings}")
                          val emulation = ModelCapability.getEmulation(settings.modelIndex)
                          val paperSize = settings.paperSize*/

                    /*  var mPort = StarIOPort.getPort(settings.portName, settings.portSettings, 10000, this@ServiceActivity)
                      var status = mPort!!.endCheckedBlock()
                      Log.d("TAG", "observer: status ${status.coverOpen} ${status.receiptPaperEmpty} ${status.offline}")
                     *//*   if (status.coverOpen) {
                              Log.d("TAG", "observer:23 called")
                              throw StarIOPortException("Printer cover is open")
                          } else*//*
                        if (status.receiptPaperEmpty) {
                              Log.d("TAG", "observer:235 called")
                              throw StarIOPortException("Receipt paper is empty")
                          }*//* else if (status.offline) {
                              Log.d("TAG", "observer: called")
                              throw StarIOPortException("Printer236 is offline")
                          }*/
                    Log.d("TAG", "observer: 2 ")


                    /*    } catch (e: Exception) {
                            Log.d("TAG", "onResume: Exception 2 ")
                            setIntentError("Configure a printer: Contact to administrator")
                        }*/

                }

                is Resource.Error -> {
                    hideProgress()
                    viewModel.sendLog(branchId,response.message.toString() + "(Getting Ticket)")
                    setIntentError(response.message.toString())
                }
            }
        })

        viewModel.getTicket.observe(this, Observer { response ->
            when (response) {
                is Resource.Loading -> {


                }
                is Resource.Success -> {

                    if (response.data != null) {
                        for (list in response.data) {
                            list.Ticket?.let { this.print(it) }
                        }
                    }else{
                        hideProgress()
                    }


                }

                is Resource.Error -> {
                    hideProgress()
                    viewModel.sendLog(branchId,response.message.toString() + "(getTicket)")

                    showToastInfo(response.message.toString())
                    //   setIntentError(response.message.toString())
                }
            }
        })
        //can remove later
        /* viewModel.getIsService.observe(this, Observer { response ->
             var currentList = serviceAdapter.differ.currentList
             when (response) {
                 is Resource.Success -> {
                     if (response.data != null) {
                         for (enabled in response.data) {
                            *//* for (list in currentList) {
                                if (list.Services_PK_ID == list.Services_PK_ID) {
                                    if (!enabled.IsEnabled!!)
                                        serviceAdapter.differ.currentList.remove(list)
                                }
                            }*//*
                        }
                    }
                }
            }


        })
*/

    }

    private fun callRecursionServices() {

        Log.d("TAG", "callRecursionServices: ${System.currentTimeMillis()}   $serviceTimer  ${System.currentTimeMillis() - serviceTimer}")
        if (branchId != BRANCH_DEFAULT_VALUE) {
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    Log.d("TAG", "callRecursionServices: called ")
                    delay(DELAY_BRANCH_SERVICES)
                    viewModel.getServices(branchId)
                } catch (e: Exception) {
                    Log.d("TAG", "onResume: Exception 27 ")
                    e.printStackTrace()
                }

            }
        }


    }


    private fun setIntentError(message: String) {
        try {
            //screensavercode
            cancelTimer()
            val intent = Intent(
                    this, ErrorActivity::class.java
            )
            intent.putExtra(EXTRA_ERROR, message)
            startActivityForResult(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP), 900)

            //  startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK))
        } catch (e: Exception) {
            Log.d("TAG", "onResume: Exception 26 ")
            e.printStackTrace()
        }
    }


//*************************************************** print functions ***********************************************

    suspend fun createRasterReceiptData(text: String?, emulation: Emulation?): ByteArray {
        val builder = StarIoExt.createCommandBuilder(emulation)
        builder.beginDocument()
        //   val image = create2inchRasterReceiptImage(text)
        var image = text?.let { convertBase64ToBitmap(it) }
        // val image = convertImageUrlToBitmap("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTgGp6BHOkZeBSOxcj4IYie8k6V-QZ7zviAxA&usqp=CAU")
        // image = image?.let { scaleBitmap(it) }
        builder.appendBitmap(image, false)
        builder.appendCutPaper(ICommandBuilder.CutPaperAction.PartialCutWithFeed)
        builder.endDocument()
        return builder.commands
    }

    suspend fun convertImageUrlToBitmap(src: String): Bitmap? {
        var bitmap: Bitmap? = null
        try {
            val job = CoroutineScope(Dispatchers.Default).async {
                val url = URL(src)
                bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream())
            }


            job.await()
        } catch (e: IOException) {
            Log.d("TAG", "onResume: Exception 3 ")
            println(e)
        }
        return bitmap
    }

    suspend fun convertBase64ToBitmap(b64: String): Bitmap? {
        var bitmap: Bitmap? = null
        try {
            val job = CoroutineScope(Dispatchers.Default).async {
                val imageAsBytes: ByteArray = Base64.decode(b64.toByteArray(), Base64.DEFAULT)
                bitmap = BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.size)
            }
            job.await()
        } catch (e: IOException) {
            Log.d("TAG", "onResume: Exception 4 ")
            println(e)
        }
        return bitmap
    }

    /* private fun scaleBitmap(bitmap: Bitmap): Bitmap {
         var width = bitmap.width
         var height = bitmap.height
         val bounding: Int = dpToPx(250)
         val xScale = bounding.toFloat() / width
         val yScale = bounding.toFloat() / height
         val matrix = Matrix()
         matrix.postScale(xScale, yScale)
         val scaledBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true)
         width = scaledBitmap.width
         height = scaledBitmap.height
         return scaledBitmap
     }*/

    private fun dpToPx(dp: Int): Int {
        val density: Float = this.resources.displayMetrics.density
        return (dp.toFloat() * density).roundToInt()
    }

/*    fun create2inchRasterReceiptImage(text: String?): Bitmap {
        var textToPrint: String =
                "   Zain  \n" +
                        "        Suhwaikh\n" +
                        "      State 12345\n" +
                        "\n" +
                        "Date:04/06/2020 Time:22:11 PM\n" +
                        "-----------------------------\n" +
                        "SALE\n" +
                        "SKU       Description   Total\n" +
                        "300678566 Maintenance 10.99\n" +
                        "300692003 Customer Service   29.99\n"
        val textSize = 22
        val typeface = Typeface.create(Typeface.MONOSPACE, Typeface.NORMAL)
        //PRINTERSETTINGContant.PAPERSIZETWOINCH
        return ILocalizeReceipts.createBitmapFromText(textToPrint, textSize, PrinterSettingConstant.PAPER_SIZE_TWO_INCH, typeface)
    }*/


    private fun getAddressNamePreference(): String? {
        val pref = applicationContext.getSharedPreferences(
                Constants.BLUETOOTH_AUTH,
                0
        ) // 0 - for private mode

        return pref.getString(Constants.BLUETOOTH_NAME, BRANCH_DEFAULT_VALUE.toString());

    }

    private fun print(text: String) {
        CoroutineScope(Dispatchers.IO).launch {
            Log.d("TAG", "print: called 1")


            Log.d("TAG", "print: called 2")


            try {
                val image = convertBase64ToBitmap(text)

                if (image != null) {
                    mPrinter?.addImage(image, 0, 0,
                            image.width,
                            image.height,
                            Printer.COLOR_1,
                            Printer.MODE_MONO,
                            Printer.HALFTONE_DITHER,
                            Printer.PARAM_DEFAULT.toDouble(),
                            Printer.COMPRESS_AUTO)

                    mPrinter?.addCut(Printer.CUT_FEED)

                    printData()
                }

            } catch (e: java.lang.Exception) {
                withContext(Dispatchers.Main){
                    hideProgress()
                }
                mPrinter?.clearCommandBuffer()
                mPrinter?.status?.let { makeErrorMessage(it)?.let { it1 ->

                    viewModel.sendLog(branchId,it1)

                    setIntentError(it1) } }
            }
        }
        /*    var context: Context = this
            var commands: ByteArray
            val settingManager = PrinterSettingManager(this)
            val settings = settingManager.printerSettings

            //Log.d("TAG", "print: " + settings.getModelIndex());

            try {
                val emulation = ModelCapability.getEmulation(settings.modelIndex)
                val paperSize = settings.paperSize
                // ILocalizeReceipts localizeReceipts = ILocalizeReceipts.createLocalizeReceipts(PrinterSettingConstant.LANGUAGE_ENGLISH, paperSize);

                CoroutineScope(Dispatchers.Main).launch {
                    try {
                        commands = createRasterReceiptData(text, emulation)

                        Communication.sendCommands(this, commands, settings.portName, settings.portSettings, 10000, 30000, context, mCallback) // 10000mS!!!
                        //  printStartFunction(this, commands, settings.portName, settings.portSettings, 10000, 30000, context, mCallback) // 10000mS!!!
                        intentToMain()

                    } catch (e: StarIOPortException) {
                        Log.d("TAG", "onResume: Exception 5 ")
                        setIntentError("Printer cover is open or Receipt paper is empty or Printer is offline")
                    } catch (e: Exception) {
                        Log.d("TAG", "onResume: Exception 6 ")
                        setIntentError("Configure a printer: Contact to administrator")
                    }

                }
            } catch (e: StarIOPortException) {
                Log.d("TAG", "onResume: Exception 7 ")
                setIntentError("Printer cover is open or Receipt paper is empty or Printer is offline")
            } catch (e: Exception) {
                Log.d("TAG", "onResume: Exception 8 ")
                setIntentError("Configure a printer: Contact to administrator")
            }*/


    }


/*
    private fun printStartFunction(mLock: Any, mCommands: ByteArray, mPortName: String?, mPortSettings: String, mTimeout: Int, mEndCheckedBlockTimeout: Int, mContext: Context, result: Communication.SendCallback) {
        val mCallback: SendCallback? = null

        var mPort: StarIOPort? = null

        var code = StarResultCode.FAILURE

        CoroutineScope(Dispatchers.IO).launch {
            synchronized(mLock) {
                try {
                    if (mPort == null) {
                        if (mPortName == null) {
                            Log.d("TAG", "printStartFunction: portname is null")
                            //resultSendCallback(result, code, mCallback)

                        } else {
                            mPort = StarIOPort.getPort(mPortName, mPortSettings, mTimeout, mContext)
                        }
                    }
                    if (mPort == null) {
                        Log.d("TAG", "printStartFunction: port is null")
                        //    result = Communication.Result.ErrorOpenPort
                        //  SendCommandThread.resultSendCallback(result, code, mCallback)

                    }
                    //  result = Communication.Result.ErrorBeginCheckedBlock
                    var status: StarPrinterStatus = mPort!!.beginCheckedBlock()
                    if (status.offline) {
                        throw StarIOPortException("A printer is offline.")
                    }
                    //  result = Communication.Result.ErrorWritePort
                    mPort!!.writePort(mCommands, 0, mCommands.size)
                    //   result = Communication.Result.ErrorEndCheckedBlock
                    mPort!!.setEndCheckedBlockTimeoutMillis(mEndCheckedBlockTimeout)
                    status = mPort!!.endCheckedBlock()
                    if (status.coverOpen) {
                        throw StarIOPortException("Printer cover is open")
                    } else if (status.receiptPaperEmpty) {
                        throw StarIOPortException("Receipt paper is empty")
                    } else if (status.offline) {
                        throw StarIOPortException("Printer is offline")
                    }
                    //  result = Communication.Result.Success
                    code = StarResultCode.SUCCESS
                } catch (e: StarIOPortException) {
                    code = e.errorCode
                }

                if (mPort != null && mPortName != null) {
                    try {
                        StarIOPort.releasePort(mPort)
                    } catch (e: StarIOPortException) {
                        Log.d("TAG", "printStartFunction: onResume Exception 24")
                    }
                    mPort = null
                }
            }
        }


    }
*/

    private suspend fun printData(): Boolean {
        val mContext = this
        if (mPrinter == null) {
            withContext(Dispatchers.Main){
                hideProgress()
            }
            return false
        }


        withContext(Dispatchers.Main) {
            Log.d("TAG", "printData: called 1 finish")
            //screensavercode
            timer.cancel()
            val intent = Intent(
                mContext, ServiceActivity::class.java
            )
            startActivityForResult(intent,900)
            Log.d("TAG", "printData: called 2 finish")

        }
        Log.d("TAG", "printData: called 3 finish")

        if (!connectPrinter()) {
            mPrinter!!.clearCommandBuffer()
            withContext(Dispatchers.Main){
                hideProgress()
            }
            return false
        }
        Log.d("TAG", "printData: called 4 finish")

        try {
                mPrinter!!.beginTransaction()
                mPrinter!!.sendData(Printer.PARAM_DEFAULT)
                mPrinter?.setStatusChangeEventListener(this@ServiceActivity)


                mPrinter?.startMonitor()
                mPrinter?.setInterval(1000)
            withContext(Dispatchers.Main){
                hideProgress()
            }


        } catch (e: java.lang.Exception) {
            withContext(Dispatchers.Main){
                hideProgress()
            }
            mPrinter!!.clearCommandBuffer()
            mPrinter?.status?.let { makeErrorMessage(it)?.let {
                it1 ->
                viewModel.sendLog(branchId,it1)
                setIntentError(it1)
            } }
            try {
                mPrinter!!.disconnect()
            } catch (ex: java.lang.Exception) {
                // Do nothing
            }
            return false
        }
        return true
    }


    private suspend fun connectPrinter(): Boolean {
        if (mPrinter == null) {
            return false
        }
        try {
            withContext(Dispatchers.Main) {

                //  mPrinter!!.connect("BT:00:01:90:97:5C:97", Printer.PARAM_DEFAULT)
                if (getAddressNamePreference() == BRANCH_DEFAULT_VALUE.toString()) {
                    viewModel.sendLog(branchId,"Printer is Not Connected")
                    setIntentError("Printer is Not Connected")

                } else {
                    //  "BT:00:01:90:97:5C:97"
                    Log.d("TAG", "connectPrinter: bt address ${Printer.PARAM_DEFAULT} /" + getAddressNamePreference())
                    try{
                        mPrinter!!.connect(getAddressNamePreference(), Printer.PARAM_DEFAULT)


                       /* mPrinter?.setStatusChangeEventListener(this@ServiceActivity)


                        mPrinter?.startMonitor()
                        mPrinter?.setInterval(1000)
*/


                    }catch (e: Exception){
                        Log.d("TAG", "connectPrinter: exception bluetooth ")

                      //  Log.d("TAG", "onCreate: printer status 4${mPrinter?.status?.let { makeErrorMessage(it) }}")
                    }


                }
            }
//            mPrinter.connect(mEditTarget.getText().toString(), Printer.PARAM_DEFAULT);

        } catch (e: java.lang.Exception) {
            mPrinter?.status?.let { makeErrorMessage(it)?.let { it1 ->
                viewModel.sendLog(branchId,it1)
                setIntentError(it1) } }
            return false
        }
        return true
    }


    private fun intentToMain() {
        //screensavercode
        timer.cancel()
        val intent = Intent(
                this, ServiceActivity::class.java
        )

        startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK))

    }


    private fun showToastInfo(message: String) {
        var context = this
        CoroutineScope(Dispatchers.Main).launch {
            FancyToast.makeText(
                context, message, FancyToast.LENGTH_SHORT, FancyToast.INFO, false
            ).show()
        }

    }

    override fun onPtrReceive(p0: Printer?, code: Int, PrinterStatusInfo: PrinterStatusInfo?, printJobId: String?) {
        Log.d("TAG", "onPtrReceive: called")
        runOnUiThread {
            // ShowMsg.showResult(code, makeErrorMessage(status), mContext)
            //dispPrinterWarnings(status)
            //updateButtonState(true)

            PrinterStatusInfo?.let {
                var error = makeErrorMessage(it)
                Log.d("TAG", "exception $error/")
                error?.let { errorString ->
                    if (errorString!= "") {
                        viewModel.sendLog(branchId,errorString)
                        setIntentError(errorString)
                    }
                }
            }
        }

        CoroutineScope(Dispatchers.IO).launch {
            disconnectPrinter();
        }
    }

    private fun makeErrorMessage(status: PrinterStatusInfo): String? {
        var msg = ""
        if (status.online == Printer.FALSE) {
            msg += getString(R.string.handlingmsg_err_offline)
        }
        if (status.connection == Printer.FALSE) {
            msg += getString(R.string.handlingmsg_err_no_response)
        }
        if (status.coverOpen == Printer.TRUE) {
            msg += getString(R.string.handlingmsg_err_cover_open)
        }
        if (status.paper == Printer.PAPER_EMPTY) {
            msg += getString(R.string.handlingmsg_err_receipt_end)
        }
        if (status.paperFeed == Printer.TRUE || status.panelSwitch == Printer.SWITCH_ON) {
            msg += getString(R.string.handlingmsg_err_paper_feed)
        }
        if (status.errorStatus == Printer.MECHANICAL_ERR || status.errorStatus == Printer.AUTOCUTTER_ERR) {
            msg += getString(R.string.handlingmsg_err_autocutter)
            msg += getString(R.string.handlingmsg_err_need_recover)
        }
        if (status.errorStatus == Printer.UNRECOVER_ERR) {
            msg += getString(R.string.handlingmsg_err_unrecover)
        }
        if (status.errorStatus == Printer.AUTORECOVER_ERR) {
            if (status.autoRecoverError == Printer.HEAD_OVERHEAT) {
                msg += getString(R.string.handlingmsg_err_overheat)
                msg += getString(R.string.handlingmsg_err_head)
            }
            if (status.autoRecoverError == Printer.MOTOR_OVERHEAT) {
                msg += getString(R.string.handlingmsg_err_overheat)
                msg += getString(R.string.handlingmsg_err_motor)
            }
            if (status.autoRecoverError == Printer.BATTERY_OVERHEAT) {
                msg += getString(R.string.handlingmsg_err_overheat)
                msg += getString(R.string.handlingmsg_err_battery)
            }
            if (status.autoRecoverError == Printer.WRONG_PAPER) {
                msg += getString(R.string.handlingmsg_err_wrong_paper)
            }
        }
        if (status.batteryLevel == Printer.BATTERY_LEVEL_0) {
            msg += getString(R.string.handlingmsg_err_battery_real_end)
        }
        return msg
    }

    private fun disconnectPrinter() {
        if (mPrinter == null) {
            return
        }
        while (true) {
            try {
                mPrinter!!.disconnect()
                break
            } catch (e: java.lang.Exception) {
                if (e is Epos2Exception) {
                    //Note: If printer is processing such as printing and so on, the disconnect API returns ERR_PROCESSING.
                    if (e.errorStatus == Epos2Exception.ERR_PROCESSING) {
                        try {
                            Thread.sleep(DISCONNECT_INTERVAL.toLong())
                        } catch (ex: java.lang.Exception) {
                        }
                    } else {
                        runOnUiThread { ShowMsg.showException(e, "disconnect", this) }
                        break
                    }
                } else {
                    runOnUiThread { ShowMsg.showException(e, "disconnect", this) }
                    break
                }
            }
        }
        mPrinter!!.clearCommandBuffer()
    }


    private fun showProgress() {

        mRecyclerView.isEnabled = false
        mProgressBarMain.visibility = View.VISIBLE
        //mMainLayout.visibility = View.GONE
        mTransparent.visibility = View.VISIBLE
    }

    private fun hideProgress() {
        mRecyclerView.isEnabled = true
        mProgressBarMain.visibility = View.GONE
        // mMainLayout.visibility = View.VISIBLE
        mTransparent.visibility = View.GONE
    }

    private fun getServerPreference(): Boolean {
        val pref = this.getSharedPreferences(
                Constants.SERVER_AUTH,
                0
        ) // 0 - for private mode

        return pref.getBoolean(Constants.LOCAL_DATABASE, false)

    }

    private fun requestRuntimePermission() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return
        }
        val permissionStorage = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        val permissionLocation = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
        val requestPermissions: MutableList<String> = java.util.ArrayList()
        if (permissionStorage == PackageManager.PERMISSION_DENIED) {
            requestPermissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }
        if (permissionLocation == PackageManager.PERMISSION_DENIED) {
            requestPermissions.add(Manifest.permission.ACCESS_COARSE_LOCATION)
        }
        if (!requestPermissions.isEmpty()) {
            ActivityCompat.requestPermissions(this, requestPermissions.toTypedArray(), REQUEST_PERMISSION)
        }
    }

    override fun onPtrStatusChange(p0: Printer?, p1: Int) {
        Log.d("TAG", "onPtrStatusChange: called ")
        when (p1) {
            Printer.EVENT_ONLINE -> {
                viewModel.sendTabletStatus(branchId,"Printer Connectivity","Online")
                Log.d("TAG", "onPtrStatusChange: print status is Online ")
            }
            Printer.EVENT_OFFLINE -> {
                viewModel.sendTabletStatus(branchId,"Printer Connectivity","Offline")
                Log.d("TAG", "onPtrStatusChange: print status is Offline")
            }
            Printer.EVENT_POWER_OFF -> {

                viewModel.sendTabletStatus(branchId,"Printer Connectivity","Power Off")
                Log.d("TAG", "onPtrStatusChange: print status is Power off")
            }
            Printer.EVENT_COVER_CLOSE -> {

                viewModel.sendTabletStatus(branchId,"Printer Cover","Cover close")
                Log.d("TAG", "onPtrStatusChange: print status is Cover close")
            }
            Printer.EVENT_COVER_OPEN -> {

                viewModel.sendTabletStatus(branchId,"Printer Cover","Cover open")
                Log.d("TAG", "onPtrStatusChange: print status is Cover open")
            }
            Printer.EVENT_PAPER_OK -> {

                viewModel.sendTabletStatus(branchId,"PrintePaper","remains")
                Log.d("TAG", "onPtrStatusChange: print status is Paper remains.")
            }
            Printer.EVENT_PAPER_NEAR_END -> {
                viewModel.sendTabletStatus(branchId,"Printer Paper","almost run out")
                Log.d("TAG", "onPtrStatusChange: print status is Paper has almost run out.")
            }
            Printer.EVENT_PAPER_EMPTY -> {

                viewModel.sendTabletStatus(branchId,"Printer Paper","run out")
                Log.d("TAG", "onPtrStatusChange: print status is Paper has run out.")
            }
            Printer.EVENT_DRAWER_HIGH -> {

                viewModel.sendTabletStatus(branchId,"Printer Drawer","High")
                Log.d("TAG", "onPtrStatusChange: print status is Drawer kick connector pin No.3 status = H")
            }
            Printer.EVENT_DRAWER_LOW -> {

                viewModel.sendTabletStatus(branchId,"Printer Drawer","Low")
                Log.d("TAG", "onPtrStatusChange: print status is Drawer kick connector pin No.3 status = L")
            }
            Printer.EVENT_BATTERY_ENOUGH -> {
                viewModel.sendTabletStatus(branchId,"Printer Battery","Enough")
                Log.d("TAG", "onPtrStatusChange: print status is Battery is enough. ")
            }
            Printer.EVENT_BATTERY_EMPTY -> {
                viewModel.sendTabletStatus(branchId,"Printer Battery","Empty")
                Log.d("TAG", "onPtrStatusChange: print status is Battery has run out.")
            }
            else -> {
                Log.d("TAG", "onPtrStatusChange: $p1")
            }


        }

    }


}