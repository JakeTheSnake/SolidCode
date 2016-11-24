package com.squeed;

public class LabSecurity {
    public boolean isAdmitted(Employee employee) {



        return employee.getClearance().isAdmitted();
    }
}
