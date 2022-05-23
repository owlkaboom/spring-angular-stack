package com.owlkaboom.springangular.auth.model;

public class FauxUser {
    private String username;

    public FauxUser(String username){
        this.username = username;
    }

    public String getUsername(){
        return username;
    }
}
