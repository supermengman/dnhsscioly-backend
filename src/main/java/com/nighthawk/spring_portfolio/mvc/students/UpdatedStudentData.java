package com.nighthawk.spring_portfolio.mvc.students;

import java.util.ArrayList;

public class UpdatedStudentData extends Student {
    private String currentEmail;

    public UpdatedStudentData(Long id, String name, String password, ArrayList<String> event, int graduatingYear,
            String email, String phoneNumber, String currentEmail) {
        super(id, name, password, event, graduatingYear, email, phoneNumber);
        this.currentEmail = currentEmail;
    }

    public UpdatedStudentData() {
        super();
    }

    // getter & setter for new email
    public String getCurrentEmail() {
        return currentEmail;
    }

    public void setCurrentEmail(String currentEmail) {
        this.currentEmail = currentEmail;
    }
}
