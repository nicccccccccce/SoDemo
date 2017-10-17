package com.eshi.bridge.sodemo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.eshi.bridge.sondklib.NdkTest;
import com.eshi.bridge.sondklib.TestNdk;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btC = findViewById(R.id.button);
        btC.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        System.out.println("jni start--->" +(false || false)+"-"+ (false || false||true));
        System.out.println("ndk test --->" + NdkTest.getStringFromNative());
        try {
            TestNdk testNdk = new TestNdk(handler);
            testNdk.setA(3);
            testNdk.notifyFiledChange();
            System.out.println("test ndk --->" + testNdk.getStringFromNative());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                Integer ir = msg.getData().getInt("a");
                System.out.println("jni--->" + ir);
            }
        }
    };

}
