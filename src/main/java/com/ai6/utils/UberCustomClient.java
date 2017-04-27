package com.ai6.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uber.sdk.rides.client.model.RideEstimate;
import com.uber.sdk.rides.client.model.RideRequestParameters;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

/**
 * Created by bharath on 4/27/17.
 */
public class UberCustomClient {

  private String uberApiUrl = "https://api.uber.com/v1.2/requests/estimate";
  private WebTarget webTarget;
  private String uberToken;
  private Client client;
  private ObjectMapper objectMapper;

  public UberCustomClient(String uberToken) {
    this.uberToken = uberToken;
    this.objectMapper = new ObjectMapper();
    //Move to dependency injection
    this.client = ClientBuilder.newClient();
    this.webTarget = client.target(uberApiUrl);
  }

  public RideEstimate estimateRide(RideRequestParameters requestParameters)
      throws IOException {
    objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    String body = objectMapper.writeValueAsString(requestParameters);
    //this.webTarget.path("");
    Response response = this.webTarget.request(MediaType.APPLICATION_JSON)
        .header("Content-Type", "application/json")
        .header("Accept-Language", "en_US")
        .header(HttpHeaders.AUTHORIZATION, "Bearer " + this.uberToken)
        .post(Entity.entity(body, MediaType.APPLICATION_JSON), Response.class);




    RideEstimate rideEstimate = null;
    if(response.getStatus() == 200){
      rideEstimate = this.objectMapper.readValue((String)response.getEntity(), RideEstimate.class);
    }
    return rideEstimate;
  }
}
