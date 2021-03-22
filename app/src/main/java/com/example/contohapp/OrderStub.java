package com.example.contohapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class OrderStub extends AppCompatActivity {
    public static final String SALON_NAME = "com.example.contohapp.sname";
    public static final String DATE_TIME = "com.example.contohapp.dtime";
    public static final String PRODUCT_NAME = "com.example.contohapp.pname";
    public static final String PRODUCT_COUNT = "com.example.contohapp.pcount";

    private List<String> products = new ArrayList<String>();
    private List<Integer> count = new ArrayList<Integer>();

    private Integer productCount = 0;
    private TextView pCountElement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_stub);
        pCountElement = (TextView) findViewById(R.id.productCount);
        pCountElement.setText(productCount.toString());
    }

    public void increaseProductCount(View view) {
        this.productCount++;
        this.pCountElement.setText(productCount.toString());
    }

    public void decreaseProductCount(View view) {
        this.productCount--;
        this.pCountElement.setText(productCount.toString());
    }

    public void addProduct(View view) {
        EditText productName = (EditText) findViewById(R.id.productName);
        this.products.add(productName.getText().toString());
        this.count.add(productCount);
        this.productCount = 0;
        this.pCountElement.setText(productCount.toString());
    }

    public void createOrder(View view) {
        Intent intent = new Intent(this, ConfirmOrder.class);
        EditText salonInput = (EditText) findViewById(R.id.salonName);
        EditText datetimeInput = (EditText) findViewById(R.id.dateTime);

        intent.putExtra(SALON_NAME, salonInput.getText().toString());
        intent.putExtra(DATE_TIME, datetimeInput.getText().toString());

//        String[] productsArray = new String[this.products.size()];
//        for (int i=0; i < productsArray.length; i++) {
//            productsArray[i] = this.products.get(i);
//        }
        intent.putStringArrayListExtra (PRODUCT_NAME, (ArrayList<String>) this.products);

//        int[] countArray = new int[this.count.size()];
//        for (int i=0; i < countArray.length; i++) {
//            countArray[i] = this.count.get(i).intValue();
//        }
        intent.putIntegerArrayListExtra (PRODUCT_COUNT, (ArrayList<Integer>) this.count);

        startActivity(intent);
    }
}