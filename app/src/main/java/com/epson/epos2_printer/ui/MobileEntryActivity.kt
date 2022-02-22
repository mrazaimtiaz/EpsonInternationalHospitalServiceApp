package com.epson.epos2_printer.ui

import android.Manifest
import android.annotation.SuppressLint
import android.app.ActionBar
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.PixelFormat
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.os.PowerManager
import android.provider.Settings
import android.provider.Settings.System.SCREEN_BRIGHTNESS
import android.util.Log
import android.view.*
import android.view.animation.CycleInterpolator
import android.view.animation.TranslateAnimation
import android.widget.Button
import android.widget.ImageView
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition;
import com.davidmiguel.numberkeyboard.NumberKeyboardListener
import com.epson.epos2.printer.Printer
import com.epson.epos2_printer.R
import com.epson.epos2_printer.ShowMsg
import com.epson.epos2_printer.repository.QRepository
import com.epson.epos2_printer.utils.Constants
import com.epson.epos2_printer.utils.Constants.ALLOW_NUMBER_5
import com.epson.epos2_printer.utils.Constants.ALLOW_NUMBER_6
import com.epson.epos2_printer.utils.Constants.ALLOW_NUMBER_9
import com.epson.epos2_printer.utils.Constants.BRANCH_ADMIN_AR
import com.epson.epos2_printer.utils.Constants.BRANCH_ADMIN_En
import com.epson.epos2_printer.utils.Constants.BRANCH_AUTH
import com.epson.epos2_printer.utils.Constants.BRANCH_AUTH_ID
import com.epson.epos2_printer.utils.Constants.BRANCH_DEFAULT_VALUE
import com.epson.epos2_printer.utils.Constants.DELAY_UPDATE_APP
import com.epson.epos2_printer.utils.Constants.DISPLAY_LNG_ENGLISH
import com.epson.epos2_printer.utils.Constants.EXTRA_BRANCH_ID
import com.epson.epos2_printer.utils.Constants.EXTRA_CHECKED_NUMBER
import com.epson.epos2_printer.utils.Constants.EXTRA_ERROR
import com.epson.epos2_printer.utils.Constants.EXTRA_ERROR_EN
import com.epson.epos2_printer.utils.Constants.EXTRA_MOBILE_NUMBER
import com.epson.epos2_printer.utils.Constants.INPUT_NUMBER_LENGTH
import com.epson.epos2_printer.utils.Constants.LNG_ARABIC
import com.epson.epos2_printer.utils.Constants.LNG_ENGLISH
import com.epson.epos2_printer.utils.Constants.MSG_UPDATE_FAILED
import com.epson.epos2_printer.utils.Constants.MSG_UPDATE_SUCCESFULL
import com.epson.epos2_printer.utils.Constants.NO_BRANCH_INFORMATION
import com.epson.epos2_printer.utils.Constants.NO_BRANCH_INFORMATION_AR
import com.epson.epos2_printer.utils.KioskService
import com.epson.epos2_printer.utils.Resource
import com.epson.epos2_printer.viewmodel.BackEndViewModel
import com.epson.epos2_printer.viewmodel.BackEndViewModelProviderFactory
import com.epson.epos2_printer.viewmodel.QViewModel
import com.epson.epos2_printer.viewmodel.QViewModelProviderFactory
import com.google.android.play.core.appupdate.AppUpdateManagerFactory
import com.google.android.play.core.install.model.AppUpdateType
import com.google.android.play.core.install.model.UpdateAvailability
import com.google.android.play.core.ktx.isFlexibleUpdateAllowed
import com.google.android.play.core.ktx.isImmediateUpdateAllowed
import com.shashank.sony.fancytoastlib.FancyToast
import com.yariksoffice.lingver.Lingver
import kotlinx.android.synthetic.main.activity_mobile_entry.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*
import kotlin.collections.ArrayList


class MobileEntryActivity : AppCompatActivity(), NumberKeyboardListener {

    private lateinit var viewModel: QViewModel

  //  private lateinit var backEndViewModel: BackEndViewModel

    private var amount: String = ""  //text

    private var count = 0

    private val REQUEST_PERMISSION = 100




    private lateinit var mProccedEn: Button
    private lateinit var mProccedAr: Button
    private lateinit var mImageLogo: ImageView


    var mPrinter: Printer? = null
    var branchTimer: Long = 0

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return super.onTouchEvent(event)
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

    override fun onDestroy() {
        cancelTimer()
        super.onDestroy()
    }




//screensavercode
    val timer = object: CountDownTimer(Constants.DELAY_SCREENSAVER, 1) {
        override fun onTick(millisUntilFinished: Long) {}




        override fun onFinish() {
            Log.d("TAG", "onFinish: called ")
        try{
            val intent = Intent(
                this@MobileEntryActivity, ScreenSaverActivity::class.java
            )
            startActivityForResult(intent,900)
        }catch (e: java.lang.Exception){

        }


        //    startActivity(intent)

        }
    }
//screensavercode
    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        // dismiss shown snackbar if user tapped anywhere outside snackbar

        cancelTimer()

        startTimer()
        Log.d("TAG", "dispatchTouchEvent: timerStarted1")

        // call super
        return super.dispatchTouchEvent(ev)
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

    private fun startKioskService() { // ... and this method
        startService(Intent(this, KioskService::class.java))
    }

    private fun increaseBrightness(){

    }




    private var REQUEST_CODE_UPDATE_APP = 12


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        Log.d("TAG", "onResume: first onCreate $count")
       /* // settingLanguage()
        if(isCanWriteSettings(this))
            setupLight(this,255)//0~255
        else
            requestCanWriteSettings(this)*/

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.activity_mobile_entry)
        requestRuntimePermission()
        initializeObject()

        val qRepository = QRepository()
        val viewModelProviderFactory =
                QViewModelProviderFactory(
                        application,
                        qRepository
                )
      /*  val backEndViewModelProviderFactory =
                BackEndViewModelProviderFactory(
                        application,
                        qRepository
                )*/
        ////screensavercode

          startTimer()


        Log.d("TAG", "onCreate: timerstarted2")
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(QViewModel::class.java)

     //   backEndViewModel = ViewModelProvider(this, backEndViewModelProviderFactory).get(BackEndViewModel::class.java)
       //todo backend added
         lateinit var backEndViewModel: BackEndViewModel

        val backEndViewModelProviderFactory =
            BackEndViewModelProviderFactory(
                application,
                qRepository
            )
        backEndViewModel = ViewModelProvider(this, backEndViewModelProviderFactory).get(
            BackEndViewModel::class.java)

        backEndViewModel.saveISCallSendDisplayMessage(true)
        backEndViewModel.savePreferenceDisplayMessage(null)
        backEndViewModel.saveShowBlinkIndexPreference(-1)
        backEndViewModel.saveIsCallTIMERDISPLAY(false)
        backEndViewModel.setDispenserSettings()

        CoroutineScope(Dispatchers.Main).launch {
            delay(Constants.DELAY_CHECK_BRANCH)
            backEndViewModel.getCounter()
            backEndViewModel.sendDisplayMessage()
            backEndViewModel.timerDisplay()
        }
        setObserver()
        val branchId = getPreference()


        mProccedEn = findViewById(R.id.mProceedEn)
        mProccedAr = findViewById(R.id.mProceedAr)
        mImageLogo = findViewById(R.id.mZainLogo)

        mNumberKeyboard.setListener(this)

        clickListener()
        if (branchId != BRANCH_DEFAULT_VALUE)
            viewModel.isBranchOpen(branchID = branchId)

        //registerKioskModeScreenOffReceiver();
     //   startKioskService();

     //   preventStatusBarExpansion(applicationContext)

      //    updateApp()
        sendVersion()   

    }

    //************************************************ update preference ********************************
    private fun updateBranchPreference(id: Int, name: String) {
        val pref = applicationContext.getSharedPreferences(
            BRANCH_AUTH,
            0
        ) // 0 - for private mode
        val editor = pref.edit()
        editor.putInt(BRANCH_AUTH_ID, id)
        editor.putString(Constants.BRANCH_AUTH_NAME, name)
        editor.apply() // commit changes
    }

    /**
     *
     * @param context
     * @param light max 255
     */
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
            ////screensavercode
            cancelTimer()
            val intent = Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS)
            intent.data = Uri.parse("package:" + activity.packageName)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            activity.startActivityForResult(intent, 0)
        }catch (e: Exception){
            Log.e("requestCanWriteSettings","requestCanWriteSettings $e")
        }
    }



    fun preventStatusBarExpansion(context: Context) {

        val manager = context.getApplicationContext().getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val localLayoutParams: WindowManager.LayoutParams = WindowManager.LayoutParams()
        localLayoutParams.type = WindowManager.LayoutParams.TYPE_APPLICATION_PANEL
        localLayoutParams.gravity = Gravity.TOP
        localLayoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL or WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
        localLayoutParams.width = WindowManager.LayoutParams.MATCH_PARENT
        val resId: Int = context.getResources().getIdentifier("status_bar_height", "dimen", "android")
        var result = 0
        result = if (resId > 0) {
            context.getResources().getDimensionPixelSize(resId)
        } else {
            // Use Fallback size:
            60 // 60px Fallback
        }
        localLayoutParams.height = result
        localLayoutParams.format = PixelFormat.TRANSPARENT
        val view: CustomViewGroup = CustomViewGroup(context)
        manager.addView(view, localLayoutParams)
    }


    /*override fun onPause() {
        super.onPause()
        try{
            Log.d("TAG", "onPause: lifecycle called")
            branchTimer = System.currentTimeMillis()
        }catch (e: Exception){
            e.printStackTrace()
        }
    }*/

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d("TAG", "onActivityResult: called")
////screensavercode
        cancelTimer()
        startTimer()
        Log.d("TAG", "onCreate: timerstarted3")


        if(requestCode == REQUEST_CODE_UPDATE_APP){
            if (resultCode == Activity.RESULT_OK){
                showToastSuccess(MSG_UPDATE_SUCCESFULL)
            }else{
                showToastFail(MSG_UPDATE_FAILED)
            }
        }
        try {
            val branchId = getPreference()
            if (branchId != BRANCH_DEFAULT_VALUE){
                    Log.d("TAG", "onResume: branch timer called  ${System.currentTimeMillis()}   $branchTimer  ${ System.currentTimeMillis() - branchTimer }")
                    viewModel.isBranchOpen(branchID = branchId)
            }
        } catch (e: Exception) {
            showToastFail("something wrong please reopen application")
        }
    }
    override fun onResume() {
        Log.d("TAG", "onResume: lifecycle first $count")

        super.onResume()
        /*try {
            val branchId = getPreference()
            if (branchId != BRANCH_DEFAULT_VALUE){
                if(branchTimer == 0.toLong() ||  System.currentTimeMillis() - branchTimer  > 85000 ) {
                    Log.d("TAG", "onResume: branch timer called  ${System.currentTimeMillis()}   $branchTimer  ${ System.currentTimeMillis() - branchTimer }")
                    viewModel.isBranchOpen(branchID = branchId)
                }

            }
        } catch (e: Exception) {
            showToastFail("something wrong please reopen application")
        }*/

        amount = ""
        showAmount()
        mInputNumber.error = null
        mDontBtnRadio.isChecked = false

        val decorView = window.decorView
        decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)

    //    count++
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


    //**************************************************************************** clickListener ************************************************************************
    @SuppressLint("ClickableViewAccessibility")
    private fun clickListener() {
        var then: Long = 0

        mDontHaveNumber.setOnClickListener {
            mDontBtnRadio.performClick()
        }

        mProccedEn.setOnClickListener {
            if (mDontBtnRadio.isChecked || mInputNumber.length() == INPUT_NUMBER_LENGTH) {
                proceedWithEnglish()
            }else{
                showToastInfo("Please Enter the correct Number OR click on the ✅ Check Box")
                if(mInputNumber.length() > 0){
                    startAnimationInputNumberError()
                }else{
                    startAnimationError()
                }

            }
        }

        mProccedAr.setOnClickListener {
            if (mDontBtnRadio.isChecked || mInputNumber.length() == INPUT_NUMBER_LENGTH) {
                proceedWithArabic()
            }else{
                showToastInfo("Please Enter the correct Number OR click on the ✅ Check Box")
                if(mInputNumber.length() > 0){
                    startAnimationInputNumberError()
                }else{
                    startAnimationError()
                }
            }

        }

        mImageLogo.setOnTouchListener { _, event ->
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
                       /* val intent = Intent(
                                this, SettingActivity::class.java
                        )*/
                        ////screensavercode
                    cancelTimer()

                         val intent = Intent(
                                this, IntializeSettingActivity::class.java
                        )
                        startActivityForResult(intent,900)

                    }
                }
            }
            true
        }
    }

    fun shakeError(): TranslateAnimation? {
        val shake = TranslateAnimation(0.toFloat(), 10.toFloat(), 0.toFloat(), 0.toFloat())
        shake.duration = 500
        shake.interpolator = CycleInterpolator(7.toFloat())
        return shake
    }

    fun startAnimationError(){
      //  mInputNumber.startAnimation(shakeError())
        mDontHaveNumber.startAnimation(shakeError())
        mDontBtnRadio.startAnimation(shakeError())
    }
    fun startAnimationInputNumberError(){
          mInputNumber.startAnimation(shakeError())
    }
    override fun onNumberClicked(number: Int) {
        if (amount.isEmpty() && number != ALLOW_NUMBER_9 && number != ALLOW_NUMBER_6 && number != ALLOW_NUMBER_5) {
            mInputNumber.isFocusable = true
            mInputNumber.requestFocus()
            mInputNumber.error = getString(R.string.mobile_number_cannot_start_with) + " " + number.toString()
        } else {
            mInputNumber.error = null
            val newAmount = amount + number.toString()

            if (newAmount.length < INPUT_NUMBER_LENGTH + 1) {
                amount = newAmount
                showAmount()
            }

        }

    }

    override fun onLeftAuxButtonClicked() {
        amount = ""
        showAmount()
    }

    override fun onRightAuxButtonClicked() {
        if (amount.isNotEmpty()) {
            amount = amount.substring(0, amount.length - 1)
        }
        showAmount()
    }

    private fun showAmount() {
        mInputNumber.setText(amount)
    }

    fun sendVersion(){
        Log.d("TAG", "sendVersion: called sendversion")
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
            val branchId = getPreference()

            if(branchId != BRANCH_DEFAULT_VALUE){
                Log.d("TAG", "sendVersion: called version $versionName")
                viewModel.sendTabletStatus(branchId,"Version Number", versionName)
            }
            CoroutineScope(Dispatchers.Main).launch{
                delay(DELAY_UPDATE_APP)
                sendVersion()
            }

        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
    }

    //******************************************* observer ******************************************************
    private fun setObserver() {
        viewModel.isBranchOpen.observe(this, Observer { response ->
            when (response) {
                is Resource.Loading -> {
                    //   mProccedAr.isEnabled = false
                    //   mProccedEn.isEnabled = false
                }

                is Resource.Success -> {
                    //   mProccedAr.isEnabled = true
                    //   mProccedEn.isEnabled = true
                    if (response.data != null) {
                        for (list in response.data) {
                            Log.d("TAG", "observer: $1")
                            if(list.IsOnBreak == null){
                                list.IsOnBreak = false
                            }
                            if (list.IsOpen != null && list.IsOnBreak != null) {

                                Log.d("TAG", "observer: $ ${list.IsOpen} ${list.IsOnBreak}")
                                if (list.IsOpen!! && !list.IsOnBreak!!) {

                                    val intent = Intent(
                                            this, ServiceActivity::class.java
                                    )
                                    val branchId = getPreference()
                                    CoroutineScope(Dispatchers.Main).launch {
                                        delay(Constants.DELAY_CHECK_BRANCH)
                                        if (branchId != BRANCH_DEFAULT_VALUE)
                                            viewModel.isBranchOpen(branchId)
                                    }
                                    /* intent.putExtra(EXTRA_BRANCH_ID, branchId)
                                     intent.putExtra(EXTRA_CHECKED_NUMBER, mDontBtnRadio.isChecked)
                                     intent.putExtra(EXTRA_MOBILE_NUMBER, mInputNumber.text.toString())
                                     startActivity(intent)*/
                                } else {
                                    val intent = Intent(
                                            this, ErrorActivity::class.java
                                    )
                                    ////screensavercode
                                  cancelTimer()

                                    intent.putExtra(EXTRA_ERROR,list.msgAr)
                                    intent.putExtra(EXTRA_ERROR_EN,list.msgEn)
                                   // intent.putExtra(EXTRA_ERROR, getString(R.string.branch_is_closed))
                                    intent.putExtra(EXTRA_BRANCH_ID, getPreference())
                                    startActivityForResult(intent,900)
                                }
                            }
                        }

                    } else {/*
                            mProccedAr.isEnabled = true
                            mProccedEn.isEnabled = true*/
                                ////screensavercode
                       cancelTimer()
                        val intent = Intent(
                                this, ErrorActivity::class.java
                        )
                        intent.putExtra(EXTRA_ERROR, NO_BRANCH_INFORMATION_AR)
                        intent.putExtra(EXTRA_ERROR_EN,NO_BRANCH_INFORMATION )
                        startActivityForResult(intent,900)
                    }
                }

                is Resource.Error -> {
                    showToastInfo(response.message.toString())
                  /*  val intent = Intent(
                            this, ErrorActivity::class.java
                    )

                    intent.putExtra(EXTRA_ERROR, response.message.toString())
                    intent.putExtra(EXTRA_BRANCH_ID, getPreference())
                   // startActivity(intent)
                    startActivityForResult(intent,900)*/
                }

            }


        })
    }

    //**************************************************************** ui **************************************
    /*  private fun settingHint() {
          when (amount.length) {
              1 -> {
                  mInputNumberField.hint = amount + "XXXXXXX"
              }
              2 -> {
                  mInputNumberField.hint = amount + "XXXXXX"
              }
              3 -> {
                  mInputNumberField.hint = amount + "XXXXX"
              }
              4 -> {
                  mInputNumberField.hint = amount + "XXXX"
              }
              5 -> {
                  mInputNumberField.hint = amount + "XXX"
              }
              6 -> {
                  mInputNumberField.hint = amount + "XX"
              }
              7 -> {
                  mInputNumberField.hint = amount + "X"
              }
              8 -> {
                  mInputNumberField.hint = amount
              }
              else -> {
                  mInputNumberField.hint = "XXXXXXXX"
              }
          }

      }*/

    //**************************************************************************** language ************************************************************************
    private fun settingLanguage() {
        if (Locale.getDefault().displayLanguage != DISPLAY_LNG_ENGLISH) {
            Lingver.getInstance().setLocale(this, LNG_ENGLISH)
////screensavercode
         cancelTimer()

            val intent = Intent(
                    this, MobileEntryActivity::class.java
            )
            startActivityForResult(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP),900)

        //    startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK))
        }
    }

    //******************************************************** intent *******************************************
    private fun proceedWithEnglish() {
        Lingver.getInstance().setLocale(this, LNG_ENGLISH)
        proceedToNext()
    }

    private fun proceedWithArabic() {
        Lingver.getInstance().setLocale(this, LNG_ARABIC)
        proceedToNext()
    }

    private fun proceedToNext() {
        val branchId = getPreference()

        if (branchId != BRANCH_DEFAULT_VALUE) {
            //  viewModel.isBranchOpen(branchId)
            if (mDontBtnRadio.isChecked || mInputNumber.length() == INPUT_NUMBER_LENGTH) {
                ////screensavercode
             cancelTimer()

                val intent = Intent(
                        this, ServiceActivity::class.java
                )
                intent.putExtra(EXTRA_BRANCH_ID, branchId)
                intent.putExtra(EXTRA_CHECKED_NUMBER, mDontBtnRadio.isChecked)
                intent.putExtra(EXTRA_MOBILE_NUMBER, mInputNumber.text.toString())
                startActivityForResult(intent,900)
            }


        } else {
            ////screensavercode
          cancelTimer()

            val intent = Intent(
                    this, ErrorActivity::class.java
            )
            intent.putExtra(EXTRA_ERROR, BRANCH_ADMIN_AR)
            intent.putExtra(EXTRA_ERROR_EN, BRANCH_ADMIN_En)
            startActivityForResult(intent,900)
        }

    }

    //******************************************* prefrence ***********************************
    private fun getPreference(): Int {
        val pref = applicationContext.getSharedPreferences(
                BRANCH_AUTH,
                0
        ) // 0 - for private mode

        return pref.getInt(BRANCH_AUTH_ID, BRANCH_DEFAULT_VALUE)

    }

    //******************************************* visibility ************************************************
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
    /*  private fun isButtonShouldEnable(){
          if (mDontBtnRadio.isChecked || mInputNumber.length() == 8) {
              enableButtons()
          }
          else{
              disableButtons()
          }
      }*/

    /*  private fun enableButtons(){
          mProccedAr.isEnabled = true
          mProccedEn.isEnabled = true
          mProccedEn.alpha = 1f
          mProccedAr.alpha = 1f
      }

      private fun disableButtons(){
          mProccedAr.isEnabled = false
          mProccedEn.isEnabled = false
          mProccedEn.alpha = 0.9f
          mProccedAr.alpha = 0.9f
      }
  */

    private fun requestRuntimePermission() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return
        }
        val permissionStorage = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        val permissionLocation = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
        val requestPermissions: MutableList<String> = ArrayList()
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


    private fun initializeObject(): Boolean {
        try {

            mPrinter = Printer((Printer.TM_M30),
                    (Printer.MODEL_ANK),
                    this)


            //createReceiptData();
            /*connectPrinter();*/

            /*  if (!runPrintReceiptSequence()) {
                updateButtonState(true);
            }*/
        } catch (e: java.lang.Exception) {
            ShowMsg.showException(e, "Printer", this)
            return false
        }
        return true
    }


    //********************** update avaiablelity ***************
    fun  updateApp(){

        Log.d("TAG", "updateApp: updating the app")
        val appUpdateManager = AppUpdateManagerFactory.create(this)
        val appUpdateInfoTask = appUpdateManager!!.appUpdateInfo

        try{
            appUpdateInfoTask.addOnSuccessListener { appUpdateInfo ->
                Log.d("TAG", "updateApp: updating the app 1")
                if(appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE && !appUpdateInfo.isFlexibleUpdateAllowed){
                //    showToastInfo("No Flexible Applowed")
                }
                if(appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE && !appUpdateInfo.isImmediateUpdateAllowed){
              //      showToastInfo("No Imeddiate Applowed")
                }
                if(appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE){
                     //showToastSuccess("Avaiable");
                    Log.d("TAG", "updateApp: updating the app 2")
                    try{
                        appUpdateManager!!.startUpdateFlowForResult(appUpdateInfo, AppUpdateType.IMMEDIATE,
                                this@MobileEntryActivity,
                                REQUEST_CODE_UPDATE_APP
                        )
                        showToastSuccess("available started")
                    }catch (e: java.lang.Exception) {
                    //    showToastFail(e.message.toString())
                    }
                }else{
                  //  showToastSuccess("Avaiblable");
                }
            }
        }catch (e: java.lang.Exception){

        }



    var con = this
        CoroutineScope(Dispatchers.Main).launch {
            delay(Constants.DELAY_UPDATE_APP)
            Log.d("TAG", "updateApp: ${con.isChild} des ${con.isDestroyed} ${con.isFinishing}  ${con.isRestricted} ${con.isTaskRoot} ${con.isTaskRoot} ")
                updateApp()

        }
    }

}


class CustomViewGroup(context: Context?) : ViewGroup(context) {
    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {}
    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        // Intercepted touch!
        return true
    }
}


