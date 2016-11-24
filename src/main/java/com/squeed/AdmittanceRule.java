package com.squeed;

import com.squeed.util.LabDate;

public interface AdmittanceRule {

    boolean isAdmitted(Employee employee, LabDate labDate);

}
