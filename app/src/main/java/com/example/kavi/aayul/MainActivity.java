package com.example.kavi.aayul;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread mySplash = new Thread(){
            @Override
            public void run(){
                try{
                    sleep(700);
                    Intent i = new Intent(getApplicationContext(),Activity1.class);
                    startActivity(i);
                    finish();
                } catch(InterruptedException e) {
                    e.printStackTrace();

                }
            }
        };

        mySplash.start();

    }
}
