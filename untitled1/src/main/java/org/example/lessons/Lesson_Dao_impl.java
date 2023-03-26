package org.example.lessons;

import org.example.JDBCConnector;
import org.example.util_date.Utils;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import static org.example.util_date.Utils.*;

public class Lesson_Dao_impl implements Lesson_Dao{
    @Override
    public List<Lesson_super> findAll() throws SQLException {
        Connection connection = JDBCConnector.getConnection();
        if(connection==null){ }

        List<Lesson_super> lesson_supers = new LinkedList<>();

        String query = "SELECT * FROM lessons_information ;";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            ResultSet resultSet =preparedStatement.executeQuery(query);
            while (resultSet.next()){
               Lesson_super lesson_super =new Lesson_super(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getInt("teacher_id"),resultSet.getTime("start_time"),resultSet.getTime("end_time"));
                lesson_supers.add(lesson_super);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return lesson_supers;
    }

    @Override
    public Lesson_super findById(int id) throws SQLException {
        Connection connection =JDBCConnector.getConnection();
        if(connection == null){
            return null;
        }else{
            String query = "SELECT * FROM lessons_information WHERE id=?;";
            try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
                preparedStatement.setInt(1,id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()){
                    Lesson_super lesson_super =new Lesson_super(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getInt("teacher_id"),resultSet.getTime("start_time"),resultSet.getTime("end_time"));

                    return lesson_super;
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
        return null;}

    @Override
    public void seve(Lesson_super lesson_super) throws SQLException {
        Connection connection = JDBCConnector.getConnection();
        if (connection == null) {
            return;
        }
        if (lesson_super.getId() > 0) {  //Update
            String query = "UPDATE lessons_information SET name = ?,teacher_id = ?,start_time = ?,end_time = ? WHERE id=?; ";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, lesson_super.getName());
                preparedStatement.setInt(2, lesson_super.getTeacher_id());
                preparedStatement.setTime(3, (Time) lesson_super.getStart_time());
                preparedStatement.setTime(4, (Time) lesson_super.getEnd_time());
                preparedStatement.setInt(5, lesson_super.getId());
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
            String query = "INSERT INTO lessons_information (name,teacher_id,start_time,end_time) VALUES (?,?,?,?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, lesson_super.getName());
                preparedStatement.setInt(2, lesson_super.getTeacher_id());
                preparedStatement.setTime(3, (Time) lesson_super.getStart_time());
                preparedStatement.setTime(4, (Time) lesson_super.getEnd_time());
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
            String query ="DELETE FROM lessons_information WHERE id=?; ";
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
