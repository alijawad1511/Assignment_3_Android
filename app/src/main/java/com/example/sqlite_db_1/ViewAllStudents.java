package com.example.sqlite_db_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewAllStudents extends AppCompatActivity {

    DBHelper db = new DBHelper(this);
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_students);
        listView = findViewById(R.id.listView);

        // Get All Students Data from DB
        ArrayList<Student> students = db.getAllStudents();

        for(Student student : students)
        {
            Log.d("DB_School","\nID: "+student.getId()+"\nName: "+student.getName()+"\nClass: "+student.getStudentClass()+
                    "\nAge: "+student.getAge()+"\nRoll No.: "+student.getRollNumber());
        }

        // Setting Data in ListView using ListAdapter
        ListAdapter listAdapter = new ListAdapter(ViewAllStudents.this,students);
        listView.setAdapter(listAdapter);
    }
}