package com.example.sqlite_db_1;

import android.content.Context;
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
    TextView id,name,studentClass,rollNumber,age;

    public ListAdapter(Context context,ArrayList<Student> students){
        this.students = students;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
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

        id = newView.findViewById(R.id.id);
        name = newView.findViewById(R.id.name);
        studentClass = newView.findViewById(R.id.studentClass);
        rollNumber = newView.findViewById(R.id.rollNumber);
        age = newView.findViewById(R.id.age);

        id.setText(students.get(i).id);
        name.setText(students.get(i).name);
        studentClass.setText(students.get(i).studentClass);
        rollNumber.setText(students.get(i).rollNumber);
        age.setText(students.get(i).age);


        return newView;
    }
}
