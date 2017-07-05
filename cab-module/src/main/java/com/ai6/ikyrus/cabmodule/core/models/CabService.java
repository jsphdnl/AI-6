package com.ai6.ikyrus.cabmodule.core.models;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by bharath on 7/5/17.
 */
@Data
@NoArgsConstructor
public class CabService {
    private ServiceType serviceType;
    private String subService;
}
