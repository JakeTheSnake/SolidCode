package com.squeed;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class NormalRoleRules implements EmployeeVerifier {

    private Map<Role, Function<Employee, Boolean>> roleRules = new HashMap<>();

    public NormalRoleRules() {
        roleRules.put(Role.MANAGER, employee -> true);
        roleRules.put(Role.SENIOR_SCIENTIST, employee -> true);
    }

    public boolean verify(Employee employee) {
        return roleRules.containsKey(employee.getRole()) &&
                roleRules.get(employee.getRole()).apply(employee);
    }
}
