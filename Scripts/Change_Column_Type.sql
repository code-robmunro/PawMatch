SET SQL_SAFE_UPDATES=0;



/* Animals table
attributes changed:

Boolean
- Mixed
- Dogs 
- Cats 
- Kids
- Declawed
- Housetrained
- SpecialNeeds
- Altered
- OKWithAdults
- YardRequired
- OlderKidsOnly
- NoSmallDogs 
- NoLargeDogs
- NoFemaleDogs
- NoMaleDogs
- OKForSeniors
- OKWithFarmAnimals
- Uptodate
- Goofy
- Hypoallergenic
- GoodInCar
- Leashtrained
- Cratetrained
- Fetches
- PlaysToys
- Swims
- Lap
- Apartment
- Protective
- Obedient
- Timid 
- Independent
- Affectionate
- EagerToPlease
- Eventempered
- Gentle


Enum
- ObedienceTraining
- OwnerExperience
- Fence
- ExerciseNeeds
- GroomingNeeds
- Shedding



*/

ALTER TABLE Animals
ADD temp BOOLEAN;
UPDATE Animals 
SET 
    temp = IF(Mixed = 'Yes',
        TRUE,
        IF(Mixed='No',
            FALSE,
            NULL));
ALTER TABLE Animals 
DROP Mixed, 
CHANGE COLUMN `temp` `Mixed` BOOLEAN;

ALTER TABLE Animals
ADD temp BOOLEAN;
UPDATE Animals 
SET 
    temp = IF(Dogs = 'Yes',
        TRUE,
        IF(Dogs='No',
            FALSE,
            NULL));
ALTER TABLE Animals 
DROP Dogs, 
CHANGE COLUMN `temp` `Dogs` BOOLEAN;

ALTER TABLE Animals
ADD temp BOOLEAN;
UPDATE Animals 
SET 
    temp = IF(Cats = 'Yes',
        TRUE,
        IF(Cats='No',
            FALSE,
            NULL));
ALTER TABLE Animals 
DROP Cats, 
CHANGE COLUMN `temp` `Cats` BOOLEAN;

ALTER TABLE Animals
ADD temp BOOLEAN;
UPDATE Animals 
SET 
    temp = IF(Kids = 'Yes',
        TRUE,
        IF(Kids='No',
            FALSE,
            NULL));
ALTER TABLE Animals 
DROP Kids, 
CHANGE COLUMN `temp` `Kids` BOOLEAN;

ALTER TABLE Animals
ADD temp BOOLEAN;
UPDATE Animals 
SET 
    temp = IF(Declawed = 'Yes',
        TRUE,
        IF(Declawed='No',
            FALSE,
            NULL));
ALTER TABLE Animals 
DROP Declawed, 
CHANGE COLUMN `temp` `Declawed` BOOLEAN;

ALTER TABLE Animals
ADD temp BOOLEAN;
UPDATE Animals 
SET 
    temp = IF(Housetrained = 'Yes',
        TRUE,
        IF(Housetrained='No',
            FALSE,
            NULL));
ALTER TABLE Animals 
DROP Housetrained, 
CHANGE COLUMN `temp` `Housetrained` BOOLEAN;

ALTER TABLE Animals
ADD temp BOOLEAN;
UPDATE Animals 
SET 
    temp = IF(SpecialNeeds = 'Yes',
        TRUE,
        IF(SpecialNeeds='No',
            FALSE,
            NULL));
ALTER TABLE Animals 
DROP SpecialNeeds, 
CHANGE COLUMN `temp` `SpecialNeeds` BOOLEAN;

ALTER TABLE Animals
ADD temp BOOLEAN;
UPDATE Animals 
SET 
    temp = IF(Altered = 'Yes',
        TRUE,
        IF(Altered='No',
            FALSE,
            NULL));
ALTER TABLE Animals 
DROP Altered, 
CHANGE COLUMN `temp` `Altered` BOOLEAN;

ALTER TABLE Animals
ADD temp BOOLEAN;
UPDATE Animals 
SET 
    temp = IF(OKWithAdults = 'Yes',
        TRUE,
        IF(OKWithAdults='No',
            FALSE,
            NULL));
ALTER TABLE Animals 
DROP OKWithAdults, 
CHANGE COLUMN `temp` `OKWithAdults` BOOLEAN;

ALTER TABLE Animals
ADD temp BOOLEAN;
UPDATE Animals 
SET 
    temp = IF(OlderKidsOnly = 'Yes',
        TRUE,
        IF(OlderKidsOnly='No',
            FALSE,
            NULL));
ALTER TABLE Animals 
DROP OlderKidsOnly, 
CHANGE COLUMN `temp` `OlderKidsOnly` BOOLEAN;

ALTER TABLE Animals
ADD temp BOOLEAN;
UPDATE Animals 
SET 
    temp = IF(YardRequired = 'Yes',
        TRUE,
        IF(YardRequired='No',
            FALSE,
            NULL));
ALTER TABLE Animals 
DROP YardRequired, 
CHANGE COLUMN `temp` `YardRequired` BOOLEAN;

ALTER TABLE Animals
ADD temp BOOLEAN;
UPDATE Animals 
SET 
    temp = IF(NoSmallDogs = 'Yes',
        TRUE,
        IF(NoSmallDogs='No',
            FALSE,
            NULL));
ALTER TABLE Animals 
DROP NoSmallDogs, 
CHANGE COLUMN `temp` `NoSmallDogs` BOOLEAN;

ALTER TABLE Animals
ADD temp BOOLEAN;
UPDATE Animals 
SET 
    temp = IF(NoLargeDogs = 'Yes',
        TRUE,
        IF(NoLargeDogs='No',
            FALSE,
            NULL));
ALTER TABLE Animals 
DROP NoLargeDogs, 
CHANGE COLUMN `temp` `NoLargeDogs` BOOLEAN;

ALTER TABLE Animals
ADD temp BOOLEAN;
UPDATE Animals 
SET 
    temp = IF(NoFemaleDogs = 'Yes',
        TRUE,
        IF(NoFemaleDogs='No',
            FALSE,
            NULL));
ALTER TABLE Animals 
DROP NoFemaleDogs, 
CHANGE COLUMN `temp` `NoFemaleDogs` BOOLEAN;

ALTER TABLE Animals
ADD temp BOOLEAN;
UPDATE Animals 
SET 
    temp = IF(NoMaleDogs = 'Yes',
        TRUE,
        IF(NoMaleDogs='No',
            FALSE,
            NULL));
ALTER TABLE Animals 
DROP NoMaleDogs, 
CHANGE COLUMN `temp` `NoMaleDogs` BOOLEAN;

ALTER TABLE Animals
ADD temp BOOLEAN;
UPDATE Animals 
SET 
    temp = IF(OKForSeniors = 'Yes',
        TRUE,
        IF(OKForSeniors='No',
            FALSE,
            NULL));
ALTER TABLE Animals 
DROP OKForSeniors, 
CHANGE COLUMN `temp` `OKForSeniors` BOOLEAN;

ALTER TABLE Animals
ADD temp BOOLEAN;
UPDATE Animals 
SET 
    temp = IF(OKWithFarmAnimals = 'Yes',
        TRUE,
        IF(OKWithFarmAnimals='No',
            FALSE,
            NULL));
ALTER TABLE Animals 
DROP OKWithFarmAnimals, 
CHANGE COLUMN `temp` `OKWithFarmAnimals` BOOLEAN;

ALTER TABLE Animals
ADD temp BOOLEAN;
UPDATE Animals 
SET 
    temp = IF(Uptodate = 'Yes',
        TRUE,
        IF(Uptodate='No',
            FALSE,
            NULL));
ALTER TABLE Animals 
DROP Uptodate, 
CHANGE COLUMN `temp` `Uptodate` BOOLEAN;

ALTER TABLE Animals
ADD temp BOOLEAN;
UPDATE Animals 
SET 
    temp = IF(Goofy = 'Yes',
        TRUE,
        IF(Goofy='No',
            FALSE,
            NULL));
ALTER TABLE Animals 
DROP Goofy, 
CHANGE COLUMN `temp` `Goofy` BOOLEAN;

ALTER TABLE Animals
ADD temp BOOLEAN;
UPDATE Animals 
SET 
    temp = IF(Hypoallergenic = 'Yes',
        TRUE,
        IF(Hypoallergenic='No',
            FALSE,
            NULL));
ALTER TABLE Animals 
DROP Hypoallergenic, 
CHANGE COLUMN `temp` `Hypoallergenic` BOOLEAN;

ALTER TABLE Animals
ADD temp BOOLEAN;
UPDATE Animals 
SET 
    temp = IF(GoodInCar = 'Yes',
        TRUE,
        IF(GoodInCar='No',
            FALSE,
            NULL));
ALTER TABLE Animals 
DROP GoodInCar, 
CHANGE COLUMN `temp` `GoodInCar` BOOLEAN;

ALTER TABLE Animals
ADD temp BOOLEAN;
UPDATE Animals 
SET 
    temp = IF(Leashtrained = 'Yes',
        TRUE,
        IF(Leashtrained='No',
            FALSE,
            NULL));
ALTER TABLE Animals 
DROP Leashtrained, 
CHANGE COLUMN `temp` `Leashtrained` BOOLEAN;

ALTER TABLE Animals
ADD temp BOOLEAN;
UPDATE Animals 
SET 
    temp = IF(Cratetrained = 'Yes',
        TRUE,
        IF(Cratetrained='No',
            FALSE,
            NULL));
ALTER TABLE Animals 
DROP Cratetrained, 
CHANGE COLUMN `temp` `Cratetrained` BOOLEAN;

ALTER TABLE Animals
ADD temp BOOLEAN;
UPDATE Animals 
SET 
    temp = IF(Fetches = 'Yes',
        TRUE,
        IF(Fetches='No',
            FALSE,
            NULL));
ALTER TABLE Animals 
DROP Fetches, 
CHANGE COLUMN `temp` `Fetches` BOOLEAN;

ALTER TABLE Animals
ADD temp BOOLEAN;
UPDATE Animals 
SET 
    temp = IF(PlaysToys = 'Yes',
        TRUE,
        IF(PlaysToys='No',
            FALSE,
            NULL));
ALTER TABLE Animals 
DROP PlaysToys, 
CHANGE COLUMN `temp` `PlaysToys` BOOLEAN;

ALTER TABLE Animals
ADD temp BOOLEAN;
UPDATE Animals 
SET 
    temp = IF(Swims = 'Yes',
        TRUE,
        IF(Swims='No',
            FALSE,
            NULL));
ALTER TABLE Animals 
DROP Swims, 
CHANGE COLUMN `temp` `Swims` BOOLEAN;

ALTER TABLE Animals
ADD temp BOOLEAN;
UPDATE Animals 
SET 
    temp = IF(Lap = 'Yes',
        TRUE,
        IF(Lap='No',
            FALSE,
            NULL));
ALTER TABLE Animals 
DROP Lap, 
CHANGE COLUMN `temp` `Lap` BOOLEAN;

ALTER TABLE Animals
ADD temp BOOLEAN;
UPDATE Animals 
SET 
    temp = IF(Apartment = 'Yes',
        TRUE,
        IF(Apartment='No',
            FALSE,
            NULL));
ALTER TABLE Animals 
DROP Apartment, 
CHANGE COLUMN `temp` `Apartment` BOOLEAN;

ALTER TABLE Animals
ADD temp BOOLEAN;
UPDATE Animals 
SET 
    temp = IF(Protective = 'Yes',
        TRUE,
        IF(Protective='No',
            FALSE,
            NULL));
ALTER TABLE Animals 
DROP Protective, 
CHANGE COLUMN `temp` `Protective` BOOLEAN;

ALTER TABLE Animals
ADD temp BOOLEAN;
UPDATE Animals 
SET 
    temp = IF(Obedient = 'Yes',
        TRUE,
        IF(Obedient='No',
            FALSE,
            NULL));
ALTER TABLE Animals 
DROP Obedient, 
CHANGE COLUMN `temp` `Obedient` BOOLEAN;

ALTER TABLE Animals
ADD temp BOOLEAN;
UPDATE Animals 
SET 
    temp = IF(Playful = 'Yes',
        TRUE,
        IF(Playful='No',
            FALSE,
            NULL));
ALTER TABLE Animals 
DROP Playful, 
CHANGE COLUMN `temp` `Playful` BOOLEAN;

ALTER TABLE Animals
ADD temp BOOLEAN;
UPDATE Animals 
SET 
    temp = IF(Timid = 'Yes',
        TRUE,
        IF(Timid='No',
            FALSE,
            NULL));
ALTER TABLE Animals 
DROP Timid, 
CHANGE COLUMN `temp` `Timid` BOOLEAN;

ALTER TABLE Animals
ADD temp BOOLEAN;
UPDATE Animals 
SET 
    temp = IF(Independent = 'Yes',
        TRUE,
        IF(Independent='No',
            FALSE,
            NULL));
ALTER TABLE Animals 
DROP Independent, 
CHANGE COLUMN `temp` `Independent` BOOLEAN;

ALTER TABLE Animals
ADD temp BOOLEAN;
UPDATE Animals 
SET 
    temp = IF(Affectionate = 'Yes',
        TRUE,
        IF(Affectionate='No',
            FALSE,
            NULL));
ALTER TABLE Animals 
DROP Affectionate, 
CHANGE COLUMN `temp` `Affectionate` BOOLEAN;

ALTER TABLE Animals
ADD temp BOOLEAN;
UPDATE Animals 
SET 
    temp = IF(EagerToPlease = 'Yes',
        TRUE,
        IF(EagerToPlease='No',
            FALSE,
            NULL));
ALTER TABLE Animals 
DROP EagerToPlease, 
CHANGE COLUMN `temp` `EagerToPlease` BOOLEAN;

ALTER TABLE Animals
ADD temp BOOLEAN;
UPDATE Animals 
SET 
    temp = IF(Eventempered = 'Yes',
        TRUE,
        IF(Eventempered='No',
            FALSE,
            NULL));
ALTER TABLE Animals 
DROP Eventempered, 
CHANGE COLUMN `temp` `Eventempered` BOOLEAN;


ALTER TABLE Animals
ADD temp BOOLEAN;
UPDATE Animals 
SET 
    temp = IF(Gentle = 'Yes',
        TRUE,
        IF(Gentle='No',
            FALSE,
            NULL));
ALTER TABLE Animals 
DROP Gentle, 
CHANGE COLUMN `temp` `Gentle` BOOLEAN;


#------------------------------------------

ALTER TABLE Animals
ADD temp Enum('Has Basic Training','Needs Training','Well Trained', '');
UPDATE Animals 
SET 
    temp = IF(ObedienceTraining = 'Has Basic Training',
        'Has Basic Training',
        IF(ObedienceTraining = 'Needs Training',
            'Needs Training',
            IF(ObedienceTraining = 'Well Trained',
                'Well Trained',
                '')));
ALTER TABLE Animals 
DROP ObedienceTraining, 
CHANGE COLUMN `temp` `ObedienceTraining` Enum('Has Basic Training','Needs Training','Well Trained', '');

ALTER TABLE Animals
ADD temp Enum('None','Species','Breed','All','');
UPDATE Animals 
SET 
    temp = IF(OwnerExperience = 'None',
        'None',
        IF(OwnerExperience = 'Species',
            'Species',
            IF(OwnerExperience = 'Breed',
                'Breed',
                IF(OwnerExperience = 'All', 'All', ''))));
ALTER TABLE Animals 
DROP OwnerExperience, 
CHANGE COLUMN `temp` `OwnerExperience` Enum('None','Species','Breed','All','');


ALTER TABLE Animals
ADD temp Enum('3 foot','6 foot','Any Type','Not Required','');
UPDATE Animals 
SET 
    temp = IF(Fence = '3 foot',
        '3 foot',
        IF(Fence = '6 foot',
            '6 foot',
            IF(Fence = 'Any Type',
                'Any Type',
                IF(Fence = 'Not Required',
                    'Not Required',
                    ''))));
ALTER TABLE Animals 
DROP Fence, 
CHANGE COLUMN `temp` `Fence` Enum('3 foot','6 foot','Any Type','Not Required','');

ALTER TABLE Animals
ADD temp ENUM('Low', 'Moderate', 'High', '');
UPDATE Animals 
SET 
    temp = IF(ExerciseNeeds = 'High',
        'High',
        IF(ExerciseNeeds = 'Low',
            'Low',
            IF(ExerciseNeeds = 'Moderate',
                'Moderate',
                    '')));
ALTER TABLE Animals 
DROP ExerciseNeeds, 
CHANGE COLUMN `temp` `ExerciseNeeds` ENUM('Low', 'Moderate', 'High', '');


ALTER TABLE Animals
ADD temp ENUM('Low', 'Moderate', 'High', '');
UPDATE Animals 
SET 
    temp = IF(GroomingNeeds = 'High',
        'High',
        IF(GroomingNeeds = 'Low',
            'Low',
            IF(GroomingNeeds = 'Moderate',
                'Moderate',
                    '')));
ALTER TABLE Animals 
DROP GroomingNeeds, 
CHANGE COLUMN `temp` `GroomingNeeds` ENUM('Low', 'Moderate', 'High', '');

SET SQL_SAFE_UPDATES=0;
ALTER TABLE Animals
ADD temp ENUM('None', 'Low', 'Moderate', 'High', '');
UPDATE Animals 
SET 
    temp = IF(Shedding = 'High',
        'High',
        IF(Shedding = 'Moderate',
            'Moderate',
            IF(Shedding = 'Low',
                'Low',
                IF(Shedding = 'None',
                    'None',
                    ''))));
ALTER TABLE Animals 
DROP Shedding, 
CHANGE COLUMN `temp` `Shedding` ENUM('None', 'Low', 'Moderate', 'High', '');

SET SQL_SAFE_UPDATES=1;
