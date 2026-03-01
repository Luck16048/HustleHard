package org.example.service;

import org.example.entity.ApartmentEntity;
import org.example.repository.ApartmentRepository;

import java.sql.SQLException;
import java.util.Map;

public class ApartmentService {
    private final ApartmentRepository rep = new ApartmentRepository();

    public ApartmentEntity getById(int id) throws SQLException {
        return rep.getById(id);
    }

    public void deleteById(int id) throws SQLException {
        rep.deleteById(id);
    }

    public void save(ApartmentEntity apartmentEntity) throws SQLException {
        rep.save(apartmentEntity);
    }

    public void update(ApartmentEntity apartmentEntity) throws SQLException {
        rep.update(apartmentEntity);
    }

    public void patch(int id, Map<String, Object> updates) throws SQLException{
        ApartmentEntity apartmentEntity = getById(id);
        rep.update(apartmentEntity);
    }
}
