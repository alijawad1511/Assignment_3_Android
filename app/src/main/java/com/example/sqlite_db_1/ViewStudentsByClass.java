package com.example.sqlite_db_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewStudentsByClass extends AppCompatActivity {

    DBHelper db = new DBHelper(this);
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_students_by_class);
        listView = findViewById(R.id.listView);

        // Get All Students Data from DB
        ArrayList<Student> students = db.searchStudentsByClassLimit();

        // Setting Data in ListView using ListAdapter
        ListAdapter listAdapter = new ListAdapter(this,students);
        listView.setAdapter(listAdapter);
    }
}