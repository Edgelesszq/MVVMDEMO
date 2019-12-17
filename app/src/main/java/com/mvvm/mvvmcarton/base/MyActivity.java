package com.mvvm.mvvmcarton.base;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class MyActivity extends AppCompatActivity {
    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext=this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    public Context getContext(){
        return mContext;
    }
}
