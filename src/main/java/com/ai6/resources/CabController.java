package com.ai6.resources;

import com.ai6.cabintent.CabBaseServices;
import com.ai6.models.Address;
import com.ai6.models.Ride;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.IOException;

/**
 * Created by bharath on 4/27/17.
 */

@Path("rides")
public class CabController {
  private CabBaseServices cabBaseServices;

  public CabController(CabBaseServices cabBaseServices) {
    this.cabBaseServices = cabBaseServices;
  }

  @POST
  @Path("bookcab")
  @Consumes("application/json")
  @Produces("application/json")
  public Response bookCab(Address address){
    return null;
  }

  @POST
  @Consumes("application/json")
  @Produces("application/json")
  public Response rides(Address address) throws IOException {
    return Response.ok(cabBaseServices.rides(address)).build();
  }

  @POST
  @Path("cheapest")
  @Consumes("application/json")
  @Produces("application/json")
  public Response cheapest(Ride ride, @QueryParam("service") String service,
      @QueryParam("cabType") String cabType,
      @QueryParam("pool") Boolean pool) throws IOException {
    return Response.ok(cabBaseServices.cheapest(ride, service, cabType, pool)).build();
  }

  @POST
  @Path("pool")
  @Consumes("application/json")
  @Produces("application/json")
  public Response pool(Address address){
    return null;
  }

  @POST
  @Path("luxury")
  @Consumes("application/json")
  @Produces("application/json")
  public Response luxury(Address address){
    return null;
  }

  @POST
  @Path("fastest")
  @Consumes("application/json")
  @Produces("application/json")
  public Response fastest(Address address){
    return null;
  }

}
