package com.eshi.bridge.sondklib;

/**
 * Created by user on 2017/4/11.
 */

public class NdkTest {
    static {
        System.loadLibrary("NativeExample");
    }

    public static native String getStringFromNative();
}
