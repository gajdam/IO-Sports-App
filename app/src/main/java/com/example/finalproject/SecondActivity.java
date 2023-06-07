package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.opcja4) {
            Intent i = new Intent(this, SettingsActivity.class);
            startActivity(i);
        } else if (id == R.id.opcja3) {
            Log.d("click 3", "Option 3");
        }
        return true;
    }


    public void openCreateEvent(View v) {
        Intent i = new Intent(this, CreateEventActivity.class);
        startActivity(i);
    }

    public void openProfile(View v) {
        Bundle b = getIntent().getExtras();
        String tmp = b.getString("number");
        Intent i = new Intent(this, ProfileACTIVITY.class);
        i.putExtra("number", tmp);
        startActivity(i);
    }
}