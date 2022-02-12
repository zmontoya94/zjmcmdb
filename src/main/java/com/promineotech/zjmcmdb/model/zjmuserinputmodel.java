package com.promineotech.zjmcmdb.model;


/**
 * Represents a user.
 */
public class zjmuserinputmodel {
  private String username;
  private String hostname;
  private String first_name;
  private String last_name;
  
  public zjmuserinputmodel() {
  }

  public String getusername() {
    return username;
  }

  public zjmuserinputmodel setusername(String username) {
    this.username = username;
    return(this);
  }

  public String gethostname() {
    return hostname;
  }

  public zjmuserinputmodel sethostname(String hostname) {
    this.hostname = hostname;
    return(this);
  }


  @Override
  public String toString() {
    return(String.format("[%s] %s (%d)", getusername(), gethostname(), getfirst_name(), getlast_name()));
  }
  
  public int compareTo(zjmuserinputmodel hostname) {
    return(compareTo(this, hostname));
  }

  public static int compareTo(zjmuserinputmodel computer1, zjmuserinputmodel computer2) {
    if ((computer1 == null) && (computer2 == null)) return(0);
    if (computer1 == null) return(1);
    if (computer2 == null) return(-1);
    if (computer1.gethostname().length() < computer2.gethostname().length()) {
      return(-1);
    }
    if (computer1.gethostname().length() > computer2.gethostname().length()) {
      return(1);
    }
    return(computer1.gethostname().compareTo(computer2.gethostname()));
  }

  public String getfirst_name() {
    return first_name;
  }

  public void setfirst_name(String first_name) {
    this.first_name = first_name;
  }

  public String getlast_name() {
    return last_name;
  }

  public void setlast_name(String last_name) {
    this.last_name = last_name;
  }
}

