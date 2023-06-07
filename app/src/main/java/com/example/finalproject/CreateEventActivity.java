package com.example.finalproject;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.telephony.SmsManager;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CreateEventActivity extends AppCompatActivity{
    EditText location;
    EditText date;
    EditText hour;
    EditText sport;
    SmsManager smsManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);
        smsManager = SmsManager.getDefault();
    }

    public void btnSend_click(View v) {
        location = (EditText) findViewById(R.id.etLocation);
        date = (EditText) findViewById(R.id.etDate);
        hour = (EditText) findViewById(R.id.etTime);
        sport = (EditText) findViewById(R.id.etSportName);

        String sportSt = sport.getText().toString();
        String dateSt = date.getText().toString();
        String hourSt = hour.getText().toString();
        String locationSt = location.getText().toString();

        String number = "9876543210";
        String message = "Hi, I want to invite you to play " + sportSt + " with me, on " + dateSt + " at " + hourSt + ". Meet me at: " + locationSt;
        ArrayList<String> parts = smsManager.divideMessage(message);

        smsManager.sendMultipartTextMessage(number, null, parts, null, null);
        Toast.makeText(this, "SMS sent", Toast.LENGTH_SHORT).show();
    }

    public void btnLocation_click(View view) {
        Intent mapIntent = new Intent(Intent.ACTION_VIEW);
        mapIntent.setData(Uri.parse("geo:0,0?q="));

        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        } else {
            Toast.makeText(this, "Unable to find maps app", Toast.LENGTH_SHORT).show();
        }
    }



}