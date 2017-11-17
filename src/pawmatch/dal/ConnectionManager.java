package pawmatch.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by irenakushner on 11/15/17.
 */
public class ConnectionManager {

  private final String user = "root";
  private final String password = "password";
  private final String hostName = "localhost";
  private final int port= 3306;
  private final String schema = "PawMatch";

  /** Get the connection to the database instance. */
  public Connection getConnection() throws SQLException {
    Connection connection = null;
    try {
      Properties connectionProperties = new Properties();
      connectionProperties.put("user", this.user);
      connectionProperties.put("password", this.password);
      try {
        Class.forName("com.mysql.jdbc.Driver");
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
        throw new SQLException(e);
      }
      connection = DriverManager.getConnection(
          "jdbc:mysql://" + this.hostName + ":" + this.port + "/" + this.schema + "?useSSL=false",
          connectionProperties);
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    }
    return connection;
  }

  /** Close the connection to the database instance. */
  public void closeConnection(Connection connection) throws SQLException {
    try {
      connection.close();
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    }
  }
}
