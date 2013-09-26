package tsoha.divelog.database;

import java.sql.*;

/**
 *
 * @author jani
 */
public class DatabaseConnection {

    private Connection connection = null;

    public DatabaseConnection() {
    }

    public Connection openConnection() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/divelog?user=root&password=password");
            return connection;
        } catch (Exception e) {
            throw e;
        }
    }

    public void closeConnection() throws Exception {
        try {
            this.connection.close();
        } catch (Exception e) {
            throw e;
        }
    }

    public Connection getConnection() {
        return this.connection;
    }

    public boolean isOpen() {
        if (this.connection == null) {
            return false;
        }
        return true;
    }
}
