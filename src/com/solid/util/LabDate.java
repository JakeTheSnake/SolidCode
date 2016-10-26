package com.solid.util;


public class LabDate {

    public enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    public static int getYear() {
        return 2016;
    }

    public static Day getDay() {
        return Day.THURSDAY;
    }
}
