package com.async_wu.mvvmdemo.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.async_wu.mvvmdemo.BR;
import com.squareup.picasso.Picasso;

/**
 * Created by Administrator on 2019/2/28.
 */

public class Food extends BaseObservable {
    private String description;
    private String img;
    private String keywords;
    private String summary;

    public Food() {
    }

    public Food(String description, String img, String keywords, String summary) {
        this.description = description;
        this.img = img;
        this.keywords = keywords;
        this.summary = summary;
    }

    @BindingAdapter("bind:img")
    public static void loadInternetImage(ImageView iv, String img) {
        Picasso.with(iv.getContext()).load(img).into(iv);
    }

    public void onItemClick(View view) {
//        Toast.makeText(view.getContext(), getDescription(), Toast.LENGTH_SHORT).show();
        setDescription("111");
    }

    public void clickKeywords(View view) {
        Toast.makeText(view.getContext(), getKeywords(), Toast.LENGTH_SHORT).show();
    }


    @Bindable
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        notifyPropertyChanged(BR.description);
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
