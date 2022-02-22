package com.epson.epos2_printer.utils

import android.content.Context
import com.epson.epos2.printer.Printer
import com.epson.epos2_printer.ShowMsg
import com.epson.epos2_printer.api.PdaAPI
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class PrinterSingleTon {

    companion object {

        @Volatile private var INSTANCE: Printer? = null

        fun getInstance(context: Context): Printer =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?:   Printer(1,
                            0,
                            context).also { INSTANCE = it }
                }

    }


}
