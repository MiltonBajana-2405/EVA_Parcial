package com.example.semna9;

import android.graphics.Color;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MainActivity extends AppCompatActivity
        implements OnMapReadyCallback, GoogleMap.OnMapClickListener {

     GoogleMap mapa;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        SupportMapFragment mapFragment = (SupportMapFragment)
                getSupportFragmentManager()
                        .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapa = googleMap;
        //Mapa configuracion
        mapa.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        mapa.getUiSettings().setZoomControlsEnabled(true);
        LatLng posQuevedo = new LatLng(-1.019858, -79.465915);
        CameraUpdate camUpd1 =
                CameraUpdateFactory
                        .newLatLngZoom( posQuevedo,25 );
        mapa.moveCamera(camUpd1);

        PolylineOptions lineas = new
                PolylineOptions()
                .add(new LatLng(-0.982766, -79.500933))
                .add(new LatLng(-0.982755, -79.434856))
                .add(new LatLng(-1.0671058,-79.4324200))
                .add(new LatLng(-1.0662932,-79.5002712))
                .add(new LatLng(-0.982766, -79.500933));
        lineas.width(8);
        lineas.color(Color.BLUE);
        mapa.addPolyline(lineas);
        // Marcadores sobre el mapa
        mapa.addMarker(new MarkerOptions()
                .position(posQuevedo)
                .title(" Quevedo"));
        mapa.addMarker(new MarkerOptions()
                .position(new LatLng(-0.982766, -79.500933)));
        mapa.addMarker(new MarkerOptions()
                .position(new LatLng(-0.982755, -79.434856)));
        mapa.addMarker(new MarkerOptions()
                .position(new LatLng(-1.0671058,-79.4324200)));
        mapa.addMarker(new MarkerOptions()
                .position(new LatLng(-1.0662932,-79.5002712)));
        //CAPTURAR
        mapa.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            public void onMapClick(LatLng point) {
                mapa.addMarker(new MarkerOptions().position(new LatLng(point.latitude, point.longitude)));
            }
        });
        //Colorear el territorio

        Circle Cir;
        CircleOptions circleOptions = new CircleOptions()
                .center(new LatLng(-1.0248850049768206, -79.4666253314406))
                .radius(6000)
                .strokeColor(Color.RED)
                .fillColor(Color.argb(60, 100, 60, 60));
        Cir = mapa.addCircle(circleOptions);


    }

    @Override
    public void onMapClick(LatLng latLng) {

    }
}