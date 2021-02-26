package com.example.activitytest

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.first_layout.*

class FirstActivity : BaeActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("FirstActivity","Task id is $taskId")
        setContentView(R.layout.first_layout)
        button1.setOnClickListener{
            SecondActivity.actionStart(this,"nmsl","ok")
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.add_item -> Toast.makeText(this,"you add",Toast.LENGTH_SHORT).show()
            R.id.remove_item -> Toast.makeText(this,"you remove",Toast.LENGTH_SHORT).show()
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
      menuInflater.inflate(R.menu.main,menu)
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode)
        {
            1-> if(resultCode== Activity.RESULT_OK){
                val returneddata = data?.getStringExtra("data_return")
                Toast.makeText(this,"$returneddata",Toast.LENGTH_SHORT).show()
            }
        }
    }
}