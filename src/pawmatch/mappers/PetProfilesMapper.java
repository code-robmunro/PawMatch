package pawmatch.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import pawmatch.model.Enums;
import pawmatch.model.PetProfiles;

/**
 * Created by irenakushner on 12/5/17.
 */
public class PetProfilesMapper extends AbstractMapper {

  public PetProfiles mapRow(ResultSet results) throws SQLException {

    int profileId = results.getInt("PetProfileId");
    Enums.Species species = Enums.Species.valueOf(results.getString("Species").toUpperCase());
    Enums.Sex sex = Enums.Sex.lookup(results.getString("Sex").toUpperCase(), Enums.Sex.EMPTY);
    String breed = results.getString("Breed");
    Enums.Age age = Enums.Age.valueOf(parseValue(results, "Age"));
    Enums.Size size = Enums.Size.lookup(results.getString("Size").toUpperCase(), Enums.Size.EMPTY);
    boolean housetrained = results.getBoolean("HouseTrained");
    Enums.CoatLength coatLength = Enums.CoatLength.valueOf(parseValue(results, "CoatLength"));
    String location = results.getString("Location");
    boolean shelteredLonger = results.getBoolean("ShelteredLonger");
    int shelterProfileId = results.getInt("ShelterProfileId");
    boolean okWithKids = results.getBoolean("OKWithKids");
    boolean okWithDogs = results.getBoolean("OKWithDogs");
    boolean okWithCats = results.getBoolean("OKWithCats");
    boolean okWithAdults = results.getBoolean("OKWithAdults");
    boolean okWithFarm = results.getBoolean("OKWithFarm");
    boolean goodWithSeniors = results.getBoolean("GoodWithSeniors");
    boolean declawed = results.getBoolean("Declawed");
    String color = results.getString("Color");
    boolean upToDate = results.getBoolean("UpToDate");
    Enums.ObedienceTraining obedienceTraining =
        Enums.ObedienceTraining.valueOf(parseValue(results, "ObedienceTraining"));
    int fee = results.getInt("Fee");
    Enums.ExerciseNeeds exerciseNeeds = Enums.ExerciseNeeds.valueOf(parseValue(results, "ExerciseNeeds"));
    Enums.EnergyLevel energyLevel = Enums.EnergyLevel.valueOf(parseValue(results, "EnergyLevel"));
    Enums.ActivityLevel activityLevel = Enums.ActivityLevel.valueOf(parseValue(results, "ActivityLevel"));
    Enums.GroomingNeeds groomingNeeds = Enums.GroomingNeeds.valueOf(parseValue(results, "GroomingNeeds"));
    Enums.Shedding shedding = Enums.Shedding.valueOf(parseValue(results, "Shedding"));
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
    boolean hasPictures = results.getBoolean("HasPictures");

    PetProfiles profile =
        new PetProfiles(profileId, species, sex, breed, age, size, housetrained, coatLength,
            location, shelteredLonger, shelterProfileId, okWithKids,
            okWithDogs, okWithCats, okWithAdults, okWithFarm, goodWithSeniors, declawed, color,
            upToDate, obedienceTraining, fee, exerciseNeeds, energyLevel, activityLevel,
            groomingNeeds, shedding, goofy, hypoallergenic, carTrained, leashTrained,
            likesToFetch, likesToys, likesSwimming, likesLaps, apartment, protective, obedient,
            playful, timidShy, independent, affectionate, eagerToPlease, evenTempered, gentle, hasPictures);

    return profile;
  }

  public PetProfilesMapper() {

  }
}

