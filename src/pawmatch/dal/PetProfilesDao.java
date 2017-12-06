package pawmatch.dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
        int profileId = results.getInt("PetProfileId");
        Enums.Species species = Enums.Species.valueOf(results.getString("Species").toUpperCase());
        Enums.Sex sex = Enums.Sex.valueOf(results.getString("Sex").toUpperCase());
        String breed = results.getString("Breed");
        Enums.Age age = Enums.Age.valueOf(results.getString("Age").toUpperCase());
        Enums.Size size = Enums.Size.valueOf(results.getString("Size").toUpperCase());
        boolean houseTrained = results.getBoolean("HouseTrained");
        String l = results.getString("CoatLength").length() < 1 ? "EMPTY"
            : results.getString("CoatLength");
        Enums.CoatLength coatLength = Enums.CoatLength.valueOf(l.toUpperCase());
        int location = results.getInt("Location");
        boolean shelteredLonger = results.getBoolean("ShelteredLonger");
        int picturesId = results.getInt("PicturesId");
        int videosId = results.getInt("VideosId");
        int shelterProfileId = results.getInt("ShelterProfileId");
        boolean okWithKids = results.getBoolean("OkWithKids");
        boolean okWithDogs = results.getBoolean("OkWithDogs");
        boolean okWithCats = results.getBoolean("OkWithCats");
        boolean okWithAdults = results.getBoolean("OkWithAdults");
        boolean okWithFarm = results.getBoolean("OkWithFarm");
        boolean goodWithSeniors = results.getBoolean("GoodWithSeniors");
        boolean declawed = results.getBoolean("Declawed");
        String color = results.getString("Color");
        boolean upToDate = results.getBoolean("UpToDate");
        l = results.getString("ObedienceTraining").length() < 1 ? "EMPTY"
            : results.getString("ObedienceTraining");
        Enums.ObedienceTraining obedienceTraining =
            Enums.ObedienceTraining.valueOf(l.toUpperCase());
        int fee = results.getInt("Fee");
        l = results.getString("ExerciseNeeds").length() < 1 ? "EMPTY"
            : results.getString("ExerciseNeeds");
        Enums.ExerciseNeeds exerciseNeeds = Enums.ExerciseNeeds.valueOf(l.toUpperCase());
        l = results.getString("EnergyLevel").length() < 1 ? "EMPTY"
            : results.getString("EnergyLevel");
        Enums.EnergyLevel energyLevel = Enums.EnergyLevel.valueOf(l.toUpperCase());
        l = results.getString("ActivityLevel").length() < 1 ? "EMPTY"
            : results.getString("ActivityLevel");
        Enums.ActivityLevel activityLevel = Enums.ActivityLevel.valueOf(l.toUpperCase());
        l = results.getString("GroomingNeeds").length() < 1 ? "EMPTY"
            : results.getString("GroomingNeeds");
        Enums.GroomingNeeds groomingNeeds = Enums.GroomingNeeds.valueOf(l.toUpperCase());
        l = results.getString("Shedding").length() < 1 ? "EMPTY" : results.getString("Shedding");
        Enums.Shedding shedding = Enums.Shedding.valueOf(l.toUpperCase());
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
        PetProfiles profile =
            new PetProfiles(profileId, species, sex, breed, age, size, houseTrained, coatLength,
                location, shelteredLonger, picturesId, videosId, shelterProfileId, okWithKids,
                okWithDogs, okWithCats, okWithAdults, okWithFarm, goodWithSeniors, declawed, color,
                upToDate, obedienceTraining, fee, exerciseNeeds, energyLevel, activityLevel,
                groomingNeeds, shedding, goofy, hypoallergenic, carTrained, leashTrained,
                likesToFetch, likesToys, likesSwimming, likesLaps, apartment, protective, obedient,
                playful, timidShy, independent, affectionate, eagerToPlease, evenTempered, gentle);
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
    String petsQuery = "SELECT *, \n"
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
    Connection connection = null;
    PreparedStatement queryStmt = null;
    ResultSet results = null;
    try {
      connection = this.connectionManager.getConnection();
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
        String l = results.getString("CoatLength").length() < 1 ? "EMPTY"
            : results.getString("CoatLength");
        Enums.CoatLength coatLength = Enums.CoatLength.valueOf(l.toUpperCase());

        int location = results.getInt("Location");
        boolean shelteredLonger = results.getBoolean("ShelteredLonger");
        int picturesId = results.getInt("PicturesId");
        int videosId = results.getInt("VideosId");
        int shelterProfileId = results.getInt("ShelterProfileId");
        boolean okWithKids = results.getBoolean("OkWithKids");
        boolean okWithDogs = results.getBoolean("OkWithDogs");
        boolean okWithCats = results.getBoolean("OkWithCats");
        boolean okWithAdults = results.getBoolean("OkWithAdults");
        boolean okWithFarm = results.getBoolean("OkWithFarm");
        boolean goodWithSeniors = results.getBoolean("GoodWithSeniors");
        boolean declawed = results.getBoolean("Declawed");
        String color = results.getString("Color");
        boolean upToDate = results.getBoolean("UpToDate");
        l = results.getString("ObedienceTraining").length() < 1 ? "EMPTY"
            : results.getString("ObedienceTraining");
        Enums.ObedienceTraining obedienceTraining =
            Enums.ObedienceTraining.valueOf(l.toUpperCase());
        int fee = results.getInt("Fee");
        l = results.getString("ExerciseNeeds").length() < 1 ? "EMPTY"
            : results.getString("ExerciseNeeds");
        Enums.ExerciseNeeds exerciseNeeds = Enums.ExerciseNeeds.valueOf(l.toUpperCase());
        l = results.getString("EnergyLevel").length() < 1 ? "EMPTY"
            : results.getString("EnergyLevel");
        Enums.EnergyLevel energyLevel = Enums.EnergyLevel.valueOf(l.toUpperCase());
        l = results.getString("ActivityLevel").length() < 1 ? "EMPTY"
            : results.getString("ActivityLevel");
        Enums.ActivityLevel activityLevel = Enums.ActivityLevel.valueOf(l.toUpperCase());
        l = results.getString("GroomingNeeds").length() < 1 ? "EMPTY"
            : results.getString("GroomingNeeds");
        Enums.GroomingNeeds groomingNeeds = Enums.GroomingNeeds.valueOf(l.toUpperCase());
        l = results.getString("Shedding").length() < 1 ? "EMPTY" : results.getString("Shedding");
        Enums.Shedding shedding = Enums.Shedding.valueOf(l.toUpperCase());

        boolean goofy = results.getBoolean("Goofy");
        boolean hypoallergenic = results.getBoolean("Hypoallergenic");
        boolean carTrained = results.getBoolean("CarTrained");
        boolean leashTrained = results.getBoolean("LeashTrained");
        boolean likesToFetch = results.getBoolean("LikesToFetch");
        boolean likesToys = results.getBoolean("LikesToys");
        boolean likesSwimming = results.getBoolean("LikesSwimming");
        boolean likesLaps = results.getBoolean("LikesLaps");
        boolean apartment = results.getBoolean("Apartment");
        boolean protective = results.getBoolean("Protective");
        boolean obedient = results.getBoolean("Obedient");
        boolean timidShy = results.getBoolean("TimidShy");
        boolean playful = results.getBoolean("Playful");
        boolean independent = results.getBoolean("Independent");
        boolean affectionate = results.getBoolean("Affectionate");
        boolean eagerToPlease = results.getBoolean("EagerToPlease");
        boolean evenTempered = results.getBoolean("EvenTempered");
        boolean gentle = results.getBoolean("Gentle");

        PetProfiles profile =
            new PetProfiles(profileId, species, sex, breed, age, size, housetrained, coatLength,
                location, shelteredLonger, picturesId, videosId, shelterProfileId, okWithKids,
                okWithDogs, okWithCats, okWithAdults, okWithFarm, goodWithSeniors, declawed, color,
                upToDate, obedienceTraining, fee, exerciseNeeds, energyLevel, activityLevel,
                groomingNeeds, shedding, goofy, hypoallergenic, carTrained, leashTrained,
                likesToFetch, likesToys, likesSwimming, likesLaps, apartment, protective, obedient,
                playful, timidShy, independent, affectionate, eagerToPlease, evenTempered, gentle);
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
