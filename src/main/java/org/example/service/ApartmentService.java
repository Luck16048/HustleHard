package org.example.service;
import org.example.entity.ApartmentEntity;
import org.example.repository.ApartmentRepository;
import java.sql.SQLException;

public class ApartmentService {
    private final ApartmentRepository rep = new ApartmentRepository();

    public ApartmentEntity getById(int id) throws SQLException{
        return rep.getById(id);
    }

    public void deleteById(int id) throws SQLException{
        rep.deleteById(id);
    }

    public void save(ApartmentEntity apartmentEntity) throws  SQLException{
        rep.save(apartmentEntity);
    }
}
