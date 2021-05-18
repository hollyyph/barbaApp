package com.example.contohapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.contohapp.ui.activity.ActivityFragment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        HashMap<String, Object> order = (HashMap<String, Object>) getIntent().getSerializableExtra(ActivityFragment.CHOSEN_ID_ACTIVITY);

        TextView paymentMethod = findViewById(R.id.OrderActivity_paymentMethodValue);
        paymentMethod.setText(order.get("metode_pembayaran").toString());

        TextView salonNameText = findViewById(R.id.OrderActivity_salonName);
        salonNameText.setText(order.get("nama_salon").toString());


        TextView dateTimeText = findViewById(R.id.OrderActivity_dateTime);

        String dt = order.get("waktu").toString();

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd MMMM yyyy HH:mm");

        Date convertdt = null;
        try {
            convertdt = sdf1.parse(dt);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String newdt = sdf2.format(convertdt);
        dateTimeText.setText(newdt);

//        dateTimeText.setText(order.get("waktu").toString());
        TextView statusValue = findViewById(R.id.OrderActivity_statusValue);

        Calendar cal = Calendar.getInstance();
        Date nowdt = new Date(System.currentTimeMillis());
        if (convertdt.compareTo(nowdt) > 0){
            statusValue.setText("Ongoing");
            statusValue.setTextColor(Color.parseColor("#FF58A4B0"));
        }

        TextView notes = findViewById(R.id.OrderActivity_notes);

        try {
            notes.setText(order.get("keterangan").toString());
        } catch (NullPointerException e) {
            e.printStackTrace();
            notes.setText("");
        }

        TextView paymentMethodText = findViewById(R.id.OrderActivity_paymentMethodValue);
        paymentMethodText.setText(order.get("metode_pembayaran").toString());

        String productsString = "";
        String pricesString = "";
        Integer totalPriceValue = 0;

        if (order.get("info_produk") != null) {
            for (HashMap<String, Object> produk : (ArrayList<HashMap<String, Object>>) order.get("info_produk")) {
                Integer subtotal = (int) produk.get("kuantitas_produk") * (int)  produk.get("harga_produk") ;
                totalPriceValue += subtotal;
                pricesString = pricesString + subtotal.toString() + "\n";
                productsString = productsString + produk.get("nama_produk") + "\n";
            }

            //menghapus newline terakhir
            productsString = productsString.substring(0, productsString.length() - 1);
            pricesString = pricesString.substring(0, pricesString.length() - 1);
        }

        TextView totalPrice = findViewById(R.id.OrderActivity_totalPriceValue);
        totalPrice.setText(totalPriceValue.toString());

        TextView products = findViewById(R.id.OrderActivity_products);
        products.setText(productsString);

        TextView prices = findViewById(R.id.OrderActivity_prices);
        prices.setText(pricesString);

//        findViewById(R.id.OrderActivity_homeButton).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(view.getContext(), MainActivity.class);
//                view.getContext().startActivity(intent);
//            }
//        });
    }
}