package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private int balance = 0;
    ArrayList<Order> OL = OrderList.getInstance().OL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if(getIntent()!= null && getIntent().getExtras() !=null){
            if(getIntent().getExtras().getParcelable("obj") !=null){
                Order o = new Order("",0,0);
                o = getIntent().getExtras().getParcelable("obj");
                OL.add(o);
            }


                int topUp = getIntent().getIntExtra("topUp",0);
                balance+=topUp;



        }

        TextView updateBal = findViewById(R.id.txtBalance);
        updateBal.setText("Balance: " + balance);
    }


    public void Drinks(View view) {

        Intent drinkIntent = new Intent(MainActivity.this, DrinksActivity.class);
        this.startActivity(drinkIntent);
    }


    public void TopUp(View view) {

        Intent topupIntent = new Intent(MainActivity.this, TopupbalanceActivity.class);

        this.startActivity(topupIntent);
        finish();

    }

    public void MyOrder(View view) {
        Intent intent = new Intent(MainActivity.this, MyOrderActivity.class);
        Bundle args = new Bundle();
        args.putSerializable("ARRAYLIST",(Serializable)OL);
        intent.putExtra("BUNDLE",args);
        intent.putExtra("balance" , balance);
        this.startActivity(intent);
    }
}
