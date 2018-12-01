package com.mlh2018.data_structures;

public class Features {
    private FeatureEvaluation ramp;
    private FeatureEvaluation elevator;
    private FeatureEvaluation parking;
    private FeatureEvaluation automaticDoor;

    public Features(FeatureEvaluation ramp, FeatureEvaluation elevator, FeatureEvaluation parking, FeatureEvaluation automaticDoor, FeatureEvaluation seating, FeatureEvaluation washrooms, FeatureEvaluation otherNotes) {
        this.ramp = ramp;
        this.elevator = elevator;
        this.parking = parking;
        this.automaticDoor = automaticDoor;
        Seating = seating;
        Washrooms = washrooms;
        this.otherNotes = otherNotes;
    }

    private FeatureEvaluation Seating;
    private FeatureEvaluation Washrooms;
    private FeatureEvaluation otherNotes;


    public FeatureEvaluation getRamp() {
        return ramp;
    }

    public void setRamp(FeatureEvaluation ramp) {
        this.ramp = ramp;
    }

    public FeatureEvaluation getElevator() {
        return elevator;
    }

    public void setElevator(FeatureEvaluation elevator) {
        this.elevator = elevator;
    }

    public FeatureEvaluation getParking() {
        return parking;
    }

    public void setParking(FeatureEvaluation parking) {
        this.parking = parking;
    }

    public FeatureEvaluation getAutomaticDoor() {
        return automaticDoor;
    }

    public void setAutomaticDoor(FeatureEvaluation automaticDoor) {
        this.automaticDoor = automaticDoor;
    }

    public FeatureEvaluation getSeating() {
        return Seating;
    }

    public void setSeating(FeatureEvaluation seating) {
        Seating = seating;
    }

    public FeatureEvaluation getWashrooms() {
        return Washrooms;
    }

    public void setWashrooms(FeatureEvaluation washrooms) {
        Washrooms = washrooms;
    }

    public FeatureEvaluation getOtherNotes() {
        return otherNotes;
    }

    public void setOtherNotes(FeatureEvaluation otherNotes) {
        this.otherNotes = otherNotes;
    }

}
