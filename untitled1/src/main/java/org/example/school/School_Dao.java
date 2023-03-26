package org.example.school;

import java.sql.SQLException;
import java.util.List;

public interface School_Dao {
    List<School_Super> findAll() throws SQLException;
    School_Super findById(int id) throws SQLException;
    void seve(School_Super school_super) throws SQLException;
    void deleteById(int id) throws SQLException;
}
