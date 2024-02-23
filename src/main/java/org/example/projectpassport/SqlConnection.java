package org.example.projectpassport;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SqlConnection {

    public  Connection connectDb() {

        try {
            Connection conn = null;
            String url = "jdbc:mysql://localhost:3306/passport_system";
            String sqlusername = "root";
            String sqlpassword = "Rehan@221104";
            conn = DriverManager.getConnection(url, sqlusername, sqlpassword);
            //System.out.println("success");
            return conn;
        } catch (SQLException exception) {
            //System.out.println("Connection Fails");
            throw  new RuntimeException(exception);
        }

    }


}
