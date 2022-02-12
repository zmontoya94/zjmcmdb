package com.promineotech.zjmcmdb.model;

/**
 * Represents a computer.
 */
public class zjmsoftwareinputmodel {
  private String softwareID;
  private String primaryUser;
  private String SoftwareName;
  private String domain;
  
  public zjmsoftwareinputmodel() {
  }

  public String getsoftwareID() {
    return softwareID;
  }

  public zjmsoftwareinputmodel setsoftwareID(String softwareID) {
    this.softwareID = softwareID;
    return(this);
  }

  public String getprimaryUser() {
    return primaryUser;
  }

  public zjmsoftwareinputmodel setprimaryUser(String primaryUser) {
    this.primaryUser = primaryUser;
    return(this);
  }


  @Override
  public String toString() {
    return(String.format("[%s] %s (%d)", getsoftwareID(), getprimaryUser(), getSoftwareName(), getDomain()));
  }
  
  public int compareTo(zjmsoftwareinputmodel softwarename) {
    return(compareTo(this, softwarename));
  }

  public static int compareTo(zjmsoftwareinputmodel software1, zjmsoftwareinputmodel software2) {
    if ((software1 == null) && (software2 == null)) return(0);
    if (software1 == null) return(1);
    if (software2 == null) return(-1);
    if (software1.getprimaryUser().length() < software2.getprimaryUser().length()) {
      return(-1);
    }
    if (software1.getprimaryUser().length() > software2.getprimaryUser().length()) {
      return(1);
    }
    return(software1.getprimaryUser().compareTo(software2.getprimaryUser()));
  }

  public String getSoftwareName() {
    return SoftwareName;
  }

  public void setSoftwareName(String SoftwareName) {
    this.SoftwareName = SoftwareName;
  }

  public String getDomain() {
    return domain;
  }

  public void setDomain(String domain) {
    this.domain = domain;
  }
}
