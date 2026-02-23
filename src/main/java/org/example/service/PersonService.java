package org.example.service;
import org.example.entity.PersonEntity;
import org.example.repository.PersonRepository;
import java.sql.SQLException;


public class PersonService {
    private final PersonRepository rep = new PersonRepository();

    public PersonEntity getById(int id) throws SQLException{
        return rep.getById(id);
    }

    public void deletById(int id) throws SQLException{
        rep.deleteById(id);
    }

    public void save(PersonEntity personEntity) throws SQLException{
        rep.save(personEntity);
    }
}
