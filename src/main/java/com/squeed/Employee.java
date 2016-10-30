package com.squeed;

public class Employee {
    private String name;
    private Role role;
    private int startedYear;

    Employee(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public int getStartedYear() {
        return startedYear;
    }

    public void setStartedYear(int startedYear) {
        this.startedYear = startedYear;
    }
}
