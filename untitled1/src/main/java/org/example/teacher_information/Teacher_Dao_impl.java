package org.example.teacher_information;

import org.example.JDBCConnector;
import org.example.util_date.Utils;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class Teacher_Dao_impl implements Teacher_Dao{
    @Override
    public List<Teacher_super> findAll() throws SQLException {
        Connection connection = JDBCConnector.getConnection();
        if(connection==null){ }

        List<Teacher_super> teacher_supers = new LinkedList<>();

        String query = "SELECT * FROM teacher_information ;";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            ResultSet resultSet =preparedStatement.executeQuery(query);
            while (resultSet.next()){
                Teacher_super teacher_super = new Teacher_super(resultSet.getInt("teacher_id"),resultSet.getString("first_name"
                ), resultSet.getString("last_name"), resultSet.getString("birth_date"), resultSet.getBoolean("gender"), resultSet.getString("TC_address"), resultSet.getString("phone_number"), resultSet.getString("email_address"), resultSet.getString("home_address"),resultSet.getDouble("salary"),resultSet.getDate("date_of_registration"));
                teacher_supers.add(teacher_super);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return teacher_supers;

    }

    @Override
    public Teacher_super findById(int id) throws SQLException {
        Connection connection =JDBCConnector.getConnection();
        if(connection == null){
            return null;
        }else{
            String query = "SELECT * FROM teacher_information WHERE teacher_id=?;";
            try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
                preparedStatement.setInt(1,id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()){
                    Teacher_super teacher_super = new Teacher_super(resultSet.getInt("teacher_id"),resultSet.getString("first_name"
                    ), resultSet.getString("last_name"), resultSet.getString("birth_date"), resultSet.getBoolean("gender"), resultSet.getString("TC_address"), resultSet.getString("phone_number"), resultSet.getString("email_address"), resultSet.getString("home_address"),resultSet.getDouble("salary"),resultSet.getDate("date_of_registration"));
                    return teacher_super;
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
    public void seve(Teacher_super teacher_super) throws SQLException {
        Connection connection = JDBCConnector.getConnection();
        if (connection == null) {
            return;
        }
        if (teacher_super.getId() > 0) {  //Update
            String query = "UPDATE teacher_information SET first_name = ?,last_name =?,birth_date=?,gender=?,TC_address=?,phone_number=?,email_address=?,home_address=?,salary = ?,date_of_registration = ? WHERE id=?; ";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, teacher_super.getFirst_name());
                preparedStatement.setString(2, teacher_super.getLast_name());
                preparedStatement.setString(3, teacher_super.getBirth_date());
                preparedStatement.setBoolean(4, teacher_super.isGender());
                preparedStatement.setString(5, teacher_super.getTC_address());
                preparedStatement.setString(6, teacher_super.getPhone_number());
                preparedStatement.setString(7, teacher_super.getEmail_address());
                preparedStatement.setString(8,teacher_super.getHome_address());
                preparedStatement.setDouble(9,teacher_super.getSalary());
                preparedStatement.setDate(10, Utils.getSqlDate(teacher_super.getDate_of_registration()));
                preparedStatement.setInt(11, teacher_super.getId());

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


        } else {       // Insert into
            String query = "INSERT INTO teacher_information (first_name,last_name,birth_date,gender,TC_address,phone_number,email_address,home_address,salary,date_of_registration) VALUES (?,?,?,?,?,?,?,?,?,?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, teacher_super.getFirst_name());
                preparedStatement.setString(2, teacher_super.getLast_name());
                preparedStatement.setString(3, teacher_super.getBirth_date());
                preparedStatement.setBoolean(4, teacher_super.isGender());
                preparedStatement.setString(5, teacher_super.getTC_address());
                preparedStatement.setString(6, teacher_super.getPhone_number());
                preparedStatement.setString(7, teacher_super.getEmail_address());
                preparedStatement.setString(8,teacher_super.getHome_address());
                preparedStatement.setDouble(9,teacher_super.getSalary());
                preparedStatement.setDate(10, Utils.getSqlDate(teacher_super.getDate_of_registration()));
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
    public void deleteById(int id) throws SQLException {
        Connection connection =JDBCConnector.getConnection();
        if (connection==null){
            return;
        }else {
            String query ="DELETE FROM teacher_information WHERE teacher_id = ?; ";
            try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
                preparedStatement.setInt(1,id);
                preparedStatement.executeUpdate();
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

    }
}
