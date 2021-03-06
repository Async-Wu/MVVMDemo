package com.async_wu.mvvmdemo.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2019/2/28.
 */

public class MyAdapter<T> extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private int layoutId;
    private int variableId;
    private List<T> list;

    public MyAdapter(Context context, int layoutId, List<T> list, int resId){
        this.context = context;
        this.layoutId = layoutId;
        this.list = list;
        this.variableId = resId;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewDataBinding viewDataBinding = null;
        if(convertView==null){
            viewDataBinding = DataBindingUtil.inflate(inflater,layoutId,parent,false);
        }else {
            viewDataBinding = DataBindingUtil.getBinding(convertView);
        }
        viewDataBinding.setVariable(variableId,list.get(position));
        return viewDataBinding.getRoot();
    }



}
