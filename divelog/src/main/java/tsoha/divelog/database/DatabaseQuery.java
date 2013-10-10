package tsoha.divelog.database;

import com.sun.rowset.JdbcRowSetImpl;
import java.sql.*;
import javax.sql.rowset.JdbcRowSet;

/**
 *
 * @author jani
 */
public class DatabaseQuery {

    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private DatabaseAccess connection;

    public DatabaseQuery() {
        this.connection = new DatabaseAccess();
    }

    public PreparedStatement query(String sql) throws SQLException, Exception {
        try {
            preparedStatement = connection.connectDatabase().prepareStatement(sql);
        } catch (SQLException ex) {
            throw ex;
        }
        return preparedStatement;
    }

    public void closeAll() throws SQLException, Exception {
        this.resultSet.close();
        this.preparedStatement.close();
        this.connection.closeConnection();
    }
}
