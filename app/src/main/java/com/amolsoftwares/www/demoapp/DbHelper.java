package com.amolsoftwares.www.demoapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "Student_Database";



    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createStudentTable = "CREATE TABLE STUDENT(id INTEGER, name text, address text)";
        db.execSQL(createStudentTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


     long saveUser(Student student)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        values.put("id",student.getId());
        values.put("name",student.getName());
        values.put("address",student.getAddress());

        // insert row
        long id = db.insert("STUDENT", null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }
}
