package com.example.a0106last.fcm

import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFCMService : FirebaseMessagingService() {

    override fun onMessageReceived(p0: RemoteMessage) {
        super.onMessageReceived(p0)

        val text = p0.notification!!.title!!
        Log.d("푸시알림수신", text)
        val myHandler = Handler(Looper.getMainLooper())
        myHandler.post{
            Toast.makeText(applicationContext, text, Toast.LENGTH_SHORT).show()
        }




    }

}