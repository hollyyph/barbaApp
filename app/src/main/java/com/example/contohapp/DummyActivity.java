package com.example.contohapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;


public class DummyActivity extends AppCompatActivity {
    private ReviewModel reviewModel;
    private OrderModel orderModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummy_activity);


        TextView reviewTextView = findViewById(R.id.da_reviewlist);
        TextView orderTextView = findViewById(R.id.da_orderlist);

        reviewModel = new ViewModelProvider(this).get(ReviewModel.class);
        orderModel = new ViewModelProvider(this).get(OrderModel.class);

        reviewModel.loadSalonReviews(1);
        orderModel.loadOrders(1);

        final Observer<ArrayList<HashMap<String, Object>>> reviewObserver = new Observer<ArrayList<HashMap<String, Object>>>() {
            @Override
            public void onChanged(final ArrayList<HashMap<String, Object>> reviews) {
                String content = "Jumlah review: " + reviews.size() + ". Konten tiap review: \n";
                ArrayList<Integer> ratings = new ArrayList<Integer>();
                if (reviews.size() != 0) {
                    Set<String> keys = reviews.get(0).keySet();
                    for (int i = 0; i < reviews.size(); i++) {
                        for (String key : keys) {
                            if ((int) reviews.get(i).get("id_salon") == 1) {
                                ratings.add((Integer) reviews.get(i).get("rating"));
                            }
                            content += String.format("%s: %s\n", key, reviews.get(i).get(key).toString());
                        }
                        content += "\n";
                    }
                } else {
                    content += "belum ada review";
                }
                content += countRatingsAvg(ratings);
                reviewTextView.setText(content);
            }
        };

        final Observer<ArrayList<HashMap<String, Object>>> orderObserver = new Observer<ArrayList<HashMap<String, Object>>>() {
            @Override
            public void onChanged(final ArrayList<HashMap<String, Object>> orders) {
                String content = "Semua Order: \n";
                if (orders.size() != 0) {

                    Integer subtotal;
                    Integer totalPriceValue = 0;
                    for (HashMap<String, Object> map : orders) {
                        if ((int) map.get("id_pesanan") == 1) {
                            subtotal = (int) map.get("harga_produk") * (int) map.get("kuantitas_produk");
                            totalPriceValue += subtotal;
                            content += String.format("%s: %s\n", map.get("nama_produk"), subtotal.toString());
                        }
                    }
                    content += String.format("\n%s: %s\n", "total", totalPriceValue.toString());

//                    Set<String> keys = orders.get(0).keySet();
//                    for (int i = 0; i < orders.size(); i++) {
//                        for (String key : keys) {
//                            String value;
//                            // reminder:
//                            // int id_stylist bakal diisi 0 klo di JSON nya null
//                            // String nama_stylist tp tetep null
//                            if (orders.get(i).get(key) == null) {
//                                value = "";
//                            } else {
//                                value = orders.get(i).get(key).toString();
//                            }
//                            content += String.format("%s: %s\n", key, value);
//                        }
//                        content += "\n";
//                    }
                } else {
                    content += "belum ada order";
                }
                orderTextView.setText(content);
            }
        };

        reviewModel.getSalonReviews().observe(this, reviewObserver);
        orderModel.getUserOrder().observe(this, orderObserver);

        findViewById(R.id.da_createreview).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                reviewModel.createSalonReview(1, 1, "konten review", 3);
            }
        });
    }

    public float countRatingsAvg(ArrayList<Integer> ratings) {
        if (ratings.size() == 0) {
            return 0;
        } else {
            int sum = 0;
            int count = 0;
            for (int r : ratings) {
                sum += r;
                count++;
            }
            return ((float) sum) / count;
        }
    }
}