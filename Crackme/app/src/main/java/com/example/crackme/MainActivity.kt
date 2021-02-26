package com.example.crackme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        BTN_Login.setOnClickListener {
            val a = TEXT_NAME.text.toString()
            val b = TEST_PASS.text.toString()
            check(a,b)
        }
    }
    private fun check( name: String,pass : String){
        if(pass.equals(RjJNI.pass())){
            Toast.makeText(this,"successful",Toast.LENGTH_SHORT).show()
            val intent = Intent(this,NewActivity::class.java)
            startActivity(intent)
        }
        else{
            Toast.makeText(this,"you lose",Toast.LENGTH_SHORT).show()
        }
    }
}