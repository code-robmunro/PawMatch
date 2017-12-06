package pawmatch.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import pawmatch.model.DetailedPreferences;
import pawmatch.model.Enums;

/**
 * Created by irenakushner on 12/5/17.
 */
public class DetailedPreferencesMapper extends AbstractMapper {

  public DetailedPreferences mapRow(ResultSet results) throws SQLException {

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
    Enums.ObedienceTraining obedience = Enums.ObedienceTraining.valueOf(parseValue(results, "ObedienceTraining"));
    Integer fee = results.getInt("Fee");
    Enums.ExerciseNeeds exercise = Enums.ExerciseNeeds.valueOf(parseValue(results, "ExerciseNeeds"));
    Enums.EnergyLevel energyLevel = Enums.EnergyLevel.valueOf(parseValue(results, "EnergyLevel"));
    Enums.ActivityLevel activityLevel = Enums.ActivityLevel.valueOf(parseValue(results, "ActivityLevel"));
    Enums.GroomingNeeds grooming = Enums.GroomingNeeds.valueOf(parseValue(results, "GroomingNeeds"));
    Enums.Shedding shedding = Enums.Shedding.valueOf(parseValue(results, "Shedding"));
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

  public DetailedPreferencesMapper() {
  }

}
