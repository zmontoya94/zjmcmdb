package com.promineotech.zjmcmdb.model;

public class zjmusermodel {
  private int userID;
  private String username;
  private String first_name;
  private String last_name;
  private String email;
  
  public zjmusermodel(int userID, String username, String first_name, String last_name, String email) {
    setuserId(userID);
    setusername(username);
    setfirst_name(first_name);
    setLast_name(last_name);
    setEmail(email);
  }
  
  public int getuserId() {
    return userID;
  }
  public void setuserId(int userID) {
    this.userID = userID;
  }
  public String getusername() {
    return username;
  }
  public void setusername(String username) {
    this.username = username;
  }
  public String getfirst_name() {
    return first_name;
  }
  public void setfirst_name(String first_name) {
    this.first_name = first_name;
  }

  public String getLast_name() {
    return last_name;
  }

  public void setLast_name(String last_name) {
    this.last_name = last_name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
  
  
}
