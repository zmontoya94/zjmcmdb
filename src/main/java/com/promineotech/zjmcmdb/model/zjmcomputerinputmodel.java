package com.promineotech.zjmcmdb.model;


  /**
   * Represents a computer.
   */
  public class zjmcomputerinputmodel {
    private String computerID;
    private String hostname;
    private String ipV4Address;
    private String domain;
    
    public zjmcomputerinputmodel() {
    }

    public String getcomputerID() {
      return computerID;
    }

    public zjmcomputerinputmodel setcomputerID(String computerID) {
      this.computerID = computerID;
      return(this);
    }

    public String gethostname() {
      return hostname;
    }

    public zjmcomputerinputmodel sethostname(String hostname) {
      this.hostname = hostname;
      return(this);
    }


    @Override
    public String toString() {
      return(String.format("[%s] %s (%d)", getcomputerID(), gethostname(), getIpV4Address(), getDomain()));
    }
    
    public int compareTo(zjmcomputerinputmodel hostname) {
      return(compareTo(this, hostname));
    }

    public static int compareTo(zjmcomputerinputmodel computer1, zjmcomputerinputmodel computer2) {
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

    public String getIpV4Address() {
      return ipV4Address;
    }

    public void setIpV4Address(String ipV4Address) {
      this.ipV4Address = ipV4Address;
    }

    public String getDomain() {
      return domain;
    }

    public void setDomain(String domain) {
      this.domain = domain;
    }
  }
