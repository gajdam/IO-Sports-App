package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.Manifest;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;



public class MainActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.SEND_SMS}, 100);
        username=findViewById(R.id.txtNumber);
        password=findViewById(R.id.txtPass);
    }


    public void onClick(View view) {
        String number = username.getText().toString();
        if(username.getText().toString().equals("100100")&&password.getText().toString().equals("user")){
            Toast.makeText(MainActivity.this,"Login Successful", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, SecondActivity.class);
            i.putExtra("number", number);
            startActivity(i);
        }else{
            Toast.makeText(MainActivity.this,"Login Unsuccessful", Toast.LENGTH_SHORT).show();
        }
    }
}