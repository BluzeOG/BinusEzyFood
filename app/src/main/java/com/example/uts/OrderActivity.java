package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {
    String name;
    int price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        name = intent.getStringExtra("PName");
        price = intent.getIntExtra("Price",0);

        TextView tvName = findViewById(R.id.txtPName);
        tvName.setText("Name : " + name);

        TextView tvprice = findViewById(R.id.txtPrice);
        tvprice.setText("Price : " + price);

        EditText edt = findViewById(R.id.editTextQty);
        edt.setText("1");

    }

    public void Order(View view) {
        TextView tvName = findViewById(R.id.txtPName);
        TextView tvprice = findViewById(R.id.txtPrice);
        EditText edt = findViewById(R.id.editTextQty);
        int qty = Integer.parseInt(edt.getText().toString());
        Order newOrder = new Order(name, qty , price);


        Intent result = new Intent(this, ChooseRestaurantActivity.class);
        result.putExtra("obj", newOrder);
        startActivity(result);
    }

}
