package com.demo.bookstore.dao;

import com.demo.bookstore.dto.StudentDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class StudentDao {
    // Connection object to interact with the database
    private Connection connection;

    // Constructor to initialize the connection
    public StudentDao(Connection connection) {
        this.connection = connection;
    }

    // Method to retrieve all students from the database
    public List<StudentDTO> getAllStudents() throws SQLException {
        List<StudentDTO> students = new ArrayList<>();
        String query = "SELECT * FROM students";

        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int studentID = resultSet.getInt("StudentID");
                String name = resultSet.getString("Name");
                int age = resultSet.getInt("Age");
                String gender = resultSet.getString("Gender");

                StudentDTO student = new StudentDTO(studentID, name, age, gender);
                students.add(student);
            }
        }

        return students;
    }

    // Method to add a new student to the database
    public boolean addNewStudent(StudentDTO newStudent) throws SQLException {
        String query = "INSERT INTO students (Name, Age, Gender) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, newStudent.getName());
            statement.setInt(2, newStudent.getAge());
            statement.setString(3, newStudent.getGender());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        }
    }
    // Method to update an existing student in the database
    public boolean updateStudent(StudentDTO student) throws SQLException {
        String query = "UPDATE students SET Name = ?, Age = ?, Gender = ? WHERE StudentID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, student.getName());
            statement.setInt(2, student.getAge());
            statement.setString(3, student.getGender());
            statement.setInt(4, student.getStudentID());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        }
    }

    // Method to retrieve a student by student ID from the database
    public StudentDTO getStudentById(int studentID) throws SQLException {
        String query = "SELECT * FROM students WHERE StudentID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, studentID);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String name = resultSet.getString("Name");
                    int age = resultSet.getInt("Age");
                    String gender = resultSet.getString("Gender");

                    return new StudentDTO(studentID, name, age, gender);
                }
            }
        }

        return null; // Student not found
    }

}
