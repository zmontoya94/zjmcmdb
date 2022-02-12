package com.promineotech.zjmcmdb.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import com.promineotech.zjmcmdb.model.zjmcomputermodel;

@Repository("zjmcomputerjbdcrepository")
public class zjmcomputerjbdcrepository implements zjmComputerRepository {
  @Autowired
  private NamedParameterJdbcTemplate provider;
  
  @Override
  public void close() throws Exception {
  }

  public Stream<zjmcomputermodel> all(String computer) {
    String sql = "SELECT computerID, hosntame, primaryUser From computer WHERE computerID = :code";
    Map<String,Object> parameters = new HashMap<>();
    parameters.put("code", computer);
    
    List<zjmcomputermodel> cities = provider.query(sql, parameters, (rs, rowNum) -> {
      int id = rs.getInt("computerID");
      zjmcomputermodel city = new zjmcomputermodel(id,
          rs.getString("computerID"), rs.getString("hostname"), sql, sql);
      return(city);
    });
    
    return(cities.stream());
  }

  @Override
  public Optional<zjmcomputermodel> get(String id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Stream<zjmcomputermodel> all() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Stream<zjmcomputermodel> find(String name) {
    // TODO Auto-generated method stub
    return null;
  }
}

