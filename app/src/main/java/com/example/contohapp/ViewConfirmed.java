package com.example.contohapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewConfirmed extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_confirmed);

        Intent intent = getIntent();

        String pMethodString = intent.getStringExtra(PaymentMethod.PAYMENT_METHOD);
        if (pMethodString != null && !pMethodString.isEmpty()) {
            TextView paymentMethod = (TextView) findViewById(R.id.ViewConfirmed_paymentMethodValue);
            paymentMethod.setText(pMethodString);
        }

        TextView salonNameText = (TextView) findViewById(R.id.ViewConfirmed_salonName);
        salonNameText.setText(intent.getStringExtra(OrderStub.SALON_NAME));

        TextView dateTimeText = (TextView) findViewById(R.id.ViewConfirmed_dateTime);
        dateTimeText.setText(intent.getStringExtra(OrderStub.DATE_TIME));

        TextView notes = (TextView) findViewById(R.id.ViewConfirmed_notes);
        notes.setText(intent.getStringExtra(ConfirmOrder.ORDER_NOTES));

        TextView products = (TextView) findViewById(R.id.ViewConfirmed_products);
        TextView prices = (TextView) findViewById(R.id.ViewConfirmed_prices);

        ArrayList<String> pnames = intent.getStringArrayListExtra(OrderStub.PRODUCT_NAME);
        ArrayList<Integer> pcount = intent.getIntegerArrayListExtra(OrderStub.PRODUCT_COUNT);

        String productsString = "";
        String pricesString = "";
        for (int i=0; i <= pnames.size() - 1; i++) {
            productsString = productsString + pnames.get(i) + "\n";
            pricesString = pricesString + pcount.get(i).toString() + "\n";
        }
        productsString = productsString.substring(0, productsString.length() - 1);
        pricesString = pricesString.substring(0, pricesString.length() - 1);

        products.setText(productsString);
        prices.setText(pricesString);
    }


}