package pawmatch.model;
import pawmatch.model.Enums.*;

/**
 * Created by Robert Munro on 11/12/2017.
 */
public class PetProfiles {

  private Integer petProfileId;
  private Species species;
  private Sex sex;
  private String breed;
  private Age age;
  private Size size;
  private Boolean houseTrained;
  private CoatLength coatLength;
  private Integer location;
  private Boolean shelteredLonger;
  private Integer picturesId;
  private Integer videosId;
  private Integer shelterProfileId;

  // Constructor with petProfileId
  public PetProfiles(Integer petProfileId, Species species, Sex sex, String breed, Age age, Size
      size, Boolean houseTrained, CoatLength coatLength, Integer location, Boolean
      shelteredLonger, Integer picturesId, Integer videosId, Integer shelterProfileId) {
    this.petProfileId = petProfileId;
    this.species = species;
    this.sex = sex;
    this.breed = breed;
    this.age = age;
    this.size = size;
    this.houseTrained = houseTrained;
    this.coatLength = coatLength;
    this.location = location;
    this.shelteredLonger = shelteredLonger;
    this.picturesId = picturesId;
    this.videosId = videosId;
    this.shelterProfileId = shelterProfileId;
  }

  // Constructor without shelterProfileId
  public PetProfiles(Species species, Sex sex, String breed, Age age, Size size, Boolean
      houseTrained, CoatLength coatLength, Integer location, Boolean shelteredLonger, Integer
      picturesId, Integer videosId, Integer shelterProfileId) {
    this.species = species;
    this.sex = sex;
    this.breed = breed;
    this.age = age;
    this.size = size;
    this.houseTrained = houseTrained;
    this.coatLength = coatLength;
    this.location = location;
    this.shelteredLonger = shelteredLonger;
    this.picturesId = picturesId;
    this.videosId = videosId;
    this.shelterProfileId = shelterProfileId;
  }

  public Integer getPetProfileId() {
    return petProfileId;
  }

  public void setPetProfileId(Integer petProfileId) {
    this.petProfileId = petProfileId;
  }

  public Species getSpecies() {
    return species;
  }

  public void setSpecies(Species species) {
    this.species = species;
  }

  public Sex getSex() {
    return sex;
  }

  public void setSex(Sex sex) {
    this.sex = sex;
  }

  public String getBreed() {
    return breed;
  }

  public void setBreed(String breed) {
    this.breed = breed;
  }

  public Age getAge() {
    return age;
  }

  public void setAge(Age age) {
    this.age = age;
  }

  public Size getSize() {
    return size;
  }

  public void setSize(Size size) {
    this.size = size;
  }

  public Boolean getHouseTrained() {
    return houseTrained;
  }

  public void setHouseTrained(Boolean houseTrained) {
    this.houseTrained = houseTrained;
  }

  public CoatLength getCoatLength() {
    return coatLength;
  }

  public void setCoatLength(CoatLength coatLength) {
    this.coatLength = coatLength;
  }

  public Integer getLocation() {
    return location;
  }

  public void setLocation(Integer location) {
    this.location = location;
  }

  public Boolean getShelteredLonger() {
    return shelteredLonger;
  }

  public void setShelteredLonger(Boolean shelteredLonger) {
    this.shelteredLonger = shelteredLonger;
  }

  public Integer getPicturesId() {
    return picturesId;
  }

  public void setPicturesId(Integer picturesId) {
    this.picturesId = picturesId;
  }

  public Integer getVideosId() {
    return videosId;
  }

  public void setVideosId(Integer videosId) {
    this.videosId = videosId;
  }

  public Integer getShelterProfileId() {
    return shelterProfileId;
  }

  public void setShelterProfileId(Integer shelterProfileId) {
    this.shelterProfileId = shelterProfileId;
  }

  @Override
  public String toString() {
    return "PetProfiles{" +
        "petProfileId=" + petProfileId +
        ", species=" + species +
        ", sex=" + sex +
        ", breed='" + breed + '\'' +
        ", age=" + age +
        ", size=" + size +
        ", houseTrained=" + houseTrained +
        ", coatLength=" + coatLength +
        ", location=" + location +
        ", shelteredLonger=" + shelteredLonger +
        ", picturesId=" + picturesId +
        ", videosId=" + videosId +
        ", shelterProfileId=" + shelterProfileId +
        '}';
  }
}
