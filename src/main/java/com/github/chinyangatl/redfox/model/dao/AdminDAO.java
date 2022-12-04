package com.github.chinyangatl.redfox.model.dao;

import com.github.chinyangatl.redfox.model.beans.Admin;
import com.github.chinyangatl.redfox.model.beans.Employee;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO {
    private DataSource dataSource;

    public AdminDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = dataSource.getConnection();
            String sql = "select * from employee";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");


                Employee employee = new Employee(id, name, email, password);
                employees.add(employee);
            }
            return employees;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection, statement, resultSet);
        }

    }

    public List<Admin> getAdmins() {
        List<Admin> admins = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = dataSource.getConnection();
            String sql = "select * from admin";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");


                Admin admin = new Admin(id, email, password);
                admins.add(admin);
            }
            return admins;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection, statement, resultSet);
        }
    }

    private void close(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if(connection != null) {
                connection.close();
            }
            if(statement != null) {
                connection.close();
            }
            if(resultSet != null) {
                resultSet.close();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}