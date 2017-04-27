package com.ai6.resources;

import com.ai6.models.Users;
import com.ai6.services.UserService;
import com.couchbase.client.deps.com.fasterxml.jackson.core.JsonProcessingException;
import javafx.application.Application;
import org.eclipse.jetty.http.HttpHeader;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

/**
 * Created by bharath on 4/24/17.
 */
@Path("user")
public class UserController {

  private UserService userService;

  public UserController() {
  }

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @POST
  @Consumes("application/json")
  @Produces("application/json")
  public Response createUser(Users user) {
      return Response.accepted(userService.createUser(user)).status(201).build();
  }

  @GET
  @Path("/{user}")
  @Produces("application/json")
  public Response getUser(@PathParam("user") String key){
    return Response.accepted(userService.getUser(key)).status(200).build();
  }

}
