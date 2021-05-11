package com.example.contohapp.data.pojo;

import com.google.gson.annotations.SerializedName;

public class ReviewBody {
    @SerializedName("type")
    private String type;

    @SerializedName("id_salon")
    private int id_salon;

    @SerializedName("id_stylist")
    private int id_stylist;

    @SerializedName("id_pengguna")
    private int id_pengguna;

    @SerializedName("konten")
    private String konten;

    @SerializedName("rating")
    private int rating;

    public ReviewBody(String type,
                      int id_salon,
                      int id_stylist,
                      int id_pengguna,
                      String konten,
                      int rating) {
        this.type = type;
        this.id_salon = id_salon;
        this.id_stylist = id_stylist;
        this.id_pengguna = id_pengguna;
        this.konten = konten;
        this.rating = rating;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getKonten() {
        return konten;
    }

    public void setKonten(String konten) {
        this.konten = konten;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
