package com.demo.bookstore.dto;

public class StudentDTO {
    private int StudentID;
    private String Name;
    private int Age;
    private String Gender;

    public StudentDTO(int studentID, String name, int age, String gender) {
        StudentID = studentID;
        Name = name;
        Age = age;
        Gender = gender;
    }

    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int studentID) {
        StudentID = studentID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "StudentID=" + StudentID +
                ", Name='" + Name + '\'' +
                ", Age=" + Age +
                ", Gender='" + Gender + '\'' +
                '}';
    }
}

