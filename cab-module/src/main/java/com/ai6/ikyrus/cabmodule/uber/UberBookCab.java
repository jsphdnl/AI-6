package com.ai6.ikyrus.cabmodule.uber;

import com.ai6.ikyrus.cabmodule.BookCab;
import com.ai6.ikyrus.cabmodule.core.models.ActionType;
import com.ai6.ikyrus.cabmodule.core.models.Address;
import com.ai6.ikyrus.cabmodule.core.models.ServiceType;
import com.ai6.ikyrus.cabmodule.core.models.Trip;

/**
 * Created by bharath on 7/5/17.
 */
public class UberBookCab implements BookCab{
    @Override
    public Trip bookCab(Address source, Address dest, ServiceType serviceType) {
        return null;
    }

    @Override
    public Trip bookCab(Address source, Address dest, ServiceType serviceType, ActionType actionType) {
        return null;
    }

    @Override
    public boolean cancelCab(Trip trip) {
        return false;
    }
}
