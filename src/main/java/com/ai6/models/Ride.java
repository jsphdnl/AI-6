package com.ai6.models;

/**
 * Created by bharath on 4/27/17.
 */
public class Ride {
  private String service;
  private String serviceName;
  private float fromLatitude;
  private float fromLongitude;
  private float toLatitude;
  private float toLongitude;
  private float cost;
  private String estimate;
  private String productId;
  private String fareId;
  private float distance;
  private String distanceUnit;
  private String estimateCost;
  public Ride() {
  }


  public float getDistance() {
    return distance;
  }

  public void setDistance(float distance) {
    this.distance = distance;
  }

  public String getDistanceUnit() {
    return distanceUnit;
  }

  public void setDistanceUnit(String distanceUnit) {
    this.distanceUnit = distanceUnit;
  }

  public String getEstimateCost() {
    return estimateCost;
  }

  public void setEstimateCost(String estimateCost) {
    this.estimateCost = estimateCost;
  }

  public String getFareId() {
    return fareId;
  }

  public void setFareId(String fareId) {
    this.fareId = fareId;
  }

  public String getService() {
    return service;
  }

  public void setService(String service) {
    this.service = service;
  }

  public String getServiceName() {
    return serviceName;
  }

  public void setServiceName(String serviceName) {
    this.serviceName = serviceName;
  }

  public float getCost() {
    return cost;
  }

  public void setCost(float cost) {
    this.cost = cost;
  }

  public String getEstimate() {
    return estimate;
  }

  public void setEstimate(String estimate) {
    this.estimate = estimate;
  }

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public float getToLongitude() {
    return toLongitude;
  }

  public void setToLongitude(float toLongitude) {
    this.toLongitude = toLongitude;
  }

  public float getFromLongitude() {
    return fromLongitude;
  }

  public void setFromLongitude(float fromLongitude) {
    this.fromLongitude = fromLongitude;
  }

  public float getFromLatitude() {
    return fromLatitude;
  }

  public void setFromLatitude(float fromLatitude) {
    this.fromLatitude = fromLatitude;
  }

  public float getToLatitude() {
    return toLatitude;
  }

  public void setToLatitude(float toLatitude) {
    this.toLatitude = toLatitude;
  }

  public Address toAddress(){
    Address address = new Address();
    address.setLatitude(this.fromLatitude);
    address.setLongitude(this.fromLongitude);

    return address;
  }
}
