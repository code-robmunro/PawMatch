package pawmatch.dal;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by irenakushner on 12/1/17.
 */
public class AbstractDao {

  /*
  Parses a column value into a String that can be interpreted as an Enum.
  Handles nulls and empty strings
   */
  public String parseValue(ResultSet results, String column) throws SQLException {
    String str = (results.getString(column) == null
                  || results.getString(column).length() < 1) ? "EMPTY" : results.getString(column);
    return str.toUpperCase();
  }

}
