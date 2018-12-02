package com.mlh2018.hackcessibility;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
// todo add listeners for adding location review
        Button addIncidentBtn = findViewById(R.id.addincidentbtn);
        addIncidentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddActivity.this, AddIncidentReportActivity.class));
                finish();
            }
        });

        Button addReviewBtn = findViewById(R.id.addreviewbtn);
        addReviewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddActivity.this, RatePlace.class));
                finish();
            }
        });
    }

    private void writeNewIncident(Incident incident){
    }
}
