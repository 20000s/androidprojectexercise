package com.example.crackme;

public class RjJNI {
    public static native String pass();
    static {
        System.loadLibrary("RjJNI");
    }
}
