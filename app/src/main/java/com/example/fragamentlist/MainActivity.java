package com.example.fragamentlist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends Activity implements ListFgt.OnItemSelectedListener{
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getResources().getBoolean(R.bool.twoPaneMode)) {
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.frame1, new ListFgt());
            ft.add(R.id.frame2, new DetailFgt());
            ft.commit();
        }
        else {
            if (savedInstanceState != null) {  // cleanup existing fragments
                getFragmentManager().executePendingTransactions();
                Fragment fragmentById = getFragmentManager().
                        findFragmentById(R.id.fragment_container);
                if (fragmentById!=null) getFragmentManager().beginTransaction().
                        remove(fragmentById).commit();
            }
            ListFgt listFragment = new ListFgt();
            getFragmentManager().beginTransaction().
                    replace(R.id.fragment_container, listFragment).commit();
        }
    }

    @Override public void onDateTimeItemSelected(String info) {
        if (getResources().getBoolean(R.bool.twoPaneMode)) {
            DetailFgt fragment = (DetailFgt) getFragmentManager().findFragmentById(R.id.frame2);
            fragment.setText(info);
        } else {
            DetailFgt newFragment = new DetailFgt();
            Bundle args = new Bundle();
            args.putString(DetailFgt.EXTRA, info);
            newFragment.setArguments(args);
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, newFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }
}