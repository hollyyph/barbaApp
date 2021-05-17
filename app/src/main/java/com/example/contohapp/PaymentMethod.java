package com.example.contohapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PaymentMethod extends AppCompatActivity {
    public static final String PAYMENT_METHOD = "com.example.contohapp.pmethod";

    private Intent prevIntent;

    private RecyclerView recyclerView;

    private String paymentMethod;

    // untuk isi teks listitem di recyclerview payment method
    private static final String[] paymentMethodNames = {"GoPay", "OVO", "LinkAja", "Dana", "Cash (OTS)"};

    // untuk gambar setiap payment method di recyclerview
    private static final int[] images = {
            R.drawable.gopay_logo_cropped,
            R.drawable.ovo_logo_cropped,
            R.drawable.linkaja_logo,
            R.drawable.dana_logo_cropped,
            R.drawable.cash_logo
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_method);

        prevIntent = getIntent();

        recyclerView = findViewById(R.id.PaymentMethod_recyclerview);
        PaymentMethodAdapter paymentMethodAdapter = new PaymentMethodAdapter(paymentMethodNames, images, new PaymentMethodAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String item) {
                paymentMethod = item;
            }
        });
        recyclerView.setAdapter(paymentMethodAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    public void choosePaymentMethod(View view) {
        Intent intent = new Intent(this, ConfirmOrder.class);
        intent.putExtras(prevIntent);
        intent.putExtra(PAYMENT_METHOD, paymentMethod);
        startActivity(intent);
    }
}