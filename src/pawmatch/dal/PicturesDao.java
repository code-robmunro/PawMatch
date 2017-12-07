package pawmatch.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import pawmatch.mappers.PicturesMapper;
import pawmatch.model.Pictures;

/**
 * Created by Robert Munro on 11/12/2017.
 */
public class PicturesDao {

  private ConnectionManager connectionManager;
  private static PicturesDao instance = null;

  private PicturesDao() {
    connectionManager = new ConnectionManager();
  }

  public static PicturesDao getInstance() {
    if(instance == null) {
      instance = new PicturesDao();
    }
    return instance;
  }

  public Pictures create(Pictures picture) throws SQLException {
    String insertPicture =
        "INSERT INTO Pictures (`PetProfileId`,\n" +
            "`FullImageUrl`,\n" +
            "`ThumbnailImageUrl`) VALUES(?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    ResultSet resultKey = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertPicture, Statement.RETURN_GENERATED_KEYS);
      insertStmt.setInt(1, picture.getPetProfileId());
      insertStmt.setString(2, picture.getFullImageUrl());
      insertStmt.setString(3, picture.getThumbnailImageUrl());
      insertStmt.executeUpdate();

      // Retrieve the auto-generated key and set it, so it can be used by the caller
      resultKey = insertStmt.getGeneratedKeys();
      int pictureId = -1;
      if (resultKey.next()) {
        pictureId = resultKey.getInt(1);
      } else {
        throw new SQLException("Unable to retrieve auto-generated key.");
      }
      picture.setPictureId(pictureId);
      return picture;
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

  public Pictures delete(Pictures picture) throws SQLException {
    String deletepicture = "DELETE FROM Pictures WHERE PictureId=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deletepicture);
      deleteStmt.setInt(1, picture.getPictureId());
      deleteStmt.executeUpdate();
      // Return null so the caller can no longer operate on the Pictures instance.
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

  public Pictures getPictureById(int pictureId) throws SQLException {
    String selectPictureById =
        "SELECT * FROM Pictures WHERE pictureId=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectPictureById);
      selectStmt.setInt(1, pictureId);
      results = selectStmt.executeQuery();
      if(results.next()) {
        Pictures picture = new PicturesMapper().mapRow(results);
        return picture;
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

  public Pictures getRandomFullPicture() throws SQLException {
    String getRandomFull =
        "SELECT * FROM Pictures ORDER BY RAND() LIMIT 0,1;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(getRandomFull);
      results = selectStmt.executeQuery();
      if(results.next()) {
        Pictures picture = new PicturesMapper().mapRow(results);
        return picture;
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
