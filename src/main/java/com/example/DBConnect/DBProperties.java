package com.example.DBConnect;

import java.io.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class DBProperties extends Properties {

    private static DBProperties ap;

    private DBProperties() {
    }

    public static DBProperties get() {
        if (ap == null) {
            ap = new DBProperties();
            File file = new File("src/main/resources/app.properties");
            try {
                if (file.exists()) file.createNewFile();
                ap.load(new FileInputStream(file));
            } catch (IOException ex) {

                Logger.getLogger(DBProperties.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ap;
    }
}

