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

//Class MainActivity yang merupakan turunan dari Class AppCompatActivity dan
// mengimplementasikan Interface View.OnClickListener untuk meng-handle event onClick().
public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private BarangAdapter adapter;
    private ArrayList<Barang> barangArrayList;
    DBController controller = new DBController(this);
    String nm, harga, jml;
    private FloatingActionButton fab;

    //meng-inisialisasikan pada method onCreate(). Method ini akan dieksekusi setiap Activity dicitpakan.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //membuat objek dari komponen yang ada di activity_main.xml ke java dengan bantuan fungsi findViewById().
        recyclerView = findViewById(R.id.recyclerView);
        fab = findViewById(R.id.floatingBtn);
        BacaData();
        adapter = new BarangAdapter(barangArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        //mententukan Class yang akan meng-handle komponen tersebut apabila diklik dengan method setOnClickListener().
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BarangActivity.class);
                startActivity(intent);
            }
        });
    }

    //membaca data barang kemudian menambahkan data item ke array
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

