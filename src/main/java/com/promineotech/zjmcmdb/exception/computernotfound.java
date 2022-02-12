package com.promineotech.zjmcmdb.exception;

public class computernotfound extends RuntimeException {
  private static final long serialVersionUID = 1L;

  private String id;
  
  public computernotfound(String id) {
    this(id, "Requested computer (" + id + ") was not found");
  }
  
  public computernotfound(String id, String message) {
    super(message);
    this.id = id;
  }

  public String getId() {
    return id;
  }
}
