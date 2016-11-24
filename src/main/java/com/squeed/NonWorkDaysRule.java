package com.squeed;

import com.squeed.util.LabDate;

import java.util.Arrays;
import java.util.List;

public class NonWorkDaysRule implements AdmittanceRule {
    private List<LabDate.Day> nonWorkingDays;

    public NonWorkDaysRule(LabDate.Day... nonWorkingDays) {
        this.nonWorkingDays = Arrays.asList(nonWorkingDays);
    }

    @Override
    public boolean isAdmitted(Employee employee, LabDate labDate) {
        return !nonWorkingDays.contains(labDate.getDay());
    }
}
