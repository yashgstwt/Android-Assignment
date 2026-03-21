package com.theo.androidAssi.model;

import java.util.ArrayList;

public class Root {
    public ArrayList<User> users;
    public int total;

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSkip() {
        return skip;
    }

    public void setSkip(int skip) {
        this.skip = skip;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "Root{" +
                "users=" + users +
                ", total=" + total +
                ", skip=" + skip +
                ", limit=" + limit +
                '}';
    }

    public int skip;
    public int limit;
}
