package com.example.hotelApp.dto;

public class UserPasswordChangeDTO {
    private Integer userID;
    private String newPassword;

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
