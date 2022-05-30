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

    Button btnAddStudent,btnDeleteStudent,btnUpdateStudent,btnSearchAll,btnSearchByAge,btnSearchByClass;
    DBHelper db = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        // Add Student
        db.addStudent(new Student("Mushahid Hussain","Eight","S2022MUSHAHID",12));
        db.addStudent(new Student("Mushahid Hussain","Eight","S2022AHMAD",10));
        db.addStudent(new Student("Hammad Mustafa","Nine","S2022HAMMAD",15));
        db.addStudent(new Student("Bilal Awan","Nine","S2022BILAL",14));
        db.addStudent(new Student("Ali Raza","Ten","S2022ALI",15));

        db.updateStudent(new Student(1,"Jawad Shah","Ten","S2022JAWAD",15));

        // Get All Students
        ArrayList<Student> allStudents = db.searchStudentsByClassLimit();
        for(Student student : allStudents)
        {
            Log.d("DB_School","ID: "+student.getId()+"\nName: "+student.getName()+"\nClass: "+student.getStudentClass()+
                    "\nAge: "+student.getAge()+"\nRoll No.: "+student.getRollNumber());
        }

    }

    private void init(){
        // Initialize all xml objects in Java
        btnAddStudent = findViewById(R.id.btnAddNewStudent);
        btnDeleteStudent = findViewById(R.id.btnDeleteStudent);
        btnUpdateStudent = findViewById(R.id.btnUpdateStudent);
        btnSearchAll = findViewById(R.id.btnSearchAll);
        btnSearchByAge = findViewById(R.id.btnSearchByAge);
        btnSearchByClass = findViewById(R.id.btnSearchByClass);
    }

    public void onClickAddStudent(View view) {
        Toast.makeText(this, "Add Student", Toast.LENGTH_SHORT).show();
    }

    public void onClickDeleteStudent(View view) {
        Toast.makeText(this, "Delete Student", Toast.LENGTH_SHORT).show();
    }

    public void onClickUpdateStudent(View view) {
        Intent intent = new Intent(MainActivity.this,UpdateStudent.class);
        startActivity(intent);
    }

    public void onClickSearchAll(View view) {
        Toast.makeText(this, "Search all Students", Toast.LENGTH_SHORT).show();
    }

    public void onClickSearchByAge(View view) {
        Toast.makeText(this, "Search Students by Age", Toast.LENGTH_SHORT).show();
    }

    public void onClickSearchByClass(View view) {
        Toast.makeText(this, "Search Students by Class", Toast.LENGTH_SHORT).show();
    }
}