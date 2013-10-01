package tsoha.divelog.database;

import java.sql.*;

/**
 *
 * @author jani
 */
public class DatabaseQuery {

    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private DatabaseAccess connection;

    public PreparedStatement query(String sql) throws SQLException, Exception {
        try {
            connection = new DatabaseAccess();
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
