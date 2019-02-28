package com.async_wu.mvvmdemo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.async_wu.mvvmdemo.adapter.MyAdapter;
import com.async_wu.mvvmdemo.bean.Food;
import com.google.gson.Gson;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/2/28.
 */

public class ListActivity extends AppCompatActivity {
    private List<Food> foods;
    private ListView lv;

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            MyAdapter<Food> adapter = new MyAdapter<>(ListActivity.this,R.layout.item_listview,foods, BR.food);
        }
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();
        initData();
    }

    private void initView() {
        lv = findViewById(R.id.lv_second);

    }

    private void initData() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("http://www.tngou.net/api/food/list?id=1").build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (response.isSuccessful()) {
                    parseJson(response.body().string());
                }
            }

        });
    }

    private void parseJson(String jsonStr) {
        Log.e("json ",jsonStr);
        foods = new ArrayList<>();
        try {
            JSONObject jo = null;
            try {
                jo = new JSONObject(jsonStr);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            JSONArray tngou = jo.getJSONArray("tngou");
            for (int i = 0; i < tngou.length(); i++) {
                JSONObject item = tngou.getJSONObject(i);
                String description = item.getString("description");
                String img = "http://tnfs.tngou.net/image" + item.getString("img");
                String keywords = "【关键词】 " + item.getString("keywords");
                String summary = item.getString("summary");
                foods.add(new Food(description, img, keywords, summary));
            }
            mHandler.sendEmptyMessage(0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}
