package com.demo.bookstore.service;

import java.sql.SQLException;
import java.util.List;

import com.demo.bookstore.dao.StudentDao;
import com.demo.bookstore.dto.StudentDTO;

public class StudentService {
    private StudentDao studentDao;

    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public List<StudentDTO> getAllStudents() throws SQLException {
        return studentDao.getAllStudents();
    }

    public boolean addNewStudent(StudentDTO newStudent) throws SQLException {
        return studentDao.addNewStudent(newStudent);
    }

    public boolean updateStudent(StudentDTO student) throws SQLException {
        return studentDao.updateStudent(student);
    }
    public StudentDTO getStudentById(int id) throws SQLException {
        return studentDao.getStudentById(id);
    }
}
