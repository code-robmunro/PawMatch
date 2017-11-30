CREATE SCHEMA IF NOT EXISTS PawMatch;
USE PawMatch;

DROP TABLE IF EXISTS Pictures;
DROP TABLE IF EXISTS Videos;
DROP TABLE IF EXISTS SimplePreferences;
DROP TABLE IF EXISTS DetailedPreferences;
DROP TABLE IF EXISTS PetProfiles;
DROP TABLE IF EXISTS ShelterProfiles;
DROP TABLE IF EXISTS CommonApplications;
DROP TABLE IF EXISTS Animals;
DROP TABLE IF EXISTS Organizations;
DROP TABLE IF EXISTS Users;

CREATE TABLE Animals (
  OrgID INTEGER,
  AnimalID INTEGER,
  Status TEXT,
  LastUpdated DATE,
  RescueID TEXT,
  Name TEXT,
  Summary TEXT,
  Species TEXT,
  Breed TEXT,
  PrimaryBreed TEXT,
  SecondaryBreed TEXT,
  Sex TEXT,
  Mixed TEXT,
  Dogs TEXT,
  Cats TEXT,
  Kids TEXT,
  Declawed TEXT,
  Housetrained TEXT,
  Age TEXT,
  Birthdate DATE,
  SpecialNeeds TEXT,
  Altered TEXT,
  Size VARCHAR(255),
  SizeCurrent DECIMAL(8,2),
  SizePotential DECIMAL(8,2),
  SizeUOM TEXT,
  Uptodate TEXT,
  Color TEXT,
  CoatLength TEXT,
  Pattern TEXT,
  Courtesy TEXT,
  Found TEXT,
  FoundDate DATE,
  FoundZipcode BIGINT,
  AnimalLocation BIGINT,
  KillDate DATE,
  KillReason TEXT,
  DescriptionPlain TEXT,
  TrackerImageUrl VARCHAR(255),
  AdoptionFee TEXT,
  OKWithAdults TEXT,
  ObedienceTraining TEXT,
  OwnerExperience TEXT,
  ExerciseNeeds TEXT,
  EnergyLevel TEXT,
  GroomingNeeds TEXT,
  YardRequired TEXT,
  Fence TEXT,
  Shedding TEXT,
  NewPeople TEXT,
  Vocal TEXT,
  ActivityLevel TEXT,
  EarType TEXT,
  EyeColor TEXT,
  TailType TEXT,
  OlderKidsOnly TEXT,
  NoSmallDogs TEXT,
  NoLargeDogs TEXT,
  NoFemaleDogs TEXT,
  NoMaleDogs TEXT,
  OKForSeniors TEXT,
  Hypoallergenic TEXT,
  GoodInCar TEXT,
  Leashtrained TEXT,
  Cratetrained TEXT,
  Fetches TEXT,
  PlaysToys TEXT,
  Swims TEXT,
  Lap TEXT,
  OKWithFarmAnimals TEXT,
  Drools TEXT,
  Apartment TEXT,
  NoHeat TEXT,
  NoCold TEXT,
  Protective TEXT,
  Escapes TEXT,
  Predatory TEXT,
  HasAllergies TEXT,
  SpecialDiet TEXT,
  OngoingMedical TEXT,
  HearingImpaired TEXT,
  SightImpaired TEXT,
  Obedient TEXT,
  Playful TEXT,
  Timid TEXT,
  Skittish TEXT,
  Independent TEXT,
  Affectionate TEXT,
  EagerToPlease TEXT,
  Intelligent TEXT,
  Eventempered TEXT,
  Gentle TEXT,
  Goofy TEXT,
  Pictures TEXT,
  Videos TEXT,
  VideoUrls TEXT,
  MediaLastUpdated VARCHAR(255),
  ContactName VARCHAR(255),
  ContactEmail TEXT,
  ContactCellPhone TEXT,
  ContactHomePhone TEXT,
  PetUrl VARCHAR(255),
  MessagePet VARCHAR(255),
  NeedsFoster TEXT,
  CONSTRAINT pk_Animals_ID PRIMARY KEY (animalID)
);

#LOAD DATA LOCAL INFILE ‘/Path/to/pet_output.csv' INTO TABLE Animals
#  FIELDS TERMINATED BY '\t'
#  LINES TERMINATED BY '\r\n'
#  IGNORE 1 LINES;

CREATE TABLE Organizations (
  OrganizationId INTEGER,
  Status TEXT,
  Name TEXT,
  Address TEXT,
  City TEXT,
  State TEXT,
  Zip TEXT,
  Country TEXT,
  Phone TEXT,
  Fax TEXT,
  Email TEXT,
  OrgUrl TEXT,
  FacebookUrl TEXT,
  OrgType TEXT,
  OrgSpecies TEXT,
  ServeAreas TEXT,
  AdoptionProcess TEXT,
  MeetPets TEXT,
  Services TEXT,
  AllowCommonApp TEXT,
  MessageOrg TEXT,
  CONSTRAINT pk_Organizations_ID PRIMARY KEY (OrganizationId)
);

#LOAD DATA LOCAL INFILE ‘/Path/to/org_output.csv' INTO #TABLE Organizations
 # FIELDS TERMINATED BY '\t'
 #LINES TERMINATED BY '\r\n'
 # IGNORE 1 LINES;

CREATE TABLE Users (
  UserId INTEGER AUTO_INCREMENT,
  UserName VARCHAR(255),
  FirstName VARCHAR(255),
  LastName VARCHAR(255),
  Email VARCHAR(255),
  Password VARCHAR(255),
  SimplePreferencesId INTEGER,
  DetailedPreferencesId INTEGER,
  NotificationsOn BOOLEAN,
  Foster BOOLEAN,
  CONSTRAINT pk_Users_ID PRIMARY KEY (UserId)
);


#LOAD DATA LOCAL INFILE ‘/Path/to/users.csv' INTO TABLE Users
#  FIELDS TERMINATED BY ','
#  LINES TERMINATED BY '\r\n' (UserName, FirstName, LastName, Email, Password, SimplePreferencesId, DetailedPreferencesId, NotificationsOn, Foster);

CREATE TABLE SimplePreferences (
  SimplePreferencesId INTEGER AUTO_INCREMENT,
  Species ENUM('Cat', 'Dog', ''),
  Sex ENUM('Female', 'Male', ''),
  Breed VARCHAR(255),
  Age ENUM('Baby', 'Young', 'Adult', 'Senior', ''),
  Size ENUM('Small', 'Medium', 'Large', 'X-Large', ''),
  HouseTrained ENUM('Yes', 'No', ''),
  CoatLength ENUM('Short', 'Medium', 'Long', ''),
  HasMedia ENUM('Yes', 'No', ''),
  Location INTEGER,
  ShelteredLonger ENUM('Yes', 'No', ''),
  UserId INTEGER,
  CONSTRAINT pk_SimplePreferences_ID PRIMARY KEY (SimplePreferencesId),
  CONSTRAINT fk_SimplePreferences_UserId
	FOREIGN KEY (UserId)
    REFERENCES Users(UserId)
    ON UPDATE CASCADE ON DELETE CASCADE
);


CREATE TABLE DetailedPreferences (
  DetailedPreferencesId INTEGER AUTO_INCREMENT,
  OKWithDogs BOOLEAN,
  OKWithCats BOOLEAN,
  OKWithKids BOOLEAN,
  OKWithAdults BOOLEAN,
  OKWithFarm BOOLEAN,
  GoodWithSeniors BOOLEAN,
  Declawed BOOLEAN,
  Color VARCHAR(255),
  UpToDate BOOLEAN,
  Pictures TEXT,
  Videos TEXT,
  ObedienceTraining ENUM('Has Basic Training','Needs Training','Well Trained', ''),
  Fee INTEGER,
  ExerciseNeeds ENUM('Low', 'Moderate', 'High', ''),
  EnergyLevel ENUM('Low', 'Moderate', 'High', ''),
  ActivityLevel ENUM('Not Active', 'Slightly Active', 'Moderately Active', 'Highly Active', ''),
  GroomingNeeds ENUM('Low', 'Moderate', 'High', ''),
  Shedding ENUM('None', 'Low', 'Moderate', 'High', ''),
  Goofy BOOLEAN,
  Hypoallergenic BOOLEAN,
  CarTrained BOOLEAN,
  LeashTrained BOOLEAN,
  LikesToFetch BOOLEAN,
  LikesToys BOOLEAN,
  LikesSwimming BOOLEAN,
  LikesLaps BOOLEAN,
  Apartment BOOLEAN,
  Protective BOOLEAN,
  Obedient BOOLEAN,
  Playful BOOLEAN,
  TimidShy BOOLEAN,
  Independent BOOLEAN,
  Affectionate BOOLEAN,
  EagerToPlease BOOLEAN,
  EvenTempered BOOLEAN,
  Gentle BOOLEAN,
  UserId INTEGER,
  CONSTRAINT pk_DetailedPreferences_ID PRIMARY KEY (DetailedPreferencesId),
  CONSTRAINT fk_DetailedPreferences_UserId
	FOREIGN KEY (UserId)
    REFERENCES Users(UserId)
    ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Pictures (
  PictureId INTEGER AUTO_INCREMENT,
  Url TEXT NOT NULL,
  Caption TEXT,
  CONSTRAINT pk_Pictures_ID PRIMARY KEY (PictureId)
);

CREATE TABLE Videos (
  VideoId INTEGER AUTO_INCREMENT,
  Url TEXT NOT NULL,
  Caption TEXT,
  Length TIME,
  CONSTRAINT pk_Videos_ID PRIMARY KEY (VideoId)
);

CREATE TABLE ShelterProfiles (
  ShelterProfileId INTEGER AUTO_INCREMENT,
  Name TEXT,
  Address TEXT,
  City TEXT,
  State TEXT,
  Zip TEXT,
  Phone TEXT,
  Email TEXT,
  OrgUrl TEXT,
  FacebookUrl TEXT,
  MeetPets TEXT,
  AllowCommonApp TEXT,
  OrganizationId INTEGER,
  CONSTRAINT pk_ShelterProfiles_ID PRIMARY KEY (ShelterProfileId),
  CONSTRAINT fk_ShelterProfiles_OrganizationId
	FOREIGN KEY (OrganizationId)
    REFERENCES Organizations(OrganizationId)
    ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE PetProfiles (
  PetProfileId INTEGER AUTO_INCREMENT,
  Species ENUM('Cat', 'Dog', ''),
  Sex ENUM('Female', 'Male', ''),
  Breed VARCHAR(255),
  Age ENUM('Baby', 'Young', 'Adult', 'Senior', ''),
  Size ENUM('Small', 'Medium', 'Large', 'X-Large', ''),
  HouseTrained BOOLEAN,
  CoatLength ENUM('Short', 'Medium', 'Long', ''),
  Location INTEGER,
  ShelteredLonger BOOLEAN,
  PicturesId INTEGER,
  VideosId INTEGER,
  ShelterProfileId INTEGER,
  CONSTRAINT pk_PetProfiles_ID PRIMARY KEY (PetProfileId),
  CONSTRAINT fk_PetProfiles_ShelterProfileId
	FOREIGN KEY (ShelterProfileId)
    REFERENCES ShelterProfiles(ShelterProfileId)
    ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE CommonApplications (
  CommonApplicationId INTEGER AUTO_INCREMENT,
  ApplicationBody TEXT NOT NULL,
  UserId INTEGER,
  CONSTRAINT pk_CommonApplications_ID PRIMARY KEY (CommonApplicationId),
  CONSTRAINT fk_CommonApplications_UserId
	FOREIGN KEY (UserId)
    REFERENCES Users(UserId)
    ON UPDATE CASCADE ON DELETE CASCADE
);
