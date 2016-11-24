package com.squeed;

import com.squeed.util.JavaAPICalendar;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final JavaAPICalendar LAB_CALENDAR = new JavaAPICalendar();
    private LabSecurity security;
    private List<Authenticator> regularAuthenticators;

    public static void main(String[] args) {
        Main program = new Main();
        program.run();
    }

    private void run() {
        Employee employee = new Employee(Role.GUARD);
        regularAuthenticators = new ArrayList<>();
        regularAuthenticators.add(new NormalRoleRules(LAB_CALENDAR));
        regularAuthenticators.add(new GeneralRules(LAB_CALENDAR));
        security = new LabSecurity(regularAuthenticators);
        security.isAdmitted(employee);
    }

    public void panicCallback() {
        List<Authenticator> panicAuthenticators = new ArrayList<>();
        panicAuthenticators.add(new PanicRules());
        security.setAuthenticators(panicAuthenticators);
    }

    public void coastIsClear() {
        security.setAuthenticators(regularAuthenticators);
    }
}
