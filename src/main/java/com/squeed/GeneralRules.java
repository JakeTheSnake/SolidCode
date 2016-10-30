package com.squeed;


import com.squeed.util.LabCalendar;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class GeneralRules implements Authenticator {

    private LabCalendar labCalendar;
    private List<Function<Employee, Boolean>> rules = new ArrayList<>();

    public GeneralRules(LabCalendar labCalendar) {
        this.labCalendar = labCalendar;
        rules.add(isNotSunday());
        rules.add(hasWorkedAtLeast5Years());
    }

    private Function<Employee, Boolean> hasWorkedAtLeast5Years() {
        return employee -> labCalendar.getYear() - employee.getStartedYear() >= 5;
    }

    private Function<Employee, Boolean> isNotSunday() {
        return employee -> !LabCalendar.Day.SUNDAY.equals(labCalendar.getDay());
    }


    @Override
    public boolean authenticate(Employee employee) {
        return rules.stream()
                .allMatch(rule -> rule.apply(employee));
    }
}
