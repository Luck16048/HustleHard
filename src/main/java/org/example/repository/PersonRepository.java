package org.example.repository;

import org.example.config.ConnectDb;
import org.example.entity.PersonEntity;
import org.jooq.DSLContext;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PersonRepository {
    public PersonEntity getById(int id) throws SQLException {
        DSLContext dsl = ConnectDb.getDSL();

        org.jooq.Record record = dsl.select()
                .from("person")
                .where(field("id").eq(id))
                .fetchOne();

        if (record != null) {
            PersonEntity p = new PersonEntity();
            p.setId(record.get("id", Integer.class));
            p.setName(record.get("name", String.class));
            p.setAge(record.get("age", Integer.class));
            return p;
        }
        return null;
    }


    public void deleteById(int id) throws SQLException {
        DSLContext dsl = ConnectDb.getDSL();

        dsl.deleteFrom(table("person"))
                .where(field("id").eq(id))
                .execute();
    }


    public void save(PersonEntity personEntity) throws SQLException {
        DSLContext dsl = ConnectDb.getDSL();

        dsl.insertInto(table("person"),
                        field("id"),
                        field("name"),
                        field("age"))
                .values(
                        personEntity.getId(),
                        personEntity.getName(),
                        personEntity.getAge())
                .execute();
    }

    public void update(PersonEntity personEntity) throws SQLException {
        DSLContext dsl = ConnectDb.getDSL();

        dsl.update(table("person"))
                .set(field("name"), personEntity.getName())
                .set(field("age"), personEntity.getAge())
                .where(field("id").eq(personEntity.getId()))
                .execute();
    }
}
