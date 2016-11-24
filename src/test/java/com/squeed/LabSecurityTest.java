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

    private ArrayList<Authenticator> authenticators = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        labSecurity = new LabSecurity(authenticators);
    }

    @Test
    public void lab_security_should_not_admit_if_one_authenticator_fails() throws Exception {
        givenAuthenticatorThatAlwaysFails();
        givenAuthenticatorThatAlwaysAdmits();

        assertThat(labSecurity.isAdmitted(new Employee(null))).isFalse();
    }

    @Test
    public void senior_scientist_is_admitted() {
        givenNormalRoleRules();
        Employee employee = new Employee(Role.SENIOR_SCIENTIST);

        assertThat(labSecurity.isAdmitted(employee)).isTrue();
    }

    @Test
    public void mechanic_is_not_admitted() throws Exception {
        givenNormalRoleRules();
        Employee employee = new Employee(Role.MECHANIC);

        assertThat(labSecurity.isAdmitted(employee)).isFalse();
    }

    @Test
    public void junior_scientist_is_not_admitted() throws Exception {
        givenNormalRoleRules();
        Employee employee = new Employee(Role.JUNIOR_SCIENTIST);

        assertThat(labSecurity.isAdmitted(employee)).isFalse();
    }

    @Test
    public void guard_is_not_admitted() throws Exception {
        givenNormalRoleRules();
        Employee employee = new Employee(Role.GUARD);

        assertThat(labSecurity.isAdmitted(employee)).isFalse();
    }

    @Test
    public void janitor_is_not_admitted() throws Exception {
        givenNormalRoleRules();
        Employee employee = new Employee(Role.JANITOR);

        assertThat(labSecurity.isAdmitted(employee)).isFalse();
    }

    @Test
    public void manager_is_admitted() {
        givenNormalRoleRules();
        Employee employee = new Employee(Role.MANAGER);

        assertThat(labSecurity.isAdmitted(employee)).isTrue();
    }

    @Test
    public void janitor_that_worked_more_than_30_years_should_be_admitted() throws Exception {
        givenNormalRoleRules();
        Employee employee = new Employee(Role.JANITOR);
        employee.setStartedYear(1930);

        when(labCalendarMock.getYear()).thenReturn(2016);

        assertThat(labSecurity.isAdmitted(employee)).isTrue();
    }

    @Test
    public void mechanic_should_be_admitted_on_saturdays() throws Exception {
        givenNormalRoleRules();
        Employee employee = new Employee(Role.MECHANIC);

        when(labCalendarMock.getDay()).thenReturn(LabCalendar.Day.SATURDAY);

        assertThat(labSecurity.isAdmitted(employee)).isTrue();
    }

    @Test
    public void no_one_should_be_allowed_on_sundays() throws Exception {
        givenGeneralRules();

        when(labCalendarMock.getDay()).thenReturn(LabCalendar.Day.SUNDAY);

        for (Role role : Role.values()) {
            Employee employee = new Employee(role);
            assertThat(labSecurity.isAdmitted(employee)).isFalse();
        }
    }

    @Test
    public void employee_with_at_least_5_years_employment_should_be_admitted() throws Exception {
        givenGeneralRules();

        int currentYear = 2016;
        when(labCalendarMock.getYear()).thenReturn(currentYear);
        for (Role role : Role.values()) {
            Employee employee = new Employee(role);
            employee.setStartedYear(currentYear - 5);
            assertThat(labSecurity.isAdmitted(employee)).isTrue();
        }
    }

    @Test
    public void employee_with_less_than_5_years_employment_should_not_be_admitted() throws Exception {
        givenGeneralRules();

        int currentYear = 2016;
        when(labCalendarMock.getYear()).thenReturn(currentYear);
        for (Role role : Role.values()) {
            Employee employee = new Employee(role);
            employee.setStartedYear(currentYear - 4);
            assertThat(labSecurity.isAdmitted(employee)).isFalse();
        }
    }

    private void givenNormalRoleRules() {
        authenticators.add(new NormalRoleRules(labCalendarMock));

    }

    private void givenGeneralRules() {
        authenticators.add(new GeneralRules(labCalendarMock));
    }

    private void givenAuthenticatorThatAlwaysFails() {
        authenticators.add(employee -> false);
    }

    private void givenAuthenticatorThatAlwaysAdmits() {
        authenticators.add(employee -> true);
    }
}
