#  TODO fill in ShelteredLonger, PicturesId, VideosId, ShelterProfileId
INSERT INTO PetProfiles (
Species, Sex, Breed, Age, Size, HouseTrained, CoatLength, Location)
		(SELECT Species, Sex, Breed, Age, Size, HouseTrained, CoatLength, AnimalLocation
        FROM Animals 
        WHERE Age IN ('Adult', 'Baby', 'Senior', 'Young', '')
			AND CoatLength IN ('Short', 'Medium', 'Long', '')
            AND Sex IN ('Male', 'Female', '')
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
