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
  private String location;
  private Boolean shelteredLonger;
  private Integer shelterProfileId;
  private Boolean okWithKids;
  private Boolean okWithDogs;
  private Boolean okWithCats;
  private Boolean okWithAdults;
  private Boolean okWithFarm;
  private Boolean goodWithSeniors;
  private Boolean declawed;
  private String color;
  private Boolean upToDate;
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
  private Boolean hasPictures;

  // Constructor with PetProfileId
  public PetProfiles(Integer petProfileId, Species species, Sex sex, String breed, Age age,
                     Size size, Boolean houseTrained, CoatLength coatLength, String location,
                     Boolean shelteredLonger, Integer shelterProfileId,
                     Boolean okWithKids, Boolean okWithDogs, Boolean okWithCats, Boolean okWithAdults,
                     Boolean okWithFarm, Boolean goodWithSeniors, Boolean declawed, String color, Boolean upToDate,
                     ObedienceTraining obedienceTraining, Integer fee, ExerciseNeeds exerciseNeeds,
                     EnergyLevel energyLevel, ActivityLevel activityLevel, GroomingNeeds groomingNeeds,
                     Shedding shedding, Boolean goofy, Boolean hypoallergenic, Boolean carTrained,
                     Boolean leashTrained, Boolean likesToFetch, Boolean likesToys, Boolean likesSwimming,
                     Boolean likesLaps, Boolean apartment, Boolean protective, Boolean obedient, Boolean playful,
                     Boolean timidShy, Boolean independent, Boolean affectionate, Boolean eagerToPlease,
                     Boolean evenTempered, Boolean gentle, Boolean hasPictures) {
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
    this.shelterProfileId = shelterProfileId;
    this.okWithKids = okWithKids;
    this.okWithDogs = okWithDogs;
    this.okWithCats = okWithCats;
    this.okWithAdults = okWithAdults;
    this.okWithFarm = okWithFarm;
    this.goodWithSeniors = goodWithSeniors;
    this.declawed = declawed;
    this.color = color;
    this.upToDate = upToDate;
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
    this.hasPictures = hasPictures;
  }

  // Constructor without PetProfileId
  public PetProfiles(Species species, Sex sex, String breed, Age age, Size size,
                     Boolean houseTrained, CoatLength coatLength, String location, Boolean shelteredLonger,
                     Integer shelterProfileId, Boolean okWithKids,
                     Boolean okWithDogs, Boolean okWithCats, Boolean okWithAdults, Boolean okWithFarm,
                     Boolean goodWithSeniors, Boolean declawed, String color, Boolean upToDate,
                     ObedienceTraining obedienceTraining, Integer fee, ExerciseNeeds exerciseNeeds,
                     EnergyLevel energyLevel, ActivityLevel activityLevel, GroomingNeeds groomingNeeds,
                     Shedding shedding, Boolean goofy, Boolean hypoallergenic, Boolean carTrained,
                     Boolean leashTrained, Boolean likesToFetch, Boolean likesToys, Boolean likesSwimming,
                     Boolean likesLaps, Boolean apartment, Boolean protective, Boolean obedient, Boolean playful,
                     Boolean timidShy, Boolean independent, Boolean affectionate, Boolean eagerToPlease,
                     Boolean evenTempered, Boolean gentle, Boolean hasPictures) {
    this.species = species;
    this.sex = sex;
    this.breed = breed;
    this.age = age;
    this.size = size;
    this.houseTrained = houseTrained;
    this.coatLength = coatLength;
    this.location = location;
    this.shelteredLonger = shelteredLonger;
    this.shelterProfileId = shelterProfileId;
    this.okWithKids = okWithKids;
    this.okWithDogs = okWithDogs;
    this.okWithCats = okWithCats;
    this.okWithAdults = okWithAdults;
    this.okWithFarm = okWithFarm;
    this.goodWithSeniors = goodWithSeniors;
    this.declawed = declawed;
    this.color = color;
    this.upToDate = upToDate;
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
    this.hasPictures = hasPictures;
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

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public Boolean getShelteredLonger() {
    return shelteredLonger;
  }

  public void setShelteredLonger(Boolean shelteredLonger) {
    this.shelteredLonger = shelteredLonger;
  }

  public Integer getShelterProfileId() {
    return shelterProfileId;
  }

  public void setShelterProfileId(Integer shelterProfileId) {
    this.shelterProfileId = shelterProfileId;
  }

  public Boolean getOkWithKids() {
    return okWithKids;
  }

  public void setOkWithKids(Boolean okWithKids) {
    this.okWithKids = okWithKids;
  }

  public Boolean getOkWithDogs() {
    return okWithDogs;
  }

  public void setOkWithDogs(Boolean okWithDogs) {
    this.okWithDogs = okWithDogs;
  }

  public Boolean getOkWithCats() {
    return okWithCats;
  }

  public void setOkWithCats(Boolean okWithCats) {
    this.okWithCats = okWithCats;
  }

  public Boolean getOkWithAdults() {
    return okWithAdults;
  }

  public void setOkWithAdults(Boolean okWithAdults) {
    this.okWithAdults = okWithAdults;
  }

  public Boolean getOkWithFarm() {
    return okWithFarm;
  }

  public void setOkWithFarm(Boolean okWithFarm) {
    this.okWithFarm = okWithFarm;
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

  public ObedienceTraining getObedienceTraining() {
    return obedienceTraining;
  }

  public void setObedienceTraining(ObedienceTraining obedienceTraining) {
    this.obedienceTraining = obedienceTraining;
  }

  public Integer getFee() {
    return fee;
  }

  public void setFee(Integer fee) {
    this.fee = fee;
  }

  public ExerciseNeeds getExerciseNeeds() {
    return exerciseNeeds;
  }

  public void setExerciseNeeds(ExerciseNeeds exerciseNeeds) {
    this.exerciseNeeds = exerciseNeeds;
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

  public GroomingNeeds getGroomingNeeds() {
    return groomingNeeds;
  }

  public void setGroomingNeeds(GroomingNeeds groomingNeeds) {
    this.groomingNeeds = groomingNeeds;
  }

  public Shedding getShedding() {
    return shedding;
  }

  public void setShedding(Shedding shedding) {
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

  public Boolean getHasPictures() {
    return hasPictures;
  }

  public void setHasPictures(Boolean hasPictures) {
    this.hasPictures = hasPictures;
  }
}
