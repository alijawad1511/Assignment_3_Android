package com.example.sqlite_db_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateStudent extends AppCompatActivity {
    
    EditText etId,etName,etClass,etRollNumber,etAge;
    Button btnUpdateStudent;
    DBHelper db = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_student);
        init();
    }
    
    private void init(){
        etId = findViewById(R.id.etId);
        etName = findViewById(R.id.etName);
        etClass = findViewById(R.id.etClass);
        etAge = findViewById(R.id.etAge);
        etRollNumber = findViewById(R.id.etRollNumber);
        btnUpdateStudent = findViewById(R.id.btnUpdateStudent);
    }
    
    public void onClickUpdateStudent(View view){
        String id,name,studentClass,rollNumber,age;
        id = etId.getText().toString();
        name = etName.getText().toString();
        studentClass = etClass.getText().toString();
        rollNumber = etRollNumber.getText().toString();
        age = etAge.getText().toString();

        if(isValid(id,name,studentClass,rollNumber,age)){
            // Here I want to get DBHelper Object from MainActivity
            int res = db.updateStudent(new Student(Integer.parseInt(id), name, studentClass, rollNumber, Integer.parseInt(age)));

            if(res==1){
                Toast.makeText(this, "Student updated successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UpdateStudent.this, MainActivity.class);
                startActivity(intent);
                finish();
            }else if(res<1){
                Toast.makeText(this, "Student with ID = "+id+" not found", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public boolean isValid(String id,String name,String studentClass,String rollNumber,String age){
        boolean flag = true;

        if(id.isEmpty()){
            etId.setError("ID is required");
            flag = false;
        }
        if(name.isEmpty()){
            etId.setError("Name is required");
            flag = false;
        }
        if(studentClass.isEmpty()){
            etId.setError("Class is required");
            flag = false;
        }
        if(rollNumber.isEmpty()){
            etId.setError("Roll Number is required");
            flag = false;
        }
        if(age.isEmpty()){
            etId.setError("Age is required");
            flag = false;
        }

        return flag;
    }
}