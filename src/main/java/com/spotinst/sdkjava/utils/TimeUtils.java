package com.spotinst.sdkjava.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by yossi.elman on 01/03/2020.
 */
public class TimeUtils {

    public static String convertDateToISO8601(Date date) {
        String retVal = null;

        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
            Calendar         cal = Calendar.getInstance();
            cal.setTime(date);
            retVal = sdf.format(cal.getTime());
        }

        return retVal;
    }
}
