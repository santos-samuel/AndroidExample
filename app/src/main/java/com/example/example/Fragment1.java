package com.example.example;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Fragment1 extends Fragment {

    private EditText input1_et;
    private Button move_btn;
    private String input1;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        input1_et = view.findViewById(R.id.input1);

        move_btn = view.findViewById(R.id.gt2);
        move_btn.setOnClickListener(moveListener);
        Log.d("CREATED", "Created Listener");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Log.d("CREATE", "Creating fragment 1");

        return inflater.inflate(R.layout.frag1, container, false);
    }

    View.OnClickListener moveListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            input1 = input1_et.getText().toString();

            Log.d("CLICK", "Button GT2 pressed" + input1);

            Fragment newFrag = new Fragment2();
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

            //using Bundle to send data
            Bundle bundle = new Bundle();
            bundle.putString("input1", input1);
            newFrag.setArguments(bundle); //data being send to SecondFragment


            transaction.replace(R.id.fragment_container, newFrag);
            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack
            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();
        }
    };
}