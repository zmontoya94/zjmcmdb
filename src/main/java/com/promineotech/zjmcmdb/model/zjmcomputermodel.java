package com.promineotech.zjmcmdb.model;


public class zjmcomputermodel {
  private int computerID;
  private String primaryUser;
  private String hostname;
  private String ipV4Address;
  private String domain;
  
  public zjmcomputermodel(int computerID, String primaryUser, String hostname, String ipV4Address, String domain) {
    setcomputerID(computerID);
    setprimaryUser(primaryUser);
    sethostname(hostname);
    setipV4Address(ipV4Address);
    setdomain(domain);
  }
  
  public int getcomputerID() {
    return computerID;
  }
  public void setcomputerID(int computerID) {
    this.computerID = computerID;
  }
  public String getprimaryUser() {
    return primaryUser;
  }
  public void setprimaryUser(String primaryUser) {
    this.primaryUser = primaryUser;
  }
  public String gethostname() {
    return hostname;
  }
  public void sethostname(String hostname) {
    this.hostname = hostname;
  }

  public String getipV4Address() {
    return ipV4Address;
  }

  public void setipV4Address(String ipV4Address) {
    this.ipV4Address = ipV4Address;
  }

  public String getdomain() {
    return domain;
  }

  public void setdomain(String domain) {
    this.domain = domain;
  }
  
  
}