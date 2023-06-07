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

    SmsManager smsManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);
        smsManager = SmsManager.getDefault();
    }

    public void btnSend_click(View v) {
        EditText location = (EditText) v.findViewById(R.id.etLocation);
        EditText  date = (EditText) v.findViewById(R.id.etDate);
        EditText hour = (EditText) v.findViewById(R.id.etTime);
        EditText sport = (EditText) v.findViewById(R.id.etSportName);

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