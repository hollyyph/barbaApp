package com.example.contohapp.data.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

public class OrderBody {
    @SerializedName("type")
    private String type;

    @SerializedName("id_pengguna")
    private int id_pengguna;

    @SerializedName("id_salon")
    private int id_salon;

    @SerializedName("id_stylist")
    private int id_stylist;

    @SerializedName("produk")
    private HashMap<Integer, Integer> produk;

    @SerializedName("waktu")
    private String waktu;

    @SerializedName("metode_pembayaran")
    private String metode_pembayaran;

    @SerializedName("keterangan")
    private String keterangan;

    public OrderBody(String type,
                     int id_pengguna,
                     int id_salon,
                     int id_stylist,
                     HashMap<Integer, Integer> produk,
                     String waktu,
                     String metode_pembayaran,
                     String keterangan
    ) {
        this.type = type;
        this.id_pengguna = id_pengguna;
        this.id_salon = id_salon;
        this.id_stylist = id_stylist;
        this.produk = produk;
        this.waktu = waktu;
        this.metode_pembayaran = metode_pembayaran;
        this.keterangan = keterangan;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId_pengguna() {
        return id_pengguna;
    }

    public void setId_pengguna(int id_pengguna) {
        this.id_pengguna = id_pengguna;
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

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getMetode_pembayaran() {
        return metode_pembayaran;
    }

    public void setMetode_pembayaran(String metode_pembayaran) {
        this.metode_pembayaran = metode_pembayaran;
    }

    public void setProduk(HashMap<Integer, Integer> produk) {
        this.produk = produk;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}
