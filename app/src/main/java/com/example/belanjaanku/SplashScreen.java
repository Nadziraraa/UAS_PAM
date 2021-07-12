package com.example.belanjaanku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    //membuat splashscreen untuk tampilan awal ketika aplikasi dibuka
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //menentukan waktu berapa lama splashscreen dibuka dan halaman apa yang akan ditampilkan setelah splashscreen selesai
        Thread thread = new Thread(){
            public void run(){
                try {
                    sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    startActivity(new Intent(SplashScreen.this, MainActivity.class));
                    finish();
                }
            }
        };
        thread.start();
    }
}