package com.example.kavi.aayul;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Do You Know the SBC Value?");
        //builder.setMessage("You are about to delete all records of database. Do you really want to proceed ?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Proceed....!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),Activity3.class);
                startActivity(intent);
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Toast.makeText(getApplicationContext(), "You've changed your mind to delete all records", Toast.LENGTH_SHORT).show();
                Intent intent = new  Intent(getApplicationContext(),Activity5.class);
                startActivity(intent);
            }
        });

        builder.show();
    }

    private Boolean exit = false;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBackPressed() {
        if (exit) {
            super.onBackPressed();
            finishAffinity();
            //finish(); // finish activity
        } else {
            Toast.makeText(this, "Press Back again to Exit.",
                    Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 3 * 1000);

        }

    }
}
