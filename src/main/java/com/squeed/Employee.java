package com.squeed;

import com.squeed.util.LabDate;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.squeed.util.LabDate.Day.SUNDAY;
import static java.util.Arrays.asList;

public abstract class Employee {

    private String name;
    private int startYear;
    private List<AdmittanceRule> admittanceRules = new ArrayList<>();

    public Employee(String name, int startYear) {
        this.name = name;
        this.startYear = startYear;
        addAdmittanceRules(new NonWorkDaysRule(SUNDAY), new WorkedYearsRule(5));
    }

    private void addAdmittanceRules(AdmittanceRule... rules) {
        this.admittanceRules.addAll(asList(rules));
    }

    public String getName() {
        return name;
    }

    public int getStartYear() {
        return startYear;
    }

    public boolean isAdmitted(LabDate labDate) {
        for (AdmittanceRule rule : this.admittanceRules) {
            if (!rule.isAdmitted(this, labDate)) {
                return false;
            }
        }
        return true;
    }
}
