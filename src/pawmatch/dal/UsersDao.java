package pawmatch.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import pawmatch.mappers.UsersMapper;
import pawmatch.model.Users;

/**
 * Created by Robert Munro on 11/12/2017.
 */
public class UsersDao {

  private ConnectionManager connectionManager;
  private static UsersDao instance = null;

  private UsersDao() {
    connectionManager = new ConnectionManager();
  }

  public static UsersDao getInstance() {
    if(instance == null) {
      instance = new UsersDao();
    }
    return instance;
  }

  public Users create(Users user) throws SQLException {
    String insertUser =
        "INSERT INTO Users (`UserName`,\n" +
            "`FirstName`,\n" +
            "`LastName`,\n" +
            "`Email`,\n" +
            "`Password`,\n" +
            "`SimplePreferencesId`,\n" +
            "`DetailedPreferencesId`,\n" +
            "`NotificationsOn`,\n" +
            "`Foster`) VALUES(?,?,?,?,?,?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    ResultSet resultKey = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertUser, Statement.RETURN_GENERATED_KEYS);
      insertStmt.setString(1, user.getUserName());
      insertStmt.setString(2, user.getFirstName());
      insertStmt.setString(3, user.getLastName());
      insertStmt.setString(4, user.getEmail());
      insertStmt.setString(5, user.getPassword());
      insertStmt.setInt(6, user.getSimplePreferencesId());
      insertStmt.setInt(7, user.getDetailedPreferencesId());
      insertStmt.setBoolean(8, user.getNotificationsOn());
      insertStmt.setBoolean(9, user.getFoster());
      insertStmt.executeUpdate();

      // Retrieve the auto-generated key and set it, so it can be used by the caller
      resultKey = insertStmt.getGeneratedKeys();
      int userId = -1;
      if (resultKey.next()) {
        userId = resultKey.getInt(1);
      } else {
        throw new SQLException("Unable to retrieve auto-generated key.");
      }
      user.setUserId(userId);
      return user;
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if (connection != null)
        connection.close();
      if (insertStmt != null)
        insertStmt.close();
      if (resultKey != null)
        resultKey.close();
    }
  }

  public Users delete(Users user) throws SQLException {
    String deleteuser = "DELETE FROM Users WHERE UserId=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteuser);
      deleteStmt.setInt(1, user.getUserId());
      deleteStmt.executeUpdate();
      // Return null so the caller can no longer operate on the Users instance.
      return null;
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if(connection != null) {
        connection.close();
      }
      if(deleteStmt != null) {
        deleteStmt.close();
      }
    }
  }

  public Users getUserById(int userId) throws SQLException {
    String selectUser =
        "SELECT * FROM Users WHERE userId=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectUser);
      selectStmt.setInt(1, userId);
      results = selectStmt.executeQuery();
      if(results.next()) {
        Users user = new UsersMapper().mapRow(results);
        return user;
      }
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if(connection != null) {
        connection.close();
      }
      if(selectStmt != null) {
        selectStmt.close();
      }
      if(results != null) {
        results.close();
      }
    }
    return null;
  }
}
