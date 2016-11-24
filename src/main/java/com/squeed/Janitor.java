package com.squeed;

import com.squeed.util.LabDate;

public class Janitor extends Employee {

    public Janitor(String name, int startYear) {
        super(name, startYear, new JanitorClearance(startYear));
    }

}