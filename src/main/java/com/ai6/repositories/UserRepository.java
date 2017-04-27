package com.ai6.repositories;

import com.ai6.exceptions.DocumentNotFoundException;
import com.ai6.exceptions.InternalServerException;
import com.ai6.exceptions.ResourceNotFoundException;
import com.ai6.models.Users;
import com.ai6.utils.Constants;
import com.ai6.wrapper.CouchBaseWrapper;
import com.couchbase.client.deps.com.fasterxml.jackson.core.JsonProcessingException;
import com.couchbase.client.deps.com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by bharath on 4/26/17.
 */
public class UserRepository {

  private CouchBaseWrapper couchBaseWrapper;
  private ObjectMapper mapper;

  public UserRepository() {
  }

  public UserRepository(CouchBaseWrapper couchBaseWrapper, ObjectMapper mapper) {
    this.couchBaseWrapper = couchBaseWrapper;
    this.mapper = mapper;
  }

  public Users persist(Users users) throws JsonProcessingException {
    String key = couchBaseWrapper.getNextUid(users.getClass().getSimpleName());
    users.setId(key);
    couchBaseWrapper.set(key, users);
    return users;
  }

  public Users getUser(String key)  {
    Users users = null;
    try {
      users = couchBaseWrapper.<Users>get(key, Users.class);
    }catch (IOException ex){
      throw new InternalServerException(Constants.DATABASE_CONNECTION_ERROR_MSG);
    }catch (DocumentNotFoundException ex){
      throw new ResourceNotFoundException(Constants.CANNOT_FIND_RESOURCE_ERROR_MSG +key);
    }
    return users;
  }
}
