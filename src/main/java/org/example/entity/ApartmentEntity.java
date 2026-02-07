package org.example.entity;

public class ApartmentEntity {
    private int id;
    private int number;
    private ServesLevelEntity type;
    private StatusEntity statusEntity;


    public void setId(int id) {
        this.id = id;
    }
    public int getId (){
        return id;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    public int getNumber() {
        return number;
    }

    public void setType(ServesLevelEntity type) {
        this.type = type;
    }
    public ServesLevelEntity getType() {
        return type;
    }

    public void setStatus(StatusEntity statusEntity) {
        this.statusEntity = statusEntity;
    }
    public StatusEntity getStatus() {
        return statusEntity;
    }
}
