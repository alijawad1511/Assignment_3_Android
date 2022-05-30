package com.example.sqlite_db_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddStudent extends AppCompatActivity {

    EditText etName,etClass,etAge, etRollNumber;
    Button btnAddStudent;
    DBHelper dbHelper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        init();
    }

    private void init(){
        btnAddStudent = findViewById(R.id.btnAddStudent);
        etName = findViewById(R.id.etName);
        etClass = findViewById(R.id.etClass);
        etAge = findViewById(R.id.etAge);
        etRollNumber = findViewById(R.id.etRollNumber);
        dbHelper = new DBHelper(AddStudent.this);
    }

    public void onClickAddStudent(View view) {
        String name,studentClass,rollNumber;
        int age;

        name = etName.getText().toString();
        studentClass = etClass.getText().toString();
        rollNumber = etRollNumber.getText().toString();
        age = Integer.parseInt(etAge.getText().toString());

        dbHelper.addStudent(new Student(name,studentClass,rollNumber,age));
        Toast.makeText(this, "New Student added successfully", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(AddStudent.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}