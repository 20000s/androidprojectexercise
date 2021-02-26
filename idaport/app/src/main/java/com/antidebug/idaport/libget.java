package com.antidebug.idaport;

public class libget {

    static {
        System.loadLibrary("native-lib");
    }
    public static native String aaa();

}
