package com.example.databasetest

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import java.lang.NullPointerException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dbHelper = MyDatabaseHelper(this,"BookStore.db",2 )
        createDatabase.setOnClickListener {
            dbHelper.writableDatabase
        }
        addData.setOnClickListener {
            val db = dbHelper.writableDatabase
            val value1 = ContentValues().apply {
                put("name","The Lost Symbol")
                put("author","Dan Brown")
                put("pages",510)
                put("price",19.95)
            }
            val value2 = ContentValues().apply {
                put("name","The Da Vinci Code")
                put("author", "Dan brown")
                put("pages",454)
                put("price",16.96)
            }
            db.insert("Book",null ,value1)
            db.insert("Book",null,value2)
        }
        updateData.setOnClickListener {
            val db  = dbHelper.writableDatabase
            val values = ContentValues()
            values.put("price",10.99)
            db.update("Book",values,"name = ?", arrayOf("The Da Vinci Code"))
        }
        deleteData.setOnClickListener {
            val db = dbHelper.writableDatabase
            db.delete("Book","pages > ?", arrayOf("500"))
        }
        replaceData.setOnClickListener {
            val db = dbHelper.writableDatabase
            db.beginTransaction()
            try {
                db.delete("Book",null,null)
                if(true){
                    throw NullPointerException()
                }
               val values = ContentValues().apply {
                   put("name","Game of Thrones")
                   put("author","George Martin")
                   put("pages",720)
                   put("price",20.85)
               }
                db.insert("Book",null,values)
                db.setTransactionSuccessful()
            }catch (e : Exception){
                e.printStackTrace()
            } finally {
                db.endTransaction()
            }
        }

    }
}