package com.example.contohapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CreateOrder extends AppCompatActivity {
    public static final String PRODUCT_NAME = "com.example.contohapp.pname";
    public static final String PRODUCT_COUNT = "com.example.contohapp.pcount";

    private Integer product1Count = 0;
    private Integer product2Count = 0;
    private Integer product3Count = 0;

//    private String product1Name = "L’Oreal Hair Treatment - 90 Minutes";
//    private String product2Name = "Ginseng Hair Treatment - 90 Minutes";
//    private String product3Name = "Hair and Foot Treatment - 60 Minutes";

    private TextView pc1;
    private TextView pc2;
    private TextView pc3;

    private Intent prevIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_order);

        pc1 = (TextView) findViewById(R.id.CreateOrder_productCount1);
        pc2 = (TextView) findViewById(R.id.CreateOrder_productCount2);
        pc3 = (TextView) findViewById(R.id.CreateOrder_productCount3);

        pc1.setText(product1Count.toString());
        pc2.setText(product2Count.toString());
        pc3.setText(product3Count.toString());

        prevIntent = getIntent();
        String message = prevIntent.getStringExtra(ReserveHome.SALON_NAME);
        TextView sname = (TextView) findViewById(R.id.CreateOrder_salonName);
        sname.setText(message);
    }


    public void increaseProduct1Count(View view) {
        this.product1Count++;
        this.pc1.setText(product1Count.toString());
    }
    public void decreaseProduct1Count(View view) {
        this.product1Count--;
        this.pc1.setText(product1Count.toString());
    }

    public void increaseProduct2Count(View view) {
        this.product2Count++;
        this.pc2.setText(product2Count.toString());
    }
    public void decreaseProduct2Count(View view) {
        this.product2Count--;
        this.pc2.setText(product2Count.toString());
    }

    public void increaseProduct3Count(View view) {
        this.product3Count++;
        this.pc3.setText(product1Count.toString());
    }
    public void decreaseProduct3Count(View view) {
        this.product3Count--;
        this.pc3.setText(product3Count.toString());
    }

    public void createOrder(View view) {
        Intent intent = new Intent(this, ConfirmOrder.class);

        intent.putExtras(prevIntent);
//        intent.putExtra(DATE_TIME, datetimeInput.getText().toString());

        List<Integer> pcounts = new ArrayList<Integer>();
        if (product1Count == 0) {
            pcounts.add(product1Count);
        }
        if (product2Count == 0) {
            pcounts.add(product2Count);
        }
        if (product3Count == 0) {
            pcounts.add(product3Count);
        }

        List<String> pnames = new ArrayList<String>();
        pnames.add("L’Oreal Hair Treatment - 90 Minutes");
        pnames.add("Ginseng Hair Treatment - 90 Minutes");
        pnames.add("Hair and Foot Treatment - 60 Minutes");

        intent.putStringArrayListExtra (PRODUCT_NAME, (ArrayList<String>) pnames);
        intent.putIntegerArrayListExtra (PRODUCT_COUNT, (ArrayList<Integer>) pcounts);

        startActivity(intent);
    }


}