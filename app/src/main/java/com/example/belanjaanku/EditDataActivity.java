package com.example.belanjaanku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.belanjaanku.Database.DBController;

import java.util.HashMap;

public class EditDataActivity extends AppCompatActivity {

    EditText edNama, edJumlah;
    Button btnSimpan;

    DBController controller = new DBController(this );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data);

        edNama = findViewById(R.id.ednama);
        edJumlah = findViewById(R.id.edjumlah);
        btnSimpan = findViewById(R.id.buttonsave);

        String nama = getIntent().getStringExtra("nama");
        String jumlah = getIntent().getStringExtra("jumlah");
        String position = getIntent().getStringExtra("position");

        edNama.setText(nama);
        edJumlah.setText(jumlah);

        btnSimpan.setOnClickListener(v -> {
            setContentView(R.layout.activity_main);

            if(edNama.getText().toString().equals("")||edJumlah.getText().toString().equals("")){
                Toast.makeText(getApplicationContext(),"Data belum komplit !",Toast.LENGTH_SHORT).show();
            }else {
                String nm = edNama.getText().toString();
                String jml = edJumlah.getText().toString();

                HashMap<String,String> qvalues = new HashMap<>();
                qvalues.put("nama",nm);
                qvalues.put("jumlah",jml);

                controller.editData(qvalues, position);
                Toast.makeText(getApplicationContext(),"Berhasil di perbarui !",Toast.LENGTH_SHORT).show();

                finish();
            }


        });
    }

}