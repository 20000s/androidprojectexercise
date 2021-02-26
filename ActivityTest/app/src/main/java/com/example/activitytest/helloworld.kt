package com.example.activitytest

import kotlin.text.StringBuilder

fun main(){
    val list = listOf("banana","apple","orange","pear","grape")


    val result = StringBuilder().apply{
        append("start eating fruits\n")
        for(fruit in list)
        append(fruit+"\n")
        append("finish eating\n")

    }
    println(result.toString())
}