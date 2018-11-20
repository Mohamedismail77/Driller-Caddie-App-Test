package com.mit_technologies.drillercaddie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class DropDownAdapter extends BaseAdapter {

    private Context mContext;
    private String[] mData;

    public DropDownAdapter(Context context, String[] data){

        mContext = context;
        mData = data;

    }

    @Override
    public int getCount() {
        return mData.length;
    }

    @Override
    public Object getItem(int position) {
        return mData[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){

            convertView = (TextView)LayoutInflater.from(mContext).inflate(R.layout.dropdown_layout,parent,false);

        }

        ((TextView)convertView).setText(mData[position]);
        return convertView;
    }
}
