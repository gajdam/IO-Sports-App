package com.example.finalproject;


import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.PendingIntent;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.telephony.SmsManager;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CreateEventActivity extends AppCompatActivity{

    private DatabaseHelper databaseHelper;
    EditText location;
    EditText date;
    EditText hour;
    EditText sport;
    SmsManager smsManager = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);
        databaseHelper = new DatabaseHelper(this);
        smsManager = SmsManager.getDefault();
    }

    private void sendSMS(String phoneNumber, String sport, String city, String date, String hour, String location) {
        String message = "Hi, I want to invite you to play " + sport + " with me in " + city + " on that day: " + date + " at: " + hour + ". Let's meet up! " + location;

        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber, null, message, null, null);
            Toast.makeText(this, "SMS sent to " + phoneNumber, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "Failed to send SMS to " + phoneNumber, Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
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


    public void sendInvitations(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("UserPreferences", MODE_PRIVATE);
        String userCity = sharedPreferences.getString("PreferredCity", "");
        Log.d("PreferredCity", userCity);

        location = (EditText) findViewById(R.id.etLocation);
        date = (EditText) findViewById(R.id.etDate);
        hour = (EditText) findViewById(R.id.etTime);
        sport = (EditText) findViewById(R.id.etSportName);

        String sportSt = sport.getText().toString();
        String dateSt = date.getText().toString();
        String hourSt = hour.getText().toString();
        String locationSt = location.getText().toString();

        Cursor cursor = databaseHelper.getUsersBySportAndCity(sportSt, userCity);
        int phoneNumberIndex = cursor.getColumnIndex("phoneNumber");
        while (cursor.moveToNext()) {
            String phoneNumber = cursor.getString(phoneNumberIndex);
            sendSMS(phoneNumber, sportSt, userCity, dateSt, hourSt, locationSt);
        }
        cursor.close();
    }
}