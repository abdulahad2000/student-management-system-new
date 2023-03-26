package org.example.additional_income;

import java.sql.SQLException;
import java.util.List;

public interface Economy_Dao {
    List<Economy_super> findAll() throws SQLException;
    Economy_super findById() throws SQLException;
    void seve(Economy_super economy_super) throws SQLException;
    void deleteById(Economy_super economy_super) throws SQLException;
}
