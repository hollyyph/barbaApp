package com.example.contohapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ReserveHome extends AppCompatActivity {
    public static final String SALON_NAME = "com.example.contohapp.sname";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve_home);
    }

    public void chooseOption1(View view) {
        createIntent("D’Moze Salon Kelapa Gading Treatments");
    }
    public void chooseOption2(View view) {
        createIntent("Glo Studio Hair and Beauty Treatments");
    }
    public void chooseOption3(View view) {
        createIntent("Johnny Andrean Bintaro");
    }

    public void createIntent(String salonName) {
        Intent intent = new Intent(this, CreateOrder.class);
        intent.putExtra(SALON_NAME, salonName);
        startActivity(intent);
    }
}