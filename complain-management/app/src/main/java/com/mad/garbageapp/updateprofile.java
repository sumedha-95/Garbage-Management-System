package com.mad.garbageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mad.garbageapp.Database.DBHandler;

import java.util.List;

public class updateprofile extends AppCompatActivity {

    EditText username,phone,Address,Location,complain;
    Button Edit,search,DELETE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateprofile);


        username =findViewById(R.id.editTextText91);
        phone =findViewById(R.id.editTextTextPersonName8);
        Address=findViewById(R.id.editTextTextPersonName9);
        Location=findViewById(R.id.editTextTextPersonName10);
        complain=findViewById(R.id.editTextTextPersonName11);
        search=findViewById(R.id.button3);
        Edit=findViewById(R.id.btn5);
        DELETE=findViewById(R.id.button5);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DBHandler dbHandler = new DBHandler(getApplicationContext());
                List user=dbHandler.readAllInfo(username.getText().toString());

                if (user.isEmpty()){
                    Toast.makeText(updateprofile.this, "No User", Toast.LENGTH_SHORT).show();
                    username.setText(null);
                }
                else {
                    Toast.makeText(updateprofile.this, "User Found! Use:"+user.get(0).toString(), Toast.LENGTH_SHORT).show();
                    username.setText(user.get(0).toString());
                    phone.setText(user.get(1).toString());
                    Address.setText(user.get(2).toString());
                    Location.setText(user.get(3).toString());
                    complain.setText(user.get(4).toString());

                }

            }
        });


        Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DBHandler dbHandler = new DBHandler(getApplicationContext());
                Boolean status =dbHandler.updateInfo(username.getText().toString(),phone.getText().toString(),Address.getText().toString(),Location.getText().toString(),complain.getText().toString());
                if(status){
                    Toast.makeText(updateprofile.this, "User Update", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(updateprofile.this, "Update Failed", Toast.LENGTH_SHORT).show();
                }

            }
        });

        DELETE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DBHandler dbHandler=new DBHandler(getApplicationContext());
                dbHandler.deleteInfo(username.getText().toString());

                Toast.makeText(updateprofile.this, "User Deleted", Toast.LENGTH_SHORT).show();

                username.setText(null);
                phone.setText(null);
                Address.setText(null);
                Location.setText(null);
                complain.setText(null);
            }
        });

    }
}