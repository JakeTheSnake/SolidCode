package com.squeed.util;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class JavaAPICalendar implements LabCalendar {
    @Override
    public int getYear() {
        return LocalDate.now().getYear();
    }

    @Override
    public Day getDay() {
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
        switch (dayOfWeek) {
            case MONDAY:
                return Day.MONDAY;
            case TUESDAY:
                return Day.TUESDAY;
            case WEDNESDAY:
                return Day.WEDNESDAY;
            case THURSDAY:
                return Day.THURSDAY;
            case FRIDAY:
                return Day.FRIDAY;
            case SATURDAY:
                return Day.SATURDAY;
            case SUNDAY:
                return Day.SUNDAY;
            default:
                return null;
        }
    }
}
