package tsoha.divelog.database;

import java.sql.*;
import javax.naming.NamingException;

/**
 *
 * @author jani
 */
public class DatabaseQuery {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private DatabaseAccess database;

    public DatabaseQuery() throws SQLException, NamingException {
        this.database = new DatabaseAccess();
    }

    public PreparedStatement query(String sql) throws SQLException, Exception {
        try {
            connection = database.connect();
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException ex) {
            throw ex;
        }
        return preparedStatement;
    }

    public void closeConnection() throws SQLException, Exception {
        this.connection.close();
    }
}
