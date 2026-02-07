package org.example.entity;

public class PassportEntity {
    private int id;
    private String fullName;
    private String country;
    private int code;

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setFullName(String fullName){
        this.fullName = fullName;
    }
    public String getFullName(){
        return fullName;
    }

    public void setCountry(String country){
        this.country = country;
    }
    public String getCountry(){
        return country;
    }

    public void setCode(int code){
        this.code = code;
    }
    public int getCode(){
        return code;
    }

}
