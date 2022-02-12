package com.promineotech.zjmcmdb.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.promineotech.zjmcmdb.exception.computerexists;
import com.promineotech.zjmcmdb.exception.computernotfound;
import com.promineotech.zjmcmdb.exception.softwareexists;
import com.promineotech.zjmcmdb.exception.softwarenotfound;
import com.promineotech.zjmcmdb.exception.userexists;
import com.promineotech.zjmcmdb.exception.usernotfound;
import com.promineotech.zjmcmdb.model.zjmcomputerinputmodel;
import com.promineotech.zjmcmdb.model.zjmcomputermodel;
import com.promineotech.zjmcmdb.model.zjmsoftwareinputmodel;
import com.promineotech.zjmcmdb.model.zjmsoftwaremodel;
import com.promineotech.zjmcmdb.model.zjmuserinputmodel;
import com.promineotech.zjmcmdb.model.zjmusermodel;
import com.promineotech.zjmcmdb.service.zjmcmdbservice;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name="CMDB")
@OpenAPIDefinition(info = @Info(title = "CMDB: do you know where your computer is???"))
public class zjmcmdbcontroller {
  private zjmcmdbservice service;
  
  
 //computers
  @Operation(summary = "Get's all of the available computers.")
  @RequestMapping(value = "/computers", method = RequestMethod.GET)
  public List<zjmcomputermodel> all() {
    return service.all();
  }
  @Operation(summary = "Get's a computer by it's unique identifier.")
  @RequestMapping(value = "/computers/{computerID}", method = RequestMethod.GET)
  public zjmcomputermodel get(@PathVariable String code) {
    Optional<zjmcomputermodel> computer = service.get(code);
    if (computer.isPresent()) {
      return(computer.get());
    }
    
    throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
        "The requested computer doesn't exist.");
  }
  
  @Operation(summary = "Finds computers matching all of part of the specified hostname.")
  @RequestMapping(value = "/computers/find", method = RequestMethod.GET)
  public List<zjmcomputermodel> find(@RequestParam String hostname) { 
    List<zjmcomputermodel> countries = service.find(hostname);
    if (! countries.isEmpty()) {
      return(countries);
    }
    
    throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
        "No computers found matching the value provided");
  }
  @Operation(summary = "Modifies an existing computer.")
  @RequestMapping(value = "/computers/{computerID}", method = RequestMethod.PUT)
  public zjmcomputermodel update(@PathVariable String code, @RequestBody zjmcomputerinputmodel input) {
    if ((code != null) && (! code.isEmpty())) {
      if (input != null) {
        zjmcomputermodel updated = service.modify(code, input);
        if (updated != null) {
          return(updated);
        }
        
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, 
            "Failed to updated computer due to an unhandled or unexpected error.");
      }
    }
    
    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
        "computer identifier or computer input was missing, empty or null");
  }
  @Operation(summary = "Delete or remove a computer.")
  @RequestMapping(value = "/computer/{computerID}", method = RequestMethod.DELETE)
  public zjmcomputermodel delete(@PathVariable String code) {
    if ((code != null) && (! code.isEmpty())) {
      try {
        zjmcomputermodel result = service.remove(code);
        if (result != null) {
          return(result);
        }
      } catch(computernotfound e) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
            "Requested computer doesn't exist.");
      }
      
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, 
          "Failed to remove computer due to an unhandled or unexpected error.");
    }
    
    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
        "computerID was empty or null");
  }
  
  @Operation(summary = "Create a new computer.")
  @RequestMapping(value = "/computers", method = RequestMethod.POST)
  public zjmcomputermodel create(@RequestBody zjmcomputerinputmodel input) {
    if (input != null) {
      try {
        zjmcomputermodel result = service.create(input);
        if (result != null) {
          return(result);
        }
      }
      catch (computerexists e) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
            e.getMessage());
      }
      
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, 
          "Failed to create computer due to an unhandled or unexpected internal error");
    }
    
    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
        "computer input was empty or null");
  }
  
//users
  @Operation(summary = "Get's all of the available users.")
  @RequestMapping(value = "/users", method = RequestMethod.GET)
  public List<zjmusermodel> all1() {
    return service.all1();
  }
  @Operation(summary = "Get's a user by it's unique identifier.")
  @RequestMapping(value = "/users/{userID}", method = RequestMethod.GET)
  public zjmusermodel getUser(@PathVariable String code) {
    Optional<zjmusermodel> computer = service.getUser(code);
    if (computer.isPresent()) {
      return(computer.get());
    }
    
    throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
        "The requested user doesn't exist.");
  }
 
  @Operation(summary = "Finds users matching all of part of the specified username.")
  @RequestMapping(value = "/users/find", method = RequestMethod.GET)
  public List<zjmuserinputmodel> findusers(@RequestParam String username) { 
    List<zjmuserinputmodel> countries = service.findusers(username);
    if (! countries.isEmpty()) {
      return(countries);
    }
    
    throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
        "No users found matching the value provided");
  }
  
  @Operation(summary = "Modifies an existing user.")
  @RequestMapping(value = "/users/{userID}", method = RequestMethod.PUT)
  public zjmusermodel updateUser(@PathVariable String code, @RequestBody zjmuserinputmodel input) {
    if ((code != null) && (! code.isEmpty())) {
      if (input != null) {
        zjmusermodel updated = service.modify(code, input);
        if (updated != null) {
          return(updated);
        }
        
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, 
            "Failed to updated user due to an unhandled or unexpected error.");
      }
    }
    
    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
        "computer identifier or user input was missing, empty or null");
  }
  
  @Operation(summary = "Create a new user.")
  @RequestMapping(value = "/users", method = RequestMethod.POST)
  public zjmuserinputmodel createUser(@RequestBody zjmuserinputmodel input) {
    if (input != null) {
      try {
        zjmuserinputmodel result = service.createUser(input);
        if (result != null) {
          return(result);
        }
      }
      catch (userexists e) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
            e.getMessage());
      }
      
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, 
          "Failed to create user due to an unhandled or unexpected internal error");
    }
    
    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
        "user input was empty or null");
  }
  
  
  @Operation(summary = "Delete or remove a user.")
  @RequestMapping(value = "/user/{userID}", method = RequestMethod.DELETE)
  public zjmusermodel deleteUser(@PathVariable String code) {
    if ((code != null) && (! code.isEmpty())) {
      try {
        zjmusermodel result = service.removeuser(code);
        if (result != null) {
          return(result);
        }
      } catch(usernotfound e) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
            "Requested user doesn't exist.");
      }
      
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, 
          "Failed to remove user due to an unhandled or unexpected error.");
    }   
    
    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
        "userID was empty or null");
  }
  
  //Software
  
  @Operation(summary = "Get's all software.")
  @RequestMapping(value = "/software", method = RequestMethod.GET)
  public List<zjmsoftwaremodel> allsoftware() {
    return service.allsoftware();
  }
  
  @Operation(summary = "Delete or remove a software.")
  @RequestMapping(value = "/software/{softwareID}", method = RequestMethod.DELETE)
  public zjmsoftwaremodel deleteSoftware(@PathVariable String code) {
    if ((code != null) && (! code.isEmpty())) {
      try {
        zjmsoftwaremodel result = service.removeSoftware(code);
        if (result != null) {
          return(result);
        }
      } catch(softwarenotfound e) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
            "Requested software doesn't exist.");
      }
      
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, 
          "Failed to remove software due to an unhandled or unexpected error.");
    }   
    
    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
        "softwareID was empty or null");
  }
  
  @Operation(summary = "Create new software.")
  @RequestMapping(value = "/software", method = RequestMethod.POST)
  public zjmsoftwareinputmodel createSoftware(@RequestBody zjmsoftwareinputmodel input) {
    if (input != null) {
      try {
        zjmsoftwareinputmodel result = service.createSoftware(input);
        if (result != null) {
          return(result);
        }
      }
      catch (softwareexists e) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
            e.getMessage());
      }
      
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, 
          "Failed to create software due to an unhandled or unexpected internal error");
    }
    
    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
        "software input was empty or null");
  }
  
  @Operation(summary = "Modifies an existing software.")
  @RequestMapping(value = "/software/{softwareID}", method = RequestMethod.PUT)
  public zjmsoftwaremodel updateSoftware(@PathVariable String code, @RequestBody zjmsoftwareinputmodel input) {
    if ((code != null) && (! code.isEmpty())) {
      if (input != null) {
        zjmsoftwaremodel updated = service.modifySoftware(code, input);
        if (updated != null) {
          return(updated);
        }
        
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, 
            "Failed to updated software due to an unhandled or unexpected error.");
      }
    }
    
    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
        "computer identifier or software input was missing, empty or null");
  } 
  
  
}