package com.example.authformjavafx;

import com.example.DBConnect.DBConnection;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.sql.*;

import static com.example.DBConnect.DBConnection.alertMessage;

public class AppLook extends Application {


    @Override
    public void start(Stage stage) {

        Label welcome = new Label("Welcome");
        Label userField = new Label("User Name:");
        Label passwordField = new Label("Password:");
        TextField userText = new TextField();
        PasswordField passwordText = new PasswordField();
        Button signIn = new Button("Sign In");
        Label message = new Label();

        welcome.setFont(Font.font("", FontWeight.BOLD, FontPosture.REGULAR, 18));


        GridPane gp = new GridPane();

        gp.getRowConstraints().add(new RowConstraints(30));
        gp.getRowConstraints().add(new RowConstraints(30));
        gp.getRowConstraints().add(new RowConstraints(30));
        gp.getRowConstraints().add(new RowConstraints(30));
        gp.getRowConstraints().add(new RowConstraints(30));
        gp.getColumnConstraints().add(new ColumnConstraints(100));
        gp.getColumnConstraints().add(new ColumnConstraints(200));

        gp.setGridLinesVisible(false);
        GridPane.setColumnIndex(welcome, 1);
        GridPane.setColumnIndex(userField, 0);
        GridPane.setColumnIndex(userText, 1);
        GridPane.setRowIndex(welcome, 1);
        GridPane.setRowIndex(userField, 2);
        GridPane.setRowIndex(userText, 2);
        GridPane.setColumnIndex(passwordField, 0);
        GridPane.setColumnIndex(passwordText, 1);
        GridPane.setRowIndex(passwordField, 3);
        GridPane.setRowIndex(passwordText, 3);
        GridPane.setColumnIndex(message, 1);
        GridPane.setRowIndex(message, 5);

        gp.setAlignment(Pos.CENTER);

        HBox hb = new HBox(10, signIn);
        hb.setAlignment(Pos.CENTER_RIGHT);
        GridPane.setColumnIndex(hb, 1);
        GridPane.setRowIndex(hb, 4);

        gp.getChildren().addAll(welcome, userField, userText, passwordField, passwordText, hb, message);



         signIn.setOnAction(aE -> {
                    String enteredUserName = userText.getText();
                    String enteredPassword = passwordText.getText();

             try {
                 Connection connection = DBConnection.DBconnect();
                 String sql = "SELECT * FROM users WHERE name = ? AND password = ?";
                 PreparedStatement statement = connection.prepareStatement(sql);
                 statement.setString(1, enteredUserName);
                 statement.setString(2, enteredPassword);
                 ResultSet resultSet = statement.executeQuery();

                 if (resultSet.next()) {
                     Stage stageDB = new Stage();
                     stageDB.showAndWait();
                     message.setText("Success!");

                 } else {
                     alertMessage();
                 }

                 resultSet.close();
                 statement.close();
                 connection.close();
             } catch (SQLException e) {
                 e.printStackTrace();
             }
         });


        Scene scene = new Scene(gp, 400, 300);
        stage.setTitle("JavaFX Welcome");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
