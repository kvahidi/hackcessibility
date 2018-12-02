package com.mlh2018.hackcessibility;

import android.Manifest;
import android.content.Intent;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private DatabaseReference mDatabase;
// ...

    private GoogleMap mMap;
    private ArrayList<Marker> markerList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        markerList = new ArrayList<>();
        setContentView(R.layout.activity_maps);
        ActivityCompat.requestPermissions(MapsActivity.this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION}, 100);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Button addBtn = findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MapsActivity.this, AddActivity.class));

            }
        });
        // dealing with typing places into search bar and searching for a place
        PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);
        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                // TODO: Get info about the selected place.
                Log.i("MAPS", "Place selected: " + place.getName());
                Intent placeSelectedIntent = new Intent(MapsActivity.this, ResultsActivity.class);
                placeSelectedIntent.putExtra("selectedPlaceName", place.getName());
                startActivity(placeSelectedIntent);
            }

            @Override
            public void onError(Status status) {
                // TODO: Handle the error.
                Log.i("MAPS", "An error occurred on place selected: " + status);
                Toast.makeText(getApplicationContext(), "An error occurred selecting a place :(", Toast.LENGTH_LONG).show();
            }
        });

    }




    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        /**/
        GPStracker g = new GPStracker(getApplicationContext());
        Location l = g.getLocation();
        System.out.println(l);
        double lat = 0;
        double lon = 0;
        if (l != null) {
            lat = l.getLatitude();
            lon = l.getLongitude();
            // Toast.makeText(getApplicationContext(), "LAT: "+lat+"\n LON: "+lon, Toast.LENGTH_LONG).show();
        }

        LatLng currLoc = new LatLng(lat,lon);
        mMap.addMarker(new MarkerOptions().position(currLoc).title("Your location!"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currLoc, 17.0f));
    }

    public void initializeMarkerListeners(GoogleMap map){

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        for (Marker markerFromList:markerList
                ) {
            if (marker.equals(markerFromList)){
                double markerLat = marker.getPosition().latitude;
                double markerLon = marker.getPosition().longitude;
                try {
                    Incident incident = DatabaseHandler.getIncidentFromDatabase(markerLat, markerLon);
                    Intent incidentReportIntent = new Intent(MapsActivity.this, IncidentReportActivity.class);
                    incidentReportIntent.putExtra("description", incident.description);
                    incidentReportIntent.putExtra("timestamp", incident.updatedTimestamp);
                    startActivity(incidentReportIntent);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
        return false;
    }
}
