package com.example.sqlite_db_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    Context c = null;

    public DBHelper(Context context){
        super(context, Params.DB_NAME, null, Params.DB_VERSION);
        c = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE IF NOT EXISTS students(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name VARCHAR(30), class VARCHAR(10), age INTEGER,roll_number VARCHAR(11) UNIQUE)";
        sqLiteDatabase.execSQL(query);
        Log.d("DB_School",query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public ArrayList<Student> getAllStudents(){
        ArrayList<Student> students = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM students";
        Cursor cursor = db.rawQuery(query,null);

        // Initialize students ArrayList
        String name,studentClass,rollNumber;
        int id, age;

        if(cursor.moveToFirst())
        {
            do{
                id = cursor.getInt(0);
                name = cursor.getString(1);
                studentClass = cursor.getString(2);
                age = cursor.getInt(3);
                rollNumber = cursor.getString(4);
                students.add(new Student(id,name,studentClass,rollNumber,age));
            }while(cursor.moveToNext());
        }
        else
        {
            Toast.makeText(c, "Students not found", Toast.LENGTH_SHORT).show();
        }

        return students;
    }

    public Student searchStudentById(int id){
        // Add a new Student in Database
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM students WHERE id="+id;
        Cursor cursor  = db.rawQuery(query,null);
        Student student = null;

        if(cursor.getCount()>0){
            cursor.moveToFirst();
            int studentId,age;
            String name,studentClass,rollNumber;

            studentId = cursor.getInt(0);
            name = cursor.getString(1);
            studentClass = cursor.getString(2);
            age = cursor.getInt(3);
            rollNumber = cursor.getString(4);

            student = new Student(studentId,name,studentClass,rollNumber,age);

            Log.d("DB_School","ID: "+studentId+"\nName: "+name+"\nClass: "+studentClass+
                    "\nAge: "+age+"\nRoll No.: "+rollNumber);

        }else{
            Toast.makeText(c, "Student not found", Toast.LENGTH_SHORT).show();
        }

        db.close();

        return student;
    }

    public void addStudent(Student student){
        // Add a new Student in Database
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("name",student.getName());
        values.put("class",student.getStudentClass());
        values.put("age",student.getAge());
        values.put("roll_number",student.getRollNumber());

        long res = db.insert(Params.TABLE_NAME,null,values);
        Log.d("DB_School","Student inserted successfully");
        db.close();
    }

    public int updateStudent(Student student){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name",student.getName());
        values.put("class",student.getStudentClass());
        values.put("roll_number",student.getRollNumber());
        values.put("age",student.getAge());

        // update() => return number of effected rows
        int res = db.update(Params.TABLE_NAME, values, "id=?", new String[]{"" + student.getId()});

        return res;
    }

    public void deleteStudent(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Params.TABLE_NAME, "id=?", new String[]{"" + id});
        db.close();
    }

    public ArrayList<Student> searchStudentsByAgeLimit(){
        // Select Students with Age within range 10-15
        ArrayList<Student> students = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM students WHERE age>=10 AND age<=15";
        Cursor cursor = db.rawQuery(query,null);

        // Initialize students ArrayList
        String name,studentClass,rollNumber;
        int id, age;

        if(cursor.moveToFirst())
        {
            do{
                id = cursor.getInt(0);
                name = cursor.getString(1);
                studentClass = cursor.getString(2);
                age = cursor.getInt(3);
                rollNumber = cursor.getString(4);
                students.add(new Student(id,name,studentClass,rollNumber,age));
            }while(cursor.moveToNext());
        }
        else
        {
            Toast.makeText(c, "Students not found", Toast.LENGTH_SHORT).show();
        }

        return students;
    }

    public ArrayList<Student> searchStudentsByClassLimit(){
        // Select Students with class within range 8-10 (Eight-Ten)
        ArrayList<Student> students = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM students WHERE class='Eight' OR class='Nine' OR class='Ten'";
        Cursor cursor = db.rawQuery(query,null);

        // Initialize students ArrayList
        String name,studentClass,rollNumber;
        int id, age;

        if(cursor.moveToFirst())
        {
            do{
                id = cursor.getInt(0);
                name = cursor.getString(1);
                studentClass = cursor.getString(2);
                age = cursor.getInt(3);
                rollNumber = cursor.getString(4);
                students.add(new Student(id,name,studentClass,rollNumber,age));
            }while(cursor.moveToNext());
        }
        else
        {
            Toast.makeText(c, "Students not found", Toast.LENGTH_SHORT).show();
        }

        return students;
    }
}
