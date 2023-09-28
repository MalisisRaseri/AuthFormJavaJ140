module com.example.authformjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires java.sql;


    opens com.example.authformjavafx to javafx.fxml;
    exports com.example.authformjavafx;
}