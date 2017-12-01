package pawmatch.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import pawmatch.model.DetailedPreferences;

/**
 * Created by Robert Munro on 11/12/2017.
 */
public class DetailedPreferencesDao extends AbstractDao {

  private ConnectionManager connectionManager;
  private static DetailedPreferencesDao instance = null;

  private DetailedPreferencesDao() {
    connectionManager = new ConnectionManager();
  }

  public static DetailedPreferencesDao getInstance() {
    if(instance == null) {
      instance = new DetailedPreferencesDao();
    }
    return instance;
  }

  public DetailedPreferences create(DetailedPreferences detailedPreference) throws SQLException {
    String insertDetailedPreference =
        "INSERT INTO DetailedPreferences(`OKWithDogs`,\n" +
            "`OKWithCats`,\n" +
            "`OKWithKids`,\n" +
            "`OKWithAdults`,\n" +
            "`OKWithFarm`,\n" +
            "`GoodWithSeniors`,\n" +
            "`Declawed`,\n" +
            "`Color`,\n" +
            "`UpToDate`,\n" +
            "`Pictures`,\n" +
            "`Videos`,\n" +
            "`ObedienceTraining`,\n" +
            "`Fee`,\n" +
            "`ExerciseNeeds`,\n" +
            "`EnergyLevel`,\n" +
            "`ActivityLevel`,\n" +
            "`GroomingNeeds`,\n" +
            "`Shedding`,\n" +
            "`Goofy`,\n" +
            "`Hypoallergenic`,\n" +
            "`CarTrained`,\n" +
            "`LeashTrained`,\n" +
            "`LikesToFetch`,\n" +
            "`LikesToys`,\n" +
            "`LikesSwimming`,\n" +
            "`LikesLaps`,\n" +
            "`Apartment`,\n" +
            "`Protective`,\n" +
            "`Obedient`,\n" +
            "`Playful`,\n" +
            "`TimidShy`,\n" +
            "`Independent`,\n" +
            "`Affectionate`,\n" +
            "`EagerToPlease`,\n" +
            "`EvenTempered`,\n" +
            "`Gentle`,\n" +
            "`UserId`) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    ResultSet resultKey = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertDetailedPreference, Statement.RETURN_GENERATED_KEYS);
      insertStmt.setBoolean(1, detailedPreference.getoKWithDogs());
      insertStmt.setBoolean(2, detailedPreference.getoKWithCats());
      insertStmt.setBoolean(3, detailedPreference.getoKWithKids());
      insertStmt.setBoolean(4, detailedPreference.getoKWithAdults());
      insertStmt.setBoolean(5, detailedPreference.getoKWithFarm());
      insertStmt.setBoolean(6, detailedPreference.getGoodWithSeniors());
      insertStmt.setBoolean(7, detailedPreference.getDeclawed());
      insertStmt.setString(8, detailedPreference.getColor());
      insertStmt.setBoolean(9, detailedPreference.getUpToDate());
      insertStmt.setBoolean(10, detailedPreference.getPictures());
      insertStmt.setBoolean(11, detailedPreference.getVideos());
      insertStmt.setBoolean(12, detailedPreference.getObedienceTraining());
      insertStmt.setInt(13, detailedPreference.getFee());
      insertStmt.setBoolean(14, detailedPreference.getExerciseNeeds());
      insertStmt.setString(15, detailedPreference.getEnergyLevel().toString());
      insertStmt.setString(16, detailedPreference.getActivityLevel().toString());
      insertStmt.setBoolean(17, detailedPreference.getGroomingNeeds());
      insertStmt.setBoolean(18, detailedPreference.getShedding());
      insertStmt.setBoolean(19, detailedPreference.getGoofy());
      insertStmt.setBoolean(20, detailedPreference.getHypoallergenic());
      insertStmt.setBoolean(21, detailedPreference.getCarTrained());
      insertStmt.setBoolean(22, detailedPreference.getLeashTrained());
      insertStmt.setBoolean(23, detailedPreference.getLikesToFetch());
      insertStmt.setBoolean(24, detailedPreference.getLikesToys());
      insertStmt.setBoolean(25, detailedPreference.getLikesSwimming());
      insertStmt.setBoolean(26, detailedPreference.getLikesLaps());
      insertStmt.setBoolean(27, detailedPreference.getApartment());
      insertStmt.setBoolean(28, detailedPreference.getProtective());
      insertStmt.setBoolean(29, detailedPreference.getObedient());
      insertStmt.setBoolean(30, detailedPreference.getPlayful());
      insertStmt.setBoolean(31, detailedPreference.getTimidShy());
      insertStmt.setBoolean(32, detailedPreference.getIndependent());
      insertStmt.setBoolean(33, detailedPreference.getAffectionate());
      insertStmt.setBoolean(34, detailedPreference.getEagerToPlease());
      insertStmt.setBoolean(35, detailedPreference.getEvenTempered());
      insertStmt.setBoolean(36, detailedPreference.getGentle());
      insertStmt.setInt(37, detailedPreference.getUserId());
      insertStmt.executeUpdate();

      // Retrieve the auto-generated key and set it, so it can be used by the caller
      resultKey = insertStmt.getGeneratedKeys();
      int detailedPreferenceId = -1;
      if (resultKey.next()) {
        detailedPreferenceId = resultKey.getInt(1);
      } else {
        throw new SQLException("Unable to retrieve auto-generated key.");
      }
      detailedPreference.setDetailedPreferencesId(detailedPreferenceId);
      return detailedPreference;
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

  public DetailedPreferences delete(DetailedPreferences detailedPreference) throws SQLException {
    String deletedetailedPreference = "DELETE FROM DetailedPreferences WHERE DetailedPreferencesId=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deletedetailedPreference);
      deleteStmt.setInt(1, detailedPreference.getDetailedPreferencesId());
      deleteStmt.executeUpdate();
      // Return null so the caller can no longer operate on the DetailedPreferences instance.
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
