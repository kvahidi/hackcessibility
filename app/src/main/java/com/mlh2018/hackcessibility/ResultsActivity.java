package com.mlh2018.hackcessibility;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mlh2018.data_structures.AccessiblePlace;

public class ResultsActivity extends AppCompatActivity {

    AccessiblePlace thePlace;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        thePlace=serverParser();
    }

    private AccessiblePlace serverParser(){
        return null;
    }
}
