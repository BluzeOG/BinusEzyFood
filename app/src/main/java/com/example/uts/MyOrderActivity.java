package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyOrderActivity extends AppCompatActivity {
    int total = 0;
    int balance = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

        ListView lv = findViewById(R.id.listview);

        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("BUNDLE");

        balance =  intent.getIntExtra("balance",0);

        ArrayList<Order> OL = (ArrayList<Order>) args.getSerializable("ARRAYLIST");
        ArrayList<Integer> qty = new ArrayList<>();

        for(int i = 0; i< OL.size();i++){
            qty.add(OL.get(i).getQty());
        }

        ArrayAdapter<Order> arrayAdapter = new ArrayAdapter<Order>(
                this,
                android.R.layout.simple_list_item_1,
                OL);

        lv.setAdapter(arrayAdapter);


        TextView tvTotal = findViewById(R.id.txtTotal);
        total = 0;
        for(int i = 0; i<OL.size(); i++){
            total+= (OL.get(i).getPrice())*(OL.get(i).getQty());
        }
        tvTotal.setText("Total Price = " +total);

    }

    public void Finish(View view) {
        if(total>balance){
            AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
            dlgAlert.setMessage("Your Balance is not enough");
            dlgAlert.setTitle("Binus EzyFood");
            dlgAlert.setPositiveButton("Ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            //dismiss the dialog
                        }
                    });
            dlgAlert.setCancelable(true);
            dlgAlert.create().show();
        }else {
            Intent intent = new Intent(this, OrderFinishedActivity.class);
            intent.putExtra("total", total);
            this.startActivity(intent);
        }
    }
}
