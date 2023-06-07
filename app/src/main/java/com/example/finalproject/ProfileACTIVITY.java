package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ProfileACTIVITY extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Bundle b = getIntent().getExtras();
        String number = b.getString("number");
        TextView field = (TextView) findViewById(R.id.txtVName);
        field.setText(number);
    }

//    public void wyswietl() {
//        Bundle b = getIntent().getExtras();
//        String parametr = b.getString("data");
//        TextView pole = (TextView) findViewById(R.id.txtView);
//        pole.setText(parametr);
//    }
}