package com.mvvm.mvvmcarton.ui.activity;


import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.mvvm.mvvmcarton.R;
import com.mvvm.mvvmcarton.base.BaseFragmentAdapter;
import com.mvvm.mvvmcarton.base.MyActivity;
import com.mvvm.mvvmcarton.databinding.ActivityMainBinding;
import com.mvvm.mvvmcarton.ui.fragment.CimocFragment;
import com.mvvm.mvvmcarton.ui.fragment.NovelFragment;
import com.mvvm.mvvmcarton.ui.fragment.VideoFragment;
import com.mvvm.mvvmcarton.viewmodel.MainVM;


public class MainActivity extends MyActivity {
    ActivityMainBinding mainBinding;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    ViewPager viewPager;
    private BaseFragmentAdapter<Fragment> mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        mainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        mainBinding.setMainVm(new MainVM());
        initView();

    }
    public void initView(){
        toolbar=findViewById(R.id.toolbar);
        drawerLayout=findViewById(R.id.drawerlayout);
        setSupportActionBar(toolbar);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.app_name, R.string.app_name);
        toggle.syncState();
        drawerLayout.addDrawerListener(toggle);
        toolbar.setNavigationIcon(getResources().getDrawable(R.mipmap.icon_lefttitle));
        toolbar.inflateMenu(R.menu.home_menu);
        toolbar.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()){
                case R.id.app_bar_search:
                    break;
            }
            return false;
        });
        viewPager=findViewById(R.id.viewpager);
        mPagerAdapter=new BaseFragmentAdapter<Fragment>(this);
        mPagerAdapter.addFragment(new VideoFragment());
        mPagerAdapter.addFragment(new CimocFragment());
        mPagerAdapter.addFragment(new NovelFragment());
        viewPager.setAdapter(mPagerAdapter);
        viewPager.setCurrentItem(0);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewPager.setAdapter(null);
    }
}
