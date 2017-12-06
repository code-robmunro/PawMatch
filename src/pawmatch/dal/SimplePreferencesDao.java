package pawmatch.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import pawmatch.mappers.SimplePreferencesMapper;
import pawmatch.model.Enums;
import pawmatch.model.SimplePreferences;

/**
 * Created by Robert Munro on 11/12/2017.
 */
public class SimplePreferencesDao {

  private ConnectionManager connectionManager;
  private static SimplePreferencesDao instance = null;

  private SimplePreferencesDao() {
    connectionManager = new ConnectionManager();
  }

  public static SimplePreferencesDao getInstance() {
    if(instance == null) {
      instance = new SimplePreferencesDao();
    }
    return instance;
  }

  public SimplePreferences create(SimplePreferences simplePreference) throws SQLException {
    String insertSimplePreference =
        "INSERT INTO SimplePreferences(`Species`,\n" +
            "`Sex`,\n" +
            "`Breed`,\n" +
            "`Age`,\n" +
            "`Size`,\n" +
            "`HouseTrained`,\n" +
            "`CoatLength`,\n" +
            "`HasMedia`,\n" +
            "`Location`,\n" +
            "`ShelteredLonger`,\n" +
            "`UserId`) VALUES(?,?,?,?,?,?,?,?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    ResultSet resultKey = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertSimplePreference, Statement.RETURN_GENERATED_KEYS);
      insertStmt.setString(1, simplePreference.getSpecies().toString());
      insertStmt.setString(2, simplePreference.getSex().toString());
      insertStmt.setString(3, simplePreference.getBreed().toString());
      insertStmt.setString(4, simplePreference.getAge().toString());
      insertStmt.setString(5, simplePreference.getSize().toString());
      insertStmt.setBoolean(6, simplePreference.getHouseTrained());
      insertStmt.setString(7, simplePreference.getCoatLength().toString());
      insertStmt.setBoolean(8, simplePreference.getHasMedia());
      insertStmt.setInt(9, simplePreference.getLocation());
      insertStmt.setBoolean(10, simplePreference.getShelteredLonger());
      insertStmt.setInt(11, simplePreference.getUserId());
      insertStmt.executeUpdate();

      // Retrieve the auto-generated key and set it, so it can be used by the caller
      resultKey = insertStmt.getGeneratedKeys();
      int simplePreferenceId = -1;
      if (resultKey.next()) {
        simplePreferenceId = resultKey.getInt(1);
      } else {
        throw new SQLException("Unable to retrieve auto-generated key.");
      }
      simplePreference.setSimplePreferencesId(simplePreferenceId);
      return simplePreference;
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

  public SimplePreferences delete(SimplePreferences simplePreference) throws SQLException {
    String deletesimplePreference = "DELETE FROM SimplePreferences WHERE simplePreferencesId=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deletesimplePreference);
      deleteStmt.setInt(1, simplePreference.getSimplePreferencesId());
      deleteStmt.executeUpdate();
      // Return null so the caller can no longer operate on the SimplePreferences instance.
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

  public SimplePreferences getSimplePrefsByUserId(int userId) throws SQLException {
    String selectsimpleprefs =
        "SELECT * FROM SimplePreferences WHERE userId=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectsimpleprefs);
      selectStmt.setInt(1, userId);
      results = selectStmt.executeQuery();
      if(results.next()) {
        SimplePreferences prefs = new SimplePreferencesMapper().mapRow(results);
        return prefs;
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
