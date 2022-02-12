package com.promineotech.zjmcmdb.repository;

import java.util.Optional;
import java.util.stream.Stream;
import com.promineotech.zjmcmdb.model.zjmusermodel;

public interface zjmuserrepository extends AutoCloseable{
  /**
   * Retrieves the user with the specified id.
   * @param id The unique id of the user.
   * @return The user if found, otherwise returns a null/empty Optional.
   */
  Optional<zjmusermodel> get(String id);

  /**
   * Retrieves all available users.
   * @return All the users found. If none are present, then an empty list is returned.
   */
  Stream<zjmusermodel> all();
  
  /**
   * Finds the user with the specified name or parts of the name.
   * @param name The name to search for.
   * @return The users found. If none found, then an empty list is returned.
   */
  Stream<zjmusermodel> find(String name);
  

}
