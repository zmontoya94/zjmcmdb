package com.promineotech.zjmcmdb.repository;

import java.util.Optional;
import java.util.stream.Stream;
import com.promineotech.zjmcmdb.model.zjmcomputermodel;

public interface zjmComputerRepository extends AutoCloseable{
  /**
   * Retrieves the country with the specified id.
   * @param id The unique id of the country.
   * @return The country if found, otherwise returns a null/empty Optional.
   */
  Optional<zjmcomputermodel> get(String id);

  /**
   * Retrieves all available countries.
   * @return All the countries found. If none are present, then an empty list is returned.
   */
  Stream<zjmcomputermodel> all();
  
  /**
   * Finds the country with the specified name or parts of the name.
   * @param name The name to search for.
   * @return The countries found. If none found, then an empty list is returned.
   */
  Stream<zjmcomputermodel> find(String name);
  

}
