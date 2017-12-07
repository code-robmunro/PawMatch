package pawmatch.tools;

import java.sql.SQLException;
import java.util.List;

import pawmatch.dal.CommonApplicationsDao;
import pawmatch.dal.DetailedPreferencesDao;
import pawmatch.dal.PetProfilesDao;
import pawmatch.dal.ShelterProfilesDao;
import pawmatch.dal.SimplePreferencesDao;
import pawmatch.dal.UsersDao;
import pawmatch.model.CommonApplications;
import pawmatch.model.DetailedPreferences;
import pawmatch.model.Enums;
import pawmatch.model.PetProfiles;
import pawmatch.model.ShelterProfiles;
import pawmatch.model.SimplePreferences;
import pawmatch.model.Users;

/**
 * Created by Robert Munro on 11/12/2017.
 */
public class Injector {

  public static void main(String[] args) throws SQLException {

    /* Daos */
    CommonApplicationsDao commonAppDao = CommonApplicationsDao.getInstance();
    PetProfilesDao petProfilesDao = PetProfilesDao.getInstance();
    ShelterProfilesDao shelterProfilesDao = ShelterProfilesDao.getInstance();
    SimplePreferencesDao simplePrefsDao = SimplePreferencesDao.getInstance();
    DetailedPreferencesDao detailedPrefsDao = DetailedPreferencesDao.getInstance();
    UsersDao usersDao = UsersDao.getInstance();

    /* Insert */
    CommonApplications app1 = new CommonApplications("I love dogs", 1);
    app1 = commonAppDao.create(app1);

    ShelterProfiles shelter1 = new ShelterProfiles("A", "1 Main St", "Seattle", "WA", "1234556",
        "123@asfd", "www.asdf.com", "facebook.asdf", true, true, 1);
    shelter1 = shelterProfilesDao.create(shelter1);
/*
    PetProfiles petProfile1 = new PetProfiles(Enums.Species.DOG, Enums.Sex.FEMALE, "Labrador",
        Enums.Age.YOUNG, Enums.Size.SMALL, true, Enums.CoatLength.LONG, 98122,
        true, 1, 1, shelter1.getShelterProfileId());
    petProfile1 = petProfilesDao.create(petProfile1);
*/
    DetailedPreferences detailedPrefs1 = new DetailedPreferences( true, true,
        true, true, true,true, true,
        "brown", true, true, false, Enums.ObedienceTraining.HAS_BASIC_TRAINING,
        25, Enums.ExerciseNeeds.LOW, Enums.EnergyLevel.HIGH, Enums.ActivityLevel.EMPTY,
        Enums.GroomingNeeds.LOW, Enums.Shedding.LOW, false, true, false,
        true, false, true, false, true,
        false, true, false, true, false, true,
        false, true, false, true, 1);
    //detailedPrefs1 = detailedPrefsDao.create(detailedPrefs1);

    SimplePreferences simplePrefs1 = new SimplePreferences(Enums.Species.DOG, Enums.Sex.FEMALE, "Labrador",
        Enums.Age.YOUNG, Enums.Size.SMALL, true, Enums.CoatLength.LONG, true,
        98122, true, 1);
    simplePrefs1 = simplePrefsDao.create(simplePrefs1);

    Users user1 = new Users("ab", "a", "b", "ab@c.com",
        "asdf", 1, 1, true, true);
    user1 = usersDao.create(user1);

    /* Read */
    List<PetProfiles> profilesList = petProfilesDao.searchPetsByLocation("98122");
//    for(PetProfiles p : profilesList)
//      System.out.println(p.getPetProfileId());

    SimplePreferences user1SimplePrefs = simplePrefsDao.getSimplePrefsByUserId(1);
    System.out.println(user1SimplePrefs.toString());

    /*
    Make sure you've inserted the preference for user2:

    INSERT INTO SimplePreferences(Species, Sex, Breed, Age, Size, HouseTrained, CoatLength,
	HasMedia, Location, ShelteredLonger, UserId)
    VALUES('Dog', 'Female', 'Labrador', 'Young', null, 'Yes', 'Short', 'Yes', 94582 , null, 1);
     */
    List<PetProfiles> petsForUser2 = petProfilesDao.matchPetsToSimplePrefs(usersDao.getUserById(1));
//    for(PetProfiles p : petsForUser2)
//      System.out.println(p.getPetProfileId());

    CommonApplications updated = commonAppDao.updateApplication(app1, "I REALLY love dogs");
    //System.out.println(updated.getApplicationBody());

    /* Update */

    /* Delete */
    commonAppDao.delete(app1);
  //  petProfilesDao.delete(petProfile1);
    shelterProfilesDao.delete(shelter1);
    usersDao.delete(user1);
    simplePrefsDao.delete(simplePrefs1);
//    detailedPrefsDao.delete(detailedPrefs1);
  }
}
