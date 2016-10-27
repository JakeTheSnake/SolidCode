package com.squeed;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class LabSecurityTest {
    LabSecurity labSecurity;

    @Before
    public void setUp() throws Exception {
        ArrayList<EmployeeVerifier> evaluators = new ArrayList<>();
        evaluators.add(new NormalRoleRules());
        labSecurity = new LabSecurity(evaluators);
    }

    @Test
    public void senior_scientist_is_admitted() {
        Employee employee = new Employee(Role.SENIOR_SCIENTIST);
        assertThat(labSecurity.isAdmitted(employee)).isTrue();
    }

    @Test
    public void manager_is_admitted() {
        Employee employee = new Employee(Role.MANAGER);
        assertThat(labSecurity.isAdmitted(employee)).isTrue();
    }
}
