package tsoha.divelog.database;

import java.sql.*;
/**
 *
 * @author jani
 */
public class DatabaseOperation {

    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private DatabaseAccess connection;

    public ResultSet query(String sql) throws SQLException, Exception {
        try {
            connection = new DatabaseAccess();
            preparedStatement = connection.connectDatabase().prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            throw ex;
        }
        return resultSet;
    }
    
    public void closeAll() throws SQLException, Exception {
        this.resultSet.close();
        this.preparedStatement.close();
        this.connection.closeConnection();
    }
}
