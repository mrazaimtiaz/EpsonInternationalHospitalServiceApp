package com.epson.epos2_printer.ui

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.Drawable
import android.graphics.drawable.TransitionDrawable
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.epson.epos2_printer.R
import com.epson.epos2_printer.repository.QRepository
import com.epson.epos2_printer.utils.Constants
import com.epson.epos2_printer.utils.Resource
import com.epson.epos2_printer.viewmodel.BackEndViewModel
import com.epson.epos2_printer.viewmodel.BackEndViewModelProviderFactory
import com.epson.epos2_printer.viewmodel.QViewModel
import com.epson.epos2_printer.viewmodel.QViewModelProviderFactory
import kotlinx.android.synthetic.main.activity_screen_saver.*
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext


class ScreenSaverActivity : AppCompatActivity() {

    private lateinit var viewModel: QViewModel
    private val images: MutableList<Int> = mutableListOf()
    var selected = 0

     var  coroutineContext: CoroutineContext? = null


    lateinit var backEndViewModel: BackEndViewModel

    var isRunning = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  requestWindowFeature(Window.FEATURE_NO_TITLE)
     /*   window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
*/
        setContentView(R.layout.activity_screen_saver)


        Log.d("TAG", "onCreate: created screen")

        //  images.add(R.drawable.zainlogo)
        images.add(R.drawable.screensaver1)
        images.add(R.drawable.screensaver2)
        //   images.add(R.drawable.star_logo_image)


        val qRepository = QRepository()
        val viewModelProviderFactory =
            QViewModelProviderFactory(
                application,
                qRepository
            )


        val backEndViewModelProviderFactory =
            BackEndViewModelProviderFactory(
                application,
                qRepository
            )
        backEndViewModel = ViewModelProvider(this, backEndViewModelProviderFactory).get(
            BackEndViewModel::class.java
        )
        CoroutineScope(Dispatchers.Main).launch {
            delay(Constants.DELAY_CHECK_BRANCH)
            backEndViewModel.getCounter()
            backEndViewModel.sendDisplayMessage()
            backEndViewModel.timerDisplay()
            backEndViewModel.callChangeImage()
        }

        if (selected >= images.size) {
            selected = 0
        }

        iv_screensaver.setImageDrawableWithAnimation(getDrawable(images[selected])!!)

        iv_screensaver.background = getDrawable(images[selected])!!
        selected += 1

        val branchId = getPreference()

        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(QViewModel::class.java)
      //  if (branchId != Constants.BRANCH_DEFAULT_VALUE)
        //   viewModel.isBranchOpen(branchID = branchId)

        /* for(i in 1..5){
             Glide.with(this@ScreenSaverActivity).asBitmap().load("https://www.google.es/images/srpr/logo11w.png").into(object : CustomTarget<Bitmap?>() {
                 override fun onResourceReady(resource: Bitmap, @Nullable transition: Transition<in Bitmap?>?) {
                     iv_screensaver.setImageBitmap(resource)
                     //   bitmapArray.ad
                 }
                 override fun onLoadCleared(@Nullable placeholder: Drawable?) {}
             })
         }*/
          //  setScreenSaver()
        observeScreenSaver()
        //  setObserver()


    }

    fun observeScreenSaver(){
        backEndViewModel.changeImage.observe(this, Observer {
            coroutineContext = CoroutineScope(Dispatchers.Main).launch {
                Log.d("TAG", "observeScreenSaver: called image change")
            delay(10000)
            if (selected >= images.size) {
                selected = 0
            }
                iv_screensaver.setImageDrawableWithAnimation(getDrawable(images[selected])!!)

              //  iv_screensaver.setImageDrawable(getDrawable(images[selected])!!);

                iv_screensaver.background = getDrawable(images[selected])!!
                selected += 1
                Log.d("TAG", "setScreenSaver: called screen saver")


                backEndViewModel.callChangeImage()


        }

        })
    }

    override fun onDestroy() {
        coroutineContext?.cancel()
        super.onDestroy()
    }

    fun ImageView.setImageDrawableWithAnimation(drawable: Drawable, duration: Int = 300) {
        val currentDrawable = getDrawable()
        if (currentDrawable == null) {
            setImageDrawable(drawable)
            return
        }

        val transitionDrawable = TransitionDrawable(
            arrayOf(
                currentDrawable,
                drawable
            )
        )
        setImageDrawable(transitionDrawable)
        transitionDrawable.startTransition(duration)
    }

    private fun setScreenSaver() {
        if (selected >= images.size) {
            selected = 0
        }


        CoroutineScope(Dispatchers.Main).launch {
           // iv_screensaver.setImageDrawable(getDrawable(images[selected])!!);
            iv_screensaver.setImageDrawableWithAnimation(getDrawable(images[selected])!!)

            iv_screensaver.background = getDrawable(images[selected])!!
            selected += 1
            Log.d("TAG", "setScreenSaver: called screen saver")

            if(isRunning){
                withContext(Dispatchers.IO){
                    delay(10000)
                    setScreenSaver()
                }

            }



        }

    }

  /*  override fun onWindowFocusChanged(hasFocus: Boolean) {
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
    }*/


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
                            if (list.IsOnBreak == null) {
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
                                        if (branchId != Constants.BRANCH_DEFAULT_VALUE)
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
                                    intent.putExtra(Constants.EXTRA_ERROR, list.msgAr)
                                    intent.putExtra(Constants.EXTRA_ERROR_EN, list.msgEn)
                                    // intent.putExtra(EXTRA_ERROR, getString(R.string.branch_is_closed))
                                    intent.putExtra(Constants.EXTRA_BRANCH_ID, getPreference())
                                    startActivityForResult(intent, 900)
                                }
                            }
                        }

                    } else {/*
                            mProccedAr.isEnabled = true
                            mProccedEn.isEnabled = true*/
                        val intent = Intent(
                            this, ErrorActivity::class.java
                        )
                        intent.putExtra(Constants.EXTRA_ERROR, Constants.NO_BRANCH_INFORMATION_AR)
                        intent.putExtra(Constants.EXTRA_ERROR_EN, Constants.NO_BRANCH_INFORMATION)
                        startActivityForResult(intent, 900)
                    }
                }

                is Resource.Error -> {
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

    //******************************************* prefrence ***********************************
    private fun getPreference(): Int {
        val pref = this.getSharedPreferences(
            Constants.BRANCH_AUTH,
            0
        ) // 0 - for private mode

        return pref.getInt(Constants.BRANCH_AUTH_ID, Constants.BRANCH_DEFAULT_VALUE)

    }


    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        // dismiss shown snackbar if user tapped anywhere outside snackbar
        isRunning = false
        setResult(Activity.RESULT_OK)
        finish()
        // call super
        return super.dispatchTouchEvent(ev)
    }


}