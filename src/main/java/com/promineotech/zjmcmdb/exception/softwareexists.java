package com.promineotech.zjmcmdb.exception;

import com.promineotech.zjmcmdb.model.zjmsoftwaremodel;

public class softwareexists extends RuntimeException {
  private static final long serialVersionUID = 1L;
  
  private zjmsoftwaremodel software;
  
  public softwareexists(zjmsoftwaremodel existing) {
    this(existing, "The software already exists.");
  }
  
  public softwareexists(zjmsoftwaremodel existing, String message) {
    super(message);
    this.software = existing;
  }
  

  public zjmsoftwaremodel getSoftware() {
    return software;
  }
}