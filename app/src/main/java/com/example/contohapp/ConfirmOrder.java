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
        salonNameText.setText(prevIntent.getStringExtra(OrderStub.SALON_NAME));

        TextView dateTimeText = (TextView) findViewById(R.id.ConfirmOrder_dateTime);
        dateTimeText.setText(prevIntent.getStringExtra(OrderStub.DATE_TIME));

        String notesString = prevIntent.getStringExtra(ConfirmOrder.ORDER_NOTES);
        if (notesString != null && !notesString.isEmpty()) {
            EditText notes = (EditText) findViewById(R.id.ConfirmOrder_notes);
            notes.setText(prevIntent.getStringExtra(ConfirmOrder.ORDER_NOTES));
        }

        TextView products = (TextView) findViewById(R.id.ConfirmOrder_products);
        TextView prices = (TextView) findViewById(R.id.ConfirmOrder_prices);

        ArrayList<String> pnames = prevIntent.getStringArrayListExtra(OrderStub.PRODUCT_NAME);
        ArrayList<Integer> pcount = prevIntent.getIntegerArrayListExtra(OrderStub.PRODUCT_COUNT);

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