package com.theo.androidAssi.model;

import java.util.ArrayList;

public class Root {
    public ArrayList<User> users;
    public int total;

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
