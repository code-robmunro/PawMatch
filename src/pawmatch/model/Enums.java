package pawmatch.model;

/**
 * Created by irenakushner on 11/13/17.
 */

public class Enums {

  public enum Species {
    CAT("Cat"), DOG("Dog"), EMPTY("");

    // Assigning a value to each enum
    private final String code;
    Species(String code){this.code = code;}

    // Overriding toString() method to return "" instead of "EMPTY"
    @Override
    public String toString(){
      return this.code;
    }
  }

  public enum Sex{
    MALE("Male"), FEMALE("Female"), EMPTY("");

    private final String code;
    Sex(String code){this.code = code;}

    @Override
    public String toString(){
      return this.code;
    }
  }

  public enum Age{
    BABY("Baby"), YOUNG("Young"), ADULT("Adult"), SENIOR("Senior"), EMPTY("");

    private final String code;
    Age(String code){this.code = code;}

    @Override
    public String toString(){
      return this.code;
    }
  }

  public enum Size{
    SMALL("Small"), MEDIUM("Medium"), LARGE("Large"), XLARGE("X-Large"), EMPTY("");

    private final String code;
    Size(String code){this.code = code;}

    @Override
    public String toString(){
      return this.code;
    }
  }

  public enum CoatLength{
    SHORT("Short"), MEDIUM("Medium"), LONG("Long"), EMPTY("");

    private final String code;
    CoatLength(String code){this.code = code;}

    @Override
    public String toString(){
      return this.code;
    }
  }

  public enum EnergyLevel{
    LOW("Low"), MODERATE("Moderate"), HIGH("High"), EMPTY("");

    private final String code;
    EnergyLevel(String code){this.code = code;}

    @Override
    public String toString(){
      return this.code;
    }
  }

  public enum ActivityLevel{
    NOT_ACTIVE("Not Active"), SLIGHTLY_ACTIVE("Slightly Active"), MODERATELY_ACTIVE("Moderately Active"),
    HIGHLY_ACTIVE("Highly Active"),EMPTY("");

    private final String code;
    ActivityLevel(String code){this.code = code;}

    @Override
    public String toString(){
      return this.code;
    }
  }

}
