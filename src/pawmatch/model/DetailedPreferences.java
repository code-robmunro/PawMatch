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
  private ObedienceTraining obedienceTraining;
  private Integer fee;
  private ExerciseNeeds exerciseNeeds;
  private EnergyLevel energyLevel;
  private ActivityLevel activityLevel;
  private GroomingNeeds groomingNeeds;
  private Shedding shedding;
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
      Boolean oKWithKids, Boolean oKWithAdults, Boolean oKWithFarm, Boolean goodWithSeniors,
      Boolean declawed, String color, Boolean upToDate, Boolean pictures, Boolean videos,
      ObedienceTraining obedienceTraining, Integer fee, ExerciseNeeds exerciseNeeds,
      EnergyLevel energyLevel, ActivityLevel activityLevel, GroomingNeeds groomingNeeds,
      Shedding shedding, Boolean goofy, Boolean hypoallergenic, Boolean carTrained,
      Boolean leashTrained, Boolean likesToFetch, Boolean likesToys, Boolean likesSwimming,
      Boolean likesLaps, Boolean apartment, Boolean protective, Boolean obedient, Boolean playful,
      Boolean timidShy, Boolean independent, Boolean affectionate, Boolean eagerToPlease,
      Boolean evenTempered, Boolean gentle, Integer userId) {
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
    this.exerciseNeeds = exerciseNeeds;
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
  public DetailedPreferences(Boolean oKWithDogs, Boolean oKWithCats, Boolean oKWithKids,
      Boolean oKWithAdults, Boolean oKWithFarm, Boolean goodWithSeniors, Boolean declawed,
      String color, Boolean upToDate, Boolean pictures, Boolean videos,
      ObedienceTraining obedienceTraining, Integer fee, ExerciseNeeds exerciseNeeds,
      EnergyLevel energyLevel, ActivityLevel activityLevel, GroomingNeeds groomingNeeds,
      Shedding shedding, Boolean goofy, Boolean hypoallergenic, Boolean carTrained,
      Boolean leashTrained, Boolean likesToFetch, Boolean likesToys, Boolean likesSwimming,
      Boolean likesLaps, Boolean apartment, Boolean protective, Boolean obedient, Boolean playful,
      Boolean timidShy, Boolean independent, Boolean affectionate, Boolean eagerToPlease,
      Boolean evenTempered, Boolean gentle, Integer userId) {
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
    this.exerciseNeeds = exerciseNeeds;
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
    return this.detailedPreferencesId;
  }

  public void setDetailedPreferencesId(Integer detailedPreferencesId) {
    this.detailedPreferencesId = detailedPreferencesId;
  }

  public Boolean getoKWithDogs() {
    return this.oKWithDogs;
  }

  public void setoKWithDogs(Boolean oKWithDogs) {
    this.oKWithDogs = oKWithDogs;
  }

  public Boolean getoKWithCats() {
    return this.oKWithCats;
  }

  public void setoKWithCats(Boolean oKWithCats) {
    this.oKWithCats = oKWithCats;
  }

  public Boolean getoKWithKids() {
    return this.oKWithKids;
  }

  public void setoKWithKids(Boolean oKWithKids) {
    this.oKWithKids = oKWithKids;
  }

  public Boolean getoKWithAdults() {
    return this.oKWithAdults;
  }

  public void setoKWithAdults(Boolean oKWithAdults) {
    this.oKWithAdults = oKWithAdults;
  }

  public Boolean getoKWithFarm() {
    return this.oKWithFarm;
  }

  public void setoKWithFarm(Boolean oKWithFarm) {
    this.oKWithFarm = oKWithFarm;
  }

  public Boolean getGoodWithSeniors() {
    return this.goodWithSeniors;
  }

  public void setGoodWithSeniors(Boolean goodWithSeniors) {
    this.goodWithSeniors = goodWithSeniors;
  }

  public Boolean getDeclawed() {
    return this.declawed;
  }

  public void setDeclawed(Boolean declawed) {
    this.declawed = declawed;
  }

  public String getColor() {
    return this.color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public Boolean getUpToDate() {
    return this.upToDate;
  }

  public void setUpToDate(Boolean upToDate) {
    this.upToDate = upToDate;
  }

  public Boolean getPictures() {
    return this.pictures;
  }

  public void setPictures(Boolean pictures) {
    this.pictures = pictures;
  }

  public Boolean getVideos() {
    return this.videos;
  }

  public void setVideos(Boolean videos) {
    this.videos = videos;
  }

  public ObedienceTraining getObedienceTraining() {
    return this.obedienceTraining;
  }

  public void setObedienceTraining(ObedienceTraining obedienceTraining) {
    this.obedienceTraining = obedienceTraining;
  }

  public Integer getFee() {
    return this.fee;
  }

  public void setFee(Integer fee) {
    this.fee = fee;
  }

  public ExerciseNeeds getExerciseNeeds() {
    return this.exerciseNeeds;
  }

  public void setExerciseNeeds(ExerciseNeeds exerciseNeeds) {
    this.exerciseNeeds = exerciseNeeds;
  }

  public EnergyLevel getEnergyLevel() {
    return this.energyLevel;
  }

  public void setEnergyLevel(EnergyLevel energyLevel) {
    this.energyLevel = energyLevel;
  }

  public ActivityLevel getActivityLevel() {
    return this.activityLevel;
  }

  public void setActivityLevel(ActivityLevel activityLevel) {
    this.activityLevel = activityLevel;
  }

  public GroomingNeeds getGroomingNeeds() {
    return this.groomingNeeds;
  }

  public void setGroomingNeeds(GroomingNeeds groomingNeeds) {
    this.groomingNeeds = groomingNeeds;
  }

  public Shedding getShedding() {
    return this.shedding;
  }

  public void setShedding(Shedding shedding) {
    this.shedding = shedding;
  }

  public Boolean getGoofy() {
    return this.goofy;
  }

  public void setGoofy(Boolean goofy) {
    this.goofy = goofy;
  }

  public Boolean getHypoallergenic() {
    return this.hypoallergenic;
  }

  public void setHypoallergenic(Boolean hypoallergenic) {
    this.hypoallergenic = hypoallergenic;
  }

  public Boolean getCarTrained() {
    return this.carTrained;
  }

  public void setCarTrained(Boolean carTrained) {
    this.carTrained = carTrained;
  }

  public Boolean getLeashTrained() {
    return this.leashTrained;
  }

  public void setLeashTrained(Boolean leashTrained) {
    this.leashTrained = leashTrained;
  }

  public Boolean getLikesToFetch() {
    return this.likesToFetch;
  }

  public void setLikesToFetch(Boolean likesToFetch) {
    this.likesToFetch = likesToFetch;
  }

  public Boolean getLikesToys() {
    return this.likesToys;
  }

  public void setLikesToys(Boolean likesToys) {
    this.likesToys = likesToys;
  }

  public Boolean getLikesSwimming() {
    return this.likesSwimming;
  }

  public void setLikesSwimming(Boolean likesSwimming) {
    this.likesSwimming = likesSwimming;
  }

  public Boolean getLikesLaps() {
    return this.likesLaps;
  }

  public void setLikesLaps(Boolean likesLaps) {
    this.likesLaps = likesLaps;
  }

  public Boolean getApartment() {
    return this.apartment;
  }

  public void setApartment(Boolean apartment) {
    this.apartment = apartment;
  }

  public Boolean getProtective() {
    return this.protective;
  }

  public void setProtective(Boolean protective) {
    this.protective = protective;
  }

  public Boolean getObedient() {
    return this.obedient;
  }

  public void setObedient(Boolean obedient) {
    this.obedient = obedient;
  }

  public Boolean getPlayful() {
    return this.playful;
  }

  public void setPlayful(Boolean playful) {
    this.playful = playful;
  }

  public Boolean getTimidShy() {
    return this.timidShy;
  }

  public void setTimidShy(Boolean timidShy) {
    this.timidShy = timidShy;
  }

  public Boolean getIndependent() {
    return this.independent;
  }

  public void setIndependent(Boolean independent) {
    this.independent = independent;
  }

  public Boolean getAffectionate() {
    return this.affectionate;
  }

  public void setAffectionate(Boolean affectionate) {
    this.affectionate = affectionate;
  }

  public Boolean getEagerToPlease() {
    return this.eagerToPlease;
  }

  public void setEagerToPlease(Boolean eagerToPlease) {
    this.eagerToPlease = eagerToPlease;
  }

  public Boolean getEvenTempered() {
    return this.evenTempered;
  }

  public void setEvenTempered(Boolean evenTempered) {
    this.evenTempered = evenTempered;
  }

  public Boolean getGentle() {
    return this.gentle;
  }

  public void setGentle(Boolean gentle) {
    this.gentle = gentle;
  }

  public Integer getUserId() {
    return this.userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  @Override
  public String toString() {
    return "DetailedPreferences{" + "detailedPreferencesId=" + this.detailedPreferencesId
        + ", oKWithDogs=" + this.oKWithDogs + ", oKWithCats=" + this.oKWithCats + ", oKWithKids="
        + this.oKWithKids + ", oKWithAdults=" + this.oKWithAdults + ", oKWithFarm="
        + this.oKWithFarm + ", goodWithSeniors=" + this.goodWithSeniors + ", declawed="
        + this.declawed + ", color='" + this.color + '\'' + ", upToDate=" + this.upToDate
        + ", pictures=" + this.pictures + ", videos=" + this.videos + ", obedienceTraining="
        + this.obedienceTraining + ", fee=" + this.fee + ", ExerciseNeeds=" + this.exerciseNeeds
        + ", energyLevel=" + this.energyLevel + ", activityLevel=" + this.activityLevel
        + ", groomingNeeds=" + this.groomingNeeds + ", shedding=" + this.shedding + ", goofy="
        + this.goofy + ", hypoallergenic=" + this.hypoallergenic + ", carTrained=" + this.carTrained
        + ", leashTrained=" + this.leashTrained + ", likesToFetch=" + this.likesToFetch
        + ", likesToys=" + this.likesToys + ", likesSwimming=" + this.likesSwimming + ", likesLaps="
        + this.likesLaps + ", apartment=" + this.apartment + ", protective=" + this.protective
        + ", obedient=" + this.obedient + ", playful=" + this.playful + ", timidShy="
        + this.timidShy + ", independent=" + this.independent + ", affectionate="
        + this.affectionate + ", eagerToPlease=" + this.eagerToPlease + ", evenTempered="
        + this.evenTempered + ", gentle=" + this.gentle + ", userId=" + this.userId + '}';
  }
}
