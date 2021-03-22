package com.example.contohapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class ConfirmOrder extends AppCompatActivity {
    public static final String ORDER_NOTES = "com.example.contohapp.onotes";
    private Intent prevIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);

        // Get the Intent that started this activity and extract the string
        prevIntent = getIntent();

        String pMethodString = prevIntent.getStringExtra(PaymentMethod.PAYMENT_METHOD);
        if (pMethodString != null && !pMethodString.isEmpty()) {
            TextView paymentMethod = (TextView) findViewById(R.id.ConfirmOrder_chosenMethod);
            paymentMethod.setText(pMethodString);
        }

        TextView salonNameText = (TextView) findViewById(R.id.ConfirmOrder_salonName);
        salonNameText.setText(prevIntent.getStringExtra(ReserveHome.SALON_NAME));

        TextView dateTimeText = (TextView) findViewById(R.id.ConfirmOrder_dateTime);
        dateTimeText.setText(prevIntent.getStringExtra(CreateOrder.DATE_TIME));
//        dateTimeText.setText("22 March 2021 23:05");

        String notesString = prevIntent.getStringExtra(ConfirmOrder.ORDER_NOTES);
        if (notesString != null && !notesString.isEmpty()) {
            EditText notes = (EditText) findViewById(R.id.ConfirmOrder_notes);
            notes.setText(prevIntent.getStringExtra(ConfirmOrder.ORDER_NOTES));
        }

        TextView products = (TextView) findViewById(R.id.ConfirmOrder_products);
        TextView prices = (TextView) findViewById(R.id.ConfirmOrder_prices);

        ArrayList<String> pnames = prevIntent.getStringArrayListExtra(CreateOrder.PRODUCT_NAME);
        ArrayList<Integer> pcount = prevIntent.getIntegerArrayListExtra(CreateOrder.PRODUCT_COUNT);

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



        productsString = productsString.substring(0, productsString.length() - 1);
        pricesString = pricesString.substring(0, pricesString.length() - 1);

        Integer tp = quantity1 + quantity2 + quantity3;
        TextView totalPrice = (TextView) findViewById(R.id.ConfirmOrder_totalPriceValue);
        totalPrice.setText(tp.toString());

        products.setText(productsString);
        prices.setText(pricesString);
    }

    public void choosePaymentMethod(View view) {
        Intent intent = new Intent(this, PaymentMethod.class);
        intent.putExtras(prevIntent);

        EditText notes = (EditText) findViewById(R.id.ConfirmOrder_notes);
        intent.putExtra(ORDER_NOTES, notes.getText().toString());

        startActivity(intent);
    }

    public void confirmOrder(View view) {
        Intent intent = new Intent(this, ViewConfirmed.class);
        intent.putExtras(prevIntent);

        EditText notes = (EditText) findViewById(R.id.ConfirmOrder_notes);
        intent.putExtra(ORDER_NOTES, notes.getText().toString());

        startActivity(intent);
    }
}