package pawmatch.model;
import pawmatch.model.Enums.*;

/**
 * Created by Robert Munro on 11/12/2017.
 */
public class DetailedPreferences {

  private Integer detailedPreferencesId;
  private Boolean oKWithDogs;
  private Boolean oKWithCats;
  private Boolean oKWithKids;
  private Boolean oKWithAdults;
  private Boolean oKWithFarm;
  private Boolean goodWithSeniors;
  private Boolean declawed;
  private String color;
  private Boolean upToDate;
  private Boolean pictures;
  private Boolean videos;
  private Boolean obedienceTraining;
  private Integer fee;
  private Boolean ExerciseNeeds;
  private EnergyLevel energyLevel;
  private ActivityLevel activityLevel;
  private Boolean groomingNeeds;
  private Boolean shedding;
  private Boolean goofy;
  private Boolean hypoallergenic;
  private Boolean carTrained;
  private Boolean leashTrained;
  private Boolean likesToFetch;
  private Boolean likesToys;
  private Boolean likesSwimming;
  private Boolean likesLaps;
  private Boolean apartment;
  private Boolean protective;
  private Boolean obedient;
  private Boolean playful;
  private Boolean timidShy;
  private Boolean independent;
  private Boolean affectionate;
  private Boolean eagerToPlease;
  private Boolean evenTempered;
  private Boolean gentle;
  private Integer userId;

  // Constructor with detailedPreferencesId
  public DetailedPreferences(Integer detailedPreferencesId, Boolean oKWithDogs, Boolean oKWithCats,
                             Boolean oKWithKids, Boolean oKWithAdults, Boolean oKWithFarm,
                             Boolean goodWithSeniors, Boolean declawed, String color, Boolean
                                 upToDate, Boolean pictures, Boolean videos, Boolean
                                 obedienceTraining, Integer fee, Boolean exerciseNeeds, EnergyLevel
                                 energyLevel, ActivityLevel activityLevel, Boolean groomingNeeds,
                             Boolean shedding, Boolean goofy, Boolean hypoallergenic, Boolean
                                 carTrained, Boolean leashTrained, Boolean likesToFetch, Boolean
                                 likesToys, Boolean likesSwimming, Boolean likesLaps, Boolean
                                 apartment, Boolean protective, Boolean obedient, Boolean
                                 playful, Boolean timidShy, Boolean independent, Boolean
                                 affectionate, Boolean eagerToPlease, Boolean evenTempered,
                             Boolean gentle, Integer userId) {
    this.detailedPreferencesId = detailedPreferencesId;
    this.oKWithDogs = oKWithDogs;
    this.oKWithCats = oKWithCats;
    this.oKWithKids = oKWithKids;
    this.oKWithAdults = oKWithAdults;
    this.oKWithFarm = oKWithFarm;
    this.goodWithSeniors = goodWithSeniors;
    this.declawed = declawed;
    this.color = color;
    this.upToDate = upToDate;
    this.pictures = pictures;
    this.videos = videos;
    this.obedienceTraining = obedienceTraining;
    this.fee = fee;
    ExerciseNeeds = exerciseNeeds;
    this.energyLevel = energyLevel;
    this.activityLevel = activityLevel;
    this.groomingNeeds = groomingNeeds;
    this.shedding = shedding;
    this.goofy = goofy;
    this.hypoallergenic = hypoallergenic;
    this.carTrained = carTrained;
    this.leashTrained = leashTrained;
    this.likesToFetch = likesToFetch;
    this.likesToys = likesToys;
    this.likesSwimming = likesSwimming;
    this.likesLaps = likesLaps;
    this.apartment = apartment;
    this.protective = protective;
    this.obedient = obedient;
    this.playful = playful;
    this.timidShy = timidShy;
    this.independent = independent;
    this.affectionate = affectionate;
    this.eagerToPlease = eagerToPlease;
    this.evenTempered = evenTempered;
    this.gentle = gentle;
    this.userId = userId;
  }

  // Constructor without detailedPreferencesId
  public DetailedPreferences(Boolean oKWithDogs, Boolean oKWithCats, Boolean oKWithKids, Boolean
      oKWithAdults, Boolean oKWithFarm, Boolean goodWithSeniors, Boolean declawed, String color,
                             Boolean upToDate, Boolean pictures, Boolean videos, Boolean
                                 obedienceTraining, Integer fee, Boolean exerciseNeeds, EnergyLevel
                                 energyLevel, ActivityLevel activityLevel, Boolean groomingNeeds,
                             Boolean shedding, Boolean goofy, Boolean hypoallergenic, Boolean
                                 carTrained, Boolean leashTrained, Boolean likesToFetch, Boolean
                                 likesToys, Boolean likesSwimming, Boolean likesLaps, Boolean
                                 apartment, Boolean protective, Boolean obedient, Boolean
                                 playful, Boolean timidShy, Boolean independent, Boolean
                                 affectionate, Boolean eagerToPlease, Boolean evenTempered,
                             Boolean gentle, Integer userId) {
    this.oKWithDogs = oKWithDogs;
    this.oKWithCats = oKWithCats;
    this.oKWithKids = oKWithKids;
    this.oKWithAdults = oKWithAdults;
    this.oKWithFarm = oKWithFarm;
    this.goodWithSeniors = goodWithSeniors;
    this.declawed = declawed;
    this.color = color;
    this.upToDate = upToDate;
    this.pictures = pictures;
    this.videos = videos;
    this.obedienceTraining = obedienceTraining;
    this.fee = fee;
    ExerciseNeeds = exerciseNeeds;
    this.energyLevel = energyLevel;
    this.activityLevel = activityLevel;
    this.groomingNeeds = groomingNeeds;
    this.shedding = shedding;
    this.goofy = goofy;
    this.hypoallergenic = hypoallergenic;
    this.carTrained = carTrained;
    this.leashTrained = leashTrained;
    this.likesToFetch = likesToFetch;
    this.likesToys = likesToys;
    this.likesSwimming = likesSwimming;
    this.likesLaps = likesLaps;
    this.apartment = apartment;
    this.protective = protective;
    this.obedient = obedient;
    this.playful = playful;
    this.timidShy = timidShy;
    this.independent = independent;
    this.affectionate = affectionate;
    this.eagerToPlease = eagerToPlease;
    this.evenTempered = evenTempered;
    this.gentle = gentle;
    this.userId = userId;
  }

  public Integer getDetailedPreferencesId() {
    return detailedPreferencesId;
  }

  public void setDetailedPreferencesId(Integer detailedPreferencesId) {
    this.detailedPreferencesId = detailedPreferencesId;
  }

  public Boolean getoKWithDogs() {
    return oKWithDogs;
  }

  public void setoKWithDogs(Boolean oKWithDogs) {
    this.oKWithDogs = oKWithDogs;
  }

  public Boolean getoKWithCats() {
    return oKWithCats;
  }

  public void setoKWithCats(Boolean oKWithCats) {
    this.oKWithCats = oKWithCats;
  }

  public Boolean getoKWithKids() {
    return oKWithKids;
  }

  public void setoKWithKids(Boolean oKWithKids) {
    this.oKWithKids = oKWithKids;
  }

  public Boolean getoKWithAdults() {
    return oKWithAdults;
  }

  public void setoKWithAdults(Boolean oKWithAdults) {
    this.oKWithAdults = oKWithAdults;
  }

  public Boolean getoKWithFarm() {
    return oKWithFarm;
  }

  public void setoKWithFarm(Boolean oKWithFarm) {
    this.oKWithFarm = oKWithFarm;
  }

  public Boolean getGoodWithSeniors() {
    return goodWithSeniors;
  }

  public void setGoodWithSeniors(Boolean goodWithSeniors) {
    this.goodWithSeniors = goodWithSeniors;
  }

  public Boolean getDeclawed() {
    return declawed;
  }

  public void setDeclawed(Boolean declawed) {
    this.declawed = declawed;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public Boolean getUpToDate() {
    return upToDate;
  }

  public void setUpToDate(Boolean upToDate) {
    this.upToDate = upToDate;
  }

  public Boolean getPictures() {
    return pictures;
  }

  public void setPictures(Boolean pictures) {
    this.pictures = pictures;
  }

  public Boolean getVideos() {
    return videos;
  }

  public void setVideos(Boolean videos) {
    this.videos = videos;
  }

  public Boolean getObedienceTraining() {
    return obedienceTraining;
  }

  public void setObedienceTraining(Boolean obedienceTraining) {
    this.obedienceTraining = obedienceTraining;
  }

  public Integer getFee() {
    return fee;
  }

  public void setFee(Integer fee) {
    this.fee = fee;
  }

  public Boolean getExerciseNeeds() {
    return ExerciseNeeds;
  }

  public void setExerciseNeeds(Boolean exerciseNeeds) {
    ExerciseNeeds = exerciseNeeds;
  }

  public EnergyLevel getEnergyLevel() {
    return energyLevel;
  }

  public void setEnergyLevel(EnergyLevel energyLevel) {
    this.energyLevel = energyLevel;
  }

  public ActivityLevel getActivityLevel() {
    return activityLevel;
  }

  public void setActivityLevel(ActivityLevel activityLevel) {
    this.activityLevel = activityLevel;
  }

  public Boolean getGroomingNeeds() {
    return groomingNeeds;
  }

  public void setGroomingNeeds(Boolean groomingNeeds) {
    this.groomingNeeds = groomingNeeds;
  }

  public Boolean getShedding() {
    return shedding;
  }

  public void setShedding(Boolean shedding) {
    this.shedding = shedding;
  }

  public Boolean getGoofy() {
    return goofy;
  }

  public void setGoofy(Boolean goofy) {
    this.goofy = goofy;
  }

  public Boolean getHypoallergenic() {
    return hypoallergenic;
  }

  public void setHypoallergenic(Boolean hypoallergenic) {
    this.hypoallergenic = hypoallergenic;
  }

  public Boolean getCarTrained() {
    return carTrained;
  }

  public void setCarTrained(Boolean carTrained) {
    this.carTrained = carTrained;
  }

  public Boolean getLeashTrained() {
    return leashTrained;
  }

  public void setLeashTrained(Boolean leashTrained) {
    this.leashTrained = leashTrained;
  }

  public Boolean getLikesToFetch() {
    return likesToFetch;
  }

  public void setLikesToFetch(Boolean likesToFetch) {
    this.likesToFetch = likesToFetch;
  }

  public Boolean getLikesToys() {
    return likesToys;
  }

  public void setLikesToys(Boolean likesToys) {
    this.likesToys = likesToys;
  }

  public Boolean getLikesSwimming() {
    return likesSwimming;
  }

  public void setLikesSwimming(Boolean likesSwimming) {
    this.likesSwimming = likesSwimming;
  }

  public Boolean getLikesLaps() {
    return likesLaps;
  }

  public void setLikesLaps(Boolean likesLaps) {
    this.likesLaps = likesLaps;
  }

  public Boolean getApartment() {
    return apartment;
  }

  public void setApartment(Boolean apartment) {
    this.apartment = apartment;
  }

  public Boolean getProtective() {
    return protective;
  }

  public void setProtective(Boolean protective) {
    this.protective = protective;
  }

  public Boolean getObedient() {
    return obedient;
  }

  public void setObedient(Boolean obedient) {
    this.obedient = obedient;
  }

  public Boolean getPlayful() {
    return playful;
  }

  public void setPlayful(Boolean playful) {
    this.playful = playful;
  }

  public Boolean getTimidShy() {
    return timidShy;
  }

  public void setTimidShy(Boolean timidShy) {
    this.timidShy = timidShy;
  }

  public Boolean getIndependent() {
    return independent;
  }

  public void setIndependent(Boolean independent) {
    this.independent = independent;
  }

  public Boolean getAffectionate() {
    return affectionate;
  }

  public void setAffectionate(Boolean affectionate) {
    this.affectionate = affectionate;
  }

  public Boolean getEagerToPlease() {
    return eagerToPlease;
  }

  public void setEagerToPlease(Boolean eagerToPlease) {
    this.eagerToPlease = eagerToPlease;
  }

  public Boolean getEvenTempered() {
    return evenTempered;
  }

  public void setEvenTempered(Boolean evenTempered) {
    this.evenTempered = evenTempered;
  }

  public Boolean getGentle() {
    return gentle;
  }

  public void setGentle(Boolean gentle) {
    this.gentle = gentle;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  @Override
  public String toString() {
    return "DetailedPreferences{" +
        "detailedPreferencesId=" + detailedPreferencesId +
        ", oKWithDogs=" + oKWithDogs +
        ", oKWithCats=" + oKWithCats +
        ", oKWithKids=" + oKWithKids +
        ", oKWithAdults=" + oKWithAdults +
        ", oKWithFarm=" + oKWithFarm +
        ", goodWithSeniors=" + goodWithSeniors +
        ", declawed=" + declawed +
        ", color='" + color + '\'' +
        ", upToDate=" + upToDate +
        ", pictures=" + pictures +
        ", videos=" + videos +
        ", obedienceTraining=" + obedienceTraining +
        ", fee=" + fee +
        ", ExerciseNeeds=" + ExerciseNeeds +
        ", energyLevel=" + energyLevel +
        ", activityLevel=" + activityLevel +
        ", groomingNeeds=" + groomingNeeds +
        ", shedding=" + shedding +
        ", goofy=" + goofy +
        ", hypoallergenic=" + hypoallergenic +
        ", carTrained=" + carTrained +
        ", leashTrained=" + leashTrained +
        ", likesToFetch=" + likesToFetch +
        ", likesToys=" + likesToys +
        ", likesSwimming=" + likesSwimming +
        ", likesLaps=" + likesLaps +
        ", apartment=" + apartment +
        ", protective=" + protective +
        ", obedient=" + obedient +
        ", playful=" + playful +
        ", timidShy=" + timidShy +
        ", independent=" + independent +
        ", affectionate=" + affectionate +
        ", eagerToPlease=" + eagerToPlease +
        ", evenTempered=" + evenTempered +
        ", gentle=" + gentle +
        ", userId=" + userId +
        '}';
  }
}
