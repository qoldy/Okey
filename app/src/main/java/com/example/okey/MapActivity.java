package com.example.okey;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {
    private GoogleMap gmap;

    private static final LatLng okey1 = new LatLng(45.036871, 38.932298);
    private static final LatLng okey2 = new LatLng(45.030037, 39.046046);
    private static final LatLng okey3 = new LatLng(45.010831, 39.067192);
    private static final LatLng okey4 = new LatLng(45.010310, 39.120951);
    private Marker mOkey1;
    private Marker mOkey2;
    private Marker mOkey3;
    private Marker mOkey4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
//    @Override
//    public void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//
//        Bundle mapViewBundle = outState.getBundle(MAP_VIEW_BUNDLE_KEY);
//        if (mapViewBundle == null) {
//            mapViewBundle = new Bundle();
//            outState.putBundle(MAP_VIEW_BUNDLE_KEY, mapViewBundle);
//        }
//
//        mapView.onSaveInstanceState(mapViewBundle);
//    }
//    @Override
//    protected void onResume() {
//        super.onResume();
//        mapView.onResume();
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        mapView.onStart();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        mapView.onStop();
//    }
//    @Override
//    protected void onPause() {
//        mapView.onPause();
//        super.onPause();
//    }
//    @Override
//    protected void onDestroy() {
//        mapView.onDestroy();
//        super.onDestroy();
//    }
//    @Override
//    public void onLowMemory() {
//        super.onLowMemory();
//        mapView.onLowMemory();
//    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        gmap = googleMap;
        mOkey1 = gmap.addMarker(new MarkerOptions().position(okey1));
        mOkey1.setTag(0);
        mOkey2 = gmap.addMarker(new MarkerOptions().position(okey2));
        mOkey2.setTag(1);
        mOkey3 = gmap.addMarker(new MarkerOptions().position(okey3));
        mOkey3.setTag(2);
        mOkey4 = gmap.addMarker(new MarkerOptions().position(okey4));
        mOkey4.setTag(3);
        gmap.setOnMarkerClickListener(this);
        gmap.moveCamera(CameraUpdateFactory.newLatLngZoom(okey2, 10));
    }

    @Override
    public boolean onMarkerClick(final Marker marker) {
        Integer tag = (Integer) marker.getTag();
        Toast.makeText(this, ((Okey) this.getApplication()).addressList.get(tag),
                Toast.LENGTH_SHORT).show();
        ((Okey)this.getApplication()).tag = tag;
        Intent intent = new Intent(this, CatalogActivity.class);
        startActivityForResult(intent, 0);
        return false;
    }

    @Override
    public void onBackPressed() { }
    public void onTemplatesClick(View view){
        Intent intent = new Intent(view.getContext(), TemplateActivity.class);
        startActivityForResult(intent, 0);
    }
}