package pawmatch.model;

/**
 * Created by Robert Munro on 11/12/2017.
 */
public class Pictures {
  protected Integer PictureId;
  protected Integer PetProfileId;
  protected String FullImageUrl;
  protected String ThumbnailImageUrl;

  public Pictures(Integer pictureId, Integer petProfileId, String fullImageUrl, String thumbnailImageUrl) {
    PictureId = pictureId;
    PetProfileId = petProfileId;
    FullImageUrl = fullImageUrl;
    ThumbnailImageUrl = thumbnailImageUrl;
  }

  public Pictures(Integer petProfileId, String fullImageUrl, String thumbnailImageUrl) {
    PetProfileId = petProfileId;
    FullImageUrl = fullImageUrl;
    ThumbnailImageUrl = thumbnailImageUrl;
  }

  public Pictures() {

  }

  public Integer getPictureId() {
    return PictureId;
  }

  public void setPictureId(Integer pictureId) {
    PictureId = pictureId;
  }

  public Integer getPetProfileId() {
    return PetProfileId;
  }

  public void setPetProfileId(Integer petProfileId) {
    PetProfileId = petProfileId;
  }

  public String getFullImageUrl() {
    return FullImageUrl;
  }

  public void setFullImageUrl(String fullImageUrl) {
    FullImageUrl = fullImageUrl;
  }

  public String getThumbnailImageUrl() {
    return ThumbnailImageUrl;
  }

  public void setThumbnailImageUrl(String thumbnailImageUrl) {
    ThumbnailImageUrl = thumbnailImageUrl;
  }

  @Override
  public String toString() {
    return "Pictures{" +
        "PictureId=" + PictureId +
        ", PetProfileId=" + PetProfileId +
        ", FullImageUrl='" + FullImageUrl + '\'' +
        ", ThumbnailImageUrl='" + ThumbnailImageUrl + '\'' +
        '}';
  }
}
