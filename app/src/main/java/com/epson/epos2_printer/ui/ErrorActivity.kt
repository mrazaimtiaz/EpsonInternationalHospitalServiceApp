package com.epson.epos2_printer.ui

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.epson.epos2_printer.R
import com.epson.epos2_printer.api.RetrofitInstance
import com.epson.epos2_printer.api.RetrofitInstanceLocal
import com.epson.epos2_printer.repository.QRepository
import com.epson.epos2_printer.viewmodel.QViewModelProviderFactory
import com.shashank.sony.fancytoastlib.FancyToast
import com.epson.epos2_printer.utils.Constants
import com.epson.epos2_printer.utils.Constants.BRANCH_DEFAULT_VALUE
import com.epson.epos2_printer.utils.Constants.DELAY_INTERNET_CONNECTION
import com.epson.epos2_printer.utils.Constants.EXTRA_BRANCH_ID
import com.epson.epos2_printer.utils.Constants.EXTRA_ERROR
import com.epson.epos2_printer.utils.Constants.EXTRA_ERROR_EN
import com.epson.epos2_printer.utils.Resource
import com.epson.epos2_printer.viewmodel.BackEndViewModel
import com.epson.epos2_printer.viewmodel.BackEndViewModelProviderFactory
import com.epson.epos2_printer.viewmodel.QViewModel
import kotlinx.android.synthetic.main.activity_error.*
import kotlinx.coroutines.*
import java.util.*

class ErrorActivity : AppCompatActivity() {
    private lateinit var viewModel: QViewModel
    private var branchId = BRANCH_DEFAULT_VALUE

    private var count = 0

    var value: String? = ""
    var valueEn: String? = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.activity_error)

        Log.d("TAG", "error handling 1 ")

        val qRepository = QRepository()
        val viewModelProviderFactory =
                QViewModelProviderFactory(
                        application,
                        qRepository
                )
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(QViewModel::class.java)

        lateinit var backEndViewModel: BackEndViewModel

        val backEndViewModelProviderFactory =
            BackEndViewModelProviderFactory(
                application,
                qRepository
            )
        backEndViewModel = ViewModelProvider(this, backEndViewModelProviderFactory).get(
            BackEndViewModel::class.java)
        backEndViewModel.setDispenserSettings()
        CoroutineScope(Dispatchers.Main).launch {
            delay(Constants.DELAY_CHECK_BRANCH)
            backEndViewModel.getCounter()
            backEndViewModel.sendDisplayMessage()
            backEndViewModel.timerDisplay()
        }

        value = intent.getStringExtra(EXTRA_ERROR)
        valueEn = intent.getStringExtra(EXTRA_ERROR_EN)
        branchId = intent.getIntExtra(EXTRA_BRANCH_ID, BRANCH_DEFAULT_VALUE)

        if (value != null) {
            if (value!!.isNotEmpty()) {
                mTextError.text = value
            }
        }
        if (valueEn != null) {
            if (valueEn!!.isNotEmpty()) {
                mTextErrorEn.text = valueEn
            }
        }
        clickListener()
        observer()

        if (branchId != BRANCH_DEFAULT_VALUE)
            viewModel.isBranchOpen(branchID = branchId)

        if (value == getString(R.string.internet_error_admin)) {
            CoroutineScope(Dispatchers.Default).launch {
                checkConnection()
            }
        }
        Log.d("TAG", "onCreate: timerstarted5")

        //screensavercode
       startTimer()
    }
    fun cancelTimer(){
        try {
            CoroutineScope(Dispatchers.IO).launch {
                timer.cancel()
            }
        }catch (E: java.lang.Exception){

        }

    }

    fun startTimer(){
        try {
            CoroutineScope(Dispatchers.IO).launch {
                timer.start()
            }
        }catch (E: java.lang.Exception){

        }

    }
//screensavercode
    val timer = object: CountDownTimer(Constants.DELAY_SCREENSAVER, 1) {
        override fun onTick(millisUntilFinished: Long) {}

        override fun onFinish() {
            Log.d("TAG", "onFinish: called ")

            val intent = Intent(
                this@ErrorActivity, ScreenSaverActivity::class.java
            )
            startActivityForResult(intent,900)
            // startActivity(intent)

        }
    }

//screensavercode
    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        // dismiss shown snackbar if user tapped anywhere outside snackbar

        cancelTimer()
        Log.d("TAG", "onCreate: timerstarted6")
        //screensavercode
        startTimer()


        // call super
        return super.dispatchTouchEvent(ev)
    }


    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        val result: Boolean = when (event.keyCode) {
            KeyEvent.KEYCODE_MENU -> true
            KeyEvent.KEYCODE_VOLUME_UP -> true
            KeyEvent.KEYCODE_VOLUME_DOWN -> true
            KeyEvent.KEYCODE_BACK -> true
            KeyEvent.KEYCODE_HOME -> true

            else -> super.dispatchKeyEvent(event)
        }
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d("TAG", "onCreate: timerstarted7")

        //screensavercode
        cancelTimer()
        startTimer()
        try {
            if (value == getString(R.string.internet_error_admin)) {
                CoroutineScope(Dispatchers.Default).launch {
                    try {
                    //    if(count != 0){
                            checkConnection()
                    //    }
                    } catch (e: Exception) {
                        Log.d("TAG", "onResume: Exception 101 ")
                        e.printStackTrace()
                    }
                }
            }

            Log.d("TAG", "onCreate: timerstarted5")

            //screensavercode
            startTimer()

            if (branchId != BRANCH_DEFAULT_VALUE){
                try {
                 //   if(count != 0){
                        viewModel.isBranchOpen(branchID = branchId)
                //    }
                } catch (e: Exception) {
                    Log.d("TAG", "onResume: Exception 102 ")
                    e.printStackTrace()
                }
            }

        } catch (e: Exception) {
            Log.d("TAG", "onResume: Exception 1 ")
            e.printStackTrace()
        }
    }

    override fun onDestroy() {
        cancelTimer()
        super.onDestroy()
    }

    override fun onResume() {

        super.onResume()
       /* try {
            if (value == getString(R.string.internet_error_admin)) {
                CoroutineScope(Dispatchers.Default).launch {
                    try {
                        if(count != 0){
                            checkConnection()
                        }
                    } catch (e: Exception) {
                        Log.d("TAG", "onResume: Exception 101 ")
                        e.printStackTrace()
                    }
                }
            }

            if (branchId != BRANCH_DEFAULT_VALUE){
                try {
                    if(count != 0){
                        viewModel.isBranchOpen(branchID = branchId)
                    }
                } catch (e: Exception) {
                    Log.d("TAG", "onResume: Exception 102 ")
                    e.printStackTrace()
                }
            }

        } catch (e: Exception) {
            Log.d("TAG", "onResume: Exception 1 ")
            e.printStackTrace()
        }*/
        try {
            val decorView = window.decorView
            decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
        } catch (e: Exception) {
            Log.d("TAG", "onResume: Exception 21 ")
            e.printStackTrace()
        }
        count++
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun clickListener() {
        var then: Long = 0
        mTextError.setOnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    then = System.currentTimeMillis()
                }
                MotionEvent.ACTION_UP -> {
                    if ((System.currentTimeMillis() - then) > 4000) {
                        FancyToast.makeText(
                                this, getString(R.string.setting_activity), FancyToast.LENGTH_SHORT,
                                FancyToast.INFO, false
                        ).show()
                        //screensavercode
                       cancelTimer()
                        val intent = Intent(
                                this, IntializeSettingActivity::class.java
                        )
                        startActivityForResult(intent,900)
                       // startActivity(intent)
                    }
                }
            }
            true
        }
        mTextErrorEn.setOnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    then = System.currentTimeMillis()
                }
                MotionEvent.ACTION_UP -> {
                    if ((System.currentTimeMillis() - then) > 4000) {
                        FancyToast.makeText(
                                this, getString(R.string.setting_activity), FancyToast.LENGTH_SHORT,
                                FancyToast.INFO, false
                        ).show()
                        //screensavercode
                       cancelTimer()
                        val intent = Intent(
                                this, IntializeSettingActivity::class.java
                        )
                        startActivityForResult(intent,900)
                        // startActivity(intent)
                    }
                }
            }
            true
        }
        mBack.setOnClickListener {
            if (branchId != BRANCH_DEFAULT_VALUE) {
                CoroutineScope(Dispatchers.IO).launch {
                    try {
                        if (getServerPreference()) {
                            val value = RetrofitInstanceLocal.api.isBranchOpen(branchId)

                            if (value.isSuccessful) {
                                if( value.body()?.get(0)?.IsOnBreak == null){
                                    value.body()?.get(0)?.IsOnBreak = false
                                }
                                if (value.body()?.get(0)?.IsOpen!! && !value.body()?.get(0)?.IsOnBreak!!) {
                                    withContext(Dispatchers.Main) {
                                        try{
                                            intentToMain()
                                        } catch (e: Exception) {
                                            Log.d("TAG", "onResume: Exception 104 ")
                                            e.printStackTrace()
                                        }
                                    }
                                } else {
                                    withContext(Dispatchers.Main) {
                                        if (Locale.getDefault().displayLanguage != Constants.DISPLAY_LNG_ENGLISH) {
                                            showToastInfo(value.body()?.get(0)?.msgAr.toString())
                                        }else{
                                            showToastInfo(value.body()?.get(0)?.msgEn.toString())
                                        }
                                    }
                                }
                            } else {
                                showToastInfo("Some thing Wrong From Server")
                            }
                        }else{
                            val value = RetrofitInstance.api.isBranchOpen(branchId)

                            if (value.isSuccessful) {
                                if( value.body()?.get(0)?.IsOnBreak == null){
                                    value.body()?.get(0)?.IsOnBreak = false
                                }
                                if (value.body()?.get(0)?.IsOpen!!  && !value.body()?.get(0)?.IsOnBreak!!) {
                                    withContext(Dispatchers.Main) {
                                        try{
                                            intentToMain()
                                        } catch (e: Exception) {
                                            Log.d("TAG", "onResume: Exception 104 ")
                                            e.printStackTrace()
                                        }
                                    }
                                } else {
                                    withContext(Dispatchers.Main) {
                                        if (Locale.getDefault().displayLanguage != Constants.DISPLAY_LNG_ENGLISH) {
                                            showToastInfo(value.body()?.get(0)?.msgAr.toString())
                                        }else{
                                            showToastInfo(value.body()?.get(0)?.msgEn.toString())
                                        }
                                    }
                                }
                            } else {
                                showToastInfo("Some thing Wrong From Server")
                            }
                        }

                    } catch (e: Exception) {
                        Log.d("TAG", "onResume: Exception 19 ")
                        e.printStackTrace()
                    }
                }

            } else{
                Log.d("TAG", "clickListener: called")
                //screensavercode
                cancelTimer()
                setResult(Activity.RESULT_OK)
                finish()
            }

        }

        mTextBack.setOnClickListener {
            mBack.performClick()
        }
    }

    private fun observer() {
        viewModel.isBranchOpen.observe(this, Observer { response ->
            Log.d("TAG", "error handling 3 ")
            when (response) {
                is Resource.Success -> {
                    Log.d("TAG", "error handling 2 ")
                    try {
                        if (response.data != null) {
                            for (list in response.data) {
                                if (list.IsOpen != null) {
                                    if(list.IsOnBreak == null){
                                        list.IsOnBreak = false
                                    }
                                    if (!list.IsOpen!!  || list.IsOnBreak!!) {
                                        CoroutineScope(Dispatchers.Main).launch {
                                            mTextError.text = list.msgAr.toString()
                                            mTextErrorEn.text =list.msgEn.toString()
                                            delay(Constants.DELAY_CHECK_BRANCH)
                                            try{
                                            if (branchId != BRANCH_DEFAULT_VALUE)
                                                viewModel.isBranchOpen(branchId)
                                            } catch (e: Exception) {
                                                Log.d("TAG", "onResume: Exception 209 ")
                                                e.printStackTrace()
                                            }
                                        }

                                    } else {
                                        try{
                                        intentToMain()
                                        } catch (e: Exception) {
                                            Log.d("TAG", "onResume: Exception 210 ")
                                            e.printStackTrace()
                                        }
                                    }
                                }
                            }
                        } else {
                            CoroutineScope(Dispatchers.Main).launch {
                                try {
                                    mTextError.text = response.message.toString()
                                    mTextErrorEn.text = ""
                                    delay(Constants.DELAY_CHECK_BRANCH)
                                    if (branchId != BRANCH_DEFAULT_VALUE)
                                        viewModel.isBranchOpen(branchId)
                                } catch (e: Exception) {
                                    Log.d("TAG", "onResume: Exception 16 ")
                                    e.printStackTrace()
                                }
                            }
                        }
                    } catch (e: Exception) {
                        Log.d("TAG", "onResume: Exception 17 ")
                        e.printStackTrace()
                    }
                }
                is Resource.Error -> {
                    Log.d("TAG", "error handling 5 ")
                    CoroutineScope(Dispatchers.Main).launch {
                        try {
                            mTextError.text = response.message.toString()
                            mTextErrorEn.text = ""
                            delay(Constants.DELAY_CHECK_BRANCH)
                            if (branchId != BRANCH_DEFAULT_VALUE)
                                viewModel.isBranchOpen(branchId)
                        } catch (e: Exception) {
                            Log.d("TAG", "onResume: Exception 15 ")
                            e.printStackTrace()
                        }

                    }
                }
            }
        })
    }

    suspend fun checkConnection() {
        try {
            if (viewModel.hasInternetConnection()) {
                withContext(Dispatchers.Main) {
                    Log.d("TAG", "checkConnection: onActivityResult: called ")
                    //screensavercode
                    cancelTimer()
                    setResult(Activity.RESULT_OK)
                    finish()
                }
              } else {
                  delay(DELAY_INTERNET_CONNECTION)
                  checkConnection()
              }
        } catch (e: Exception) {
            Log.d("TAG", "onResume: Exception 23 ")
            e.printStackTrace()
        }
    }

    private fun showToastInfo(message: String) {
        try {
            FancyToast.makeText(
                    this, message, FancyToast.LENGTH_SHORT,
                    FancyToast.INFO, false
            ).show()
        } catch (e: Exception) {
            Log.d("TAG", "onResume: Exception 22")
            e.printStackTrace()
        }
    }

    private fun intentToMain() {
        //screensavercode
        cancelTimer()
        val intent = Intent(
                this, SplashActivity::class.java
        )
        startActivityForResult(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK),900)
   //     startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK))

    }

    private fun getServerPreference(): Boolean {
        val pref = this.getSharedPreferences(
                Constants.SERVER_AUTH,
                0
        ) // 0 - for private mode

        return pref.getBoolean(Constants.LOCAL_DATABASE, false)

    }
}