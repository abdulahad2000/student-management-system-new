package org.example.expanses;

import org.example.JDBCConnector;
import org.example.util_date.Utils;

import java.sql.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Expans_Dao_impl implements Expans_Dao{

    @Override
    public List<Expans_super> findAll() throws SQLException {
        Connection connection = JDBCConnector.getConnection();
        if(connection==null){ }

        List<Expans_super> expans_super = new LinkedList<>();
        String query = "SELECT * FROM expenses;";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            ResultSet resultSet =preparedStatement.executeQuery(query);
            while (resultSet.next()){
                Expans_super expans_supers= new Expans_super(resultSet.getInt("expenses_id"),resultSet.getString("name"),resultSet.getDouble("expenses"),resultSet.getDate("date_of_registration"));
                expans_super.add(expans_supers);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return expans_super;
    }

    @Override
    public Expans_super findById(int id) throws SQLException {
        Connection connection =JDBCConnector.getConnection();
        if(connection == null){
            return null;
        }else{
            String query = "SELECT * FROM expenses WHERE expenses_id = ?;";
            try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
                preparedStatement.setInt(1,id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()){
                    Expans_super expans_super= new Expans_super(resultSet.getInt("expenses_id"),resultSet.getString("name"),resultSet.getDouble("expenses"),resultSet.getDate("date_of_registration"));
                    return expans_super;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try{
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;    }

    @Override
    public void seve(Expans_super expans_super) throws SQLException {
        Connection connection = JDBCConnector.getConnection();
        if (connection == null) {
            return;
        }
        if (expans_super.getExpenses_id() > 0) {  //Update
            String query = "UPDATE expenses SET name = ?,expenses_id = ?,expenses = ?,date_of_registration = ? WHERE expenses_id=?; ";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, expans_super.getName());
                preparedStatement.setDouble(3, expans_super.getExpenses());
                preparedStatement.setDate(4, Utils.getSqlDate((Date) expans_super.getDate_of_registration()));
                preparedStatement.setInt(5,expans_super.getExpenses_id());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();                }
            }


        } else {       // Insert into
            String query = "INSERT INTO expenses (name,expenses,date_of_registration) VALUES (?,?,?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, expans_super.getName());
                preparedStatement.setDouble(2, expans_super.getExpenses_id());
                preparedStatement.setDate(3, Utils.getSqlDate(expans_super.getDate_of_registration()));
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Override
    public void defeteById(int id) throws SQLException {
        Connection connection =JDBCConnector.getConnection();
        if (connection==null){
            return;
        }else {
            String query ="DELETE FROM expenses WHERE expenses_id=?; ";
            try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
                preparedStatement.setInt(1,id);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
