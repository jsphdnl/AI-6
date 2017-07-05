package com.ai6.ikyrus.cabmodule;

import com.ai6.ikyrus.cabmodule.core.models.ActionType;
import com.ai6.ikyrus.cabmodule.core.models.Address;
import com.ai6.ikyrus.cabmodule.core.models.ServiceType;
import com.ai6.ikyrus.cabmodule.core.models.Trip;

/**
 * Created by bharath on 7/5/17.
 */
public interface BookCab {
     Trip bookCab(Address source, Address dest, ServiceType serviceType);
     Trip bookCab(Address source, Address dest, ServiceType serviceType,
                        ActionType actionType);

     boolean cancelCab(Trip trip);
}
