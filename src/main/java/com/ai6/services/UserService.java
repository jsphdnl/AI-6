package com.ai6.services;

import com.ai6.exceptions.InternalServerException;
import com.ai6.models.Users;
import com.ai6.repositories.UserRepository;
import com.ai6.utils.Constants;
import com.couchbase.client.deps.com.fasterxml.jackson.core.JsonProcessingException;

/**
 * Created by bharath on 4/26/17.
 */
public class UserService {
  private UserRepository userRepository;

  public UserService() {
  }

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public Users createUser(Users user) {
    Users users = null;
    try {
      users = userRepository.persist(user);
    } catch (JsonProcessingException ex) {
      throw new InternalServerException(
          Constants.DATABASE_CONNECTION_ERROR_MSG);
    }
    return users;
  }

  public Users getUser(String key) {
    return userRepository.getUser(key);
  }
}
