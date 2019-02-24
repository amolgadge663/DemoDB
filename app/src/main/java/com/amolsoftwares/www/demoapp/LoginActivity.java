package com.amolsoftwares.www.demoapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    DbHelper dbHelper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dbHelper = new DbHelper(this);

        Student student = new Student();
        student.setId(1);
        student.setAddress("Address");
        student.setName("Name");
        long studentId = dbHelper.saveUser(student);
        System.out.println("Student Id is " + studentId);
    }
}
