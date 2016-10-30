package com.squeed.util;


public interface LabCalendar {
    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }
    int getYear();
    Day getDay();


}
