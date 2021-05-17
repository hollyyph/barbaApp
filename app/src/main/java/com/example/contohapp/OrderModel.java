package com.example.contohapp;

import android.util.Log;

import com.example.contohapp.data.RetrofitClientInstance;
import com.example.contohapp.data.Webservice;
import com.example.contohapp.data.pojo.OrderBody;
import com.example.contohapp.data.pojo.OrderResponse;

import java.util.ArrayList;
import java.util.HashMap;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderModel extends ViewModel {
    private MutableLiveData<ArrayList<HashMap<String, Object>>> orders;
    Webservice apiInterface;

    public OrderModel() {
        orders = null;
        apiInterface = RetrofitClientInstance.getRetrofitInstance().create(Webservice.class);
    }

    public LiveData<ArrayList<HashMap<String, Object>>> getUserOrder() {
        if (orders == null) {
            orders = new MutableLiveData<ArrayList<HashMap<String, Object>>>();
        }
        return orders;
    }

    public OrderModel loadOrders(int userId) {
        Call<ArrayList<OrderResponse>> call = apiInterface.getOrders(Integer.toString(userId));
        call.enqueue(new Callback<ArrayList<OrderResponse>>() {

            @Override
            public void onResponse(Call<ArrayList<OrderResponse>> call, Response<ArrayList<OrderResponse>> response) {
                ArrayList<HashMap<String, Object>> tempArrayList = new ArrayList<HashMap<String, Object>>();

                for (OrderResponse order : response.body()) {
                    HashMap<String, Object> tempMap = new HashMap<String, Object>();
                    tempMap.put("id_pesanan", order.getId_pesanan());
                    tempMap.put("id_pengguna", order.getId_pengguna());
                    tempMap.put("id_salon", order.getId_salon());
                    tempMap.put("nama_salon", order.getNama_salon());
                    tempMap.put("id_stylist", order.getId_stylist());
                    tempMap.put("nama_stylist", order.getNama_stylist());
                    tempMap.put("id_produk", order.getId_produk());
                    tempMap.put("nama_produk", order.getNama_produk());
                    tempMap.put("waktu", order.getWaktu());
                    tempMap.put("metode_pembayaran", order.getMetode_pembayaran());
                    tempMap.put("kuantitas_produk", order.getKuantitas_produk());
                    tempMap.put("harga_produk", order.getHarga_produk());
                    tempMap.put("keterangan", order.getKeterangan());
                    tempArrayList.add(tempMap);
                }
                orders.setValue(tempArrayList);
            }

            @Override
            public void onFailure(Call<ArrayList<OrderResponse>> call, Throwable t) {
                Log.d("OrderModel", t.getMessage());
                call.cancel();
            }
        });
        return null;
    }

    public void createSalonOrder(int id_pengguna,
                                 int id_salon,
                                 HashMap<Integer, Integer> produk,
                                 String waktu,
                                 String metode_pembayaran,
                                 String keterangan) {
        Call<String> call = apiInterface.createOrder(new OrderBody("salon",
                id_pengguna,
                id_salon,
                -1,
                produk,
                waktu,
                metode_pembayaran,
                keterangan
        ));
        call.enqueue(new Callback<String>() {

            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d("OrderModel", response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("OrderModel", t.getMessage());
                call.cancel();
            }
        });
    }
}
