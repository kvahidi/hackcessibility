package com.mlh2018.hackcessibility;

import android.os.AsyncTask;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.annotation.IncompleteAnnotationException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;

import static android.content.ContentValues.TAG;

public class DatabaseHandler {

    public static String dbURL = "https://hackcessibility-1543693842696.firebaseio.com/";
    public static Incident getIncidentFromDatabase(double latitude, double longitude) throws Exception {
        String urlString = dbURL + "Incidents.json";
        AsyncTask<String, Void, String> getRequest = new GetClient().execute(urlString);
        try {
            String result = getRequest.get();
            try {
                JSONObject object = new JSONObject(result);
                Iterator<String> iterator = object.keys();
                while (iterator.hasNext()) {
                    JSONObject obj = object.getJSONObject(iterator.next());
                    if (obj.has("latitude") && Integer.parseInt(obj.get("latitude").toString()) == latitude && obj.has("longitude")
                            && Integer.parseInt(obj.get("longitude").toString()) == longitude){
                         Incident inc = new Incident("0",
                                Double.parseDouble(obj.get("longitude").toString()),
                                Double.parseDouble(obj.get("latitude").toString()) ,
                                obj.get("description").toString(),
                                obj.get("picture").toString(),
                                obj.get("updatedTimestamp").toString());
                         inc.id = "" + inc.hashCode();
                         return inc;
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        throw new Exception("Could not get incident data from database");
    }

    public static ArrayList<Incident> getListOfIncidentsFromDatabase() throws Exception {
        String urlString = dbURL + "Incidents.json";
        ArrayList<Incident> listOfIncidents = new ArrayList<>();
        AsyncTask<String, Void, String> getRequest = new GetClient().execute(urlString);
        try {
            String result = getRequest.get();
            try {
                JSONObject object = new JSONObject(result);
                Iterator<String> iterator = object.keys();
                while (iterator.hasNext()) {
                    JSONObject obj = object.getJSONObject(iterator.next());
                    if (obj.has("description")){

                        Incident inc = new Incident("0",
                                Double.parseDouble(obj.get("longitude").toString()),
                                Double.parseDouble(obj.get("latitude").toString()) ,
                                obj.get("description").toString(),
                                obj.get("picture").toString(),
                                obj.get("updatedTimestamp").toString());
                        inc.id = "" + inc.hashCode();
                        listOfIncidents.add(inc);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            } /*catch (ParseException e) {
                e.printStackTrace();
            }*/
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return listOfIncidents;
    }

    public  static void deleteIncidentFromDatabase(Incident incident){
        DatabaseReference mDatabase;
// ...
        mDatabase = FirebaseDatabase.getInstance().getReference("Incidents");
        mDatabase.child(incident.id).removeValue();
    }

    public static void updateIncidentFromDatabase(Incident incident){
        DatabaseReference mDatabase;
// ...
        mDatabase = FirebaseDatabase.getInstance().getReference("Incidents");
        mDatabase.child(incident.id).setValue("updatedTimestamp", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }
    public static void addIncidentToDatabase(Incident incident){
         DatabaseReference mDatabase;
// ...
        mDatabase = FirebaseDatabase.getInstance().getReference("Incidents");
        mDatabase.child(incident.id).setValue(incident);
    }
}
