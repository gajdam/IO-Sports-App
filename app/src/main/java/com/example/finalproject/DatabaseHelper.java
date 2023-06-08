package com.example.finalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper {
    private SQLiteDatabase database;

    public DatabaseHelper(Context context) {
        database = context.openOrCreateDatabase("my.db", Context.MODE_PRIVATE, null);
        createTable();
    }

    private void createTable() {
        database.execSQL("CREATE TABLE IF NOT EXISTS userBase (phoneNumber VARCHAR(200), sport VARCHAR(200), city VARCHAR(200))");
    }

    public void insertUser(String phoneNumber, String sport, String city) {
        ContentValues values = new ContentValues();
        values.put("phoneNumber", phoneNumber);
        values.put("sport", sport);
        values.put("city", city);
        database.insert("userBase", null, values);
    }

    public Cursor getUsersBySportAndCity(String sport, String city) {
        String[] columns = {"phoneNumber"};
        String selection = "sport = ? AND city = ?";
        String[] selectionArgs = {sport, city};
        return database.query("userBase", columns, selection, selectionArgs, null, null, null);
    }

    public void close() {
        database.close();
    }
}
