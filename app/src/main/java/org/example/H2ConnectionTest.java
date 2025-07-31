package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class H2ConnectionTest {
    private String jdbcURL;
    private String username = "sa";
    private String password = "";

    public H2ConnectionTest(String databaseFileName) {
        this.jdbcURL = "jdbc:h2:./src/db/" + databaseFileName;
    }

    void createTable() {
        try (Connection conn = DriverManager.getConnection(jdbcURL, username, password);
             Statement stmt = conn.createStatement()) {
            System.out.println("Connected to H2 database!");

            String sqlDropTable = "DROP TABLE IF EXISTS COMPANY;";
            stmt.executeUpdate(sqlDropTable);
            String sqlCreateTable = """
                    CREATE TABLE COMPANY (
                        ID INT PRIMARY KEY AUTO_INCREMENT,
                        NAME VARCHAR(255) NOT NULL UNIQUE
                    );
                    """;
            stmt.executeUpdate(sqlCreateTable);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
