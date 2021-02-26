package com.example.networktest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Website.URL
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient
import okhttp3.Request
import org.xml.sax.InputSource
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.StringReader
import java.lang.Exception
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL
import javax.xml.parsers.SAXParserFactory
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sendRequestBtn.setOnClickListener {
            senRequestWithHttpURLConnection()
        }
    }

    private fun senRequestWithHttpURLConnection(){
        thread {
            var connection : HttpURLConnection? = null
            try {
              val clinet = OkHttpClient()
              val request = Request.Builder().url("https://www.baidu.com").build()
              val response = clinet.newCall(request).execute()
              val responseData = response.body?.string()
              if(responseData != null){
              //    showResponse(responseData)
              }

            } catch (e : Exception){
                e.printStackTrace()
            }
        }
    }
    private fun parseXMLWithSAX(xmldata : String){
        try {
            val factory = SAXParserFactory.newInstance()
            val xmlreader = factory.newSAXParser().xmlReader
            val hander = MyHandler()
            xmlreader.contentHandler = hander
            xmlreader.parse(InputSource(StringReader(xmldata)))
        }catch (e : Exception){
            e.printStackTrace()
        }
    }
    class App(val id : String,val name : String,val version : String)
    private fun parseJSONWithGSON(jsondata : String){
        val gson = Gson()
        val typeOf = object : TypeToken<List<App>>(){}.type
        val applist = gson.fromJson<List<App>>(jsondata,typeOf)
        for(app in applist){
            Log.d("MainActivity","id is ${app.id}")
            Log.d("MainActivity","name is ${app.name}")
            Log.d("MainActivity","version is ${app.version}")
        }
    }
    //the following is json
    /*
    private fun parseJSONWithObject(jsondata : String){
        try{
        val jsonArray = JSONArray(jsondata)
        for(i in 0 until jsonArray.length()){
            val jsonObject = jsonArray.getJSONObject(i)
            val id = jsonObject.getString("id")
            val name = jsonObject.getString("name")
            val version = jsonObject.getString("version")
            Log.d("MainActivity","id is $id")
            Log.d("MainActivity","name is $name")
            log.d("MainActivity","version is $version")


        } catch(e : Exception){
        e.printStackTrace()
        }
        }
    }
     */
    // the following is xml methods
   /* private fun parseXMLWithPull(xmlData : String){
        try{
            val factory =XmlPullParserFactory.newInstance()
            val xmlPullParser = factory.newPullParser()
            xmlPullParser.setInput(StringReader(xmlData))
            var eventType = xmlPullParser.eventType
            var id = ""
            var name = ""
            var version = ""
            while (eventType != XmlPullParser.END_DOCUMENT){
                val nodeName =  xmlPullParser.name
                when(eventType){
                    XmlPullParser.START_TAG ->{
                        when(nodeName){
                            "id" -> id = xmlPullParser.nextText()
                            "name" -> name = xmlPullParser.nextText()
                            "version" -> version = xmlPullParser.nextText()
                        }
                    }
                    XmlPullParser.END_TAG ->{
                        if("app" == nodeName){
                            Log.d("MainActivity","id is $id")
                            Log.d("MainActivity","name is $name")
                            Log.d("MainActivity","version is $version")
                        }
                    }
                }
                eventType = xmlPullParser.next()
            }
        } catch (e : Exception){
            e.printStackTrace()
        }
    }*/
    private fun showResponse(response : String){
        runOnUiThread {
            responseText.text = response
        }
    }
}