package com.mvvm.mvvmcarton.viewmodel;


import android.view.View;

import androidx.databinding.ObservableBoolean;

import com.mvvm.mvvmcarton.R;

public class MainVM {
    public final ObservableBoolean videoBL=new ObservableBoolean(true);
    public final ObservableBoolean novelBL=new ObservableBoolean(false);
    public final ObservableBoolean comicBL=new ObservableBoolean(false);
    public final int[] mipmaps=new int[]{R.mipmap.video_on,R.mipmap.video_off,R.mipmap.cartoon_on,R.mipmap.cartoon_off,R.mipmap.novel_on,R.mipmap.novel_off};
    public final int[] textcolors=new int[]{R.color.color_000000,R.color.color_bfbfbf};
    public void onNavVideoClick(View view){
        videoBL.set(true);
        novelBL.set(false);
        comicBL.set(false);
    }
    public void onNavNovelClick(View view){
        videoBL.set(false);
        novelBL.set(true);
        comicBL.set(false);
    }
    public void onNavComicClick(View view){
        videoBL.set(false);
        novelBL.set(false);
        comicBL.set(true);
    }
}
