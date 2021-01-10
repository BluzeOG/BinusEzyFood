package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class OrderFinishedActivity extends AppCompatActivity {
    ArrayList<Order> OL = OrderList.getInstance().OL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_finished);
        TextView tv = findViewById(R.id.TOTALF);

        Intent i = getIntent();
        int aTotal = i.getIntExtra("total",0);
        tv.setText("Rp." + aTotal);
        OL.clear();

    }

    public void back(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
    }
}
