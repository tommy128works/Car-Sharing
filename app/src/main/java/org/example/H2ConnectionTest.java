package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2ConnectionTest {


    public H2ConnectionTest() {

    }

    void start() {
        System.out.println("h2 start");

        String jdbcURL = "jdbc:h2:~/test"; // Stored in user home directory
        String username = "sa";
        String password = "";

        try (Connection conn = DriverManager.getConnection(jdbcURL, username, password)) {
            System.out.println("Connected to H2 database!");
            // You can now run queries using this connection
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
