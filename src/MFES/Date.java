package MFES;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class Date {
    private Number day;
    private Number month;
    private Number year;
    private Number hour;
    private Number minute;
    private Number second;

    public Date(final Number dHour, final Number dMinute, final Number dSecond,
        final Number dDay, final Number dMonth, final Number dYear) {
        cg_init_Date_1(dHour, dMinute, dSecond, dDay, dMonth, dYear);
    }

    public Date() {
    }

    public void cg_init_Date_1(final Number dHour, final Number dMinute,
        final Number dSecond, final Number dDay, final Number dMonth,
        final Number dYear) {
        hour = dHour;
        minute = dMinute;
        second = dSecond;
        day = dDay;
        month = dMonth;
        year = dYear;

        return;
    }

    public String toString() {
        return "Date{" + "day := " + Utils.toString(day) + ", month := " +
        Utils.toString(month) + ", year := " + Utils.toString(year) +
        ", hour := " + Utils.toString(hour) + ", minute := " +
        Utils.toString(minute) + ", second := " + Utils.toString(second) + "}";
    }
}
