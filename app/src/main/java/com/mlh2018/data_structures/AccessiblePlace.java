package com.mlh2018.data_structures;

import java.util.List;

public class AccessiblePlace {
    private Features features;
    private int score;

    AccessiblePlace(Features evaluations){
        features = evaluations;
    }

    public void setFeatures(Features features) {
        this.features = features;
    }

}
