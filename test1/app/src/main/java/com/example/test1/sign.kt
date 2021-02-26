package com.example.test1

class sign {
    companion object {
        fun m1(s: String, s1: String): Any {

        }

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
    external fun m1(a:String,b: String) : Boolean
}