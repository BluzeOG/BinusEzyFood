package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DrinksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);
    }

    public void AirMineral(View view) {
        Intent orderIntent = new Intent(this, OrderActivity.class);
        String p = "Air Mineral";
        int pr = 123;
        orderIntent.putExtra("PName", p);
        orderIntent.putExtra("Price", pr);
        startActivity(orderIntent);
    }

    public void JusApel(View view){
        Intent orderIntent = new Intent(this, OrderActivity.class);
        String p = "Jus Apel";
        int pr = 234;
        orderIntent.putExtra("PName", p);
        orderIntent.putExtra("Price", pr);
        startActivity(orderIntent);
    }

    public void JusMangga(View view) {
        Intent orderIntent = new Intent(this, OrderActivity.class);
        String p = "Jus Mangga";
        int pr = 345;
        orderIntent.putExtra("PName", p);
        orderIntent.putExtra("Price", pr);
        startActivity(orderIntent);
    }

    public void JusAlpukat(View view) {
        Intent orderIntent = new Intent(this, OrderActivity.class);
        String p = "Jus Alpukat";
        int pr = 456;
        orderIntent.putExtra("PName", p);
        orderIntent.putExtra("Price", pr);
        startActivity(orderIntent);
    }
}
