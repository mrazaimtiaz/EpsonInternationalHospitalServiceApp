package com.epson.epos2_printer.ui

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
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
import com.epson.epos2_printer.utils.Resource
import com.epson.epos2_printer.viewmodel.QViewModel
import kotlinx.android.synthetic.main.activity_error.*
import kotlinx.coroutines.*

class IntializeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        finish()
    }
}
