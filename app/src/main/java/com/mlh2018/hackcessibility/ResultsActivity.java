package com.mlh2018.hackcessibility;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.mlh2018.data_structures.AccessiblePlace;
import com.mlh2018.data_structures.Evaluation;
import com.mlh2018.data_structures.FeatureEvaluation;
import com.mlh2018.data_structures.Features;

import java.util.ArrayList;

public class ResultsActivity extends AppCompatActivity {

    AccessiblePlace thePlace;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        thePlace=serverParser();
        updateList();
    }

    private void updateList() {
        TextView ramp = findViewById(R.id.ramp);
        TextView elevator = findViewById(R.id.elevator);
        TextView doors = findViewById(R.id.doors);
        TextView parking = findViewById(R.id.parking);
        TextView seating = findViewById(R.id.seating);
        TextView washrooms = findViewById(R.id.washrooms);

        String rampData = getRampData();
        String elevatorData = getElevatorData();
    }

    private String getRampData() {
        for (Features features: thePlace.getFeatures()){

        }


        return "0";
    }

    private String getElevatorData() {
        return "0";

    }

    // TODO get rid of garbage Data
    private AccessiblePlace serverParser(){
        AccessiblePlace hi = new AccessiblePlace(new ArrayList<Features>());
        hi.addFeatures(garbageData2());
        hi.addFeatures(garbageData3());
        hi.addFeatures(garbageData4());
        hi.addFeatures(garbageData5());
        return hi;
    }














    public Features garbageData(){
        FeatureEvaluation ramp = new FeatureEvaluation("Ramp", Evaluation.GOOD);
        FeatureEvaluation elevator = new FeatureEvaluation("Elevator", Evaluation.BAD);
        FeatureEvaluation parking = new FeatureEvaluation("Parking", Evaluation.GOOD);
        FeatureEvaluation automaticDoor = new FeatureEvaluation ("AutomaticDoor", Evaluation.BAD);
        FeatureEvaluation seating = new FeatureEvaluation ("Seating", Evaluation.GOOD);
        FeatureEvaluation washrooms = new FeatureEvaluation ("Washrooms", Evaluation.BAD);
        FeatureEvaluation otherNotes = new FeatureEvaluation("Narrow Hallways");
        Features hi = new Features(ramp,elevator,parking,automaticDoor,seating,washrooms,otherNotes);
        return hi;
    }


    public Features garbageData2(){
        FeatureEvaluation ramp = new FeatureEvaluation("Ramp", Evaluation.BAD);
        FeatureEvaluation elevator = new FeatureEvaluation("Elevator", Evaluation.BAD);
        FeatureEvaluation parking = new FeatureEvaluation("Parking", Evaluation.BAD);
        FeatureEvaluation automaticDoor = new FeatureEvaluation ("AutomaticDoor", Evaluation.BAD);
        FeatureEvaluation seating = new FeatureEvaluation ("Seating", Evaluation.BAD);
        FeatureEvaluation washrooms = new FeatureEvaluation ("Washrooms", Evaluation.BAD);
        FeatureEvaluation otherNotes = new FeatureEvaluation("Step near entrance");
        Features hi = new Features(ramp,elevator,parking,automaticDoor,seating,washrooms,otherNotes);
        return hi;
    }

    public Features garbageData3(){
        FeatureEvaluation ramp = new FeatureEvaluation("Ramp", Evaluation.GOOD);
        FeatureEvaluation elevator =        new FeatureEvaluation("Elevator", Evaluation.GOOD);
        FeatureEvaluation parking =         new FeatureEvaluation("Parking", Evaluation.GOOD);
        FeatureEvaluation automaticDoor =   new FeatureEvaluation ("AutomaticDoor", Evaluation.GOOD);
        FeatureEvaluation seating =         new FeatureEvaluation ("Seating", Evaluation.GOOD);
        FeatureEvaluation washrooms =       new FeatureEvaluation ("Washrooms", Evaluation.GOOD);
        FeatureEvaluation otherNotes =      new FeatureEvaluation("Accessible sinks, and outlets available");
        Features hi = new Features(ramp,elevator,parking,automaticDoor,seating,washrooms,otherNotes);
        return hi;
    }



    public Features garbageData4(){
        FeatureEvaluation ramp = new FeatureEvaluation("Ramp", Evaluation.GOOD);
        FeatureEvaluation elevator = new FeatureEvaluation("Elevator", Evaluation.GOOD);
        FeatureEvaluation parking = new FeatureEvaluation("Parking", Evaluation.BAD);
        FeatureEvaluation automaticDoor = new FeatureEvaluation ("AutomaticDoor", Evaluation.GOOD);
        FeatureEvaluation seating = new FeatureEvaluation ("Seating", Evaluation.GOOD);
        FeatureEvaluation washrooms = new FeatureEvaluation ("Washrooms", Evaluation.GOOD);
        FeatureEvaluation otherNotes = new FeatureEvaluation("Accessible parking available 2 blocks away");
        Features hi = new Features(ramp,elevator,parking,automaticDoor,seating,washrooms,otherNotes);
        return (hi);
    }

    public Features garbageData5(){
        FeatureEvaluation ramp = new FeatureEvaluation("Ramp", Evaluation.GOOD);
        FeatureEvaluation elevator = new FeatureEvaluation("Elevator", Evaluation.BAD);
        FeatureEvaluation parking = new FeatureEvaluation("Parking", Evaluation.GOOD);
        FeatureEvaluation automaticDoor = new FeatureEvaluation ("AutomaticDoor", Evaluation.GOOD);
        FeatureEvaluation seating = new FeatureEvaluation ("Seating", Evaluation.BAD);
        FeatureEvaluation washrooms = new FeatureEvaluation ("Washrooms", Evaluation.GOOD);
        FeatureEvaluation otherNotes = new FeatureEvaluation("Elevator available, but narrow door");
        Features hi = new Features(ramp,elevator,parking,automaticDoor,seating,washrooms,otherNotes);
        return (hi);
    }
}
