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
        salonNameText.setText(intent.getStringExtra(ReserveHome.SALON_NAME));

        TextView dateTimeText = (TextView) findViewById(R.id.ViewConfirmed_dateTime);
        dateTimeText.setText(intent.getStringExtra(CreateOrder.DATE_TIME));

        TextView notes = (TextView) findViewById(R.id.ViewConfirmed_notes);
        notes.setText(intent.getStringExtra(ConfirmOrder.ORDER_NOTES));

        TextView products = (TextView) findViewById(R.id.ViewConfirmed_products);
        TextView prices = (TextView) findViewById(R.id.ViewConfirmed_prices);

        ArrayList<String> pnames = intent.getStringArrayListExtra(CreateOrder.PRODUCT_NAME);
        ArrayList<Integer> pcount = intent.getIntegerArrayListExtra(CreateOrder.PRODUCT_COUNT);

        String productsString = "";
        String pricesString = "";
        Integer quantity1 = 0;
        Integer quantity2 = 0;
        Integer quantity3 = 0;

        if (pcount.get(0) > 0) {
            quantity1 = pcount.get(0) * 30000;
            pricesString = pricesString + quantity1.toString() + "\n";
            productsString = productsString + pnames.get(0) + "\n";
        }

        if (pcount.get(1) > 0) {
            quantity2 = pcount.get(1) * 80000;
            pricesString = pricesString + quantity2.toString() + "\n";
            productsString = productsString + pnames.get(1) + "\n";
        }

        if (pcount.get(2) > 0) {
            quantity3 = pcount.get(2) * 100000;
            pricesString = pricesString + quantity3.toString() + "\n";
            productsString = productsString + pnames.get(2) + "\n";
        }

//        for (int i=0; i <= pnames.size() - 1; i++) {
//            productsString = productsString + pnames.get(i) + "\n";
//            pricesString = pricesString + pcount.get(i).toString() + "\n";
//        }

        Integer tp = quantity1 + quantity2 + quantity3;
        TextView totalPrice = (TextView) findViewById(R.id.ViewConfirmed_totalPriceValue);
        totalPrice.setText(tp.toString());

        productsString = productsString.substring(0, productsString.length() - 1);
        pricesString = pricesString.substring(0, pricesString.length() - 1);

        products.setText(productsString);
        prices.setText(pricesString);
    }


}