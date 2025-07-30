package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class H2ConnectionTest {
    private String jdbcURL = "jdbc:h2:./src/db/test"; // Stored in user home directory
    private String username = "sa";
    private String password = "";

    public H2ConnectionTest() {

    }

    void createTable() {
        try (Connection conn = DriverManager.getConnection(jdbcURL, username, password);
             Statement stmt = conn.createStatement()) {
            System.out.println("Connected to H2 database!");

            String sql = """
                    CREATE TABLE COMPANY (
                        ID INT PRIMARY KEY,
                        NAME VARCHAR(255) NOT NULL
                    );
                    """;
            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
