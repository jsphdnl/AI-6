import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

/**
 * Created by bharath on 4/24/17.
 */
public class MainConfiguration extends Configuration{

  private String uberTokenKey;

  @JsonProperty("couchbase.username")
  private String couchBaseUserName;
  @JsonProperty("couchbase.pasword")
  private String couchBasePassword;
  @JsonProperty("couchbase.bucket")
  private String couchBaseBucket;
  @JsonProperty("uber.clientId")
  private String uberClientId;
  @JsonProperty("uber.serverToken")
  private String uberClientToken;


  public String getCouchBaseUserName() {
    return couchBaseUserName;
  }

  public String getUberClientId() {
    return uberClientId;
  }

  public void setUberClientId(String uberClientId) {
    this.uberClientId = uberClientId;
  }

  public String getUberClientToken() {
    return uberClientToken;
  }

  public void setUberClientToken(String uberClientToken) {
    this.uberClientToken = uberClientToken;
  }

  public void setCouchBaseUserName(String couchBaseUserName) {
    this.couchBaseUserName = couchBaseUserName;
  }

  public String getCouchBasePassword() {
    return couchBasePassword;
  }

  public void setCouchBasePassword(String couchBasePassword) {
    this.couchBasePassword = couchBasePassword;
  }

  public String getCouchBaseBucket() {
    return couchBaseBucket;
  }

  public void setCouchBaseBucket(String couchBaseBucket) {
    this.couchBaseBucket = couchBaseBucket;
  }

  public String getUberTokenKey() {
    return uberTokenKey;
  }

  public void setUberTokenKey(String uberTokenKey) {
    this.uberTokenKey = uberTokenKey;
  }



}
