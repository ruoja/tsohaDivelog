package tsoha.divelog.database;

import java.sql.*;

/**
 *
 * @author jani
 */
public class DatabaseAccess {

    private Connection connection = null;
    private final String USER = "janiruot";
    private final String PSWD = "password";
    private final String DB_DRIVER = "org.postgresql.Driver"; //"com.mysql.jdbc.Driver";
    private final String DB_PATH = "jdbc:postgresql://localhost/janiruot"; //"jdbc:mysql://localhost/divelog";

    public Connection connectDatabase() throws Exception {
        if (!isOpen()) {
            try {
                Class.forName(DB_DRIVER);
                connection = DriverManager.getConnection(DB_PATH, USER, PSWD);
                return connection;
            } catch (Exception e) {
                throw e;
            }
        } else {
            return getConnection();
        }
    }

    public void closeConnection() throws Exception {
        try {
            this.connection.close();
        } catch (Exception e) {
            throw e;
        }
    }

    private Connection getConnection() {
        return this.connection;
    }

    private boolean isOpen() {
        if (this.connection == null) {
            return false;
        }
        return true;
    }
}
