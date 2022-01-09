package com.example.a0106last.utils

import android.content.Context

class ContextUtil {


    companion object {


        val PREF_NAME = "APIPracticePref"

        val TOKEN = "TOKEN"

        fun setToken(context: Context, token: String) {
            val pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
            pref.edit().putString(TOKEN, token).apply()
        }

        fun getToken(context: Context) : String {
            val pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
            return pref.getString(TOKEN, "")!!
        }



    }

}