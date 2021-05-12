package com.example.contohapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CatalogChoose2 extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog_choose1);
        TextView article = (TextView) findViewById(R.id.Catalog_Choose1_article);
        article.setText("If you thought that sharp, structured edges were out, think again. According to Mark Thompson, Artistic and Events Manager at L’Oreal Profrssionnel, “strong, blunt cuts are comming back and will domminate 2021, in particular, pixie and short bobs will make a return.” The best part? He says it doesn’t matter what face shape or hair type you havem they’ll be a blunt cut suit you.You heard it here first, the shag is here to stay. “They are still hanging about”, says KMS Guest Artist, Emily Olsson from shibui Melbourne. “But I think for the reason that they are so versatile, you can soften them out or go almost mullet-like depending on your desired look. “ Case and point? Rihanna just got a mullet.\n" +
                "Image: @khloekardashian");
        TextView title = (TextView) findViewById(R.id.Catalog_Choose1_title);
        article.setText("Bold, Blunt Cuts");
        ImageView image = (ImageView) findViewById(R.id.Catalog_Choose1_img);
        image.setBackgroundResource(R.drawable.catalog2_title);

    }
}
