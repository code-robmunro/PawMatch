#  TODO fill in ShelteredLonger, PicturesId, VideosId, ShelterProfileId
INSERT INTO PetProfiles (
Species, Sex, Breed, Age, Size, HouseTrained, CoatLength, Location)
		(SELECT Species, Sex, Breed, Age, Size, HouseTrained, CoatLength, AnimalLocation
        FROM Animals 
        WHERE Age IN ('Adult', 'Baby', 'Senior', 'Young', '')
			AND CoatLength IN ('Short', 'Medium', 'Long', '')
            AND Sex IN ('Male', 'Female', '')
        );