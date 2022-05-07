package com.mad.garbageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button Registercomplain,Mycomplaint,Myprofile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Registercomplain=findViewById(R.id.btn1);
        Mycomplaint=findViewById(R.id.button2);
        Myprofile=findViewById(R.id.btn4);



        Registercomplain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(getApplicationContext(),Registration.class);
                startActivity(i);
            }
        });

        Mycomplaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(getApplicationContext(),Mycomplain.class);
                startActivity(i);
            }
        });

        Myprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(getApplicationContext(), com.mad.garbageapp.Myprofile.class);
                startActivity(i);
            }
        });
    }
}