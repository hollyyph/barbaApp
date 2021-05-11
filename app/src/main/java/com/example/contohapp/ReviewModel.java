package com.example.contohapp;

import android.util.Log;

import com.example.contohapp.data.RetrofitClientInstance;
import com.example.contohapp.data.pojo.ReviewBody;
import com.example.contohapp.data.pojo.ReviewResponse;
import com.example.contohapp.data.Webservice;

import java.util.ArrayList;
import java.util.HashMap;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReviewModel extends ViewModel {
    private MutableLiveData<ArrayList<HashMap<String, Object>>> reviews;
    Webservice apiInterface;

    public ReviewModel() {
        reviews = null;
        apiInterface = RetrofitClientInstance.getRetrofitInstance().create(Webservice.class);
    }

    public LiveData<ArrayList<HashMap<String, Object>>> getSalonReviews() {
        if (reviews == null) {
            reviews = new MutableLiveData<ArrayList<HashMap<String, Object>>>();
        }
        return reviews;
    }

    public void loadSalonReviews(int salonId) {
        Call<ArrayList<ReviewResponse>> call = apiInterface.getReviews(Integer.toString(salonId), "salon");
        call.enqueue(new Callback<ArrayList<ReviewResponse>>() {

            @Override
            public void onResponse(Call<ArrayList<ReviewResponse>> call, Response<ArrayList<ReviewResponse>> response) {
                ArrayList<HashMap<String, Object>> tempArrayList = new ArrayList<HashMap<String, Object>>();

                for (ReviewResponse review : response.body()) {
                    HashMap<String, Object> tempMap = new HashMap<String, Object>();
                    tempMap.put("id_review", review.getId_review());
                    tempMap.put("id_salon", review.getId_salon());
                    tempMap.put("id_pengguna", review.getId_pengguna());
                    tempMap.put("tanggal", review.getTanggal());
                    tempMap.put("konten", review.getKonten());
                    tempMap.put("nama_pengguna", review.getNama_pengguna());
                    tempMap.put("rating", review.getRating());
                    tempArrayList.add(tempMap);
                }
                reviews.setValue(tempArrayList);
            }

            @Override
            public void onFailure(Call<ArrayList<ReviewResponse>> call, Throwable t) {
                Log.d("ReviewModel", t.getMessage());
                call.cancel();
            }
        });
    }

    public void createSalonReview(int id_salon, int id_pengguna, String konten, int rating) {
        Call<String> call = apiInterface.createReview(new ReviewBody("salon",
                id_salon,
                -1,
                id_pengguna,
                konten,
                rating
        ));
        call.enqueue(new Callback<String>() {

            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d("ReviewModel", response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("ReviewModel", t.getMessage());
                call.cancel();
            }
        });
    }
}
