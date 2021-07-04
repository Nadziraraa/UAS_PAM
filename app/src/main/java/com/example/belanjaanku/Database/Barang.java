package com.example.belanjaanku.Database;

public class Barang {
    String nm;
    String jml;
    String harga;

    public Barang() {
    }

    public Barang(String nm, String jml, String harga) {
        this.nm = nm;
        this.jml = jml;
        this.harga = harga;
    }

    public String getNama() {
        return nm;
    }

    public void setNama(String nama) {
        this.nm = nama;
    }

    public String getJumlah() {
        return jml;
    }

    public void setJumlah(String jumlah) {

        this.jml = jumlah;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {

        this.harga = harga;
    }
}

