package com.example.contohapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PaymentMethod extends AppCompatActivity {
    public static final String PAYMENT_METHOD = "com.example.contohapp.pmethod";
    private TextView gopay;
    private TextView ovo;
    private TextView linkaja;
    private TextView dana;
    private TextView cash;
    private String pmethod;
    private Intent prevIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_method);
        prevIntent = getIntent();

        gopay =  (TextView) findViewById(R.id.PaymentMethod_gopay);
        ovo =  (TextView) findViewById(R.id.PaymentMethod_ovo);
        linkaja =  (TextView) findViewById(R.id.PaymentMethod_linkaja);
        dana =  (TextView) findViewById(R.id.PaymentMethod_dana);
        cash =  (TextView) findViewById(R.id.PaymentMethod_cash);

        gopay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pmethod = gopay.getText().toString();
            }
        });
        ovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pmethod = ovo.getText().toString();
            }
        });
        linkaja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pmethod = linkaja.getText().toString();
            }
        });
        dana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pmethod = dana.getText().toString();
            }
        });
        cash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pmethod = cash.getText().toString();
            }
        });
    }

    public void setPaymentMethod(View view) {
        Intent intent = new Intent(this, ConfirmOrder.class);
        intent.putExtras(this.prevIntent);
        intent.putExtra(PAYMENT_METHOD, this.pmethod);
        startActivity(intent);
    }
}