package org.example.additional_income;

import org.example.JDBCConnector;
import org.example.util_date.Utils;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
//
//                    Economy_super economy_supers = new Economy_super(resultSet.getInt("economy_id"),resultSet.getDouble("expenses"),resultSet.getDouble("Economy_Dao_impl"),resultSet.getDate("date_of_registration"));

public class Economy_Dao_impl implements Economy_Dao{
    @Override
    public List<Economy_super> findAll() throws SQLException {
        Connection connection = JDBCConnector.getConnection();
        if(connection==null){ }

        List<Economy_super> economy_super = new LinkedList<>();
        String query = "SELECT * FROM additional_income;";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            ResultSet resultSet =preparedStatement.executeQuery(query);
            while (resultSet.next()){
                    Economy_super economy_supers = new Economy_super(resultSet.getInt("additional_income_id"),resultSet.getString("name"),resultSet.getDouble("additional_income"),resultSet.getDate("date_of_registration"));
                economy_super.add(economy_supers);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return economy_super;
    }

    @Override
    public Economy_super findById() throws SQLException {
        Connection connection =JDBCConnector.getConnection();
        if(connection == null){
            return null;
        }else{
            String query = "SELECT * FROM additional_income WHERE additional_income_id=?;";
            try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
                int id = 0;
                preparedStatement.setInt(1,id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()){
                    Economy_super economy_supers = new Economy_super(resultSet.getInt("additional_income_id"),resultSet.getString("name"),resultSet.getDouble("additional_income"),resultSet.getDate("date_of_registration"));
                    return economy_supers;
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
        return null;
    }

    @Override
    public void seve(Economy_super economy_super) throws SQLException {
        Connection connection = JDBCConnector.getConnection();
        if (connection == null) {
            return;
        }
        if (economy_super.getAdditional_income_id() > 0) {  //Update
            String query = "UPDATE additional_income SET name = ?,additional_income_id = ?,additional_income = ?,date_of_registration = ? WHERE id=?; ";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, economy_super.getName());
                preparedStatement.setDouble(3, economy_super.getAdditional_income());
                preparedStatement.setDate(4, Utils.getSqlDate(economy_super.getDate_of_registration()));
                preparedStatement.setInt(5,economy_super.getAdditional_income_id());
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
            String query = "INSERT INTO additional_income (name,additional_income,date_of_registration) VALUES (?,?,?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, economy_super.getName());
                preparedStatement.setDouble(2, economy_super.getAdditional_income());
                preparedStatement.setDate(3, Utils.getSqlDate(economy_super.getDate_of_registration()));
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
    public void deleteById(Economy_super economy_super) throws SQLException {
        Connection connection =JDBCConnector.getConnection();
        if (connection==null){
            return;
        }else {
            String query ="DELETE FROM additional_income WHERE additional_income_id=?; ";
            try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
                int id = 0;
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
