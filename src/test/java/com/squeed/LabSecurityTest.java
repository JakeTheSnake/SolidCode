package com.squeed;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LabSecurityTest {
    LabSecurity labSecurity = new LabSecurity();

    @Test
    public void manager_is_admitted() throws Exception {
        Employee manager = new Manager("Bosse", 1973);

        assertThat(labSecurity.isAdmitted(manager)).isTrue();
    }

    @Test
    public void janitor_is_not_admitted_when_worked_less_than_30_years() throws Exception {
        Employee janitor = new Janitor("Jane", 2000);

        assertThat(labSecurity.isAdmitted(janitor)).isFalse();
    }

    @Test
    public void janitor_is_admitted_when_worked_more_than_30_years() throws Exception {
        Employee janitor = new Janitor("Jane", 1983);

        assertThat(labSecurity.isAdmitted(janitor)).isTrue();
    }
}
