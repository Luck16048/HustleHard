package org.example.service;
import org.example.entity.PersonEntity;
import org.example.repository.PersonRepository;
import java.sql.SQLException;
import java.util.Map;


public class PersonService {
    private final PersonRepository rep = new PersonRepository();

    public PersonEntity getById(int id) throws SQLException{
        return rep.getById(id);
    }

    public void deleteById(int id) throws SQLException{
        rep.deleteById(id);
    }

    public void save(PersonEntity personEntity) throws SQLException{
        rep.save(personEntity);
    }

    public void update(PersonEntity personEntity) throws SQLException{
        rep.update(personEntity);
    }

    public void patch(int id, Map<String, Object> updates) throws SQLException{
        PersonEntity personEntity = getById(id);
        rep.update(personEntity);
    }
}
