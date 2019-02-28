package com.async_wu.mvvmdemo;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.async_wu.mvvmdemo.bean.UserEntityBean;
import com.async_wu.mvvmdemo.databinding.ActivityMainBinding;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityMainBinding activityMainBinding;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        initData();
        button = findViewById(R.id.btn_second);
        button.setOnClickListener(this);
    }

    private void initData() {
        UserEntityBean userEntityBean = new UserEntityBean();
        userEntityBean.setUser("张三");
        userEntityBean.setNackName("Jack");
        userEntityBean.setAge(23);
        userEntityBean.setUserface("http://img.pconline.com.cn/images/upload/upc/tx/photoblog/1411/03/c1/40490848_1414982637418_mthumb.jpg");
        activityMainBinding.setUserBean(userEntityBean);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this,ListActivity.class);
        startActivity(intent);
    }
}
