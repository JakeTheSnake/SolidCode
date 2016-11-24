package com.squeed;

import com.squeed.util.LabDate;

public class WorkedYearsRule implements AdmittanceRule {
    private final int years;

    public WorkedYearsRule(int years) {
        this.years = years;
    }


    @Override
    public boolean isAdmitted(Employee employee, LabDate labDate) {
        return employee.getStartYear() - labDate.getYear() > years;
    }
}
