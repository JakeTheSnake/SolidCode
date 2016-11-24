package com.squeed;

import com.squeed.util.LabDate;

import java.util.Set;

public class DayOfWeekRule implements AdmittanceRule {

    private Set<LabDate.Day> days;

    public DayOfWeekRule(Set<LabDate.Day> days) {
        this.days = days;
    }

    @Override
    public boolean isAdmitted(Employee employee, LabDate date) {
        return days.contains(date.getDay());
    }
}
