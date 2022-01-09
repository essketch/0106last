package com.example.a0106last.api

import android.content.Context
import com.example.a0106last.utils.ContextUtil
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServerAPI {

    companion object {

        private val BASE_URL = "https://api.gudoc.in"
        private var retrofit : Retrofit? = null

        fun getRetrofit(context: Context) : Retrofit {

            if (retrofit==null) {

                val interceptor = Interceptor{
                    with(it) {
                        val newRequest = request().newBuilder()
                            .addHeader("X-Http-Token", ContextUtil.getToken(context))
                            .build()

                        proceed(newRequest)
                    }
                }

                val myClient = OkHttpClient.Builder().addInterceptor(interceptor).build()



                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(myClient)
                    .build()
            }

            return retrofit!!

        }


    }



}