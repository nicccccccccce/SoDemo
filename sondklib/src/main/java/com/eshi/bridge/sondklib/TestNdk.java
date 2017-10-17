package com.eshi.bridge.sondklib;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

/**
 * Created by user on 2017/4/13.
 */

public class TestNdk {
    int a;//本示例中将被修改的JAVA变量
    Handler handler;

    public TestNdk(Handler handler) {
        this.handler = handler;
        setUp();
    }

    public native void setUp();//本地方法

    public native void setA(int a);//本地方法

    public native static int getStringFromNative();//本地方法

    public native static int isB(boolean n);//本地方法

    public int getA() {
        return a;
    }


    public void notifyFiledChange() {//本示例中将被C/C++调用的JAVA方法
        Message message = new Message();
        Bundle bundle = new Bundle();
        bundle.putInt("a", a);
        message.setData(bundle);
        message.what = 1;
        handler.sendMessage(message);
    }

    static {
        System.loadLibrary("MyJni");//导入生成的链接库文件
    }

}
