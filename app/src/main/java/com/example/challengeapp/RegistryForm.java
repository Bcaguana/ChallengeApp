package com.example.challengeapp;

public class RegistryForm {
    private String name;
    private String email;
    private String password;
    private String rePassword;

    private Boolean validName = false, validEmail = false, validPassword = false, validRePassword = false;
    private Boolean isValid = false;

    public RegistryForm(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public RegistryForm(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        if (!getName().isEmpty())
            validName = true;
        else
            validName = false;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        if (getEmail().contains("@"))
            this.validEmail = true;
        else
            this.validEmail = false;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        if (!getPassword().isEmpty())
            this.validPassword = true;
        else
            this.validPassword = false;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
        if (getRePassword().equals(this.password))
            this.validRePassword = true;
        else
            this.validRePassword = false;
    }

    public void validateData(){
        if (this.validEmail && this.validPassword && this.validName && this.validRePassword){
            this.isValid = true;
        }else {
            this.isValid = false;
        }
    }

    public boolean getValidName(){
        return this.validName;
    }

    public boolean getValidEmail(){
        return this.validEmail;
    }

    public boolean getValidPassword(){
        return this.validPassword;
    }

    public boolean getValidRePassword(){
        return this.validRePassword;
    }

    public boolean isValid(){
        return isValid;
    }
}
