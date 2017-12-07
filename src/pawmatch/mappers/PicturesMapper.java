package pawmatch.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import pawmatch.model.Pictures;

/**
 * Created by robertmunro on 12/5/17.
 */
public class PicturesMapper extends AbstractMapper {

  public Pictures mapRow(ResultSet results) throws SQLException {

    int id = results.getInt("PictureId");
    int petProfileId  = results.getInt("PetProfileId");
    String fullImageUrl  = results.getString("FullImageUrl");
    String thumbnailImageUrl  = results.getString("ThumbnailImageUrl");

    Pictures pic = new Pictures(id, petProfileId, fullImageUrl, thumbnailImageUrl);

    return pic;
  }

  public PicturesMapper() {
  }
}
