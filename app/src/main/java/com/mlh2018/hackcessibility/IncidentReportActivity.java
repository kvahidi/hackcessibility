package com.mlh2018.hackcessibility;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class IncidentReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incident_report);
        setButtonListeners();
        Intent intent = getIntent();
        String desc, timestamp;
        desc = intent.getStringExtra("description");
        timestamp = intent.getStringExtra("timestamp");
        TextView txt = findViewById(R.id.incidentDescription);
        txt.setText(desc + "("+timestamp+")");


    }

    private void setButtonListeners() {
        Button exitBtn = findViewById(R.id.exitIncidentBtn);
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Button resolvedBtn = findViewById(R.id.resolvedBtn);
        resolvedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ///TODO //delete from DB
            }
        });
        Button stillAnIssueBtn = findViewById(R.id.stillIssueBtn);
        stillAnIssueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /// TODO update DB
            }
        });
    }
}
