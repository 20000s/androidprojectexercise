package com.example.jni_start;

public class myJNI {
    static{
        System.loadLibrary("JniTest");
    }
    public static native String sayHello();
}
