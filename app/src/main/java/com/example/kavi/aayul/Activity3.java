package com.example.kavi.aayul;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {

    String selectedItem="";
    EditText sbcvalue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        final Spinner spinner = (Spinner) findViewById(R.id.spinnersoil);
        Button rstbtn = (Button) findViewById(R.id.rstbtn);
        sbcvalue = (EditText) findViewById(R.id.sbcvalue);

        spinner.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, Spinnersoil.soilname));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                selectedItem = spinner.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });






        rstbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Activity4.class);
                intent.putExtra("selectedItem",selectedItem);
                try {
                    String value = sbcvalue.getText().toString();
                    final Float xv = Float.valueOf(value);
                    intent.putExtra("sbcvalue",xv);

                }
                catch (RuntimeException e){
                    e.printStackTrace();
                }
                startActivity(intent);
            }
        });

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
