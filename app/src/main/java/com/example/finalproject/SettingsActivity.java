package com.example.finalproject;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import android.view.View;
import android.widget.LinearLayout;
import android.window.SplashScreenView;

public class SettingsActivity extends AppCompatActivity {

    private SwitchCompat switchTheme;
    private SharedPreferences sharedPref;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        sharedPref = getPreferences(MODE_PRIVATE);
        boolean isDarkThemeEnabled = sharedPref.getBoolean("dark_theme", false);

        switchTheme = findViewById(R.id.switch_theme);
        switchTheme.setChecked(isDarkThemeEnabled);
        switchTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switchTheme.isChecked()) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    sharedPref.edit().putBoolean("dark_theme", true).apply();

                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    sharedPref.edit().putBoolean("dark_theme", false).apply();
                }
            }
        });

        if (isDarkThemeEnabled) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }
}