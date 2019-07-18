package com.example.example;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class Fragment2 extends Fragment {

    private EditText input2_et;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.frag2, container, false);

        input2_et = rootview.findViewById(R.id.input2);

        //retrieve input1
        Bundle bundle=getArguments();
        input2_et.setText(String.valueOf(bundle.getString("input1")));

        return rootview;
    }
}
