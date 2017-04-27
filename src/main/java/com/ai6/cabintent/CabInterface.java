package com.ai6.cabintent;

import com.ai6.models.BookingTransaction;
import com.ai6.utils.CAB_CRITERIA;

/**
 * Created by bharath on 4/27/17.
 */
public interface CabInterface {

  BookingTransaction bookCab(Long fromLatitude, Long fromLongitude,
      Long toLatitude, Long toLongitude, CAB_CRITERIA cab_criteria);
  BookingTransaction cancelCab(String bookingId);

}
