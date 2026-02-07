package org.example.entity;

public class ProductEntity {
    private int id;
    private String name;
    private String country;
    private StatusProductEntity status;

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }


    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }


    public void setCountry(String made) {
        this.country = made;
    }
    public String getCountry() {
        return country;
    }


    public void setStatus(StatusProductEntity status) {
        this.status = status;
    }
    public StatusProductEntity getStatus() {
        return status;
    }
}
