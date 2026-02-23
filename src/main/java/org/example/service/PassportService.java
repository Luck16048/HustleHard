package org.example.service;
import org.example.entity.PassportEntity;
import org.example.repository.PassportRepository;
import java.sql.SQLException;

public class PassportService {
    private final PassportRepository rep = new PassportRepository();

    public PassportEntity getById(int id) throws SQLException{
        return rep.getById(id);
    }

    public void deleteById(int id) throws SQLException{
        rep.deleteById(id);
    }

    public void save(PassportEntity passportEntity) throws  SQLException{
        rep.save(passportEntity);
    }
}
