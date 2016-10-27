package com.squeed;

import java.util.List;

public class LabSecurity {

    private List<EmployeeVerifier> verifiers;

    public LabSecurity(List<EmployeeVerifier> verifiers) {
        this.verifiers = verifiers;
    }

    public boolean isAdmitted(Employee employee) {
        return verifiers.stream()
            .allMatch(evaluator -> evaluator.verify(employee));
    }
}
