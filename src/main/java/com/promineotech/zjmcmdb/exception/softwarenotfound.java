package com.promineotech.zjmcmdb.exception;

public class softwarenotfound extends RuntimeException {
  private static final long serialVersionUID = 1L;

  private String id;
  
  public softwarenotfound(String id) {
    this(id, "Requested software (" + id + ") was not found");
  }
  
  public softwarenotfound(String id, String message) {
    super(message);
    this.id = id;
  }

  public String getId() {
    return id;
  }
}

