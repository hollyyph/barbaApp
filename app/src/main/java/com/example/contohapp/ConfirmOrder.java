package com.example.contohapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class ConfirmOrder extends AppCompatActivity {
    private Intent prevIntent = getIntent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);

        // Get the Intent that started this activity and extract the string
//        Intent prevIntent = getIntent;

        // Capture the layout's TextView and set the string as its text
        TextView salonNameText = (TextView) findViewById(R.id.ConfirmOrder_salonName);
        salonNameText.setText(prevIntent.getStringExtra(OrderStub.SALON_NAME));
//        salonNameText.setText("JohnnyAndrean Bintaro");

        TextView dateTimeText = (TextView) findViewById(R.id.ConfirmOrder_dateTime);
        dateTimeText.setText(prevIntent.getStringExtra(OrderStub.DATE_TIME));
//        dateTimeText.setText("Sunday, 30 Mei 2021\n" + "13.45");

        TextView products = (TextView) findViewById(R.id.ConfirmOrder_products);
        ArrayList<String> pnames = prevIntent.getStringArrayListExtra(OrderStub.PRODUCT_NAME);
        ArrayList<Integer> pcount = prevIntent.getIntegerArrayListExtra(OrderStub.PRODUCT_COUNT);
        String str = "";
        for (int i=0; i <= pnames.size() - 1; i++) {
            str = str + pnames.get(i) + "\t\t" + pcount.get(i).toString() + "\n";
        }
        str = str.substring(0, str.length() - 1);
//        products.setText(str);
    }

    public void choosePaymentMethod(View view) {
        Intent intent = new Intent(this, PaymentMethod.class);
        intent.putExtras(prevIntent);
        startActivity(intent);
    }

    public void confirmOrder(View view) {
        Intent intent = new Intent(this, ViewConfirmed.class);
        intent.putExtras(prevIntent);
        startActivity(intent);
    }
}