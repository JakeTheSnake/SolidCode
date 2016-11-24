package com.squeed;

public class PanicRules implements Authenticator {
    @Override
    public boolean authenticate(Employee employee) {
        return employee.getRole().equals(Role.GUARD);
    }
}
