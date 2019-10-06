package com.example.fragamentlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<String> {
    static class ViewHolder {
        public TextView text;
    }
    ArrayList<String> flagList = new ArrayList<>();
    public MyAdapter(Context context, int textViewResourceId, ArrayList<String> objects) {
        super(context, textViewResourceId, objects);
        flagList = objects;
    }
    @Override
    public int getCount() { return super.getCount(); }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if(v == null) {
            LayoutInflater inflater = (LayoutInflater)
                    getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.list_view_items, null);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.text = (TextView) v.findViewById(R.id.textView);
            v.setTag(viewHolder);
        }
        ViewHolder holder = (ViewHolder) v.getTag();
        String s = flagList.get(position);
        holder.text.setText(s);
        return v;
    }
} //end of class MyAdapter

