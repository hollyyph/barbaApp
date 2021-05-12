package com.example.contohapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CatalogChoose1 extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog_choose1);
        TextView article = (TextView) findViewById(R.id.Catalog_Choose1_article);
        article.setText("You heard it here first, the shag is here to stay. “They are still hanging about”, says KMS Guest Artist, Emily Olsson from shibui Melbourne. “But I think for the reason that they are so versatile, you can soften them out or go almost mullet-like depending on your desired look. “ Case and point? Rihanna just got a mullet.\n" +
                "Image: @coiffeurstory");
        TextView title = (TextView) findViewById(R.id.Catalog_Choose1_title);
        title.setText("Shags, shags, shags");
        ImageView image = (ImageView) findViewById(R.id.Catalog_Choose1_img);
        image.setBackgroundResource(R.drawable.catalog1_title);
        findViewById(R.id.Catalog_Choose1_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(view.getContext(), CatalogChoose2.class);
                view.getContext().startActivity(intent);
            }
        });

    }

};
