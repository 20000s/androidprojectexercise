package com.example.servicetest

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startdevice.setOnClickListener {
            val intent = Intent(this,MyService::class.java)
            startService(intent)
        }
        stopdevice.setOnClickListener {
            val intent = Intent(this,MyService::class.java)
            stopService(intent)
        }
        bindServiceBtn.setOnClickListener {
            val intent = Intent(this,MyService::class.java)
            bindService(intent,connection,Context.BIND_AUTO_CREATE)
        }
        unbindServiceBtn.setOnClickListener {
            unbindService(connection)
        }
    }
    lateinit var downloadBiner : MyService.DownloadBinder
    private val connection =  object : ServiceConnection{
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            downloadBiner = service as MyService.DownloadBinder
            downloadBiner.startDownload()
            downloadBiner.getProgress()
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            //TODO("Not yet implemented")
        }
    }

}