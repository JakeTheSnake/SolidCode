package com.squeed;

import com.squeed.util.LabDate;

public class JanitorClearance implements Clearance {

    private int startYear;

    public JanitorClearance(int startYear){
        this.startYear=startYear;
    }

    @Override
    public boolean isAdmitted() {
           LabDate labDate = new LabDate();
        return labDate.getYear() - this.startYear > 30;
    }
}
