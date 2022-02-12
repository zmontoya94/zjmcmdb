package com.promineotech.zjmcmdb.service;

import java.util.List;
import java.util.Optional;
import com.promineotech.zjmcmdb.model.zjmcomputerinputmodel;
import com.promineotech.zjmcmdb.model.zjmcomputermodel;
import com.promineotech.zjmcmdb.model.zjmsoftwareinputmodel;
import com.promineotech.zjmcmdb.model.zjmsoftwaremodel;
import com.promineotech.zjmcmdb.model.zjmuserinputmodel;
import com.promineotech.zjmcmdb.model.zjmusermodel;


public interface zjmcmdbservice  {
  /**
   * Retrieves the computer with the specified id.
   * @param id The unique id of the country.
   * @return The computer if found, otherwise returns a null/empty Optional.
   */
  Optional<zjmcomputermodel> get(String computerID);

  /**
   * Retrieves all available computers.
   * @return All the computers found. If none are present, then an empty list is returned.
   */
  List<zjmcomputermodel> all();
  
  /**
   * Finds the computers with the specified name or parts of the name.
   * @param name The name to search for.
   * @return The computers found. If none found, then an empty list is returned.
   */
  List<zjmcomputermodel> find(String hostname);

  zjmcomputermodel modify(String code, zjmcomputerinputmodel input);

  zjmcomputermodel remove(String code);

  zjmcomputermodel create(zjmcomputerinputmodel input);
  
  /**
   * Retrieves the computer with the specified id.
   * @param id The unique id of the country.
   * @return The computer if found, otherwise returns a null/empty Optional.
   */
  Optional<zjmusermodel> get1(String userID);

  /**
   * Retrieves all available computers.
   * @return All the computers found. If none are present, then an empty list is returned.
   */
  List<zjmusermodel> all1();
  
  /**
   * Finds the users with the specified name or parts of the name.
   * @param name The name to search for.
   * @return The users found. If none found, then an empty list is returned.
   */
  List<zjmusermodel> find1(String username);


  zjmusermodel modify(String code, zjmuserinputmodel input);

  zjmusermodel remove(String code, zjmuserinputmodel input);

  zjmusermodel remove1(String code);

  zjmusermodel create1(zjmuserinputmodel input);

  zjmusermodel modify1(String code, zjmuserinputmodel input);

  zjmusermodel remove1(String code, zjmuserinputmodel input);

  Optional<zjmusermodel> getUser(String code);

  List<zjmuserinputmodel> findusers(String username);

  zjmuserinputmodel createUser(zjmuserinputmodel input);

  zjmusermodel removeuser(String code);

  zjmsoftwaremodel removeSoftware(String code);

  List<zjmsoftwaremodel> allsoftware();

  zjmsoftwareinputmodel createSoftware(zjmsoftwareinputmodel input);

  zjmsoftwaremodel modifySoftware(String code, zjmcomputerinputmodel input);

  zjmsoftwaremodel modifySoftware(String code, zjmsoftwareinputmodel input);
  
}
