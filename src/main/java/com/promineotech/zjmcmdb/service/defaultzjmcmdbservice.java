package com.promineotech.zjmcmdb.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.promineotech.zjmcmdb.model.zjmcomputerinputmodel;
import com.promineotech.zjmcmdb.model.zjmcomputermodel;
import com.promineotech.zjmcmdb.model.zjmuserinputmodel;
import com.promineotech.zjmcmdb.model.zjmusermodel;
import com.promineotech.zjmcmdb.repository.zjmComputerRepository;

public abstract class defaultzjmcmdbservice implements zjmcmdbservice{
  @Autowired
  @Qualifier("zjmcmdbJdbcRepository")
  private zjmComputerRepository repository;

  @Override
  public Optional<zjmcomputermodel> get(String computerID) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<zjmcomputermodel> all() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<zjmcomputermodel> find(String hostname) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public zjmcomputermodel modify(String code, zjmcomputerinputmodel input) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public zjmusermodel remove1(String code) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public zjmcomputermodel create(zjmcomputerinputmodel input) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public zjmusermodel modify(String code, zjmuserinputmodel input) {
    // TODO Auto-generated method stub
    return null;
  }


  @Override
  public Optional<zjmusermodel> getUser(String userID) {
    // TODO Auto-generated method stub
    return null;
  }


  
}