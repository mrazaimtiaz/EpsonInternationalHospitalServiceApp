package com.epson.epos2_printer

import android.app.Application
import android.util.Log
import android.view.MotionEvent
import com.epson.epos2_printer.utils.Constants.LNG_ENGLISH
import com.yariksoffice.lingver.Lingver

class QappApplication : Application() {

    override fun onCreate() {
        Lingver.init(this, LNG_ENGLISH)
        super.onCreate()
    }




}