package com.squeed;

import com.squeed.util.LabCalendar;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class NormalRoleRules implements Authenticator {

    private Map<Role, Function<Employee, Boolean>> roleRules = new HashMap<>();
    private LabCalendar labCalendar;

    public NormalRoleRules(LabCalendar labCalendar) {
        this.labCalendar = labCalendar;
        roleRules.put(Role.MANAGER, employee -> true);
        roleRules.put(Role.SENIOR_SCIENTIST, employee -> true);
        roleRules.put(Role.JANITOR, this::hasWorked30Years);
        roleRules.put(Role.MECHANIC, this::isSaturday);
    }

    private Boolean isSaturday(Employee employee) {
        return LabCalendar.Day.SATURDAY.equals(labCalendar.getDay());
    }

    private Boolean hasWorked30Years(Employee employee) {
        return labCalendar.getYear() - employee.getStartedYear() >= 30;
    }

    public boolean authenticate(Employee employee) {
        return roleRules.containsKey(employee.getRole()) &&
                roleRules.get(employee.getRole()).apply(employee);
    }
}
