package com.example.sharedpreferencestest

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val prefs = getPreferences(Context.MODE_PRIVATE)
        val isRemember = prefs.getBoolean("remember_password",false)
        if(isRemember)
        {
            val account = prefs.getString("account","")
            val password = prefs.getString("password","")
            accountEdit.setText(account)
            passwordEdit.setText(password)
            rememberPass.isChecked = true

        }
        login.setOnClickListener {
            val account = accountEdit.text.toString()
            val pass = passwordEdit.text.toString()
            if(account=="admin" && pass == "123456")
            {
                val editor = prefs.edit()
                if(rememberPass.isChecked)
                {
                    editor.apply {
                        putString("account",account)
                        putString("password",pass)
                        putBoolean("remember_password",true)
                    }
                }else{
                    editor.clear()
                }
                editor.apply()
                val intent = Intent(this,win::class.java)
                startActivity(intent)
                finish()

            }else{
                Toast.makeText(this,"wrong",Toast.LENGTH_SHORT).show()
            }
        }
    }
}