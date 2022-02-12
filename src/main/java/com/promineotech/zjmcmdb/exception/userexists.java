package com.promineotech.zjmcmdb.exception;

import com.promineotech.zjmcmdb.model.zjmcomputermodel;
import com.promineotech.zjmcmdb.model.zjmusermodel;

public class userexists extends RuntimeException {
  private static final long serialVersionUID = 1L;
  
  private userexists user;
  
  public userexists(userexists existing) {
    this(existing, "The computer already exists.");
  }
  
  public userexists(userexists existing, String message) {
    super(message);
    this.user = existing;
  }
  

  public userexists getuser() {
    return user;
  }
}
