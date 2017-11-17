package pawmatch.model;

/**
 * Created by Robert Munro on 11/12/2017.
 */
public class ShelterProfiles {

  protected Integer ShelterProfileId;
  protected String Name;
  protected String Address;
  protected String City;
  protected String State;
  protected String Phone;
  protected String Email;
  protected String OrgUrl;
  protected String FacebookUrl;
  protected Boolean MeetPets;
  protected Boolean AllowCommonApp;
  protected Integer OrganizationId;

  public ShelterProfiles(Integer shelterProfileId, String name, String address, String city,
                         String state, String phone, String email, String orgUrl, String
                             facebookUrl, Boolean meetPets, Boolean allowCommonApp, Integer
                             organizationId) {
    ShelterProfileId = shelterProfileId;
    Name = name;
    Address = address;
    City = city;
    State = state;
    Phone = phone;
    Email = email;
    OrgUrl = orgUrl;
    FacebookUrl = facebookUrl;
    MeetPets = meetPets;
    AllowCommonApp = allowCommonApp;
    OrganizationId = organizationId;
  }

  public ShelterProfiles(String name, String address, String city, String state, String phone, String email, String orgUrl, String facebookUrl, Boolean meetPets, Boolean allowCommonApp, Integer organizationId) {
    Name = name;
    Address = address;
    City = city;
    State = state;
    Phone = phone;
    Email = email;
    OrgUrl = orgUrl;
    FacebookUrl = facebookUrl;
    MeetPets = meetPets;
    AllowCommonApp = allowCommonApp;
    OrganizationId = organizationId;
  }

  public Integer getShelterProfileId() {
    return ShelterProfileId;
  }

  public void setShelterProfileId(Integer shelterProfileId) {
    ShelterProfileId = shelterProfileId;
  }

  public String getName() {
    return Name;
  }

  public void setName(String name) {
    Name = name;
  }

  public String getAddress() {
    return Address;
  }

  public void setAddress(String address) {
    Address = address;
  }

  public String getCity() {
    return City;
  }

  public void setCity(String city) {
    City = city;
  }

  public String getState() {
    return State;
  }

  public void setState(String state) {
    State = state;
  }

  public String getPhone() {
    return Phone;
  }

  public void setPhone(String phone) {
    Phone = phone;
  }

  public String getEmail() {
    return Email;
  }

  public void setEmail(String email) {
    Email = email;
  }

  public String getOrgUrl() {
    return OrgUrl;
  }

  public void setOrgUrl(String orgUrl) {
    OrgUrl = orgUrl;
  }

  public String getFacebookUrl() {
    return FacebookUrl;
  }

  public void setFacebookUrl(String facebookUrl) {
    FacebookUrl = facebookUrl;
  }

  public Boolean getMeetPets() {
    return MeetPets;
  }

  public void setMeetPets(Boolean meetPets) {
    MeetPets = meetPets;
  }

  public Boolean getAllowCommonApp() {
    return AllowCommonApp;
  }

  public void setAllowCommonApp(Boolean allowCommonApp) {
    AllowCommonApp = allowCommonApp;
  }

  public Integer getOrganizationId() {
    return OrganizationId;
  }

  public void setOrganizationId(Integer organizationId) {
    OrganizationId = organizationId;
  }

  @Override
  public String toString() {
    return "ShelterProfiles{" +
        "ShelterProfileId=" + ShelterProfileId +
        ", Name='" + Name + '\'' +
        ", Address='" + Address + '\'' +
        ", City='" + City + '\'' +
        ", State='" + State + '\'' +
        ", Phone='" + Phone + '\'' +
        ", Email='" + Email + '\'' +
        ", OrgUrl='" + OrgUrl + '\'' +
        ", FacebookUrl='" + FacebookUrl + '\'' +
        ", MeetPets=" + MeetPets +
        ", AllowCommonApp=" + AllowCommonApp +
        ", OrganizationId=" + OrganizationId +
        '}';
  }
}
