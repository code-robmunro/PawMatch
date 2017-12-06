package pawmatch.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import pawmatch.model.CommonApplications;

/**
 * Created by irenakushner on 12/5/17.
 */
public class CommonAppsMapper extends AbstractMapper {

  public CommonApplications mapRow(ResultSet results) throws SQLException {

    Integer commonAppId = results.getInt("CommonApplicationId");
    String appBody = results.getString("ApplicationBody");
    Integer resultUserId = results.getInt("UserId");

    CommonApplications commonApp = new CommonApplications(commonAppId, appBody, resultUserId);

    return commonApp;
  }

  public CommonAppsMapper() {
  }
}
