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

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private DatabaseReference mDatabase;
// ...

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
                Intent placeSelectedIntent = new Intent(MapsActivity.this, PublicSpaceActivity.class);
                placeSelectedIntent.putExtra("selectedPlaceName", place.getName());
                startActivity(placeSelectedIntent);
            }

            @Override
            public void onError(Status status) {
                // TODO: Handle the error.
                Log.i("MAPS", "An error occurred on place selected: " + status);
                Toast.makeText(getApplicationContext(), "An error occured selecting a place :(", Toast.LENGTH_LONG).show();
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
        try {
            ArrayList<Marker> markers= new ArrayList<Marker>();
            ArrayList<Incident> incidents = DatabaseHandler.getListOfIncidentsFromDatabase();
            for (Incident i: incidents) {
                lat = i.latitude;
                lon = i.longitude;
                LatLng incLoc = new LatLng(lat,lon);
                MarkerOptions marker = new MarkerOptions().position(incLoc).title("Incident location!");
                mMap.addMarker(marker);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
