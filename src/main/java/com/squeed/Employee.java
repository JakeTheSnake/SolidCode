package com.squeed;

public class Employee {
    private String name;
    private Role role;

    Employee(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }
}
