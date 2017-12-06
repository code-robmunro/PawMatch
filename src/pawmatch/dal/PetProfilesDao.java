package pawmatch.dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import pawmatch.mappers.PetProfilesMapper;
import pawmatch.model.Enums;
import pawmatch.model.PetProfiles;
import pawmatch.model.Users;

/**
 * Created by Robert Munro on 11/12/2017.
 */
public class PetProfilesDao extends AbstractDao {

  private ConnectionManager connectionManager;
  private static PetProfilesDao instance = null;

  private PetProfilesDao() {
    this.connectionManager = new ConnectionManager();
  }

  public static PetProfilesDao getInstance() {
    if (PetProfilesDao.instance == null) {
      PetProfilesDao.instance = new PetProfilesDao();
    }
    return PetProfilesDao.instance;
  }



  public PetProfiles create(PetProfiles petProfile) throws SQLException {
    String insertpetProfile =
        "INSERT INTO PetProfiles(Species, Sex, Breed, Age, Size, HouseTrained, CoatLength,"
            + " Location, ShelteredLonger, PicturesId, VideosId, OKWithDogs, OKWithCats, "
            + "OKWithKids, OKWithAdults, OKWithFarm, GoodWithSeniors, Declawed, Color, UpToDate, "
            + "ObedienceTraining, Fee, ExerciseNeeds, EnergyLevel, ActivityLevel, GroomingNeeds, "
            + "Shedding, Goofy, Hypoallergenic, CarTrained, LeashTrained, LikesToFetch, LikesToys, "
            + "LikesSwimming, LikesLaps, Apartment, Protective, Obedient, Playful, TimidShy, "
            + "Independent, Affectionate, EagerToPlease, EvenTempered, Gentle, ShelterProfileId) "
            + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
            + "?,?,?,?,?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    ResultSet resultKey = null;
    try {
      connection = this.connectionManager.getConnection();
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
      if (connection != null) {
        connection.close();
      }
      if (insertStmt != null) {
        insertStmt.close();
      }
      if (resultKey != null) {
        resultKey.close();
      }
    }
  }

  public PetProfiles delete(PetProfiles petProfile) throws SQLException {
    String deletepetProfile = "DELETE FROM PetProfiles WHERE PetProfileId=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = this.connectionManager.getConnection();
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
   * What animals are located near me?
   */
  public List<PetProfiles> searchPetsByLocation(int zipcode) throws SQLException {
    List<PetProfiles> profiles = new ArrayList<>();
    String findPets = "SELECT * FROM PetProfiles WHERE Location=?;";
    Connection connection = null;
    PreparedStatement queryStmt = null;
    ResultSet results = null;
    try {
      connection = this.connectionManager.getConnection();
      queryStmt = connection.prepareStatement(findPets);
      queryStmt.setInt(1, zipcode);
      results = queryStmt.executeQuery();

      while (results.next()) {
        PetProfiles profile = new PetProfilesMapper().mapRow(results);
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
   * What animals match a given user's simple preferences?
   */
  public List<PetProfiles> matchPetsToSimplePrefs(Users user) throws SQLException {
    List<PetProfiles> profiles = new ArrayList<>();
    String petsQuery = SIMPLE_PETS_QUERY;
    Connection connection = null;
    PreparedStatement queryStmt = null;
    ResultSet results = null;
    try {
      connection = this.connectionManager.getConnection();
      queryStmt = connection.prepareStatement(petsQuery);
      queryStmt.setInt(1, user.getUserId());
      results = queryStmt.executeQuery();

      while (results.next()) {
        PetProfiles profile = new PetProfilesMapper().mapRow(results);
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

  public List<PetProfiles> matchPetsToDetailedPrefs(Users user) throws SQLException {
    List<PetProfiles> profiles = new ArrayList<>();

    Connection connection = null;
    PreparedStatement queryStmt = null;
    ResultSet results = null;
    try {
      connection = this.connectionManager.getConnection();
      queryStmt = connection.prepareStatement(DETAILED_PETS_QUERY);
      queryStmt.setInt(1, user.getUserId());
      queryStmt.setInt(2, user.getUserId());
      results = queryStmt.executeQuery();

      while (results.next()) {
        PetProfiles profile = new PetProfilesMapper().mapRow(results);
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


  private static final String SELECT_ALL_FIELDS =
      "SELECT DISTINCT PetProfiles.PetProfileId, PetProfiles.Species, PetProfiles.Sex, " +
          "PetProfiles.Breed,\n" +
          " \tPetProfiles.Age, PetProfiles.size, PetProfiles.HouseTrained, PetProfiles" +
          ".CoatLength, PetProfiles.Location,\n" +
          "     PetProfiles.ShelteredLonger, PetProfiles.PicturesId, PetProfiles.VideosId, " +
          "PetProfiles.OKWithDogs,\n" +
          "     PetProfiles.OKWithCats,  PetProfiles.OKWithKids, PetProfiles.OKWithAdults, " +
          "PetProfiles.OKWithFarm, PetProfiles.GoodWithSeniors,\n" +
          "     PetProfiles.Declawed, PetProfiles.Color, PetProfiles.UpToDate, PetProfiles" +
          ".Pictures, PetProfiles.Videos,\n" +
          "     PetProfiles.ObedienceTraining, PetProfiles.Fee, PetProfiles.ExerciseNeeds, " +
          "PetProfiles.EnergyLevel,\n" +
          "     PetProfiles.ActivityLevel, PetProfiles.GroomingNeeds, PetProfiles.Shedding, " +
          "PetProfiles.Goofy,\n" +
          "     PetProfiles.Hypoallergenic, PetProfiles.CarTrained, PetProfiles.LeashTrained, " +
          "PetProfiles.LikesToFetch,\n" +
          "     PetProfiles.LikesToys, PetProfiles.LikesSwimming, PetProfiles.LikesLaps, " +
          "PetProfiles.Apartment, PetProfiles.Protective,\n" +
          "     PetProfiles.Obedient, PetProfiles.Playful, PetProfiles.TimidShy, PetProfiles" +
          ".Independent, PetProfiles.Affectionate,\n" +
          "     PetProfiles.EagerToPlease, PetProfiles.EvenTempered, PetProfiles.Gentle, " +
          "PetProfiles.ShelterProfileId,\n";

  private static final String SIMPLE_PETS_QUERY = SELECT_ALL_FIELDS
      + "\t(IF(PetProfiles.Species=User2Prefs.Species  OR User2Prefs.Species IS NULL, 1, 0)\n"
      + "\t\t+ IF(PetProfiles.Age=User2Prefs.Age OR User2Prefs.Sex IS NULL, 1, 0)\n"
      + "\t\t+ IF(PetProfiles.Size=User2Prefs.Size OR User2Prefs.Size IS NULL, 1, 0)\n"
      + "\t\t+ IF(PetProfiles.CoatLength=User2Prefs.CoatLength \n"
      + "OR User2Prefs.CoatLength IS NULL, 1, 0)\n" + "\t\t+ IF((User2Prefs.HasMedia='Yes'\n"
      + "\t\t\tAND (PetProfiles.PicturesId IS NOT NULL \n"
      + "OR PetProfiles.VideosId IS NOT NULL)) \n"
      + "\t\t\tOR User2Prefs.HasMedia IS NULL, 1, 0)) as MatchScore\n"
      + "\tFROM PetProfiles INNER JOIN \n"
      + "    (SELECT * FROM SimplePreferences WHERE UserId=?) as User2Prefs\n"
      + "    ON (PetProfiles.Species=User2Prefs.Species OR User2Prefs.Species IS NULL)\n"
      + "\t\tAND (PetProfiles.Sex=User2Prefs.Sex OR User2Prefs.Sex IS NULL)\n"
      + "\t\tAND (PetProfiles.Breed LIKE CONCAT('%', User2Prefs.Breed, '%') \n"
      + "\t\t\t\tOR User2Prefs.Breed IS NULL)\n"
      + "\t\tAND ((PetProfiles.Location - User2Prefs.Location) BETWEEN -5 AND 5\n"
      + "\t\t\tOR User2Prefs.Location IS NULL)\n" + "\tORDER BY MatchScore DESC;";

  private static final String DETAILED_PETS_QUERY =
      SELECT_ALL_FIELDS +
          "\t(IF(PetProfiles.Species=SimplePrefs.Species  OR SimplePrefs.Species IS NULL, 1, 0)\n" +
          "\t\t+ IF(PetProfiles.Age=SimplePrefs.Age OR SimplePrefs.Sex IS NULL, 1, 0)\n" +
          "\t\t+ IF(PetProfiles.Size=SimplePrefs.Size OR SimplePrefs.Size IS NULL, 1, 0)\n" +
          "\t\t+ IF(PetProfiles.CoatLength=SimplePrefs.CoatLength OR SimplePrefs.CoatLength IS " +
          "NULL, 1, 0)\n" +
          "\t\t+ IF((SimplePrefs.HasMedia='Yes'\n" +
          "\t\t\t\tAND (PetProfiles.PicturesId IS NOT NULL OR PetProfiles.VideosId IS NOT NULL)) " +
          "\n" +
          "\t\t\t\tOR SimplePrefs.HasMedia IS NULL, 1, 0)\n" +
          "\t\t#Detailed Prefs\n" +
          "\t\t+ IF(PetProfiles.Color=DetailedPrefs.Color OR DetailedPrefs.Color IS NULL, 1, 0)\n" +
          "        + IF(PetProfiles.Fee=DetailedPrefs.Fee OR DetailedPrefs.Fee IS NULL, 1, 0)\n" +
          "        + IF(PetProfiles.EnergyLevel=DetailedPrefs.EnergyLevel OR DetailedPrefs" +
          ".EnergyLevel IS NULL, 1, 0)\n" +
          "        + IF(PetProfiles.ActivityLevel=DetailedPrefs.ActivityLevel OR DetailedPrefs" +
          ".ActivityLevel IS NULL, 1, 0)\n" +
          "        + IF(PetProfiles.OKWithDogs=DetailedPrefs.OKWithDogs OR DetailedPrefs" +
          ".OKWithDogs IS NULL, 1, 0)\n" +
          "        + IF(PetProfiles.OKWithCats=DetailedPrefs.OKWithCats OR DetailedPrefs" +
          ".OKWithCats IS NULL, 1, 0)\n" +
          "        + IF(PetProfiles.OKWithKids=DetailedPrefs.OKWithKids OR DetailedPrefs" +
          ".OKWithKids IS NULL, 1, 0)\n" +
          "        + IF(PetProfiles.OKWithAdults=DetailedPrefs.OKWithAdults OR DetailedPrefs" +
          ".OKWithAdults IS NULL, 1, 0)\n" +
          "        + IF(PetProfiles.OKWithFarm=DetailedPrefs.OKWithFarm OR DetailedPrefs" +
          ".OKWithFarm IS NULL, 1, 0)\n" +
          "        + IF(PetProfiles.GoodWithSeniors=DetailedPrefs.GoodWithSeniors OR " +
          "DetailedPrefs.GoodWithSeniors IS NULL, 1, 0)\n" +
          "        + IF(PetProfiles.Declawed=DetailedPrefs.Declawed OR DetailedPrefs.Declawed IS " +
          "NULL, 1, 0)\n" +
          "        + IF(PetProfiles.UpToDate=DetailedPrefs.UpToDate OR DetailedPrefs.UpToDate IS " +
          "NULL, 1, 0)\n" +
          "        + IF(PetProfiles.ObedienceTraining=DetailedPrefs.ObedienceTraining OR " +
          "DetailedPrefs.ObedienceTraining IS NULL, 1, 0)\n" +
          "        + IF(PetProfiles.ExerciseNeeds=DetailedPrefs.ExerciseNeeds OR DetailedPrefs" +
          ".ExerciseNeeds IS NULL, 1, 0)\n" +
          "        + IF(PetProfiles.GroomingNeeds=DetailedPrefs.GroomingNeeds OR DetailedPrefs" +
          ".GroomingNeeds IS NULL, 1, 0)\n" +
          "        + IF(PetProfiles.Shedding=DetailedPrefs.Shedding OR DetailedPrefs.Shedding IS " +
          "NULL, 1, 0)\n" +
          "        + IF(PetProfiles.Goofy=DetailedPrefs.Goofy OR DetailedPrefs.Goofy IS NULL, 1, " +
          "0)\n" +
          "        + IF(PetProfiles.Hypoallergenic=DetailedPrefs.Hypoallergenic OR DetailedPrefs" +
          ".Hypoallergenic IS NULL, 1, 0)\n" +
          "        + IF(PetProfiles.CarTrained=DetailedPrefs.CarTrained OR DetailedPrefs" +
          ".CarTrained IS NULL, 1, 0)\n" +
          "        + IF(PetProfiles.LeashTrained=DetailedPrefs.LeashTrained OR DetailedPrefs" +
          ".LeashTrained IS NULL, 1, 0)\n" +
          "        + IF(PetProfiles.LikesToFetch=DetailedPrefs.LikesToFetch OR DetailedPrefs" +
          ".LikesToFetch IS NULL, 1, 0)\n" +
          "        + IF(PetProfiles.LikesToys=DetailedPrefs.LikesToys OR DetailedPrefs.LikesToys " +
          "IS NULL, 1, 0)\n" +
          "        + IF(PetProfiles.LikesSwimming=DetailedPrefs.LikesSwimming OR DetailedPrefs" +
          ".LikesSwimming IS NULL, 1, 0)\n" +
          "        + IF(PetProfiles.LikesLaps=DetailedPrefs.LikesLaps OR DetailedPrefs.LikesLaps " +
          "IS NULL, 1, 0)\n" +
          "        + IF(PetProfiles.Apartment=DetailedPrefs.Apartment OR DetailedPrefs.Apartment " +
          "IS NULL, 1, 0)\n" +
          "        + IF(PetProfiles.Protective=DetailedPrefs.Protective OR DetailedPrefs" +
          ".Protective IS NULL, 1, 0)\n" +
          "        + IF(PetProfiles.Obedient=DetailedPrefs.Obedient OR DetailedPrefs.Obedient IS " +
          "NULL, 1, 0)\n" +
          "        + IF(PetProfiles.Playful=DetailedPrefs.Playful OR DetailedPrefs.Playful IS " +
          "NULL, 1, 0)\n" +
          "        + IF(PetProfiles.TimidShy=DetailedPrefs.TimidShy OR DetailedPrefs.TimidShy IS " +
          "NULL, 1, 0)\n" +
          "        + IF(PetProfiles.Independent=DetailedPrefs.Independent OR DetailedPrefs" +
          ".Independent IS NULL, 1, 0)\n" +
          "        + IF(PetProfiles.Affectionate=DetailedPrefs.Affectionate OR DetailedPrefs" +
          ".Affectionate IS NULL, 1, 0)\n" +
          "        + IF(PetProfiles.EagerToPlease=DetailedPrefs.EagerToPlease OR DetailedPrefs" +
          ".EagerToPlease IS NULL, 1, 0)\n" +
          "        + IF(PetProfiles.EvenTempered=DetailedPrefs.EvenTempered OR DetailedPrefs" +
          ".EvenTempered IS NULL, 1, 0)\n" +
          "        + IF(PetProfiles.Gentle=DetailedPrefs.Gentle OR DetailedPrefs.Gentle IS NULL, " +
          "1, 0)\n" +
          "        ) as MatchScore\n" +
          "FROM PetProfiles INNER JOIN\n" +
          "(\n" +
          "# Combine Simple and Detailed prefs\n" +
          "\t(\n" +
          "SELECT * FROM DetailedPreferences WHERE UserId=?)as DetailedPrefs\n" +
          "    LEFT JOIN\n" +
          "    (SELECT * FROM SimplePreferences WHERE UserId=?) as SimplePrefs\n" +
          "    USING(UserId)\n" +
          "    )\n" +
          "\tON (PetProfiles.Species=SimplePrefs.Species OR SimplePrefs.Species IS NULL)\n" +
          "\t\tAND (PetProfiles.Sex=SimplePrefs.Sex OR SimplePrefs.Sex IS NULL)\n" +
          "\t\tAND (PetProfiles.Breed LIKE CONCAT('%', SimplePrefs.Breed, '%') \n" +
          "\t\t\t\tOR SimplePrefs.Breed IS NULL)\n" +
          "\t\tAND ((PetProfiles.Location - SimplePrefs.Location) BETWEEN -5 AND 5\n" +
          "\t\t\tOR SimplePrefs.Location IS NULL)\n" +
          "ORDER BY MatchScore DESC;";
}
