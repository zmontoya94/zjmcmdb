package com.promineotech.zjmcmdb.service;

import java.util.List;
import java.util.Optional;
import com.promineotech.zjmcmdb.model.zjmcomputerinputmodel;
import com.promineotech.zjmcmdb.model.zjmcomputermodel;


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
  
}
