package com.example.belanjaanku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.belanjaanku.Database.DBController;

import java.util.HashMap;

//Class BarangActivity yang merupakan turunan dari Class AppCompatActivity dan
public class BarangActivity extends AppCompatActivity {
    private EditText edtnmbar, edtjumlahbrg, edtharga, edtuangbyr;
    private Button btnsimpan;
    private Button btneditdata;
    private Button btnkeluar;
    private TextView txtnamabar;
    private TextView txtjumlahbel;
    private TextView txtharga;
    private TextView txtuangbyr;
    private TextView txttotalbelanja;

    DBController controller = new DBController(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barang);

        getSupportActionBar().setTitle("BelanjaanKu");

        edtnmbar = (EditText) findViewById(R.id.namabarang);
        edtjumlahbrg = (EditText) findViewById(R.id.jumlahbarang);
        edtharga = (EditText) findViewById(R.id.harga);
        edtuangbyr = (EditText) findViewById(R.id.uangbayar);
        btnsimpan = (Button) findViewById(R.id.tombol1);
        btneditdata = (Button) findViewById(R.id.tombol2);
        btnkeluar = (Button) findViewById(R.id.tombol3);
        txtnamabar = (TextView) findViewById(R.id.namabarang);
        txtjumlahbel = (TextView) findViewById(R.id.jumlahbarang);
        txtharga = (TextView) findViewById(R.id.harga);
        txtuangbyr = (TextView) findViewById(R.id.uangbayar);
        txttotalbelanja = (TextView) findViewById(R.id.totalbelanja);


        //membuat action pada button simpan
        btnsimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namabarang = edtnmbar.getText().toString().trim();
                String jumlahbeli = edtjumlahbrg.getText().toString().trim();
                String harga = edtharga.getText().toString().trim();
                String uangbayar = edtuangbyr.getText().toString().trim();

                //membuat perhitungan pada total jumlah barang yg akan dibeli
                double jb = Double.parseDouble(jumlahbeli);
                double h = Double.parseDouble(harga);
                double ub = Double.parseDouble(uangbayar);
                double total = (jb * h);
                txttotalbelanja.setText("Total Belanja : " + total);

                HashMap<String,String> qvalues = new HashMap<>();
                qvalues.put("nama barang", namabarang);
                qvalues.put("jumlah barang",jumlahbeli);
                qvalues.put("harga barang",harga);
                qvalues.put("uangbayar",uangbayar);

                controller.insertData(qvalues);
                callHome();
            }

            private void callHome() {
                Intent intent = new Intent(BarangActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //MEMBERIKAN ACTION PADA TOMBOL EDIT DATA
        btneditdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_edit_data);
                txtnamabar.setText(" ");
                txttotalbelanja.setText(" Total Belanja : Rp 0");
                txtharga.setText(" ");
                txtuangbyr.setText(" ");
                txtjumlahbel.setText(" ");

                Toast.makeText(getApplicationContext(), "Data sudah diedit", Toast.LENGTH_LONG).show();
            }
        });

        //Memberikan action pada tombol keluar yang nantinya akan masuk ke halaman activitymain
        btnkeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            setContentView(R.layout.activity_main);
            }
        });
    }
}



