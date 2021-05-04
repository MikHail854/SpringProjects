package com.apress.prospring5.ch6.dao;

import com.apress.prospring5.ch6.entities.Singer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PlainSingerDao implements SingerDao{

    private static Logger logger = LoggerFactory.getLogger(PlainSingerDao.class);

    static {
        try {
            Class.forName("org.postgresql.Driver");

        }catch (ClassNotFoundException ex){
            logger.error("Problem loading DB dDriver", ex);
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/musicdb?useSSL=true",
                "prospring5", "prospring5");
    }

    private void closeConnection(Connection connection){
        if (connection == null){
            return;
        }
        try {
            connection.close();
        } catch (SQLException ex){
            logger.error("Problem closing connection to the database!", ex);
        }
    }

    @Override
    public List<Singer> findAll() {
        List<Singer> result = new ArrayList<>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from musicdb_schema.singer");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Singer singer = new Singer();
                singer.setId(resultSet.getLong("id"));
                singer.setFirstName(resultSet.getString("first_name"));
                singer.setLastName(resultSet.getString("last_name"));
                singer.setBirthDate(resultSet.getDate("birth_date"));
                result.add(singer);
            }
            statement.close();
        } catch (SQLException ex){
            logger.error("Problem when executing SELECT!", ex);
        } finally {
            closeConnection(connection);
        }
        return result;
    }

    @Override
    public List<Singer> findByFirstName(String firstName) {
        return null;
    }

    @Override
    public String findLastNameById(Long id) {
        return null;
    }

    @Override
    public String finsFirstNameById(Long id) {
        return null;
    }

    @Override
    public void insert(Singer singer) {
        Connection connection = null;
        try{
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "insert into musicdb_schema.singer (first_name, " +
                            "last_name," +
                            "birth_date) VALUES (?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, singer.getFirstName());
            statement.setString(2, singer.getLastName());
            statement.setDate(3, singer.getBirthDate());
            statement.execute();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()){
                singer.setId(generatedKeys.getLong(1));
            }
            statement.close();
        } catch (SQLException ex){
            logger.error("Problem executing INSET", ex);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void update(Singer singer) {

    }

    @Override
    public void delete(Long singerId) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("delete from musicdb_schema.singer where ID=?");
            statement.setLong(1, singerId);
            statement.execute();
            statement.close();
        } catch (SQLException ex){
            logger.error("Problem execute DELETE", ex);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<Singer> findAllWithDetail() {
        return null;
    }

    @Override
    public void insertWithDetail(Singer singer) {

    }
}

