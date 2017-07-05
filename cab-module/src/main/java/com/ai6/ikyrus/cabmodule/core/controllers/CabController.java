package com.ai6.ikyrus.cabmodule.core.controllers;

import com.ai6.ikyrus.cabmodule.core.models.Address;
import com.ai6.ikyrus.cabmodule.core.models.CabService;
import com.ai6.ikyrus.cabmodule.core.models.Trip;
import com.ai6.ikyrus.cabmodule.uber.UberEstimateRide;
import com.uber.sdk.rides.client.model.PriceEstimate;
import com.uber.sdk.rides.client.model.TimeEstimate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * Created by bharath on 7/5/17.
 */
@RestController
@RequestMapping("/rideestimate")
public class CabController {

    @Autowired
    private UberEstimateRide uberEstimateRide;

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<List<TimeEstimate>> getEstimate(@RequestParam(value = "cabType", required = false) String cabType, @RequestBody Address address) throws IOException {
        return ResponseEntity.ok(uberEstimateRide.estimateRide(address.getLatitude(), address.getLongitude(), new CabService()));
    }

    @RequestMapping(value = "/trip", method = RequestMethod.POST)
    public ResponseEntity<List<PriceEstimate>> getrEstimatesBetweenTrip(@RequestBody Trip trip) throws IOException {
        List<PriceEstimate> priceEstimates = uberEstimateRide
                .estimateBetweenDropPoints(trip.getSource().getLatitude(),
                        trip.getSource().getLongitude(),
                        trip.getDestination().getLatitude(),
                        trip.getDestination().getLongitude());
        return ResponseEntity.ok().body(priceEstimates);
    }
}
