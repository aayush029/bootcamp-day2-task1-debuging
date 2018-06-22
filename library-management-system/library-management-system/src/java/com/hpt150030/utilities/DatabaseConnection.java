/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hpt150030.utilities;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

/**
 *
 * @author Hardik
 */
public class DatabaseConnection {

    public java.sql.Connection connect = null;
    private Statement statement = null;
    public java.sql.PreparedStatement preparedStatement = null;
    public java.sql.ResultSet resultSet = null;

    public DatabaseConnection() {
    }

    public void openConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        connect = DriverManager
                .getConnection("jdbc:mysql://localhost/lms?"
                        + "user=root&password=root");
    }

    public void closeConnection() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception exp) {

        }
    }
}
