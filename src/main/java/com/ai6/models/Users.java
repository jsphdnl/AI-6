package com.ai6.models;

import com.couchbase.client.deps.com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by bharath on 4/24/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Users {
  private String id;
  private String username;
  private String nick;
  private String uberId;
  private String password;
  private String email;
  private List<String> addressList;
  private String homeAddressKey;
  private String officeAddressKey;

  public Users() {
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getNick() {
    return nick;
  }

  public void setNick(String nick) {
    this.nick = nick;
  }

  public String getUberId() {
    return uberId;
  }

  public void setUberId(String uberId) {
    this.uberId = uberId;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public List<String> getAddressList() {
    return addressList;
  }

  public void setAddressList(List<String> addressList) {
    this.addressList = addressList;
  }

  public String getHomeAddressKey() {
    return homeAddressKey;
  }

  public void setHomeAddressKey(String homeAddressKey) {
    this.homeAddressKey = homeAddressKey;
  }

  public String getOfficeAddressKey() {
    return officeAddressKey;
  }

  public void setOfficeAddressKey(String officeAddressKey) {
    this.officeAddressKey = officeAddressKey;
  }
}
