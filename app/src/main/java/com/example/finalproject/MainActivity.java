package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.Manifest;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
        database();
    }

    public void database(){
        SQLiteDatabase myDB = openOrCreateDatabase("my.db", MODE_PRIVATE, null);
        myDB.execSQL(
                "CREATE TABLE IF NOT EXISTS userBase (phoneNumber VARCHAR(200), sport VARCHAR(200), city VARCHAR(200))"
);
        ContentValues row1 = new ContentValues();
        row1.put("phoneNumber", "0987654321");
        row1.put("sport", "Tennis");
        row1.put("city", "Katowice");
        ContentValues row2 = new ContentValues();
        row2.put("phoneNumber", "0987653421");
        row2.put("sport", "Baseball");
        row1.put("city", "Warszawa");
        ContentValues row3 = new ContentValues();
        row3.put("phoneNumber", "0978654321");
        row3.put("sport", "Tennis");
        row3.put("city", "Warszawa");
        myDB.insert("userBase", null, row1);
        myDB.insert("userBase", null, row2);
        myDB.insert("userBase", null, row3);

        myDB.close();
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