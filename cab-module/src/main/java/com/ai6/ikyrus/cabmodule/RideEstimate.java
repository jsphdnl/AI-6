package com.ai6.ikyrus.cabmodule;

import com.ai6.ikyrus.cabmodule.core.models.CabService;
import com.uber.sdk.rides.client.model.PriceEstimate;
import com.uber.sdk.rides.client.model.TimeEstimate;

import java.io.IOException;
import java.util.List;

/**
 * Created by bharath on 7/5/17.
 */
public interface RideEstimate {
    List<TimeEstimate> estimateRide(float latitude, float longitude,
                                    CabService service) throws IOException;

    List<PriceEstimate> estimateBetweenDropPoints(float sourceLatitude, float sourceLongitude,
                                                  float destLatitude, float destLongitude) throws IOException;
}
