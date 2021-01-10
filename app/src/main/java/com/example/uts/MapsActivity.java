package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.text.DecimalFormat;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private double x, y, distanceP;
    private String name;
    Order o;
    coordinate coor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurantmaps);


        if(getIntent()!= null && getIntent().getExtras() !=null){
            o = getIntent().getExtras().getParcelable("obj");
            coor = getIntent().getExtras().getParcelable("coords");


            set_coordinate(coor.getName(), coor.getX(), coor.getY());


            LatLng rumah = new LatLng(-6.812098617801593, 105.82155934892579);
            LatLng coords = new LatLng(x, y);
            TextView Distance = findViewById(R.id.txtDistance);
            double d = CalculationByDistance(rumah,coords);
            distanceP = d;
            Distance.setText(String.format("%.2f", d) + " KM");


    }

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



    }



    public double CalculationByDistance(LatLng StartP, LatLng EndP) {
        int Radius = 6371;// radius of earth in Km
        double lat1 = StartP.latitude;
        double lat2 = EndP.latitude;
        double lon1 = StartP.longitude;
        double lon2 = EndP.longitude;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1))
                * Math.cos(Math.toRadians(lat2)) * Math.sin(dLon / 2)
                * Math.sin(dLon / 2);
        double c = 2 * Math.asin(Math.sqrt(a));
        double valueResult = Radius * c;
        double km = valueResult / 1;
        DecimalFormat newFormat = new DecimalFormat("####");
        int kmInDec = Integer.valueOf(newFormat.format(km));
        double meter = valueResult % 1000;
        int meterInDec = Integer.valueOf(newFormat.format(meter));
        Log.i("Radius Value", "" + valueResult + "   KM  " + kmInDec
                + " Meter   " + meterInDec);

        return Radius * c;
    }

    protected void set_coordinate(String name, double x, double y){
        this.x = x;
        this.y = y;
        this.name = name;

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng rumah = new LatLng(-6.3053252, 106.6435146);
        LatLng coords = new LatLng(x, y);
        double xt = (-6.3053252+x)/2;
        double yt = (106.6435146+y)/2;
        LatLng Camera = new LatLng(xt,yt);
        mMap.addMarker(new MarkerOptions().position(rumah).title("Rumah Hayalan"));
        mMap.addMarker(new MarkerOptions().position(coords).title(name));
        float zoom = 4.0f;
        if(distanceP > 100 && distanceP < 120) zoom = 12.0f;
        else if (distanceP >=120) zoom = 10.0f;
        else if (distanceP<=100) zoom = 15.0f;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Camera, zoom));



    }

    public void ConfirmOrder(View view) {

        Order newOrder = o;

        Intent result = new Intent(this, MainActivity.class);
        result.putExtra("obj", newOrder);
        startActivity(result);
    }
}
