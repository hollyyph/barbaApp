package com.example.contohapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

public class ConfirmOrder extends AppCompatActivity {
    public static final String ORDER_NOTES = "com.example.contohapp.onotes";
    private Intent prevIntent;
    private OrderModel orderModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);

        orderModel = new ViewModelProvider(this).get(OrderModel.class);

        prevIntent = getIntent();

        String pMethodString = prevIntent.getStringExtra(PaymentMethod.PAYMENT_METHOD);
        if (pMethodString != null && !pMethodString.isEmpty()) {
            TextView paymentMethod = findViewById(R.id.ConfirmOrder_chosenMethod);
            paymentMethod.setText(pMethodString);
        }

        TextView salonNameText = findViewById(R.id.ConfirmOrder_salonName);
        salonNameText.setText(prevIntent.getStringExtra(ReserveHome.SALON_NAME));

        TextView dateTimeText = findViewById(R.id.ConfirmOrder_dateTime);
        dateTimeText.setText(prevIntent.getStringExtra(CreateOrder.DATE_TIME));

        String notesString = prevIntent.getStringExtra(ConfirmOrder.ORDER_NOTES);
        if (notesString != null && !notesString.isEmpty()) {
            EditText notes = findViewById(R.id.ConfirmOrder_notes);
            notes.setText(prevIntent.getStringExtra(ConfirmOrder.ORDER_NOTES));
        }

        String productsString = "";
        String pricesString = "";
        HashMap<Integer, HashMap<String, Object>> pinfo = (HashMap<Integer, HashMap<String, Object>>) prevIntent.getSerializableExtra(CreateOrder.PRODUCT_INFO);
        HashMap<Integer, Integer> pcount = (HashMap<Integer, Integer>) prevIntent.getSerializableExtra(CreateOrder.PRODUCT_COUNT);
        Integer totalPriceValue = 0;

        for (int productId : pinfo.keySet()) {
            if (pcount.get(productId) > 0) {
                Integer subtotal = pcount.get(productId) * ((int) pinfo.get(productId).get("harga"));
                totalPriceValue += subtotal;
                pricesString = pricesString + subtotal.toString() + "\n";
                productsString = productsString + pinfo.get(productId).get("nama") + "\n";
            }
        }

        //menghapus newline terakhir
        productsString = productsString.substring(0, productsString.length() - 1);
        pricesString = pricesString.substring(0, pricesString.length() - 1);

        TextView products = findViewById(R.id.ConfirmOrder_products);
        TextView prices = findViewById(R.id.ConfirmOrder_prices);
        TextView totalPrice = findViewById(R.id.ConfirmOrder_totalPriceValue);

        totalPrice.setText(totalPriceValue.toString());
        products.setText(productsString);
        prices.setText(pricesString);
    }

    public void choosePaymentMethod(View view) {
        Intent intent = new Intent(this, PaymentMethod.class);
        intent.putExtras(prevIntent);

        EditText notes = findViewById(R.id.ConfirmOrder_notes);
        intent.putExtra(ORDER_NOTES, notes.getText().toString());

        startActivity(intent);
    }

    public void confirmOrder(View view) {
        String metode_pembayaran = prevIntent.getStringExtra(PaymentMethod.PAYMENT_METHOD);
        if (metode_pembayaran != null && !metode_pembayaran.isEmpty()) {
            Intent intent = new Intent(this, ViewConfirmed.class);
            intent.putExtras(prevIntent);

            EditText notes = findViewById(R.id.ConfirmOrder_notes);
            String keterangan = notes.getText().toString();
            intent.putExtra(ORDER_NOTES, keterangan);

            String waktu = prevIntent.getStringExtra(CreateOrder.DATE_TIME);
            HashMap<Integer, Integer> pcount = (HashMap<Integer, Integer>) prevIntent.getSerializableExtra(CreateOrder.PRODUCT_COUNT);

            orderModel.createSalonOrder(1, 1, pcount, waktu, metode_pembayaran, keterangan);

            startActivity(intent);
        }
    }
}