package com.ai6.ikyrus.cabmodule.core.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by bharath on 7/5/17.
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Trip {
    private String id;
    private ServiceType serviceType;
    private Address source;
    private Address destination;
    private double actualCost;
    private double time;

}
