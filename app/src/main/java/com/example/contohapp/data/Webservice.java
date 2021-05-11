package com.example.contohapp.data;

import com.example.contohapp.data.pojo.OrderBody;
import com.example.contohapp.data.pojo.OrderResponse;
import com.example.contohapp.data.pojo.ReviewResponse;
import com.example.contohapp.data.pojo.ReviewBody;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Webservice {
    @GET("/reviews")
    Call<ArrayList<ReviewResponse>> getReviews(
            @Query("id") String id,
            @Query("type") String type
    );

    @POST("/reviews")
    Call<String> createReview(@Body ReviewBody body);

    @GET("/orders")
    Call<ArrayList<OrderResponse>> getOrders(
            @Query("userid") String userid
    );

    @POST("/orders")
    Call<String> createOrder(@Body OrderBody body);
}
