package com.promineotech.zjmcmdb.exception;

public class usernotfound extends RuntimeException {
  private static final long serialVersionUID = 1L;

  private String id;
  
  public usernotfound(String id) {
    this(id, "Requested user (" + id + ") was not found");
  }
  
  public usernotfound(String id, String message) {
    this.id = id;
  }

  public String getId() {
    return id;
  }
}
