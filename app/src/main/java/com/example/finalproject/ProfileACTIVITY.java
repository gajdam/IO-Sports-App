package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ProfileACTIVITY extends AppCompatActivity {
    EditText sportName;
    EditText cityName;
    EditText timeName;
    EditText dateName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

//        saveUserPreferences("Football", "New York", "Evening", "");

        Bundle b = getIntent().getExtras();
        String number = b.getString("number");
        TextView field = (TextView) findViewById(R.id.txtNum);
        sportName = (EditText) findViewById(R.id.edSport);
        cityName = (EditText) findViewById(R.id.edCity);
        timeName = (EditText) findViewById(R.id.edTime);
        dateName = (EditText) findViewById(R.id.edTime);
        loadUserPreferences();
        field.setText(number);
    }

        public void onClick(View v) {
            String sport = sportName.getText().toString();
            if (TextUtils.isEmpty(sport)) {
                sport = "";
            }

            String city = cityName.getText().toString();
            if (TextUtils.isEmpty(city)) {
                city = "";
            }

            String time = timeName.getText().toString();
            if (TextUtils.isEmpty(time)) {
                time = "";
            }

            String date = dateName.getText().toString();
            if (TextUtils.isEmpty(date)) {
                date = "";
            }

            saveUserPreferences(sport, city, time, date);
            Toast.makeText(this, "done", Toast.LENGTH_SHORT).show();
        }

    private void saveUserPreferences(String favoriteSport, String preferredCity, String preferredTime, String preferredDates) {
        SharedPreferences sharedPreferences = getSharedPreferences("UserPreferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("FavoriteSport", favoriteSport);
        editor.putString("PreferredCity", preferredCity);
        editor.putString("PreferredTime", preferredTime);
        editor.putString("PreferredDate", preferredDates);
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
        timeName.setText(preferredTime);
        dateName.setText(preferredTime);
    }
}