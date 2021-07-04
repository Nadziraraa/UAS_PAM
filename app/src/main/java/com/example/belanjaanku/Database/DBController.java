package com.example.belanjaanku.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.belanjaanku.BarangActivity;
import com.example.belanjaanku.MainActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class DBController extends SQLiteOpenHelper {
    public DBController(Context context) { super(context, "BelanjaanKu", null, 1); }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Barang (id integer primary key, nama_barang text, Jumlah_barang integer, harga_barang integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Barang");
        onCreate(db);
    }

    public void insertData(HashMap<String,String> queryValues) {
        SQLiteDatabase dbasisdata = this.getWritableDatabase();
        ContentValues nilai = new ContentValues();
        nilai.put("nama barang",queryValues.get("nama barang"));
        nilai.put("jumlah barang",queryValues.get("jumlah barang"));
        nilai.put("harga barang",queryValues.get("harga barang"));
        dbasisdata.insert("Barang",null,nilai);
        dbasisdata.close();
    }

    public void editData(HashMap<String, String> queryValues, String  position) {
        SQLiteDatabase dbasisdata = this.getWritableDatabase();
        ContentValues kontak = new ContentValues();
        kontak.put("nama barang", queryValues.get("nama barang"));
        kontak.put("jumlah barang", queryValues.get("jumlah barang"));
        kontak.put("harga barang", queryValues.get("harga barang"));
        dbasisdata.update("Barang", kontak, position, null);
        dbasisdata.close();
    }

    public ArrayList<HashMap<String, String>> getAllBarang(){
        ArrayList<HashMap<String,String>> daftarBarang;
        daftarBarang = new ArrayList<HashMap<String, String>>();
        String selectQuery = "Select * from Barang";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            do {
                HashMap<String,String> map = new HashMap<>();
                map.put("id",cursor.getString(0));
                map.put("nama barang",cursor.getString(1));
                map.put("jumlah barang",cursor.getString(2));
                map.put("harga barang",cursor.getString(3));
                daftarBarang.add(map);
            } while (cursor.moveToNext());
        }
        db.close();
        return daftarBarang;
    }
}
