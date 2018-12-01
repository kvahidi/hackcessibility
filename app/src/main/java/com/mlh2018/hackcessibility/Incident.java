package com.mlh2018.hackcessibility;

public class Incident {
    public double latitude;
    public double longitude;
    public String id;
    public String description;
    public String picture;
    public String updatedTimestamp;

    public  Incident(){}

    public Incident(String id, double longitude, double latitude, String description, String picture, String updatedTimestamp){
        this.description=description;
        this.longitude=longitude;
        this.latitude=latitude;
        this.picture=picture;
        this.updatedTimestamp=updatedTimestamp;
        this.id=id;
    }
}
