package com.example.vishaljha.myapplication;

import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Double lat,lng;
    Address address;
    View v;
    TextView t1,t2,t3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        Geocoder geocoder =new Geocoder()
        // Add a marker in Sydney and move the camera
        try{
            List<Address> lst=geocoder.getFromLocationName("Delhi",1);
            address=lst.get(0);
            lat=address.getLatitude();
            lng=address.getLongitude();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        final LatLng latLng=new LatLng(lat,lng);
        MarkerOptions mo=new MarkerOptions();
        mo.draggable(true);
        mo.position(latLng);
        mo.title("i am at delhi");
        mMap.addMarker(mo);
        CameraUpdate cameraUpdate=CameraUpdateFactory.newLatLng(latLng);
        mMap.moveCamera(cameraUpdate);
        Marker m1=mMap.addMarker(mo);
        LayoutInflater inflater=getLayoutInflater();
        v=inflater.inflate(R.layout.info_window);

        //LatLng sydney = new LatLng(-34, 151);
       // mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
