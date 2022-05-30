package com.example.sqlite_db_1;

public class Student {
    int id;
    String name;
    String studentClass;
    String rollNumber;
    int age;

    public Student() {
        this.id = -1;
        this.age = -1;
    }

    public Student(int id, String name, String studentClass, String rollNumber, int age) {
        this.id = id;
        this.name = name;
        this.studentClass = studentClass;
        this.rollNumber = rollNumber;
        this.age = age;
    }

    public Student(String name, String studentClass,String rollNumber, int age) {
        this.name = name;
        this.studentClass = studentClass;
        this.rollNumber = rollNumber;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
