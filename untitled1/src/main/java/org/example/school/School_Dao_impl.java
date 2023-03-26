package org.example.school;

import org.example.JDBCConnector;
import org.example.util_date.Utils;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class School_Dao_impl implements School_Dao{
    @Override
    public List<School_Super> findAll() throws SQLException {
        Connection connection = JDBCConnector.getConnection();
        if(connection==null){ }

        List<School_Super> school_super = new LinkedList<>();

        String query = "SELECT * FROM school_information ;";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            ResultSet resultSet =preparedStatement.executeQuery(query);
            while (resultSet.next()){
                School_Super school_supers = new School_Super(resultSet.getInt("school_id"),resultSet.getString("name"),resultSet.getString("image"),resultSet.getString("office_address"),resultSet.getInt("teacher_id"),resultSet.getInt("student_id"),resultSet.getDate("date_of_created"));
                school_super.add(school_supers);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return school_super;
    }

    @Override
    public School_Super findById(int id) throws SQLException {
        Connection connection =JDBCConnector.getConnection();
        if(connection == null){
            return null;
        }else{
            String query = "SELECT * FROM school_information WHERE school_id =?;";
            try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
                preparedStatement.setInt(1,id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()){
                    School_Super school_super = new School_Super(resultSet.getInt("school_id"),resultSet.getString("name"),resultSet.getString("image"),resultSet.getString("office_address"),resultSet.getInt("teacher_id"),resultSet.getInt("student_id"),resultSet.getDate("date_of_created"));

                    return school_super;
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
    public void seve(School_Super school_super) throws SQLException {
        Connection connection = JDBCConnector.getConnection();
        if (connection == null) {
            return;
        }
        if (school_super.getSchool_id() > 0) {  //Update
            String query = "UPDATE school_information SET name = ?,image = ?,office_address = ?,teacher_id = ?,student_id = ?, date_of_created = ? WHERE school_id =?; ";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, school_super.getName());
                preparedStatement.setString(2,school_super.getImage());
                preparedStatement.setString(3,school_super.getOffice_address());
                preparedStatement.setInt(4, school_super.getTeacher_id());
                preparedStatement.setInt(5,school_super.getStudent_id());
                preparedStatement.setDate(6, Utils.getSqlDate(school_super.getDate_of_created()));
                preparedStatement.setInt(7,school_super.getSchool_id());
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
            String query = "INSERT INTO school_information (name,image,office_address,teacher_id,student_id,date_of_created) VALUES (?,?,?,?,?,?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, school_super.getName());
                preparedStatement.setString(2,school_super.getImage());
                preparedStatement.setString(3,school_super.getOffice_address());
                preparedStatement.setInt(4, school_super.getTeacher_id());
                preparedStatement.setInt(5,school_super.getStudent_id());
                preparedStatement.setDate(6, Utils.getSqlDate(school_super.getDate_of_created()));

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
            String query ="DELETE FROM school_information WHERE school_id =?; ";
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
