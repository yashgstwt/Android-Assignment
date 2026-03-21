package com.theo.androidAssi.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class User {
    @PrimaryKey
    public int id;

    @ColumnInfo(name = "firstname")
    public String firstName;

    @ColumnInfo(name = "lastname")
    public String lastName;

    @ColumnInfo(name = "maidenName")
    public String maidenName;
    @ColumnInfo
    public int age;

    @ColumnInfo public String gender;
    @ColumnInfo public String email;
    @ColumnInfo public String phone;
    @ColumnInfo public String username;
    @ColumnInfo
    public String password;
    @ColumnInfo
    public String birthDate;
    @ColumnInfo
    public String image;
    @ColumnInfo
    public String bloodGroup;

    @ColumnInfo
    public double height;
    @ColumnInfo
    public double weight;
    @ColumnInfo
    public String eyeColor;
    @ColumnInfo
    public Hair hair;
    @ColumnInfo
    public String ip;
    @ColumnInfo
    public Address address;
    @ColumnInfo
    public String macAddress;
    @ColumnInfo
    public String university;
    @ColumnInfo
    public Bank bank;
    @ColumnInfo
    public Company company;
    @ColumnInfo
    public String ein;
    @ColumnInfo
    public String ssn;
    @ColumnInfo
    public String userAgent;
    @ColumnInfo
    public Crypto crypto;
    @ColumnInfo
    public String role;

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
}


