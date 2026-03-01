package org.example.service;
import org.example.entity.PassportEntity;
import org.example.repository.PassportRepository;
import java.sql.SQLException;
import java.util.Map;

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

    public void update(PassportEntity passportEntity) throws SQLException{
        rep.update(passportEntity);
    }

    public void patch(int id, Map<String, Object> updates) throws SQLException{
        PassportEntity passportEntity = getById(id);
          rep.update(passportEntity);
    }
}
