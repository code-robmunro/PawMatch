#  TODO fill in ShelteredLonger, PicturesId, VideosId, ShelterProfileId, Fee
INSERT INTO PetProfiles (
Species, Sex, Breed, Age, Size, HouseTrained, CoatLength, Location, Color, OKWithDogs, OKWithCats, OKWithKids,
	Declawed, OKWithAdults, OKWithFarm, GoodWithSeniors, UpToDate, ObedienceTraining, ExerciseNeeds,
    EnergyLevel, ActivityLevel, GroomingNeeds, Shedding, Goofy, Hypoallergenic, CarTrained, LeashTrained,
    LikesToFetch, LikesToys, LikesSwimming, LikesLaps, Apartment,  Protective, Obedient, Playful, TimidShy, 
    Independent, Affectionate, EagerToPlease, EvenTempered, Gentle)
		(SELECT Species, Sex, Breed, Age, Size, HouseTrained, CoatLength, AnimalLocation, Color, Dogs, Cats, Kids,
        Declawed, OKWithAdults, OKWithFarmAnimals, OKForSeniors, UpToDate, ObedienceTraining, ExerciseNeeds,
        EnergyLevel, ActivityLevel, GroomingNeeds, Shedding, Goofy, Hypoallergenic, GoodInCar, LeashTrained, 
        Fetches, PlaysToys, Swims, Lap, Apartment, Protective, Obedient, Playful, Timid, Independent, Affectionate,
        EagerToPlease, EvenTempered, Gentle
        FROM Animals 
        WHERE Age IN ('Adult', 'Baby', 'Senior', 'Young', '')
			AND CoatLength IN ('Short', 'Medium', 'Long', '')
            AND Sex IN ('Male', 'Female', '')
            AND (EnergyLevel IN('High', 'Low', 'Moderate', '') OR EnergyLevel IS NULL)
            AND (ActivityLevel IN('Not Active', 'Slightly Active', 'Moderately Active', 'Highly Active', '') OR ActivityLevel IS NULL)
        );
        
INSERT INTO Users (UserName, FirstName, LastName, Email, Password, SimplePreferencesId, DetailedPreferencesId, NotificationsOn, Foster)
VALUES('user1', 'a', 'b', 'a@b.com', 'asldf', 1, 1, true, false);
        
INSERT INTO SimplePreferences(Species, Sex, Breed, Age, Size, HouseTrained, CoatLength,
	HasMedia, Location, ShelteredLonger, UserId)
VALUES('Dog', 'Female', 'Labrador', 'Young', null, true, 'Short', true, 94582 , null, 1);

INSERT INTO ShelterProfiles (
Name, Address, City, State, Zip, Phone, Email, OrgUrl, FacebookUrl, MeetPets, AllowCommonApp, OrganizationId)
		(SELECT Name, Address, City, State, Zip, Phone, Email, OrgUrl, FacebookUrl, MeetPets, AllowCommonApp, OrganizationId
        FROM Organizations 
        );

CREATE TABLE temp_HasPics AS 
	SELECT PetProfiles.PetProfileId, IF(PetProfiles.PetProfileId IS NULL, FALSE, TRUE) as HasPictures
	FROM PetProfiles LEFT JOIN Pictures ON PetProfiles.PetProfileId=Pictures.PetProfileId
	GROUP BY PetProfiles.PetProfileId;

SET SQL_SAFE_UPDATES=0;

UPDATE PetProfiles
INNER JOIN temp_HasPics ON PetProfiles.PetProfileId = temp_HasPics.PetProfileId
SET PetProfiles.HasPictures = IF(temp_HasPics.HasPictures = 1, 1, 0);

SET SQL_SAFE_UPDATES=1;