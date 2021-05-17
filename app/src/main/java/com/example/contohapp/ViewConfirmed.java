package com.example.contohapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;

public class ViewConfirmed extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_confirmed);

        Intent intent = getIntent();

        String pMethodString = intent.getStringExtra(PaymentMethod.PAYMENT_METHOD);
        if (pMethodString != null && !pMethodString.isEmpty()) {
            TextView paymentMethod = findViewById(R.id.ViewConfirmed_paymentMethodValue);
            paymentMethod.setText(pMethodString);
        }

        TextView salonNameText = findViewById(R.id.ViewConfirmed_salonName);
        salonNameText.setText(intent.getStringExtra(ReserveHome.SALON_NAME));

        TextView dateTimeText = findViewById(R.id.ViewConfirmed_dateTime);
        dateTimeText.setText(intent.getStringExtra(CreateOrder.DATE_TIME));

        TextView notes = findViewById(R.id.ViewConfirmed_notes);
        notes.setText(intent.getStringExtra(ConfirmOrder.ORDER_NOTES));

        findViewById(R.id.ViewConfirmed_chatButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Chat.class);
                view.getContext().startActivity(intent);
            }
        });

        String productsString = "";
        String pricesString = "";
        HashMap<Integer, HashMap<String, Object>> pinfo = (HashMap<Integer, HashMap<String, Object>>) intent.getSerializableExtra(CreateOrder.PRODUCT_INFO);
        HashMap<Integer, Integer> pcount = (HashMap<Integer, Integer>) intent.getSerializableExtra(CreateOrder.PRODUCT_COUNT);
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

        TextView totalPrice = findViewById(R.id.ViewConfirmed_totalPriceValue);
        TextView products = findViewById(R.id.ViewConfirmed_products);
        TextView prices = findViewById(R.id.ViewConfirmed_prices);

        totalPrice.setText(totalPriceValue.toString());
        products.setText(productsString);
        prices.setText(pricesString);
    }
}