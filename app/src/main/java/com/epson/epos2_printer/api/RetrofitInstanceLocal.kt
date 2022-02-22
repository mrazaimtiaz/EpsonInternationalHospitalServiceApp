package com.epson.epos2_printer.api

import com.epson.epos2_printer.utils.Constants.BASE_URL_LOCAL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitInstanceLocal {
    companion object {
        private val retrofitLocal by lazy {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)

            val client = OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .connectTimeout(100, TimeUnit.SECONDS)
                    .readTimeout(100, TimeUnit.SECONDS)
                    .build()


            Retrofit.Builder()
                    .baseUrl(BASE_URL_LOCAL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build()
        }

        val api by lazy {
            retrofitLocal.create(PdaAPI::class.java)
        }
    }
}