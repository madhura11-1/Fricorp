package com.example.fricorp;

public class User {

    private String name;
    private int age;
    private String gender;
    private String userID;
    private String password;
    private String type;


    public User(String name, int age, String gender, String userID, String password,String type) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.userID = userID;
        this.password = password;
        this.type = type;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
