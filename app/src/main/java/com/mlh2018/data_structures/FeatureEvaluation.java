package com.mlh2018.data_structures;

public class FeatureEvaluation {
    // values
    private String feature;
    private Evaluation evaluation;
    FeatureEvaluation(String feature, Evaluation eval){
        this.feature=feature;
        this.evaluation=eval;
    }

    FeatureEvaluation(String feature){
        this.feature=feature;
        this.evaluation=Evaluation.NO_DATA;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Evaluation evaluation) {
        this.evaluation = evaluation;
    }
    public void setGood(boolean evaluation) {
        if(evaluation){
            this.evaluation=Evaluation.GOOD;
        }else {
            this.evaluation = Evaluation.BAD;
        }
    }

}
