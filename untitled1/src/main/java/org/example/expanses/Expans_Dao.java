package org.example.expanses;

import java.sql.SQLException;
import java.util.List;

public interface Expans_Dao {
    List<Expans_super> findAll() throws SQLException;
    Expans_super findById(int id) throws SQLException;
    void seve(Expans_super expans_super) throws SQLException;
    void defeteById(int id) throws SQLException;

}
