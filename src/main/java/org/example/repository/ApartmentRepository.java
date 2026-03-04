package org.example.repository;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

import org.example.config.ConnectDb;
import org.example.entity.ApartmentEntity;
import org.example.entity.ServesLevelEntity;
import org.example.entity.StatusEntity;
import org.jooq.DSLContext;

import java.sql.*;


public class ApartmentRepository {
    public ApartmentEntity getById(int id) throws SQLException {
        DSLContext dsl = ConnectDb.getDSL();

        org.jooq.Record record = dsl.select()
                .from("apartment")
                .where(field("id")
                        .eq(id)).fetchOne();

        if (record != null) {
            ApartmentEntity ap = new ApartmentEntity();
            ap.setId(record.get("id", Integer.class));
            ap.setNumber(record.get("number", Integer.class));
            ap.setType(ServesLevelEntity.valueOf(record.get("class", String.class)));
            ap.setStatus(StatusEntity.valueOf(record.get("status", String.class)));

            return ap;
        }
        return null;
    }


    public void deleteById(int id) throws SQLException {
        DSLContext dsl = ConnectDb.getDSL();

        dsl.deleteFrom(table("apartment"))
                .where(field("id")
                        .eq(id))
                .execute();
    }


    public void save(ApartmentEntity apartmentEntity) throws SQLException {
        DSLContext dsl = ConnectDb.getDSL();

        dsl.insertInto(table("apartment"),
                        field("id"),
                        field("number"),
                        field("class"),
                        field("status"))
                .values(apartmentEntity.getId(),
                        apartmentEntity.getNumber(),
                        apartmentEntity.getType(),
                        apartmentEntity.getStatus())
                .execute();
    }


    public void update(ApartmentEntity apartmentEntity) throws SQLException {
        DSLContext dsl = ConnectDb.getDSL();

        dsl.update(table("apartment"))
                .set(field("number"), apartmentEntity.getNumber())
                .set(field("class"), apartmentEntity.getType().name())
                .set(field("status"), apartmentEntity.getStatus().name())
                .where(field("id").eq(apartmentEntity.getId()))
                .execute();
    }
}
