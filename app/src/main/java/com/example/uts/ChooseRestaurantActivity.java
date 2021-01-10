package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class ChooseRestaurantActivity extends AppCompatActivity {

         Order o;
         coordinate coor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooserestaurant);




        if(getIntent()!= null && getIntent().getExtras() !=null){
            o = new Order("",0,0);
            o = getIntent().getExtras().getParcelable("obj");


        }

    }

    public void BinusAlamSutera(View view) {
        Intent pass = new Intent(this, MapsActivity.class);
        coor = new coordinate();

        coor.setName("Binus EzyFood Alam Sutera");
        coor.setX(-6.2247123);
        coor.setY(106.6502748);

        o.setRestaurant("Binus EzyFood Alam Sutera");
        pass.putExtra("obj" , o);
        pass.putExtra("coords", coor);

        startActivity(pass);

    }

    public void BinusBekasi(View view) {
        Intent pass = new Intent(this, MapsActivity.class);

        coor = new coordinate();
        coor.setName("Binus EzyFood Bekasi");
        coor.setX(-6.2200771);
        coor.setY(106.9997197);

        o.setRestaurant("Binus EzyFood Bekasi");
        pass.putExtra("obj" , o);
        pass.putExtra("coords", coor);


        startActivity(pass);
    }

    public void BinusSyahdan(View view) {

        Intent pass = new Intent(this, MapsActivity.class);

        coor = new coordinate();

        coor.setName("Binus EzyFood Kampus Syahdan");
        coor.setX(-6.2002269);
        coor.setY(106.7854095);

        o.setRestaurant("Binus EzyFood Kampus Syahda");
        pass.putExtra("obj" , o);
        pass.putExtra("coords", coor);
        startActivity(pass);
    }
}
