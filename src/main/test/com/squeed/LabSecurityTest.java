package com.squeed;


import com.squeed.util.LabCalendar;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LabSecurityTest {
    private LabSecurity labSecurity;

    @Mock
    private LabCalendar labCalendarMock;

    @Before
    public void setUp() throws Exception {
        ArrayList<EmployeeVerifier> evaluators = new ArrayList<>();
        evaluators.add(new NormalRoleRules(labCalendarMock));
        labSecurity = new LabSecurity(evaluators);
    }

    @Test
    public void senior_scientist_is_admitted() {
        Employee employee = new Employee(Role.SENIOR_SCIENTIST);
        assertThat(labSecurity.isAdmitted(employee)).isTrue();
    }

    @Test
    public void mechanic_is_not_admitted() throws Exception {
        Employee employee = new Employee(Role.MECHANIC);
        assertThat(labSecurity.isAdmitted(employee)).isFalse();
    }

    @Test
    public void junior_scientist_is_not_admitted() throws Exception {
        Employee employee = new Employee(Role.JUNIOR_SCIENTIST);
        assertThat(labSecurity.isAdmitted(employee)).isFalse();
    }

    @Test
    public void guard_is_not_admitted() throws Exception {
        Employee employee = new Employee(Role.GUARD);
        assertThat(labSecurity.isAdmitted(employee)).isFalse();
    }

    @Test
    public void manager_is_admitted() {
        Employee employee = new Employee(Role.MANAGER);
        assertThat(labSecurity.isAdmitted(employee)).isTrue();
    }

    @Test
    public void janitor_that_worked_more_than_30_years_should_be_admitted() throws Exception {
        Employee employee = new Employee(Role.JANITOR);
        employee.setStartedYear(1930);
        when(labCalendarMock.getYear()).thenReturn(2016);
        assertThat(labSecurity.isAdmitted(employee)).isTrue();
    }

    @Test
    public void mechanic_should_be_admitted_on_saturdays() throws Exception {
        Employee employee = new Employee(Role.MECHANIC);
        when(labCalendarMock.getDay()).thenReturn(LabCalendar.Day.SATURDAY);
        assertThat(labSecurity.isAdmitted(employee)).isTrue();
    }

}
