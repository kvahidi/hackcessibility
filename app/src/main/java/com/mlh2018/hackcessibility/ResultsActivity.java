package com.mlh2018.hackcessibility;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

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
        //thePlace=serverParser();
        //updateList();
    }

    private void updateList() {
        LinearLayout ramp = findViewById(R.id.ramp_layout);
        LinearLayout elevator = findViewById(R.id.elevator_layout);
        LinearLayout doors = findViewById(R.id.doors_layout);
        LinearLayout parking = findViewById(R.id.parking_layout);
        LinearLayout seating = findViewById(R.id.seating_layout);
        LinearLayout washrooms = findViewById(R.id.washrooms_layout);

        updateData(ramp);

    }


    private void updateData(LinearLayout slot) {
        int goods=0;
        int bads=0;
        int nones=0;
        for (Features features: thePlace.getFeatures()){
            if(features.getRamp().getEvaluation()==Evaluation.GOOD){
                goods++;
            }if(features.getRamp().getEvaluation()==Evaluation.BAD){
                bads++;
            }if(features.getRamp().getEvaluation()==Evaluation.NOT_HERE){
                nones++;
            }
        }
        if ( ((nones + bads) >= goods) && (bads < nones) ){
            //ToDo other none
        }else {
            //slot
            RatingBar bar = new RatingBar(this);
            bar.setNumStars(5);

        }

    }

    private void look(){
        LinearLayout ll = (LinearLayout)findViewById(R.id.ramp_layout);

        Button btn = new Button(this);
        btn.setText("Manual Add");
        btn.setLayoutParams(new LinearLayout.LayoutParams
                (LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        ll.addView(btn);
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
        FeatureEvaluation ramp =            new FeatureEvaluation("Ramp", Evaluation.GOOD);
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
