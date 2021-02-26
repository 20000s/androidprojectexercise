package com.example.filepersistencetest

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            val rext = editText.text.toString()
            save(rext)
        }
        val iny= load()
        if(iny.isNotEmpty()){
            editText.setText(iny)
            editText.setSelection(iny.length)
            Toast.makeText(this," $iny",Toast.LENGTH_SHORT).show()
        }
    }
    private fun save(inputText : String){
        try{
        val tmp = openFileOutput("data",Context.MODE_PRIVATE)
        val writter = BufferedWriter(OutputStreamWriter(tmp))

            writter.use {
                it.write(inputText)
            }
        }catch (e : IOException){
            e.printStackTrace()
        }
    }
    private fun load(): String{
        val content = StringBuilder()
        try {
            val input = openFileInput("data")
            val reader = BufferedReader(InputStreamReader(input))
            reader.use{
                reader.forEachLine {
                    content.append(it)
                }
            }
        }catch (e : IOException)
        {
            e.printStackTrace()
        }
        return content.toString()
    }


}