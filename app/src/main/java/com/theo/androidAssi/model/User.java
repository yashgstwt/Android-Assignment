package com.theo.androidAssi.model;


public class User {
    public int id;
    public String firstName;
    public String lastName;
    public String maidenName;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", maidenName='" + maidenName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", image='" + image + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", eyeColor='" + eyeColor + '\'' +
                ", hair=" + hair +
                ", ip='" + ip + '\'' +
                ", address=" + address +
                ", macAddress='" + macAddress + '\'' +
                ", university='" + university + '\'' +
                ", bank=" + bank +
                ", company=" + company +
                ", ein='" + ein + '\'' +
                ", ssn='" + ssn + '\'' +
                ", userAgent='" + userAgent + '\'' +
                ", crypto=" + crypto +
                ", role='" + role + '\'' +
                '}';
    }

    public int age;
    public String gender;
    public String email;
    public String phone;
    public String username;
    public String password;
    public String birthDate;
    public String image;
    public String bloodGroup;
    public double height;
    public double weight;
    public String eyeColor;
    public Hair hair;
    public String ip;
    public Address address;
    public String macAddress;
    public String university;
    public Bank bank;
    public Company company;
    public String ein;
    public String ssn;
    public String userAgent;
    public Crypto crypto;
    public String role;

}


