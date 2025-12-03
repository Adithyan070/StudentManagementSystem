package com.project1.StudentManagementSystem;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    public void save(Student s) throws SQLException {
        String sql = "INSERT INTO students(name, grade) VALUES (?, ?)";
        try (Connection con = DataBaseUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, s.getName());
            ps.setString(2, s.getGrade());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    s.setId(rs.getInt(1));
                }
            }
        }
    }

    public List<Student> getAll() throws SQLException {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT id, name, grade FROM students";
        try (Connection con = DataBaseUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Student(rs.getInt("id"), rs.getString("name"), rs.getString("grade")));
            }
        }
        return list;
    }

    public Student getById(int id) throws SQLException {
        String sql = "SELECT id, name, grade FROM students WHERE id = ?";
        try (Connection con = DataBaseUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Student(rs.getInt("id"), rs.getString("name"), rs.getString("grade"));
                }
            }
        }
        return null;
    }

    public boolean update(Student s) throws SQLException {
        String sql = "UPDATE students SET name = ?, grade = ? WHERE id = ?";
        try (Connection con = DataBaseUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, s.getName());
            ps.setString(2, s.getGrade());
            ps.setInt(3, s.getId());
            int rows = ps.executeUpdate();
            return rows > 0;
        }
    }

    public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM students WHERE id = ?";
        try (Connection con = DataBaseUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            return rows > 0;
        }
    }
}
