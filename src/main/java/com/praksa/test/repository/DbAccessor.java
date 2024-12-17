package com.praksa.test.repository;

import com.praksa.test.model.User;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class DbAccessor {
    private final HikariDataSource dataSource;

    @Autowired
    public DbAccessor(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<User> getName() {

        String query = "SELECT id, name FROM public.test;";
        List<User> userList = new ArrayList<>();

        try(Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                userList.add(new User(resultSet.getInt("id"), resultSet.getString("name")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return userList;
    }


    public void addUser(String name, String timestamp) {
        String query = "INSERT INTO public.test(name, \"timestamp\") VALUES (?, ?);";

        try(Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,name);
            statement.setString(2, timestamp);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateTimeStampToUser(int id, String timestamp) {
        String query = "UPDATE public.test SET \"timestamp\"=? WHERE id=?;";
        try(Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,timestamp);
            statement.setInt(2, id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteRecord(int id) {
        String query = "DELETE FROM public.test WHERE id=?;";
        try(Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addWeather(String temp, String hum, String timestamp) {
        String query = "INSERT INTO public.weather(\"timestamp\", temperature, humidity) VALUES (?, ?, ?);";
        try(Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, timestamp);
            statement.setString(2, temp);
            statement.setString(3, hum);

            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
