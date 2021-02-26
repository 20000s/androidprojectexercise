package com.example.ndktest_01;

public class SignatureUtils {
    public static native String signatureParams(String pasd);
    static {
        System.loadLibrary("native-lib");
    }
}
