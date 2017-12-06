package pawmatch.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import pawmatch.model.Enums;
import pawmatch.model.SimplePreferences;

/**
 * Created by irenakushner on 12/5/17.
 */
public class SimplePreferencesMapper extends AbstractMapper {

  public SimplePreferences mapRow(ResultSet results) throws SQLException {
    Integer simplePreferencesId = results.getInt("SimplePreferencesId");
    Enums.Species species = Enums.Species.valueOf(parseValue(results, "Species"));
    Enums.Sex sex = Enums.Sex.valueOf(parseValue(results, "Sex"));
    String breed = results.getString("Breed");
    Enums.Age age = Enums.Age.valueOf(parseValue(results, "Age"));
    Enums.Size size = Enums.Size.valueOf(parseValue(results, "Size"));
    Boolean houseTrained = results.getBoolean("HouseTrained");
    Enums.CoatLength coatLength = Enums.CoatLength.valueOf(parseValue(results, "CoatLength"));
    Boolean hasMedia = results.getBoolean("HasMedia");
    Integer location = results.getInt("Location");
    Boolean shelteredLonger = results.getBoolean("ShelteredLonger");
    Integer resultUserId = results.getInt("UserId");

    SimplePreferences prefs = new SimplePreferences(simplePreferencesId, species, sex, breed, age, size,
        houseTrained, coatLength, hasMedia, location, shelteredLonger, resultUserId);

    return prefs;
  }

  public SimplePreferencesMapper() {
  }
}
