package com.ai6.services;

import com.ai6.exceptions.DocumentNotFoundException;
import com.ai6.exceptions.UnAuthorizedException;
import com.ai6.wrapper.CouchBaseWrapper;

import javax.ws.rs.InternalServerErrorException;
import java.io.IOException;

/**
 * Created by bharath on 4/26/17.
 */
public class AuthorizationService {

  private CouchBaseWrapper couchBaseWrapper;

  public AuthorizationService(CouchBaseWrapper couchBaseWrapper) {
    this.couchBaseWrapper = couchBaseWrapper;
  }

  public void checkAuthorization(String token){
    try {
      couchBaseWrapper.get(token, String.class);

    }catch (DocumentNotFoundException ex) {
      throw new UnAuthorizedException("Error session expired");
    }catch (IOException e) {
      throw new InternalServerErrorException("Failed to connect DB");
    }
  }

  public void createLoginSession(){

  }

  public void deleteLoginSession(){

  }

}
