package com.example.DBConnect;

import java.sql.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

import static java.sql.DriverManager.*;

public class DBConnection {
    private static final String URL = DBProperties.get().getProperty("db.url");
    private static final String USER = DBProperties.get().getProperty("db.user");
    private static final String PASSWORD= DBProperties.get().getProperty("db.password");

    private static Connection conn;
    public static Connection DBconnect() throws SQLException {
        if (conn == null || conn.isClosed()) {
            conn = getConnection(URL, USER, PASSWORD);


        }
        return conn;
    }
    public static void alertMessage(){
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("The database server is not responding, or an error occurred when querying the database."
                + "\nFurther operation of the application is impossible. The application will be closed.");
        alert.showAndWait().filter(response -> response == ButtonType.OK).ifPresent(response -> System.exit(0));
    }
}