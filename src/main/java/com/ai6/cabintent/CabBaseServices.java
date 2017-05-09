package com.ai6.cabintent;

import com.ai6.cabintent.uber.UberClient;
import com.ai6.models.Address;
import com.ai6.models.Ride;
import com.uber.sdk.rides.client.model.Product;

import javax.ws.rs.QueryParam;
import java.io.IOException;
import java.util.List;

/**
 * Created by bharath on 4/27/17.
 */
public class CabBaseServices {

  private UberClient uberClient;

  public CabBaseServices(UberClient uberClient) {
    this.uberClient = uberClient;
  }

  public Object bookCab(Address address){
    return null;
  }

  public List<Product> rides(Address address) throws IOException {
    return uberClient.fetchRides(address);
  }


  public Ride cheapest(Ride ride, String service,
      String cabType,
      Boolean pool) throws IOException {
    return uberClient.cheapestRide(ride);
  }

  public Object pool(Address address){
    return null;
  }


  public Object luxury(Address address){
    return null;
  }


  public Object fastest(Address address){
    return null;
  }
}
