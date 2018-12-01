package com.mlh2018.hackcessibility;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DatabaseHandler {

    public static Incident getIncidentFromDatabase(){
        DatabaseReference mDatabase;
        mDatabase = FirebaseDatabase.getInstance().getReference();

    }
}
