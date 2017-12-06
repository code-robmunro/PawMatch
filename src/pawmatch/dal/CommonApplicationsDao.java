package pawmatch.dal;

import pawmatch.dal.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import pawmatch.mappers.CommonAppsMapper;
import pawmatch.model.CommonApplications;

/**
 * Created by Robert Munro on 11/12/2017.
 */
public class CommonApplicationsDao {

  private ConnectionManager connectionManager;
  private static CommonApplicationsDao instance = null;

  private CommonApplicationsDao() {
    connectionManager = new ConnectionManager();
  }

  public static CommonApplicationsDao getInstance() {
    if(instance == null) {
      instance = new CommonApplicationsDao();
    }
    return instance;
  }

  public CommonApplications create(CommonApplications commonApp) throws SQLException {
    String insertCommonApp =
        "INSERT INTO CommonApplications(ApplicationBody, UserId) VALUES(?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    ResultSet resultKey = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertCommonApp, Statement.RETURN_GENERATED_KEYS);
      insertStmt.setString(1, commonApp.getApplicationBody());
      insertStmt.setInt(2, commonApp.getUserId());
      insertStmt.executeUpdate();

      // Retrieve the auto-generated key and set it, so it can be used by the caller
      resultKey = insertStmt.getGeneratedKeys();
      int commonAppId = -1;
      if (resultKey.next()) {
        commonAppId = resultKey.getInt(1);
      } else {
        throw new SQLException("Unable to retrieve auto-generated key.");
      }
      commonApp.setCommonApplicationId(commonAppId);
      return commonApp;
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
  
  public CommonApplications delete(CommonApplications commonApp) throws SQLException {
    String deleteCommonApp = "DELETE FROM CommonApplications WHERE CommonApplicationId=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteCommonApp);
      deleteStmt.setInt(1, commonApp.getCommonApplicationId());
      deleteStmt.executeUpdate();

      // Return null so the caller can no longer operate on the CommonApplications instance.
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

  public CommonApplications updateApplication(CommonApplications app, String newAppBody) throws SQLException {
    String updateApp = "UPDATE CommonApplications SET ApplicationBody=? WHERE CommonApplicationId=?;";
    Connection connection = null;
    PreparedStatement updateStmt = null;
    try {
      connection = connectionManager.getConnection();
      updateStmt = connection.prepareStatement(updateApp);
      updateStmt.setString(1, newAppBody);
      updateStmt.setInt(2, app.getCommonApplicationId());
      updateStmt.executeUpdate();

      app.setApplicationBody(newAppBody);
      return app;
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if(connection != null) {
        connection.close();
      }
      if(updateStmt != null) {
        updateStmt.close();
      }
    }
  }

  public CommonApplications getcommonAppByUserId(int userId) throws SQLException {
    String selectcommonApp =
        "SELECT * FROM CommonApplications WHERE userId=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectcommonApp);
      selectStmt.setInt(1, userId);
      results = selectStmt.executeQuery();
      if(results.next()) {
        CommonApplications commonApp = new CommonAppsMapper().mapRow(results);
        return commonApp;     
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
