package com.example.contohapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class CreateOrder extends AppCompatActivity {
    public static final String PRODUCT_INFO = "com.example.contohapp.pinfo";
    public static final String PRODUCT_COUNT = "com.example.contohapp.pcount";
    public static final String DATE_TIME = "com.example.contohapp.dtime";

    private HashMap<Integer, HashMap<String, Object>> productsInfo;
    private HashMap<Integer, Integer> productsCount;
    private ArrayList<TextView> productCountTextView;
    private Intent prevIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_order);

        productsInfo = new HashMap<Integer, HashMap<String, Object>>();
        HashMap<String, Object> product1Info = new HashMap<String, Object>();
        HashMap<String, Object> product2Info = new HashMap<String, Object>();
        HashMap<String, Object> product3Info = new HashMap<String, Object>();

        product1Info.put("id", 1);
        product1Info.put("nama", "L’Oreal Hair Treatment - 90 Minutes");
        product1Info.put("harga", 30000);

        product2Info.put("id", 2);
        product2Info.put("nama", "Ginseng Hair Treatment - 90 Minutes");
        product2Info.put("harga", 80000);

        product3Info.put("id", 3);
        product3Info.put("nama", "Hair and Foot Treatment - 60 Minutes");
        product3Info.put("harga", 100000);

        productsInfo.put((int) product1Info.get("id"), product1Info);
        productsInfo.put((int) product2Info.get("id"), product2Info);
        productsInfo.put((int) product3Info.get("id"), product3Info);

        productsCount = new HashMap<Integer, Integer>();
        productsCount.put((int) product1Info.get("id"), 0);
        productsCount.put((int) product2Info.get("id"), 0);
        productsCount.put((int) product3Info.get("id"), 0);

        productCountTextView = new ArrayList<TextView>();
        productCountTextView.add(findViewById(R.id.CreateOrder_productCount1));
        productCountTextView.add(findViewById(R.id.CreateOrder_productCount2));
        productCountTextView.add(findViewById(R.id.CreateOrder_productCount3));

        for (int i = 0; i <= productsCount.size() - 1; i++) {
            productCountTextView.get(i).setText(productsCount.get(i + 1).toString());
        }

        prevIntent = getIntent();
        String message = prevIntent.getStringExtra(ReserveHome.SALON_NAME);
        TextView sname = findViewById(R.id.CreateOrder_salonName);
        sname.setText(message);

        ArrayList<Button> buttons = new ArrayList<Button>();
        int[] increaseButtonIds = {
                R.id.CreateOrder_increaseButton1,
                R.id.CreateOrder_increaseButton2,
                R.id.CreateOrder_increaseButton3
        };
        int[] decreaseButtonIds = {
                R.id.CreateOrder_decreaseButton1,
                R.id.CreateOrder_decreaseButton2,
                R.id.CreateOrder_decreaseButton3
        };

        for (int i = 0; i < increaseButtonIds.length; i++) {
            int final_i = i;
            findViewById(increaseButtonIds[i]).setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    increaseProductCount(final_i);
                }
            });
            findViewById(decreaseButtonIds[i]).setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    decreaseProductCount(final_i);
                }
            });

        }

        findViewById(R.id.CreateOrder_orderButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ConfirmOrder.class);
                intent.putExtras(prevIntent);

                HashMap<Integer, Integer> newProductsCount = (HashMap<Integer, Integer>) productsCount.clone();
                HashMap<Integer, HashMap<String, Object>> newProductsInfo = (HashMap<Integer, HashMap<String, Object>>) productsInfo.clone();
                for (Integer key : productsCount.keySet()) {
                    if (productsCount.get(key) == 0) {
                        newProductsCount.remove(key);
                        newProductsInfo.remove(key);
                    }
                }

                intent.putExtra(PRODUCT_INFO, newProductsInfo);
                intent.putExtra(PRODUCT_COUNT, newProductsCount);
                intent.putExtra(DATE_TIME, "22 March 2021 23:05");

                view.getContext().startActivity(intent);
            }
        });
    }

    public void increaseProductCount(int idx) {
        Integer pc = productsCount.get(idx + 1) + 1;
        productsCount.put(idx + 1, pc);
        productCountTextView.get(idx).setText(pc.toString());
    }

    public void decreaseProductCount(int idx) {
        Integer pc = productsCount.get(idx + 1);
        if (pc > 0) {
            pc -= 1;
            productsCount.put(idx + 1, pc);
            productCountTextView.get(idx).setText(pc.toString());
        }
    }
}