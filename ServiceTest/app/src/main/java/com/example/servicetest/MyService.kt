package com.example.servicetest

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

class MyService : Service() {
private val mBinder = DownloadBinder()
    class DownloadBinder : Binder(){
        fun startDownload(){
            Log.d("Myservice","start download")
        }
        fun getProgress(){
            Log.d("Myservice","progress geted")
        }
    }
    override fun onBind(intent: Intent): IBinder {
      //  TODO("Return the communication channel to the service.")
        return mBinder
    }

    override fun onCreate() {
        super.onCreate()
        Log.d("Myservice","created")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("Myservice","exe")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Myservice","destory")
    }
}