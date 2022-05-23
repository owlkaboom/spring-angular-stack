package com.owlkaboom.springangular.auth.model;

public class RegisterDTO extends LoginDTO {

    private String verifyPassword;

    public String getVerifyPassword(){
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword){
        this.verifyPassword = verifyPassword;
    }
}
