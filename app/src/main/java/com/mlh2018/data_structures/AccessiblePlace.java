package com.mlh2018.data_structures;

import java.util.ArrayList;
import java.util.List;

public class AccessiblePlace {
    private List<Features> features;
    private int score;

    public AccessiblePlace(Features evaluations){
        features = new ArrayList<Features>();
        features.add(evaluations);
    }

    public AccessiblePlace(List<Features> evaluations){
        features = evaluations;
    }

    public void addFeatures(Features features) {
        this.features.add(features);
    }

    public List<Features> getFeatures() {
        return features;
    }
}
