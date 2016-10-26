package com.squeed;

public class Main {

    public static void main(String[] args) {
        Main program = new Main();
        program.run();
    }

    private void run() {
        Employee employee = new Employee();
        LabSecurity security = new LabSecurity();
        security.isAdmitted(employee);
    }
}
