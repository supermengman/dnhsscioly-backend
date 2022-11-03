package com.nighthawk.spring_portfolio.mvc.students;

import java.util.ArrayList;

public class UpdatedStudentData extends Student {
    private String currentEmail;

    public UpdatedStudentData(Long id, String name, String passwordHash, ArrayList<String> event, int graduatingYear,
            String email, String phoneNumber, String currentEmail) {
        super(id, name, passwordHash, event, graduatingYear, email, phoneNumber);
        this.currentEmail = currentEmail;
    }

    // getter & setter for new email
    public String getCurrentEmail() {
        return currentEmail;
    }

    public void setCurrentEmail(String currentEmail) {
        this.currentEmail = currentEmail;
    }
}