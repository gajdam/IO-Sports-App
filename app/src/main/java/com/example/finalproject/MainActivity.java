package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

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

public class MainActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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