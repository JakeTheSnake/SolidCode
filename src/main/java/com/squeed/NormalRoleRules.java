package com.squeed;

import com.squeed.util.LabCalendar;
import com.squeed.util.LabCalendarImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class NormalRoleRules implements EmployeeVerifier {

    private Map<Role, Function<Employee, Boolean>> roleRules = new HashMap<>();

    public NormalRoleRules(LabCalendar labCalendar) {
        roleRules.put(Role.MANAGER, employee -> true);
        roleRules.put(Role.SENIOR_SCIENTIST, employee -> true);
        roleRules.put(Role.JANITOR, employee -> labCalendar.getYear() - employee.getStartedYear() >= 30);
        roleRules.put(Role.MECHANIC, employee -> LabCalendar.Day.SATURDAY.equals(labCalendar.getDay()));
    }

    public boolean verify(Employee employee) {
        return roleRules.containsKey(employee.getRole()) &&
                roleRules.get(employee.getRole()).apply(employee);
    }
}
