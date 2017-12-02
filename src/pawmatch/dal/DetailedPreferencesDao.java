package pawmatch.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import pawmatch.model.DetailedPreferences;
import pawmatch.model.Enums;

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

  public DetailedPreferences getDetailedPrefsByUserId(int userId) throws SQLException {
    String selectDetailedprefs =
        "SELECT * FROM DetailedPreferences WHERE userId=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectDetailedprefs);
      selectStmt.setInt(1, userId);
      results = selectStmt.executeQuery();
      if(results.next()) {
        Integer detailedPreferencesId = results.getInt("DetailedPreferencesId");
        Boolean okDogs = results.getBoolean("OKWithDogs");
        Boolean okCats = results.getBoolean("OKWithCats");
        Boolean okKids = results.getBoolean("OKWithKids");
        Boolean okAdults = results.getBoolean("OKWithAdults");
        Boolean okFarm = results.getBoolean("OKWithFarm");
        Boolean seniors = results.getBoolean("GoodWithSeniors");
        Boolean declawed = results.getBoolean("Declawed");
        String color = results.getString("Color");
        Boolean upToDate = results.getBoolean("UpToDate");
        Boolean pictures = results.getBoolean("Pictures");
        Boolean videos = results.getBoolean("Videos");
        Boolean obedience = results.getBoolean("ObedienceTraining");
        Integer fee = results.getInt("Fee");
        Boolean exercise = results.getBoolean("Exercise");
        Enums.EnergyLevel energyLevel = Enums.EnergyLevel.valueOf(parseValue(results, "EnergyLevel"));
        Enums.ActivityLevel activityLevel = Enums.ActivityLevel.valueOf(parseValue(results, "ActivityLevel"));
        Boolean grooming = results.getBoolean("GroomingNeeds");
        Boolean shedding = results.getBoolean("Shedding");
        Boolean goofy = results.getBoolean("Goofy");
        Boolean hypoallergenic = results.getBoolean("Hypoallergenic");
        Boolean carTrained = results.getBoolean("CarTrained");
        Boolean leashTrained = results.getBoolean("LeashTrained");
        Boolean likesToFetch = results.getBoolean("LikesToFetch");
        Boolean likesToys = results.getBoolean("LikesToys");
        Boolean likesSwimming = results.getBoolean("LikesSwimming");
        Boolean likesLaps = results.getBoolean("LikesLaps");
        Boolean apartment = results.getBoolean("Apartment");
        Boolean protective = results.getBoolean("Protective");
        Boolean obedient = results.getBoolean("Obedient");
        Boolean playful = results.getBoolean("Playful");
        Boolean timidShy = results.getBoolean("TimidShy");
        Boolean independent = results.getBoolean("Independent");
        Boolean affectionate = results.getBoolean("Affectionate");
        Boolean eagerToPlease = results.getBoolean("EagerToPlease");
        Boolean evenTempered = results.getBoolean("EvenTempered");
        Boolean gentle = results.getBoolean("Gentle");
        Integer resultUserId = results.getInt("UserId");

        DetailedPreferences prefs = new DetailedPreferences(detailedPreferencesId, okDogs, okCats, okKids,
            okAdults, okFarm, seniors, declawed, color, upToDate, pictures, videos, obedience, fee,
            exercise, energyLevel, activityLevel, grooming, shedding, goofy, hypoallergenic, carTrained,
            leashTrained, likesToFetch, likesToys, likesSwimming, likesLaps, apartment, protective,
            obedient, playful, timidShy, independent, affectionate, eagerToPlease, evenTempered,
            gentle, resultUserId);
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
