package ellysmore.redditmeh.util;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationFieldType;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.format.PeriodFormat;

import java.util.Locale;

/**
 * Created by JZallas on 4/4/2015.
 */
public final class TimeHelper {

    /**
     * Get the difference between the current time and the provided start time. <br>
     * Example: The difference between a <strong>start</strong> of 6:32 and an <strong>current
     * time</strong> of 6:36 will be <em>"4 minutes"</em>
     *
     * @param startTime a {@link org.joda.time.DateTime} object representing the start time using
     *                  {@link org.joda.time.DateTimeZone#UTC}
     * @return a {@link java.lang.String} representing the time difference in a human readable
     * format
     */

    public static String getDifference(long startTime) {
        DateTime startedTime = new DateTime(startTime * 1000);
        return getDifference(startedTime);
    }

    //TODO: Fix TimeHelper
    public static String getDifference(DateTime startTime) {
        return getDifference(startTime, new DateTime(System.currentTimeMillis()));
    }

    //TODO: Fix TimeHelper
    public static String getDifference(DateTime startTime, DateTime endTime) {
        DurationFieldType[] fieldTypes = new DurationFieldType[]
                {DurationFieldType.months(),
                        DurationFieldType.weeks(), DurationFieldType.days(),
                        DurationFieldType.hours(), DurationFieldType.minutes()};
        Period difference = new Period(startTime, endTime, PeriodType.forFields(fieldTypes));
        return PeriodFormat.wordBased(Locale.getDefault()).print(difference);
    }
}
