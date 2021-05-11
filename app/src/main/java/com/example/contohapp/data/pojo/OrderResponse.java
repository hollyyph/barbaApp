package com.example.contohapp.data.pojo;

import com.google.gson.annotations.SerializedName;

public class OrderResponse {
    @SerializedName("id_pesanan")
    private int id_pesanan;

    @SerializedName("id_pengguna")
    private int id_pengguna;

    @SerializedName("id_salon")
    private int id_salon;

    @SerializedName("nama_salon")
    private String nama_salon;

    @SerializedName("id_stylist")
    private int id_stylist;

    @SerializedName("nama_stylist")
    private String nama_stylist;

    @SerializedName("id_produk")
    private int id_produk;

    @SerializedName("nama_produk")
    private String nama_produk;

    @SerializedName("waktu")
    private String waktu;

    @SerializedName("metode_pembayaran")
    private String metode_pembayaran;

    @SerializedName("kuantitas_produk")
    private int kuantitas_produk;

    @SerializedName("harga_produk")
    private int harga_produk;

    @SerializedName("keterangan")
    private String keterangan;

    public OrderResponse(int id_pesanan,
                         int id_pengguna,
                         int id_salon,
                         String nama_salon,
                         int id_stylist,
                         String nama_stylist,
                         int id_produk,
                         String nama_produk,
                         String waktu,
                         String metode_pembayaran,
                         int kuantitas_produk,
                         int harga_produk,
                         String keterangan) {
        this.id_pesanan = id_pesanan;
        this.id_pengguna = id_pengguna;
        this.id_salon = id_salon;
        this.nama_salon = nama_salon;
        this.id_stylist = id_stylist;
        this.nama_stylist = nama_stylist;
        this.id_produk = id_produk;
        this.nama_produk = nama_produk;
        this.waktu = waktu;
        this.metode_pembayaran = metode_pembayaran;
        this.kuantitas_produk = kuantitas_produk;
        this.harga_produk = harga_produk;
        this.keterangan = keterangan;
    }

    public int getId_pesanan() {
        return id_pesanan;
    }

    public void setId_pesanan(int id_pesanan) {
        this.id_pesanan = id_pesanan;
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

    public String getNama_salon() {
        return nama_salon;
    }

    public void setNama_salon(String nama_salon) {
        this.nama_salon = nama_salon;
    }

    public int getId_stylist() {
        return id_stylist;
    }

    public void setId_stylist(int id_stylist) {
        this.id_stylist = id_stylist;
    }

    public String getNama_stylist() {
        return nama_stylist;
    }

    public void setNama_stylist(String nama_stylist) {
        this.nama_stylist = nama_stylist;
    }

    public int getId_produk() {
        return id_produk;
    }

    public void setId_produk(int id_produk) {
        this.id_produk = id_produk;
    }

    public String getNama_produk() {
        return nama_produk;
    }

    public void setNama_produk(String nama_produk) {
        this.nama_produk = nama_produk;
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

    public int getKuantitas_produk() {
        return kuantitas_produk;
    }

    public void setKuantitas_produk(int kuantitas_produk) {
        this.kuantitas_produk = kuantitas_produk;
    }

    public int getHarga_produk() {
        return harga_produk;
    }

    public void setHarga_produk(int harga_produk) {
        this.harga_produk = harga_produk;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}
