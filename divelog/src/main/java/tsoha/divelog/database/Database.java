package tsoha.divelog.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author jani
 */
public final class Database {

    InitialContext cxt;
    DataSource connectionPool;
    Connection connection;
    PreparedStatement preparedStatement;

     public Database() throws SQLException, NamingException {
        this.cxt = new InitialContext();
        this.connectionPool = (DataSource) cxt.lookup("java:/comp/env/jdbc/janiruot");
    }

    public PreparedStatement query(String sql) throws SQLException, Exception {
        try {
            connection = connectionPool.getConnection();
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException ex) {
            throw ex;
        }
        return preparedStatement;
    }
    
    public void closeConnection() throws SQLException {
        this.connection.close();
    }
}
