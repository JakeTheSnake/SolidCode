package com.squeed;

import java.util.List;

public class LabSecurity {

    private List<Authenticator> authenticators;

    public LabSecurity(List<Authenticator> authenticators) {
        this.authenticators = authenticators;
    }

    public boolean isAdmitted(Employee employee) {
        return authenticators.stream()
            .allMatch(evaluator -> evaluator.authenticate(employee));
    }

    public void setAuthenticators(List<Authenticator> authenticators) {
        this.authenticators = authenticators;
    }
}
