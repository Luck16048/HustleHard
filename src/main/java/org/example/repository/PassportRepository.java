package org.example.repository;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

import org.example.config.ConnectDb;
import org.example.entity.PassportEntity;
import org.jooq.DSLContext;

import java.sql.*;


public class PassportRepository {
    public PassportEntity getById(int id) throws SQLException {
        DSLContext dsl = ConnectDb.getDSL();

        org.jooq.Record record = dsl.select()
                .from("passport")
                .where(field("id").eq(id))
                .fetchOne();

        if (record != null) {
            PassportEntity p = new PassportEntity();
            p.setId(record.get("id", Integer.class));
            p.setFullName(record.get("fullName", String.class));
            p.setCountry(record.get("country", String.class));
            p.setCode(record.get("code", Integer.class));
            return p;
        }
        return null;
    }


    public void deleteById(int id) throws SQLException {
        DSLContext dsl = ConnectDb.getDSL();

        dsl.deleteFrom(table("passport"))
                .where(field("id").eq(id))
                .execute();
    }


    public void save(PassportEntity passportEntity) throws SQLException {
        DSLContext dsl = ConnectDb.getDSL();

        dsl.insertInto(table("passport"),
                        field("id"),
                        field("fullName"),
                        field("country"),
                        field("code"))
                .values(
                        passportEntity.getId(),
                        passportEntity.getFullName(),
                        passportEntity.getCountry(),
                        passportEntity.getCode())
                .execute();
    }


    public void update(PassportEntity passportEntity) throws SQLException {
        DSLContext dsl = ConnectDb.getDSL();

        dsl.update(table("password"))
                .set(field("fullName"), passportEntity.getFullName())
                .set(field("country"), passportEntity.getCountry())
                .set(field("code"), passportEntity.getCode())
                .where(field("id").eq(passportEntity.getId()))
                .execute();
    }
}
