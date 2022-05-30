package com.example.sqlite_db_1;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {

    ArrayList<Student> students = null;
    Context context;
    LayoutInflater layoutInflater = null;

    // XML Objects
    TextView tvId,tvName,tvClass,tvRollNumber,tvAge;

    public ListAdapter(Context context,ArrayList<Student> students){
        this.students = students;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        Log.d("DB_School","No. of Students : "+students.size());
    }

    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View newView =layoutInflater.inflate(R.layout.listview_item,null);

        tvId = newView.findViewById(R.id.tvId);
        tvName = newView.findViewById(R.id.tvName);
        tvClass = newView.findViewById(R.id.tvClass);
        tvRollNumber = newView.findViewById(R.id.tvRollNumber);
        tvAge = newView.findViewById(R.id.tvAge);

        tvId.setText(""+students.get(i).getId());
        tvName.setText(students.get(i).getName());
        tvClass.setText(students.get(i).getStudentClass());
        tvRollNumber.setText(students.get(i).getRollNumber());
        tvAge.setText(""+students.get(i).getAge());


        return newView;
    }
}
