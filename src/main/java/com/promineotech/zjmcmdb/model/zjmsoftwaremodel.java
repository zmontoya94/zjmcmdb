package com.promineotech.zjmcmdb.model;

public class zjmsoftwaremodel{
  private int softwareID;
  private String primaryUser;
  private String softwareName;
  
public zjmsoftwaremodel (int softwareID, String primaryUser, String softwareName) {
  setsoftwareID(softwareID);
  setprimaryUser(primaryUser);
  setsoftwareName(softwareName);
}

public int getsoftwareID() {
  return softwareID;
}
public void setsoftwareID(int softwareID) {
  this.softwareID = softwareID;
}
public String getprimaryUser() {
  return primaryUser;
}
public void setprimaryUser(String primaryUser) {
  this.primaryUser = primaryUser;
}
public String getsoftwareName() {
  return softwareName;
}
public void setsoftwareName(String softwareName) {
  this.softwareName = softwareName;
}


}