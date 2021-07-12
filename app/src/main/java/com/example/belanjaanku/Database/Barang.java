package com.example.belanjaanku.Database;

//membuat class barang dan menentukkan variabelnya
public class Barang {
    String nm;
    String jml;
    String harga;

    public Barang (){

    }

    //method Barang
    public Barang(String nm, String jml, String harga) {
        this.nm = nm;
        this.jml = jml;
        this.harga = harga;
    }

    //getNama berfungsi untuk mengambil satu data nama berdasarkan nama barangnya
    public String getNama() {
        return nm;
    } //metode untuk mengembalikkan nilai nama

    public void setNama(String nama) {
        this.nm = nama;
    }

    public String getJumlah() {
        return jml;
    } //untuk mengembalikkan nilai jumlah

    public void setJumlah(String jumlah) {

        this.jml = jumlah;
    }

    //berfungsi untuk mengambil data dari harga yang berfungsi untuk mengolah datanya
    public String getHarga() {
        return harga;
    } //untuk mengembalikkan nilai harga

    public void setHarga(String harga) { //menyimpan barisan harga ketika data sudah dimasukkan

        this.harga = harga;
    }
}

