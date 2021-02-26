package com.example.uiwidgettest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       button.setOnClickListener {
               AlertDialog.Builder(this).apply {
                   setTitle("this is a dialog")
                   setMessage("Something important.")
                   setCancelable(false)
                   setPositiveButton("OK"){
                       dialog, which ->
                   }
                   setNegativeButton("Cancel"){
                       dialog, which ->
                   }
                   show()
               }
       }
    }
}