package com.promineotech.zjmcmdb.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import com.promineotech.zjmcmdb.model.zjmsoftwaremodel;


@Repository("zjmsoftwarejdbcrepository")
public class zjmsoftwarejdbcrepository implements zjmsoftwarerepository {
  @Autowired
  private NamedParameterJdbcTemplate provider;
  
  @Override
  public void close() throws Exception {
  }

  
  public Stream<zjmsoftwaremodel> all(String software) {
    String sql = "SELECT softwareID, primaryUser, softwareName, developer, appVersion From developer WHERE softwareID = :code";
    Map<String,Object> parameters = new HashMap<>();
    parameters.put("code", software);
    
    List<zjmsoftwaremodel> software1 = provider.query(sql, parameters, (rs, rowNum) -> {
      int id = rs.getInt("ID");
      zjmsoftwaremodel software2 = new zjmsoftwaremodel(id,
          rs.getString("softwareID"), rs.getString("Name"));
      return(software2);
    });
    
    return(software1.stream());
  }

  @Override
  public Optional<zjmsoftwaremodel> get(String id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Stream<zjmsoftwaremodel> all() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Stream<zjmsoftwaremodel> find(String name) {
    // TODO Auto-generated method stub
    return null;
  }
}
