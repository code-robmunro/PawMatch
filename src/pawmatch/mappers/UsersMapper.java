package pawmatch.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import pawmatch.model.Users;

/**
 * Created by irenakushner on 12/5/17.
 */
public class UsersMapper extends AbstractMapper {

  public Users mapRow(ResultSet results) throws SQLException {

    int id = results.getInt("UserId");
    String userName  = results.getString("UserName");
    String firstName  = results.getString("FirstName");
    String lastName  = results.getString("LastName");
    String email  = results.getString("Email");
    String password  = results.getString("Password");
    int simpleId  = results.getInt("SimplePreferencesId");
    int detailedId  = results.getInt("DetailedPreferencesId");
    boolean notifications = results.getBoolean("NotificationsOn");
    boolean foster = results.getBoolean("Foster");

    Users user = new Users(id, userName, firstName, lastName, email, password, simpleId,
        detailedId, notifications, foster);

    return user;
  }

  public UsersMapper() {
  }
}
