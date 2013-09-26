package tsoha.divelog.database;

import java.sql.*;
/**
 *
 * @author jani
 */
public class DatabaseOperation {
    
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private DatabaseConnection connection;

    public DatabaseOperation() {
        connection = new DatabaseConnection();
    }
    
    public ResultSet query(String sql) throws SQLException, Exception {
        try {
            preparedStatement = connection.openConnection().prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            try {
                connection.closeConnection();
            } catch (Exception ex) {
                throw ex;
            }
        }
        return resultSet;
        
    }
    
}
