package com.epson.epos2_printer.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.epson.epos2_printer.R
import com.epson.epos2_printer.repository.QRepository
import com.epson.epos2_printer.viewmodel.QViewModelProviderFactory
import com.shashank.sony.fancytoastlib.FancyToast
import com.epson.epos2_printer.utils.Constants
import com.epson.epos2_printer.utils.Constants.NO_BRANCH_INFORMATION
import com.epson.epos2_printer.utils.Constants.NO_BRANCH_INFORMATION_AR
import com.epson.epos2_printer.utils.Resource
import com.epson.epos2_printer.viewmodel.QViewModel
import kotlinx.android.synthetic.main.activity_error.*
import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import android.os.Build
import android.provider.Settings
import androidx.annotation.RequiresApi
import com.epson.epos2_printer.viewmodel.BackEndViewModel
import com.epson.epos2_printer.viewmodel.BackEndViewModelProviderFactory
import kotlinx.android.synthetic.main.activity_mobile_entry.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashActivity : AppCompatActivity() {

    private lateinit var viewModel: QViewModel

    private lateinit var backEndViewModel: BackEndViewModel

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Log.d("TAG", "onCreate: called 1")



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

   /*     backEndViewModel = ViewModelProvider(this, backEndViewModelProviderFactory).get(BackEndViewModel::class.java)

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
        }*/
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(QViewModel::class.java)
        setObserver()
        val branchId = getPreference()


        if (branchId != Constants.BRANCH_DEFAULT_VALUE)
            viewModel.isBranchOpen(branchID = branchId)
        else {
         //   showToastInfo(getString(R.string.choose_a_branch_admin))
            intentMain()
        }


     //   updateBoolPreference(true)

    }




    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d("TAG", "onActivityResult: called ")
        try {
            val branchId = getPreference()
            if (branchId != Constants.BRANCH_DEFAULT_VALUE){
                viewModel.isBranchOpen(branchID = branchId)
            }
            else {
              //  showToastInfo(getString(R.string.choose_a_branch_admin))
                intentMain()
            }
        } catch (e: Exception) {
            Log.d("TAG", "onResume: Exception 38")
            showToastFail("something wrong please reopen application")
        }
    }
    override fun onResume() {
        super.onResume()
        Log.d("TAG", "onResume: called")
       /* try {
            val branchId = getPreference()
            if (branchId != Constants.BRANCH_DEFAULT_VALUE){
            //    if(count != 0){
                    viewModel.isBranchOpen(branchID = branchId)
            //    }
            }
            else {
                showToastInfo(getString(R.string.choose_a_branch_admin))
                intentMain()
            }
        } catch (e: Exception) {
            Log.d("TAG", "onResume: Exception 38")
            showToastFail("something wrong please reopen application")
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
            Log.d("TAG", "onResume: Exception 33 ")
            e.printStackTrace()
        }
        count++
    }

    private fun showToastFail(message: String) {
        try {
            FancyToast.makeText(
                    this, message, FancyToast.LENGTH_SHORT,
                    FancyToast.ERROR, false
            ).show()
        } catch (e: Exception) {
            Log.d("TAG", "onResume: Exception 31 ")
            e.printStackTrace()
        }
    }

    //******************************************* prefrence ***********************************
    private fun getPreference(): Int {
        val pref = applicationContext.getSharedPreferences(
                Constants.BRANCH_AUTH,
                0
        ) // 0 - for private mode
        return pref.getInt(Constants.BRANCH_AUTH_ID, Constants.BRANCH_DEFAULT_VALUE)

    }

    //******************************************* observer ******************************************************
    private fun setObserver() {
        viewModel.isBranchOpen.observe(this, Observer { response ->
            Log.d("TAG", "setObserver: called 1")
            when (response) {

                is Resource.Success -> {
                    Log.d("TAG", "setObserver: called 2")
                    try {
                        if (response.data != null) {
                            Log.d("TAG", "setObserver: called 3")
                            for (list in response.data) {
                                if (list.IsOpen != null) {
                                    Log.d("TAG", "setObserver: called 4")
                                    if( list.IsOnBreak == null){
                                        list.IsOnBreak = false
                                    }
                                    if (list.IsOpen!! && !list.IsOnBreak!!) {
                                        Log.d("TAG", "setObserver: called 6")
                                        intentMain()
                                    } else {
                                        Log.d("TAG", "setObserver: called 7")
                                        val intent = Intent(
                                                this, ErrorActivity::class.java
                                        )
                                        intent.putExtra(Constants.EXTRA_ERROR, list.msgAr.toString())
                                        intent.putExtra(Constants.EXTRA_ERROR_EN, list.msgEn.toString())
                                        intent.putExtra(Constants.EXTRA_BRANCH_ID, getPreference())
                                        //startActivity(intent)
                                        startActivityForResult(intent,900)
                                    }
                                }
                            }
                        } else {
                            Log.d("TAG", "setObserver: called 5")
                            val intent = Intent(
                                    this, ErrorActivity::class.java
                            )
                            intent.putExtra(Constants.EXTRA_ERROR, NO_BRANCH_INFORMATION_AR)
                            intent.putExtra(Constants.EXTRA_ERROR_EN, NO_BRANCH_INFORMATION)
                            //startActivity(intent)
                            startActivityForResult(intent,900)
                        }
                    } catch (e: Exception) {
                        Log.d("TAG", "onResume: Exception 30 ")
                        e.printStackTrace()
                    }
                }

                is Resource.Error -> {
                    Log.d("TAG", "setObserver: called 3")
                    val intent = Intent(
                            this, ErrorActivity::class.java
                    )
                    intent.putExtra(Constants.EXTRA_ERROR, response.message.toString())
                    //startActivity(intent)
                    startActivityForResult(intent,900)
                }
            }
        })
    }

    //******************************************* intent main **********************************************
    private fun intentMain() {

        val branchId = getPreference()
        val intent = Intent(
                this, ServiceActivity::class.java
        )
        intent.putExtra(Constants.EXTRA_BRANCH_ID, branchId)
        intent.putExtra(Constants.EXTRA_CHECKED_NUMBER,false)
        intent.putExtra(Constants.EXTRA_MOBILE_NUMBER, "")
        startActivityForResult(intent,900)
        startActivityForResult(intent,900)
       // startActivity(intent)
    }

    private fun showToastInfo(message: String) {
        FancyToast.makeText(
                this, message, FancyToast.LENGTH_SHORT,
                FancyToast.INFO, false
        ).show()
    }

    //************************************************ update preference ********************************
/*    private fun updateBoolPreference(bool: Boolean) {
        val pref = applicationContext.getSharedPreferences(
                "boolauth",
                0
        ) // 0 - for private mode
        val editor = pref.edit()
        editor.putBoolean("bool", bool)
        editor.apply() // commit changes
    }*/

}