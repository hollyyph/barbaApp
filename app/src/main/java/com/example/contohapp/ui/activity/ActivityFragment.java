package com.example.contohapp.ui.activity;

import android.util.Log;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contohapp.ActivityAdapter;
import com.example.contohapp.OrderActivity;
import com.example.contohapp.OrderModel;
import com.example.contohapp.R;
import com.example.contohapp.ReserveHome;
import com.example.contohapp.ViewConfirmed;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ActivityFragment extends Fragment {

    private OrderModel orderModel;
    private LinearLayout l;
    private RecyclerView recyclerView;
    private String idActivity;
//    private ArrayList<HashMap<String, Object>> ordersList;
//    private HashMap<Integer, HashMap<String, Object>> ordersMap;
    public static String CHOSEN_ID_ACTIVITY = "com.example.contohapp.cidactivity";

    //ubah jadi masukin dr database
    private static final String[] activityIds = new String[]{"1", "2", "3", "4"};
    private static final String[] activityNames = new String[]{"John", "July", "June", "Jill"};
    private static final String[] activityDates = new String[]{"23 Agustus 2020", "4 September 2020", "18 Desember 2020", "3 Maret 2021"};
    private static final String[] activityStatuses = new String[]{"Done", "Done", "Done", "Done"};

    private ArrayList<HashMap<String, Object>> arrOrder;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_activity, container, false);
        final TextView textView = root.findViewById(R.id.text_activity);

        orderModel = new ViewModelProvider(this).get(OrderModel.class);
        orderModel.loadOrders(1);
        recyclerView = root.findViewById(R.id.Activity_recyclerview);

        final Observer<ArrayList<HashMap<String, Object>>> orderObserver = new Observer<ArrayList<HashMap<String, Object>>>() {
            @Override
            public void onChanged(final ArrayList<HashMap<String, Object>> orders) {
                HashMap<Integer, HashMap<String, Object>> ordersMap = new HashMap<Integer, HashMap<String, Object>>();
                String[] groupedKey = {"id_produk", "harga_produk", "kuantitas_produk", "nama_produk"};

                for (HashMap<String, Object> orderInfo : orders) {
                    int orderId = (int) orderInfo.get("id_pesanan");
                    ArrayList<HashMap<String, Object>> productList;
                    HashMap<String, Object> order;
                    if (ordersMap.containsKey(orderId)) {
                        productList = (ArrayList<HashMap<String, Object>>) ordersMap.get(orderId).get("info_produk");
                        order = ordersMap.get(orderId);
                    } else {
                        productList = new ArrayList<HashMap<String, Object>>();
                        order = orderInfo;
                    }
                    HashMap<String, Object> product = new HashMap<String, Object>();
                    if (ordersMap.containsKey(orderId)) {
                        for (String s : groupedKey) {
                            product.put(s, orderInfo.get(s));
                        }
                    } else {
                        for (String s : groupedKey) {
                            product.put(s, orderInfo.get(s));
                            order.remove(s);
                        }
                    }
                    productList.add(product);
                    order.put("info_produk", productList);
                    ordersMap.put(orderId, order);
                }

                ActivityAdapter activityAdapter = new ActivityAdapter(ordersMap, new ActivityAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(int orderId) {
                        Intent intent = new Intent(getActivity(), OrderActivity.class);
                        intent.putExtra(CHOSEN_ID_ACTIVITY, ordersMap.get(orderId));
                        startActivity(intent);
                    }
                });

                recyclerView.setAdapter(activityAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            }
        };

        orderModel.getUserOrder().observe(getViewLifecycleOwner(), orderObserver);

        ActivityAdapter activityAdapter = new ActivityAdapter(new HashMap<Integer, HashMap<String, Object>>(), new ActivityAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int orderId) {}
        });
        recyclerView.setAdapter(activityAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return root;
    }

    public void chooseActivity(View view) {
        Intent intent = new Intent(getActivity(), ViewConfirmed.class);
        intent.putExtra(CHOSEN_ID_ACTIVITY, idActivity);
        startActivity(intent);
    }
}