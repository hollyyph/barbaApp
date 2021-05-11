package com.example.contohapp.data.pojo;

import com.google.gson.annotations.SerializedName;

public class ReviewResponse {
    @SerializedName("id_review")
    private int id_review;

    @SerializedName("id_salon")
    private int id_salon;

    @SerializedName("id_stylist")
    private int id_stylist;

    @SerializedName("id_pengguna")
    private int id_pengguna;

    @SerializedName("tanggal")
    private String tanggal;

    @SerializedName("konten")
    private String konten;

    @SerializedName("nama_pengguna")
    private String nama_pengguna;

    @SerializedName("rating")
    private int rating;

    public int getId_review() {
        return id_review;
    }

    public void setId_review(int id_review) {
        this.id_review = id_review;
    }

    public int getId_salon() {
        return id_salon;
    }

    public void setId_salon(int id_salon) {
        this.id_salon = id_salon;
    }

    public int getId_stylist() {
        return id_stylist;
    }

    public void setId_stylist(int id_stylist) {
        this.id_stylist = id_stylist;
    }

    public int getId_pengguna() {
        return id_pengguna;
    }

    public void setId_pengguna(int id_pengguna) {
        this.id_pengguna = id_pengguna;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getKonten() {
        return konten;
    }

    public void setKonten(String konten) {
        this.konten = konten;
    }

    public String getNama_pengguna() {
        return nama_pengguna;
    }

    public void setNama_pengguna(String nama_pengguna) {
        this.nama_pengguna = nama_pengguna;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public ReviewResponse(int id_review, int id_salon, int id_stylist, int id_pengguna, String tanggal, String konten, String nama_pengguna, int rating) {
        this.id_review = id_review;
        this.id_salon = id_salon;
        this.id_stylist = id_stylist;
        this.id_pengguna = id_pengguna;
        this.tanggal = tanggal;
        this.konten = konten;
        this.nama_pengguna = nama_pengguna;
        this.rating = rating;
    }
}
