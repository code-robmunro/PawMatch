package pawmatch.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pawmatch.model.Enums;
import pawmatch.model.PetProfiles;
import pawmatch.model.Users;

/**
 * Created by Robert Munro on 11/12/2017.
 */
public class PetProfilesDao {

  private ConnectionManager connectionManager;
  private static PetProfilesDao instance = null;

  private PetProfilesDao() {
    connectionManager = new ConnectionManager();
  }

  public static PetProfilesDao getInstance() {
    if (instance == null) {
      instance = new PetProfilesDao();
    }
    return instance;
  }

  public PetProfiles create(PetProfiles petProfile) throws SQLException {
    String insertpetProfile =
        "INSERT INTO PetProfiles(Species, Sex, Breed, Age, Size, HouseTrained, CoatLength, Location," +
            "ShelteredLonger, PicturesId, VideosId, ShelterProfileId) VALUES(?,?,?,?,?,?,?,?,?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    ResultSet resultKey = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertpetProfile, Statement.RETURN_GENERATED_KEYS);
      insertStmt.setString(1, petProfile.getSpecies().toString());
      insertStmt.setString(2, petProfile.getSex().toString());
      insertStmt.setString(3, petProfile.getBreed().toString());
      insertStmt.setString(4, petProfile.getAge().toString());
      insertStmt.setString(5, petProfile.getSize().toString());
      insertStmt.setBoolean(6, petProfile.getHouseTrained());
      insertStmt.setString(7, petProfile.getCoatLength().toString());
      insertStmt.setInt(8, petProfile.getLocation());
      insertStmt.setBoolean(9, petProfile.getShelteredLonger());
      insertStmt.setInt(10, petProfile.getPicturesId());
      insertStmt.setInt(11, petProfile.getVideosId());
      insertStmt.setInt(12, petProfile.getShelterProfileId());
      insertStmt.executeUpdate();

      // Retrieve the auto-generated key and set it, so it can be used by the caller
      resultKey = insertStmt.getGeneratedKeys();
      int petProfileId = -1;
      if (resultKey.next()) {
        petProfileId = resultKey.getInt(1);
      } else {
        throw new SQLException("Unable to retrieve auto-generated key.");
      }
      petProfile.setPetProfileId(petProfileId);
      return petProfile;
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

  public PetProfiles delete(PetProfiles petProfile) throws SQLException {
    String deletepetProfile = "DELETE FROM PetProfiles WHERE PetProfileId=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deletepetProfile);
      deleteStmt.setInt(1, petProfile.getPetProfileId());
      deleteStmt.executeUpdate();
      // Return null so the caller can no longer operate on the PetProfiles instance.
      return null;
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if (connection != null) {
        connection.close();
      }
      if (deleteStmt != null) {
        deleteStmt.close();
      }
    }
  }

  /*
  What animals are located near me?
   */
  public List<PetProfiles> searchPetsByLocation(int zipcode) throws SQLException {
    List<PetProfiles> profiles = new ArrayList<>();
    String findPets =
        "SELECT * FROM PetProfiles WHERE Location=?;";
    Connection connection = null;
    PreparedStatement queryStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      queryStmt = connection.prepareStatement(findPets);
      queryStmt.setInt(1, zipcode);
      results = queryStmt.executeQuery();

      while (results.next()) {
        int profileId = results.getInt("PetProfileId");
        Enums.Species species = Enums.Species.valueOf(results.getString("Species").toUpperCase());
        Enums.Sex sex = Enums.Sex.valueOf(results.getString("Sex").toUpperCase());
        String breed = results.getString("Breed");
        Enums.Age age = Enums.Age.valueOf(results.getString("Age").toUpperCase());
        Enums.Size size = Enums.Size.valueOf(results.getString("Size").toUpperCase());
        boolean housetrained = results.getBoolean("HouseTrained");
        Enums.CoatLength coatLength = Enums.CoatLength.valueOf(results.getString("CoatLength").toUpperCase());
        int location = results.getInt("Location");
        boolean shelteredLonger = results.getBoolean("ShelteredLonger");
        int picturesId = results.getInt("PicturesId");
        int videosId = results.getInt("VideosId");
        int shelterProfileId = results.getInt("ShelterProfileId");
        PetProfiles profile = new PetProfiles(profileId, species, sex, breed, age, size, housetrained,
            coatLength, location, shelteredLonger, picturesId, videosId, shelterProfileId);
        profiles.add(profile);
      }
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if (connection != null) {
        connection.close();
      }
      if (queryStmt != null) {
        queryStmt.close();
      }
      if (results != null) {
        results.close();
      }
    }
    return profiles;
  }

  /*
What animals match a given user's simple preferences?
*/
  public List<PetProfiles> matchPetsToSimplePrefs(Users user) throws SQLException {
    List<PetProfiles> profiles = new ArrayList<>();
    String petsQuery = "SELECT *, \n"+
        "\t(IF(PetProfiles.ShelteredLonger=UserPrefs.ShelteredLonger  OR UserPrefs.ShelteredLonger IS NULL, 1, 0)\n"+
        "\t\t+ IF(PetProfiles.Age=UserPrefs.Age OR UserPrefs.Sex IS NULL, 1, 0)\n"+
        "\t\t+ IF(PetProfiles.Size=UserPrefs.Size OR UserPrefs.Size IS NULL, 1, 0)\n"+
        "\t\t+ IF(PetProfiles.CoatLength=UserPrefs.CoatLength \n"+
        "OR UserPrefs.CoatLength IS NULL, 1, 0)\n"+
        "\t\t+ IF((UserPrefs.HasMedia='Yes'\n"+
        "\t\t\tAND (PetProfiles.PicturesId IS NOT NULL \n"+
        "OR PetProfiles.VideosId IS NOT NULL)) \n"+
        "\t\t\tOR UserPrefs.HasMedia IS NULL, 1, 0)) as MatchScore\n"+
        "\tFROM PetProfiles INNER JOIN \n"+
        "    (SELECT * FROM SimplePreferences WHERE UserId=?) as UserPrefs\n"+
        "    ON (PetProfiles.Species=UserPrefs.Species OR UserPrefs.Species IS NULL)\n"+
        "\t\tAND (PetProfiles.Sex=UserPrefs.Sex OR UserPrefs.Sex IS NULL)\n"+
        "\t\tAND (PetProfiles.HouseTrained=UserPrefs.HouseTrained OR UserPrefs.HouseTrained IS NULL)\n"+
        "\t\tAND (PetProfiles.Breed LIKE CONCAT('%', UserPrefs.Breed, '%') \n"+
        "\t\t\t\tOR UserPrefs.Breed IS NULL)\n"+
        "\t\tAND ((PetProfiles.Location - UserPrefs.Location) BETWEEN -5 AND 5\n"+
        "\t\t\tOR UserPrefs.Location IS NULL)\n"+
        "\tORDER BY MatchScore DESC;";
    Connection connection = null;
    PreparedStatement queryStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      queryStmt = connection.prepareStatement(petsQuery);
      queryStmt.setInt(1, user.getUserId());
      results = queryStmt.executeQuery();

      while (results.next()) {
        int profileId = results.getInt("PetProfileId");
        Enums.Species species = Enums.Species.valueOf(results.getString("Species").toUpperCase());
        Enums.Sex sex = Enums.Sex.valueOf(results.getString("Sex").toUpperCase());
        String breed = results.getString("Breed");
        Enums.Age age = Enums.Age.valueOf(results.getString("Age").toUpperCase());
        Enums.Size size = Enums.Size.valueOf(results.getString("Size").toUpperCase());
        boolean housetrained = results.getBoolean("HouseTrained");

        /* This is weird but the fastest way I could make it work */
        String l = results.getString("CoatLength").length() < 1 ? "EMPTY" : results.getString("CoatLength");
        Enums.CoatLength coatLength = Enums.CoatLength.valueOf(l.toUpperCase());

        int location = results.getInt("Location");
        boolean shelteredLonger = results.getBoolean("ShelteredLonger");
        int picturesId = results.getInt("PicturesId");
        int videosId = results.getInt("VideosId");
        int shelterProfileId = results.getInt("ShelterProfileId");
        PetProfiles profile = new PetProfiles(profileId, species, sex, breed, age, size, housetrained,
            coatLength, location, shelteredLonger, picturesId, videosId, shelterProfileId);
        profiles.add(profile);
      }
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if (connection != null) {
        connection.close();
      }
      if (queryStmt != null) {
        queryStmt.close();
      }
      if (results != null) {
        results.close();
      }
    }
    return profiles;
  }

}
