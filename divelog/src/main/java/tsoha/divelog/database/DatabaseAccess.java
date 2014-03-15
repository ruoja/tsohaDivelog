package tsoha.divelog.database;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author jani
 */
public class DatabaseAccess{
    
    InitialContext cxt;
    DataSource connectionPool;

    public DatabaseAccess() throws SQLException, NamingException{
        this.cxt = new InitialContext();
        this.connectionPool = (DataSource) cxt.lookup("java:/comp/env/jdbc/tietokanta");
    }

    public Connection connect() throws SQLException {
         Connection connection = connectionPool.getConnection();
         return connection;
    }
    

    /**private Connection connection = null;
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
    }**/
}
