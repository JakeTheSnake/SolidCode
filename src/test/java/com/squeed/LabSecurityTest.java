package com.squeed;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LabSecurityTest {
    LabSecurity labSecurity = new LabSecurity();

    @Test
    public void example_test() throws Exception {
        assertThat(labSecurity.isAdmitted(new Employee())).isFalse();
    }
}
