package com.example.fragamentlist;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;


public class ListFgt extends Fragment {
    ListView simpleList;
    ArrayList<String> flagList = new ArrayList<>();
    HashMap<String, String> Data = new HashMap<String, String>();
    private OnItemSelectedListener listener;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fgt, container, false);
        simpleList = (ListView) view.findViewById(R.id.simpleListView);
        flagList.clear();
        flagList.add("Brazil");
        flagList.add("USA");
        flagList.add("EU");
        flagList.add("India");
        flagList.add("Germany");
        flagList.add("Korea");
        flagList.add("France");
        Data.put("Brazil", "The capital of Brazil is Brasilia");
        Data.put("USA", "The capital of USA is Washington, D.C.");
        Data.put("EU", "The capital of EU is Brussels");
        Data.put("India", "The capital of India is New Delhi");
        Data.put("Germany", "The capital of Germany is Berlin");
        Data.put("Korea", "The capital of Korea is Seoul");
        Data.put("France", "The capital of France is Paris");
        MyAdapter myAdapter = new MyAdapter(getActivity(), R.layout.list_view_items, flagList);
        simpleList.setAdapter(myAdapter);
        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = (String) simpleList.getItemAtPosition(position);
                Toast.makeText(getActivity(),str, Toast.LENGTH_SHORT).show();
                listener.onDateTimeItemSelected(Data.get(flagList.get(position)));
            }
        });
        return view;
    }

    public interface OnItemSelectedListener {
        void onDateTimeItemSelected(String info);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnItemSelectedListener) {
            listener = (OnItemSelectedListener) context;
        } else {
            throw new ClassCastException(context.toString() +
                    " Interface OnItemSelectedListener not implemented");
        }
    }
}