package com.example.sqlite_db_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SearchStudent extends AppCompatActivity {

    EditText etSearch;
    TextView tvId,tvName,tvClass,tvRollNumber,tvAge;
    Button btnSearch,btnClear;
    ImageView ivProfile;
    LinearLayout layoutContainer;
    DBHelper db = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_student);
        init();
    }

    public void init(){
        etSearch = findViewById(R.id.etSearch);

        // Buttons
        btnSearch = findViewById(R.id.btnSearch);
        btnClear = findViewById(R.id.btnClear);

        // TextViews
        tvId = findViewById(R.id.tvId);
        tvName = findViewById(R.id.tvName);
        tvClass = findViewById(R.id.tvClass);
        tvRollNumber = findViewById(R.id.tvRollNumber);
        tvAge = findViewById(R.id.tvAge);

        ivProfile = findViewById(R.id.ivProfile);
        layoutContainer = findViewById(R.id.layoutContainer);
    }

    public void onClickSearch(View view){
        if(etSearch.getText().toString().isEmpty()){
            etSearch.setError("Kindly search an ID of student");
        }else{
            int id = Integer.parseInt(etSearch.getText().toString());

            // Search Student from DB
            Student student = db.searchStudentById(id);

            if(student==null){
                Toast.makeText(this, "Student not found", Toast.LENGTH_SHORT).show();
            }else{
                // Make Hide Elements Visible on Frontend
                ivProfile.setVisibility(View.VISIBLE);
                layoutContainer.setVisibility(View.VISIBLE);

                // Show Searched Data on Frontend
                tvId.setText(""+student.getId());
                tvName.setText(student.getName());
                tvClass.setText(student.getStudentClass());
                tvRollNumber.setText(student.getRollNumber());
                tvAge.setText(""+student.getAge());
            }
        }
    }

    public void onClickClear(View view){
        etSearch.setText("");
        tvId.setText("");
        tvName.setText("");
        tvClass.setText("");
        tvRollNumber.setText("");
        tvAge.setText("");

        layoutContainer.setVisibility(View.INVISIBLE);
        ivProfile.setVisibility(View.INVISIBLE);
    }


}