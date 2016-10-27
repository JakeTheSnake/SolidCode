package com.squeed;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Main program = new Main();
        program.run();
    }

    private void run() {
        Employee employee = new Employee(Role.GUARD);
        LabSecurity security = new LabSecurity(new ArrayList<>());
        security.isAdmitted(employee);
    }
}
