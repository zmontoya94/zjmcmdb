package com.promineotech.zjmcmdb.repository;

import java.util.Optional;
import java.util.stream.Stream;
import com.promineotech.zjmcmdb.model.zjmsoftwaremodel;

public interface zjmsoftwarerepository extends AutoCloseable{
  /**
   * Retrieves the software with the specified id.
   * @param id The unique id of the software.
   * @return The software if found, otherwise returns a null/empty Optional.
   */
  Optional<zjmsoftwaremodel> get(String id);

  /**
   * Retrieves all available software.
   * @return All the software found. If none are present, then an empty list is returned.
   */
  Stream<zjmsoftwaremodel> all();
  
  /**
   * Finds the software with the specified name or parts of the name.
   * @param name The name to search for.
   * @return The software found. If none found, then an empty list is returned.
   */
  Stream<zjmsoftwaremodel> find(String name);
  

}

