package com.ai6.cabintent.uber;

import com.ai6.cabintent.CabInterface;
import com.ai6.models.Address;
import com.ai6.models.BookingTransaction;
import com.ai6.models.Ride;
import com.ai6.utils.CAB_CRITERIA;
import com.ai6.utils.CAB_SERVICE;
import com.ai6.utils.Constants;
import com.ai6.utils.UberCustomClient;
import com.uber.sdk.rides.client.ServerTokenSession;
import com.uber.sdk.rides.client.SessionConfiguration;
import com.uber.sdk.rides.client.UberRidesApi;
import com.uber.sdk.rides.client.model.*;
import com.uber.sdk.rides.client.services.RidesService;
import retrofit2.Response;

import javax.ws.rs.QueryParam;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;


/**
 * Created by bharath on 4/27/17.
 */
public class UberClient implements CabInterface{

  private SessionConfiguration configuration ;
  private RidesService clientRideService;
  //User client pass through oauth
  private RidesService oauthRideService;
  private ServerTokenSession session;
  private UberCustomClient uberCustomClient;

  public UberClient(SessionConfiguration configuration, UberCustomClient uberCustomClient) {
    this.configuration = configuration;
    this.uberCustomClient = uberCustomClient;
    this.session = new ServerTokenSession(configuration);
    this.clientRideService= UberRidesApi.with(session).build().createService();
  }

  @Override
  public BookingTransaction bookCab(Long fromLatitude, Long fromLongitude,
      Long toLatitude, Long toLongitude, CAB_CRITERIA cab_criteria) {
    this.clientRideService.getProducts(fromLatitude,fromLongitude);

    return null;
  }

  @Override
  public BookingTransaction cancelCab(String bookingId) {
    return null;
  }


  public List<Product> fetchRides(Address address) throws IOException {
    Response<ProductsResponse> response  = this.clientRideService.
        getProducts(address.getLatitude(), address.getLongitude()).execute();

    ProductsResponse productsResponse  = response.body();
    List<Product> products = productsResponse.getProducts();
    return products;
  }

  public String fetchRideRequest(Long fromLatitude, Long fromLongitude,
      Long toLatitude, Long toLongitude) {
    return null;
  }

  public Ride cheapestRide(Ride ride, String service,
       String cabType,
      Boolean pool) throws IOException{
    List<Product> products = fetchRides(ride.toAddress());
    BigDecimal min  = BigDecimal.ZERO;
    RideEstimate minRideEstimate = null;

    PriceEstimatesResponse response = clientRideService.getPriceEstimates(ride.getFromLatitude(),
        ride.getFromLongitude(),
        ride.getToLatitude(),
        ride.getToLongitude()).execute().body();

    PriceEstimate minEstimate = null;
    for(PriceEstimate estimate: response.getPrices()){
      if(minEstimate == null){
        minEstimate = estimate;
        continue;
      }

      if(minEstimate.getLowEstimate().compareTo(estimate.getLowEstimate()) > 0){
        minEstimate = estimate;
      }
    }

/*    for(Product product : products) {
      RideRequestParameters rideRequestParameters =
          new RideRequestParameters.Builder()
          .setPickupCoordinates(ride.getFromLatitude(), ride.getFromLongitude())
              .setProductId(product.getProductId())
          .setDropoffCoordinates(ride.getToLatitude(),
              ride.getToLongitude()).build();
      RideEstimate rideEstimate = null;
      try {
        rideEstimate =
            uberCustomClient.estimateRide(rideRequestParameters);
      } catch (IOException e) {
        e.printStackTrace();
      }

      if(rideEstimate == null){
        continue;
      }
      if(min.equals(BigDecimal.valueOf(0))){
        min = rideEstimate.getFare().getValue();
        minRideEstimate = rideEstimate;
      }

      if (rideEstimate.getFare().getValue().compareTo(min) < 0){
        min = rideEstimate.getFare().getValue();
        minRideEstimate = rideEstimate;
      }

    }*/

    ride.setEstimateCost(minEstimate.getEstimate());
    ride.setService(minEstimate.getDisplayName());
    ride.setDistance(minEstimate.getDistance());
   // ride.setDistanceUnit(minEstimate.);
    ride.setEstimate(String.valueOf(minEstimate.getDuration()));
    return ride;
  }


  public String getFastestRide(){

    //Response<TimeEstimatesResponse> response = clientRideService.getPickupTimeEstimate(37.79f, -122.39f, productId).execute();
    return null;
  }


  public String getPoolingRide(){

    return null;
  }

  public String getLargeRide(){
    return null;
  }


}
