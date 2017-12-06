package pawmatch.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import pawmatch.model.ShelterProfiles;

/**
 * Created by Robert Munro on 11/12/2017.
 */
public class ShelterProfilesDao {

  private ConnectionManager connectionManager;
  private static ShelterProfilesDao instance = null;

  private ShelterProfilesDao() {
    connectionManager = new ConnectionManager();
  }

  public static ShelterProfilesDao getInstance() {
    if(instance == null) {
      instance = new ShelterProfilesDao();
    }
    return instance;
  }

  public ShelterProfiles create(ShelterProfiles ShelterProfile) throws SQLException {
    String insertShelterProfile =
        "INSERT INTO ShelterProfiles(`Name`,\n" +
            "`Address`,\n" +
            "`City`,\n" +
            "`State`,\n" +
            "`Phone`,\n" +
            "`Email`,\n" +
            "`OrgUrl`,\n" +
            "`FacebookUrl`,\n" +
            "`MeetPets`,\n" +
            "`AllowCommonApp`,\n" +
            "`OrganizationId`) VALUES(?,?,?,?,?,?,?,?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    ResultSet resultKey = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertShelterProfile, Statement.RETURN_GENERATED_KEYS);
      insertStmt.setString(1, ShelterProfile.getName());
      insertStmt.setString(2, ShelterProfile.getAddress());
      insertStmt.setString(3, ShelterProfile.getCity());
      insertStmt.setString(4, ShelterProfile.getState());
      insertStmt.setString(5, ShelterProfile.getPhone());
      insertStmt.setString(6, ShelterProfile.getEmail());
      insertStmt.setString(7, ShelterProfile.getOrgUrl());
      insertStmt.setString(8, ShelterProfile.getFacebookUrl());
      insertStmt.setBoolean(9, ShelterProfile.getMeetPets());
      insertStmt.setBoolean(10, ShelterProfile.getAllowCommonApp());
      insertStmt.setInt(11, ShelterProfile.getOrganizationId());
      insertStmt.executeUpdate();

      // Retrieve the auto-generated key and set it, so it can be used by the caller
      resultKey = insertStmt.getGeneratedKeys();
      int ShelterProfileId = -1;
      if (resultKey.next()) {
        ShelterProfileId = resultKey.getInt(1);
      } else {
        throw new SQLException("Unable to retrieve auto-generated key.");
      }
      ShelterProfile.setShelterProfileId(ShelterProfileId);
      return ShelterProfile;
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

  public ShelterProfiles delete(ShelterProfiles ShelterProfile) throws SQLException {
    String deleteShelterProfile = "DELETE FROM ShelterProfiles WHERE ShelterProfileId=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteShelterProfile);
      deleteStmt.setInt(1, ShelterProfile.getShelterProfileId());
      deleteStmt.executeUpdate();
      // Return null so the caller can no longer operate on the ShelterProfiles instance.
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
}
