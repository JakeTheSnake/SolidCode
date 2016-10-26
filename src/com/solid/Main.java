package com.solid;

public class Main {

    public static void main(String[] args) {
	    Employee employee = new Employee();
        LabSecurity security = new LabSecurity();
        security.isAdmitted(employee);
    }
}
