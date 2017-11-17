package pawmatch.model;

/**
 * Created by Robert Munro on 11/12/2017.
 */
public class CommonApplications {

  private Integer commonApplicationId;
  private String applicationBody;
  private Integer userId;

  // Constructor with commonApplicationId
  public CommonApplications(Integer commonApplicationId, String applicationBody, Integer userId) {
    this.commonApplicationId = commonApplicationId;
    this.applicationBody = applicationBody;
    this.userId = userId;
  }

  // Constructor without commonApplicationId
  public CommonApplications(String applicationBody, Integer userId) {
    this.applicationBody = applicationBody;
    this.userId = userId;
  }

  public Integer getCommonApplicationId() {
    return commonApplicationId;
  }

  public void setCommonApplicationId(Integer commonApplicationId) {
    this.commonApplicationId = commonApplicationId;
  }

  public String getApplicationBody() {
    return applicationBody;
  }

  public void setApplicationBody(String applicationBody) {
    this.applicationBody = applicationBody;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  @Override
  public String toString() {
    return "CommonApplications{" +
        "commonApplicationId=" + commonApplicationId +
        ", applicationBody='" + applicationBody + '\'' +
        ", userId=" + userId +
        '}';
  }
}
