package com.mlh2018.hackcessibility;

import android.content.Intent;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddIncidentReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_incident_report);

        Button submitBtn = findViewById(R.id.submitIncidentBtn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GPStracker g = new GPStracker(getApplicationContext());
                Location l = g.getLocation();
                double lat = l.getLatitude();
                double longg = l.getLongitude();
                String desc = ((EditText)findViewById(R.id.descripIncidentEditTxt)).toString();
                Incident inc = new Incident(
                        "0", longg, lat, desc, "none",
                        new Date(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").toString()));
                inc.id = inc.hashCode() + "";
                DatabaseHandler.addIncidentToDatabase(inc);
                finish();


            }});
        };
}

