package com.squeed.util;


public class LabDate {

    public enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    public int getYear() {
        return 2016;
    }

    public Day getDay() {
        return Day.THURSDAY;
    }
}
