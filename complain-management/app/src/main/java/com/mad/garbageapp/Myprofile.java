package com.mad.garbageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mad.garbageapp.Database.DBHandler;


public class Myprofile extends AppCompatActivity {

    EditText username,phone,Address,Location,complain;
    Button Add,UPDATE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myprofile);

        username =findViewById(R.id.editText20);
        phone =findViewById(R.id.editTextPhone2);
        Address=findViewById(R.id.editText30);
        Location=findViewById(R.id.editText40);
        complain=findViewById(R.id.editText25);
        Add=findViewById(R.id.btn99);
        UPDATE=findViewById(R.id.btn6);

        UPDATE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(getApplicationContext(),updateprofile.class);
                startActivity(i);
            }
        });

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                DBHandler dbHandler = new DBHandler(getApplicationContext());
                long newID =dbHandler.addInfo(username.getText().toString(),phone.getText().toString(),Address.getText().toString(),Location.getText().toString(),complain.getText().toString());
                Toast.makeText(Myprofile.this, "User Added.User ID:"+newID, Toast.LENGTH_SHORT).show();

                Intent i=new Intent(getApplicationContext(),updateprofile.class);
                startActivity(i);
                username.setText(null);
                phone.setText(null);
                Address.setText(null);
                Location.setText(null);
                complain.setText(null);
            }
        });



    }
}