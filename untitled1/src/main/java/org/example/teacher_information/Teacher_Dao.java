package org.example.teacher_information;

import java.sql.SQLException;
import java.util.List;

public interface Teacher_Dao {
    List<Teacher_super> findAll() throws SQLException;
    Teacher_super findById(int id) throws SQLException;
    void seve(Teacher_super teacher) throws SQLException, RuntimeException;
    void deleteById(int id) throws SQLException;
}
