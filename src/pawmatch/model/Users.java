package pawmatch.model;

/**
 * Created by Robert Munro on 11/12/2017.
 */
public class Users {
  protected Integer UserId;
  protected String UserName;
  protected String FirstName;
  protected String LastName;
  protected String Email;
  protected String Password;
  protected Integer SimplePreferencesId;
  protected Integer DetailedPreferencesId;
  protected Boolean NotificationsOn;
  protected Boolean Foster;

  public Users(Integer userId, String userName, String firstName, String lastName, String email, String password, Integer simplePreferencesId, Integer detailedPreferencesId, Boolean notificationsOn, Boolean foster) {
    UserId = userId;
    UserName = userName;
    FirstName = firstName;
    LastName = lastName;
    Email = email;
    Password = password;
    SimplePreferencesId = simplePreferencesId;
    DetailedPreferencesId = detailedPreferencesId;
    NotificationsOn = notificationsOn;
    Foster = foster;
  }

  public Users(String userName, String firstName, String lastName, String email, String password, Integer simplePreferencesId, Integer detailedPreferencesId, Boolean notificationsOn, Boolean foster) {
    UserName = userName;
    FirstName = firstName;
    LastName = lastName;
    Email = email;
    Password = password;
    SimplePreferencesId = simplePreferencesId;
    DetailedPreferencesId = detailedPreferencesId;
    NotificationsOn = notificationsOn;
    Foster = foster;
  }

  public Integer getUserId() {
    return UserId;
  }

  public void setUserId(Integer userId) {
    UserId = userId;
  }

  public String getUserName() {
    return UserName;
  }

  public void setUserName(String userName) {
    UserName = userName;
  }

  public String getFirstName() {
    return FirstName;
  }

  public void setFirstName(String firstName) {
    FirstName = firstName;
  }

  public String getLastName() {
    return LastName;
  }

  public void setLastName(String lastName) {
    LastName = lastName;
  }

  public String getEmail() {
    return Email;
  }

  public void setEmail(String email) {
    Email = email;
  }

  public String getPassword() {
    return Password;
  }

  public void setPassword(String password) {
    Password = password;
  }

  public Integer getSimplePreferencesId() {
    return SimplePreferencesId;
  }

  public void setSimplePreferencesId(Integer simplePreferencesId) {
    SimplePreferencesId = simplePreferencesId;
  }

  public Integer getDetailedPreferencesId() {
    return DetailedPreferencesId;
  }

  public void setDetailedPreferencesId(Integer detailedPreferencesId) {
    DetailedPreferencesId = detailedPreferencesId;
  }

  public Boolean getNotificationsOn() {
    return NotificationsOn;
  }

  public void setNotificationsOn(Boolean notificationsOn) {
    NotificationsOn = notificationsOn;
  }

  public Boolean getFoster() {
    return Foster;
  }

  public void setFoster(Boolean foster) {
    Foster = foster;
  }

  @Override
  public String toString() {
    return "Users{" +
        "UserId=" + UserId +
        ", UserName='" + UserName + '\'' +
        ", FirstName='" + FirstName + '\'' +
        ", LastName='" + LastName + '\'' +
        ", Email='" + Email + '\'' +
        ", Password='" + Password + '\'' +
        ", SimplePreferencesId=" + SimplePreferencesId +
        ", DetailedPreferencesId=" + DetailedPreferencesId +
        ", NotificationsOn=" + NotificationsOn +
        ", Foster=" + Foster +
        '}';
  }
}
