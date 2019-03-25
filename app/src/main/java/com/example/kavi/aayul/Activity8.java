package com.example.kavi.aayul;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Activity8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_8);


        TextView displaytxt = (TextView) findViewById(R.id.displaytxt);
        TextView displaytxt3 = (TextView) findViewById(R.id.displaytxt3);
        TextView displaytxt2 = (TextView) findViewById(R.id.displaytxt2);
        TextView displaytxt4 = (TextView) findViewById(R.id.displaytxt4);
        TextView displaytxt5 = (TextView) findViewById(R.id.displaytxt5);
        TextView displaytxt6 = (TextView) findViewById(R.id.displaytxt6);



        Intent launch = getIntent();
        String list = launch.getStringExtra("selectedItem");
        displaytxt.setText(list);
        Float xv = launch.getFloatExtra("sbcvalue", 0);
        displaytxt2.setText(String.valueOf(xv));

        if (list.equals("Rock")) {
            displaytxt3.setText(String.valueOf("3240.0"));
        } else if (list.equals("Soft Rock")) {
            displaytxt3.setText(String.valueOf("440.0"));
        } else if (list.equals("Coarse Sand")) {
            displaytxt3.setText(String.valueOf("440.0"));
        } else if (list.equals("Medium Sand")) {
            displaytxt3.setText(String.valueOf("245.0"));
        } else if (list.equals("Fine Sand")) {
            displaytxt3.setText(String.valueOf("440.0"));
        } else if (list.equals("Soft Shell")) {
            displaytxt3.setText(String.valueOf("100.0"));
        } else if (list.equals("Soft Clay")) {
            displaytxt3.setText(String.valueOf("100.0"));
        } else if (list.equals("Very Soft Clay")) {
            displaytxt3.setText(String.valueOf("100.0"));
        }

        if ((list.equals("Rock") && xv <= 3240.0) || (list.equals("Soft Rock") && xv <= 440.0) || (list.equals("Coarse Sand") && xv <= 440.0) || (list.equals("Medium Sand") && xv <= 245.0) || (list.equals("Fine Sand") && xv <= 440.0) || (list.equals("Soft Shell") && xv <= 100.0) || (list.equals("Soft Clay") && xv <= 100.0) || (list.equals("Very Soft Clay") && xv <= 50.0)){
            // Toast.makeText(getApplicationContext(),"Bearable",Toast.LENGTH_SHORT).show();
            displaytxt4.setText("Bearable");
            displaytxt4.setTextColor(Color.DKGRAY);
            displaytxt6.setText("Can WithStand Normal building Lifespan (25 years)");


            if ((list.equals("Rock") && xv <= 3240.0)){
                displaytxt5.setText("This Soil is capable of bearing atmost 67668 Square Foot and 330 tons of weight");

            } else if ((list.equals("Soft Rock") && xv <= 440.0)){
                displaytxt5.setText("This soil is capable of bearing atmost 9189 Square Foot and 44 tons of weight ");
            } else if ((list.equals("Coarse Sand") && xv <= 440.0) ){
                displaytxt5.setText("This soil is capable of bearing atmost 9189 Square Foot and 44 tons of weight ");

            } else if ((list.equals("Medium Sand") && xv <= 245.0) ){
                displaytxt5.setText("This soil is capable of bearing atmost 5116 Square Foot and 24 tons of weight ");
            } else if ((list.equals("Fine Sand") && xv <= 440.0) ) {
                displaytxt5.setText("This soil is capable of bearing atmost 9189 Square Foot and 44 tons of weight ");

            } else if ((list.equals("Soft Shell") && xv <= 100.0)) {
                displaytxt5.setText("This soil is capable of bearing atmost 2088 Square Foot and 10 tons of weight ");
            } else if ((list.equals("Soft Clay") && xv <= 100.0)) {
                displaytxt5.setText("This soil is capable of bearing atmost 2088 Square Foot and 10 tons of weight ");

            } else if ((list.equals("Very Soft Clay") && xv <= 50.0)) {
                displaytxt5.setText("This soil is capable of bearing atmost 1044 Square Foot and 5 tons of weight ");
            }


        } else {
            // Toast.makeText(getApplicationContext(),"Not Bearable",Toast.LENGTH_SHORT).show();
            displaytxt4.setText("Not Bearable");
            displaytxt4.setTextColor(Color.RED);
            displaytxt5.setText("Not Bearable. Change the Pile Construction.");
            displaytxt6.setText("Cannot withstand Normal Building Lifespan ");

        }
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
