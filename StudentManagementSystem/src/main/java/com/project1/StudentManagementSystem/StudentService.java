package com.project1.StudentManagementSystem;


import java.sql.SQLException;
import java.util.List;

public class StudentService {
    private StudentDao dao = new StudentDao();

    public void addStudent(Student s) throws SQLException {
        dao.save(s);
    }

    public List<Student> getAllStudents() throws SQLException {
        return dao.getAll();
    }

    public Student getStudentById(int id) throws SQLException {
        return dao.getById(id);
    }

    public boolean updateStudent(Student s) throws SQLException {
        return dao.update(s);
    }

    public boolean deleteStudent(int id) throws SQLException {
        return dao.delete(id);
    }
}
