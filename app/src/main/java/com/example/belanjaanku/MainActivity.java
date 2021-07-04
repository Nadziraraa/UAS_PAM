package com.example.belanjaanku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.belanjaanku.Adapter.BarangAdapter;
import com.example.belanjaanku.Database.Barang;
import com.example.belanjaanku.Database.DBController;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private BarangAdapter adapter;
    private ArrayList<Barang> barangArrayList;
    DBController controller = new DBController(this);
    String nm, harga, jml;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerView);
        fab = findViewById(R.id.floatingBtn);
        BacaData();
        adapter = new BarangAdapter(barangArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BarangActivity.class);
                startActivity(intent);
            }
        });
    }

    public void BacaData() {
        ArrayList<HashMap<String, String>> daftarBarang = controller.getAllBarang();
        barangArrayList = new ArrayList<>();
        for (int i = 0; i < daftarBarang.size(); i++) {
            Barang barang = new Barang();

            barang.setHarga(daftarBarang.get(i).get("harga").toString());
            barang.setNama(daftarBarang.get(i).get("nama barang").toString());
            barang.setJumlah(daftarBarang.get(i).get("jumlah Barang").toString());

            barangArrayList.add(barang);
        }
    }
    @Override
    protected void onResume() {
        super.onResume();

        adapter.notifyDataSetChanged();

    }

}

