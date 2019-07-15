package com.example.example;

import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;


public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void initFrag(View view) {
        setContentView(R.layout.frag1);
    }

    public void moveForward(View view) {
        Fragment newFragment = null;

        switch (view.getId()) {
            case R.id.gt2:
                newFragment = new Fragment1();
                break;
            case R.id.gt3:
                newFragment = new Fragment2();
                break;
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack
        transaction.replace(R.id.fragment_container, newFragment);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
    }
}
