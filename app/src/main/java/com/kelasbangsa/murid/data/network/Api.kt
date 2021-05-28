package com.kelasbangsa.murid.data.network

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.kelasbangsa.murid.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class Api {
    companion object {
        @Volatile private var apiService: ApiService? = null

        private val gson: Gson by lazy {
            GsonBuilder()
                .create()
        }

        private fun httpClient(context: Context): OkHttpClient {
            val logginInterceptor = HttpLoggingInterceptor()
            logginInterceptor.level = HttpLoggingInterceptor.Level.BODY

            return OkHttpClient().newBuilder()
                .addInterceptor(Interceptor(SessionManager(context)))
                .addInterceptor(logginInterceptor)
                .build()
        }

        fun retrofit(context: Context): Retrofit {
            val adapter = RxJava3CallAdapterFactory.create()

            return Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .client(httpClient(context))
                .addCallAdapterFactory(adapter)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        }

        fun apiService(context: Context): ApiService {
            if(apiService == null) {
                apiService = retrofit(context).create(ApiService::class.java)
            }

            return apiService!!
        }
    }
}