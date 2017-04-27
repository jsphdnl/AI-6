package com.ai6.models;

import com.couchbase.client.deps.com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by bharath on 4/26/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {
  private String id;
  private String tag;
  private String line1;
  private String line2;
  private float latitude;
  private float longitude;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }

  public String getLine1() {
    return line1;
  }

  public void setLine1(String line1) {
    this.line1 = line1;
  }

  public String getLine2() {
    return line2;
  }

  public void setLine2(String line2) {
    this.line2 = line2;
  }

  public float getLatitude() {
    return latitude;
  }

  public void setLatitude(float latitude) {
    this.latitude = latitude;
  }

  public float getLongitude() {
    return longitude;
  }

  public void setLongitude(float longitude) {
    this.longitude = longitude;
  }
}
