package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class CreateEventActivity extends AppCompatActivity {

    private CheckBox cbPaid;
    private EditText editTextEventName;
    private EditText editTextDate;
    private EditText editTextTime;
    private EditText editTextPartycipants;
    private Button btnCreate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);
        editTextEventName = findViewById(R.id.etSportName);
        editTextDate = findViewById(R.id.etDate);
        editTextTime = findViewById(R.id.etTime);
        editTextPartycipants = findViewById(R.id.etParticipants);
    }

}