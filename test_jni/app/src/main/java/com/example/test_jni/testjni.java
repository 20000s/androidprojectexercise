package com.example.test_jni;

public class testjni {
    public static native String pass();
    static {
        System.loadLibrary("testjni");
    }
}
