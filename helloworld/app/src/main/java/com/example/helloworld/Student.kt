package com.example.helloworld


class Student(val sno: String, val grade: Int, ag: Int, na: String) : Person(na, ag) ,Study{
    override fun readbooks() {
        println(name + " is reading books")
    }

    override fun dohomework() {
        println(name + " is dong homework")
    }

}
