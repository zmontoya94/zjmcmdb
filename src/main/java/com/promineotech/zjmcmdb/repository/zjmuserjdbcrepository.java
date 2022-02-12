package com.promineotech.zjmcmdb.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import com.promineotech.zjmcmdb.model.zjmusermodel;


@Repository("zjmuserjdbcrepository")
public class zjmuserjdbcrepository implements zjmuserrepository {
  @Autowired
  private NamedParameterJdbcTemplate provider;
  
  @Override
  public void close() throws Exception {
  }

  
  public Stream<zjmusermodel> all(String user) {
    String sql = "SELECT userID, username, first_name, last_name From user WHERE userID = :code";
    Map<String,Object> parameters = new HashMap<>();
    parameters.put("code", user);
    
    List<zjmusermodel> cities = provider.query(sql, parameters, (rs, rowNum) -> {
      int id = rs.getInt("ID");
      zjmusermodel city = new zjmusermodel(id,
          rs.getString("CountryCode"), rs.getString("Name"), sql, sql);
      return(city);
    });
    
    return(cities.stream());
  }

  @Override
  public Optional<zjmusermodel> get(String id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Stream<zjmusermodel> all() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Stream<zjmusermodel> find(String name) {
    // TODO Auto-generated method stub
    return null;
  }
}