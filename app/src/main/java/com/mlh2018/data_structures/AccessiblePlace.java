package com.mlh2018.data_structures;

import java.util.List;

public class AccessiblePlace {
    private List<FeatureEvaluation> features;
    private int score;

    public List<FeatureEvaluation> getFeatures() {
        return features;
    }

    public void setFeatures(List<FeatureEvaluation> features) {
        this.features = features;
    }

    public int getScore() {
        generateScore();
        return score;
    }


    AccessiblePlace(List<FeatureEvaluation> evaluations){
        features = evaluations;
    }

    private void generateScore(){
        score=0;
        for (FeatureEvaluation eval: features) {
            if(eval.getEvaluation()==Evaluation.BAD) {
                score--;
            }
            else if (eval.getEvaluation()==Evaluation.GOOD) {
                score++;
            }
            else if (eval.getEvaluation()==Evaluation.NOT_HERE) {
                score--;
                score--;
            }
        }
    }


}
