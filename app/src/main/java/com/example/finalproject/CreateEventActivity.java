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
        String phoneNumbers = "";

        SQLiteDatabase myDB = openOrCreateDatabase("my.db", MODE_PRIVATE, null);
        myDB.execSQL(
                "CREATE TABLE IF NOT EXISTS userBase (phoneNumber VARCHAR(200), sport VARCHAR(200), city VARCHAR(200))"
        );
        SharedPreferences sharedPreferences = getSharedPreferences("UserPreferences", MODE_PRIVATE);
        String preferredCity = sharedPreferences.getString("PreferredCity", "");
        String[] args = {sportSt, preferredCity};
        Cursor myCursor = myDB.rawQuery("select phoneNumber from userBase where sport=? and city=?",
                args);
        while(myCursor.moveToNext()) {
            String phoneNumber = myCursor.getString(0);
            Log.d("numer:", phoneNumber);
            smsManager.sendMultipartTextMessage(phoneNumber, null, parts, null, null);
            phoneNumbers = phoneNumbers + phoneNumber + ", ";
        }
        myCursor.close();

        Toast.makeText(this, "SMS sent to: " + phoneNumbers + "all done.", Toast.LENGTH_SHORT).show();
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