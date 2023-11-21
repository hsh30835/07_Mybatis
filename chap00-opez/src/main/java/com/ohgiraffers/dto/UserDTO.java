package com.ohgiraffers.dto;

public class UserDTO {
    private int userNumber;
    private String userName;
    private String userTier;

    public UserDTO() {
    }

    public UserDTO(int userNumber, String userName, String userTier) {
        this.userNumber = userNumber;
        this.userName = userName;
        this.userTier = userTier;
    }

    public int getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(int userNumber) {
        this.userNumber = userNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserTier() {
        return userTier;
    }

    public void setUserTier(String userTier) {
        this.userTier = userTier;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userNumber=" + userNumber +
                ", userName='" + userName + '\'' +
                ", userTier='" + userTier + '\'' +
                '}';
    }
}
