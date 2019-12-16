package com.mvvm.mvvmcarton.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.mvvm.mvvmcarton.R;
import com.vondear.rxfeature.module.wechat.pay.WechatPayTools;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
