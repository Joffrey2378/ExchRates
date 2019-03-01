package com.example.exchrates;

import org.joda.time.DateTime;

public class TimeFactory {

    public static final int DAYS_TO_SUBTRACTION_FROM_CURRENT_DAY = 1;

    public DateTime giveYesterdayDate() {
        return DateTime.now().minusDays(DAYS_TO_SUBTRACTION_FROM_CURRENT_DAY);
    }
}
