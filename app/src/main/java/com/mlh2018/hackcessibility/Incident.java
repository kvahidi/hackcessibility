package com.mlh2018.hackcessibility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Incident {
    public double latitude;
    public double longitude;
    public String id;
    public String description;
    public String picture;
    public Date updatedTimestamp;

    public  Incident(){}

    public Incident(String id, double longitude, double latitude, String description, String picture, Date updatedTimestamp){
        this.description=description;
        this.longitude=longitude;
        this.latitude=latitude;
        this.picture=picture;
        this.updatedTimestamp=updatedTimestamp;
        this.id=id;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
