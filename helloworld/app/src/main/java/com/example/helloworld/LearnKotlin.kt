package com.example.helloworld

import kotlin.math.max

fun main() {

     val num =1
    val name = "nmsl"
    //print("$name is $num")
   val s = a()
    println(s)
    a(old = 1000,name = "fdghgfhdhgdh")

}
fun a(name :String = "nmsl",old : Int = 10) = println("$name is $old  old")

fun dostudy(study:Study)
{
    study.dohomework()
    study.readbooks()
}

fun checknum(num:Number) = when(num)
{
    is Int -> println("is int")
    is Double -> println("is double")
    else -> println("fuck")
}



