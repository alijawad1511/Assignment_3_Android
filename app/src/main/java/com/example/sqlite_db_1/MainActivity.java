package com.example.sqlite_db_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnAddNewStudent,btnSearchStudent,btnDeleteStudent,btnUpdateStudent,btnSearchAll,btnSearchByAge,btnSearchByClass;
    DBHelper db = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        // Add Student
//        db.addStudent(new Student("Ali Raza","Ten","S2022ALI",15));

        // Update Student
//        db.updateStudent(new Student(1,"Jawad Shah","Ten","S2022JAWAD",15));

        // Get All Students
        /*ArrayList<Student> allStudents = db.searchStudentsByClassLimit();
        for(Student student : allStudents)
        {
            Log.d("DB_School","\nID: "+student.getId()+"\nName: "+student.getName()+"\nClass: "+student.getStudentClass()+
                    "\nAge: "+student.getAge()+"\nRoll No.: "+student.getRollNumber());
        }*/

    }

    private void init(){
        // Initialize all xml objects in Java
        btnAddNewStudent = findViewById(R.id.btnAddNewStudent);
        btnSearchStudent = findViewById(R.id.btnSearchStudent);
        btnDeleteStudent = findViewById(R.id.btnDeleteStudent);
        btnUpdateStudent = findViewById(R.id.btnUpdateStudent);
        btnSearchAll = findViewById(R.id.btnSearchAll);
        btnSearchByAge = findViewById(R.id.btnSearchByAge);
        btnSearchByClass = findViewById(R.id.btnSearchByClass);
    }

    public void onClickAddNewStudent(View view) {
        Intent intent = new Intent(MainActivity.this,AddStudent.class);
        startActivity(intent);
    }

    public void onClickSearchStudent(View view) {
        Intent intent = new Intent(MainActivity.this,SearchStudent.class);
        startActivity(intent);
    }

    public void onClickDeleteStudent(View view) {
        Intent intent = new Intent(MainActivity.this,DeleteStudent.class);
        startActivity(intent);
    }

    public void onClickUpdateStudent(View view) {
        Intent intent = new Intent(MainActivity.this,UpdateStudent.class);
        startActivity(intent);
    }

    public void onClickViewAllStudents(View view) {
        Intent intent = new Intent(MainActivity.this,ViewAllStudents.class);
        startActivity(intent);
    }

    public void onClickSearchByAge(View view) {
        Intent intent = new Intent(MainActivity.this,ViewStudentsByAge.class);
        startActivity(intent);
    }

    public void onClickSearchByClass(View view) {
        Intent intent = new Intent(MainActivity.this,ViewStudentsByClass.class);
        startActivity(intent);
    }
}