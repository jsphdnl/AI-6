package com.ai6.ikyrus.cabmodule.uber;

import com.ai6.ikyrus.cabmodule.RideEstimate;
import com.ai6.ikyrus.cabmodule.core.models.CabService;
import com.uber.sdk.rides.client.UberRidesApi;
import com.uber.sdk.rides.client.model.PriceEstimate;
import com.uber.sdk.rides.client.model.PriceEstimatesResponse;
import com.uber.sdk.rides.client.model.TimeEstimate;
import com.uber.sdk.rides.client.model.TimeEstimatesResponse;
import com.uber.sdk.rides.client.services.RidesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

/**
 * Created by bharath on 7/5/17.
 */
@Component
public class UberEstimateRide implements RideEstimate {

    private UberAuthentication uberAuthentication;
    private RidesService ridesService;

    @Autowired
    public UberEstimateRide(UberAuthentication uberAuthentication) {
        this.uberAuthentication = uberAuthentication;
        this.ridesService = UberRidesApi
                .with(uberAuthentication.getServerTokenSession())
                .build().createService();
    }


    @Override
    public List<TimeEstimate> estimateRide(float latitude, float longitude,
                                           CabService service) throws IOException {
        Response<TimeEstimatesResponse> response = ridesService
                .getPickupTimeEstimate(latitude, longitude, null).execute();
        List<TimeEstimate> times = response.body().getTimes();
        return times;
    }

    @Override
    public List<PriceEstimate> estimateBetweenDropPoints(float sourceLatitude, float sourceLongitude,
                                                         float destLatitude, float destLongitude) throws IOException {

        Response<PriceEstimatesResponse> response = ridesService.getPriceEstimates(sourceLatitude,
                sourceLongitude, destLatitude, destLongitude).execute();
        return response.body().getPrices();
    }

}
