package com.example.fragamentlist;


import android.app.Fragment;
import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DetailFgt extends Fragment {
    public static final String EXTRA ="extra";

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detail_fgt, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            String str = bundle.getString(EXTRA);
            setText(str);
        }
    }

    public void setText(String info) {
        TextView view = (TextView) getView().findViewById(R.id.dateTime);
        view.setText(info);
    }
}