package com.dbserver.testapp;

import com.dbserver.raw.FileHandler;

public class TestApp {
    public static void main(String[] args) {
        try {
            FileHandler fh = new FileHandler("test.db");
            fh.add("someguy_name", 30, "address", "carplate number", "the description");
            fh.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
