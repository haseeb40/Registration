package com.example.registration;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.View;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contact.db";
    private static final String TABLE_NAME = "contact";
    private static final String COLUMN_ID = "iddb";
    private static final String COLUMN_NAME = "namedb";
    private static final String COLUMN_EMAIL = "emaildb";
    private static final String COLUMN_UNAME = "unamedb";
    private static final String COLUMN_PASS = "passdb";
    private static final String LOGCAT = null;
    SQLiteDatabase db;
    private static final String TABLE_CREATE = "create table contact (iddb integer primary key not null , " +
            "namedb text not null , emaildb text not null , unamedb text not null , passdb text not null);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS" + TABLE_NAME;
        db.execSQL(query);
        onCreate(db);
        Log.d(LOGCAT, "Created");
    }

    public void onInsert(Contact c) {

        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        long count = DatabaseUtils.queryNumEntries(db, TABLE_NAME);

        values.put(COLUMN_ID, count);
        values.put(COLUMN_NAME, c.getName());
        values.put(COLUMN_EMAIL, c.getEmail());
        values.put(COLUMN_UNAME, c.getUname());
        values.put(COLUMN_PASS, c.getPass());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public String searchpass(String uname) {

        db = this.getReadableDatabase();
        String q = "select unamedb, passdb from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(q, null);
        String a, b = "Not Found";
        if (cursor.moveToFirst()) {
            do {
                a = cursor.getString(0);
                if (a.equals(uname)) {
                    b = cursor.getString(1);
                    break;
                }
            } while (cursor.moveToNext());
        }
        return b;
    }
}
