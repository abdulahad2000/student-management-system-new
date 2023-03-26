package org.example.students_information.student;

import java.sql.SQLException;
import java.util.List;

public interface Student_Dao {

    List<Student_super> findAll() throws SQLException;
    Student_super findById(int id) throws SQLException;

    void seve(Student_super student) throws SQLException;

    void deleteById(int id) throws SQLException;

}
