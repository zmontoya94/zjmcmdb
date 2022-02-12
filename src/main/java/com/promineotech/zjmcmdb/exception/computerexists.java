package com.promineotech.zjmcmdb.exception;

import com.promineotech.zjmcmdb.model.zjmcomputermodel;

public class computerexists extends RuntimeException {
  private static final long serialVersionUID = 1L;
  
  private zjmcomputermodel computer;
  
  public computerexists(zjmcomputermodel existing) {
    this(existing, "The computer already exists.");
  }
  
  public computerexists(zjmcomputermodel existing, String message) {
    super(message);
    this.computer = existing;
  }
  

  public zjmcomputermodel    getCountry() {
    return computer;
  }
}