package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ProfileACTIVITY extends AppCompatActivity {
    TextView sportName;
    TextView cityName;
    TextView time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        saveUserPreferences("Football", "New York", "Evening");

        Bundle b = getIntent().getExtras();
        String number = b.getString("number");
        TextView field = (TextView) findViewById(R.id.txtVName);
        sportName = (TextView) findViewById(R.id.txtSportName);
        cityName = (TextView) findViewById(R.id.txtCity);
        time = (TextView) findViewById(R.id.txtTime);
        loadUserPreferences();
        field.setText(number);
    }

    private void saveUserPreferences(String favoriteSport, String preferredCity, String preferredTime) {
        SharedPreferences sharedPreferences = getSharedPreferences("UserPreferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("FavoriteSport", favoriteSport);
        editor.putString("PreferredCity", preferredCity);
        editor.putString("PreferredTime", preferredTime);
        editor.apply();
    }

    private void loadUserPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences("UserPreferences", MODE_PRIVATE);
        String favoriteSport = sharedPreferences.getString("FavoriteSport", "");
        String preferredCity = sharedPreferences.getString("PreferredCity", "");
        String preferredTime = sharedPreferences.getString("PreferredTime", "");

        Log.d("FavoriteSport", favoriteSport);
        Log.d("PreferredCity", preferredCity);
        Log.d("PreferredTime", preferredTime);

        sportName.setText(favoriteSport);
        cityName.setText(preferredCity);
        time.setText(preferredTime);
    }



//    public void wyswietl() {
//        Bundle b = getIntent().getExtras();
//        String parametr = b.getString("data");
//        TextView pole = (TextView) findViewById(R.id.txtView);
//        pole.setText(parametr);
//    }
}