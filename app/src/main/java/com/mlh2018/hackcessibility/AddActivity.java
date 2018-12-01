package com.mlh2018.hackcessibility;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        writeNewIncident(new Incident("1", 3, 4, "a", "d", "2018"));

    }

    private void writeNewIncident(Incident incident){
    mDatabase.child("Incidents").child("incident" + incident.id).setValue(incident);
    }
}
