package org.example.lessons;

import java.sql.SQLException;
import java.util.List;

public interface Lesson_Dao {
    List<Lesson_super> findAll() throws SQLException;
    Lesson_super findById(int id) throws SQLException;
    void seve(Lesson_super lesson_super) throws SQLException;
    void deleteById(int id) throws SQLException;
}
