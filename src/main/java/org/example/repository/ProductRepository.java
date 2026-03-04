package org.example.repository;

import org.example.config.ConnectDb;
import org.example.entity.ProductEntity;
import org.example.entity.StatusProductEntity;
import org.jooq.DSLContext;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

import java.sql.*;


public class ProductRepository {
    public ProductEntity getById(int id) throws SQLException {
        DSLContext dsl = ConnectDb.getDSL();

        org.jooq.Record record = dsl.select()
                .from("product")
                .where(field("id").eq(id))
                .fetchOne();

        if (record != null) {
            ProductEntity p = new ProductEntity();
            p.setId(record.get("id", Integer.class));
            p.setName(record.get("name", String.class));
            p.setCountry(record.get("country", String.class));
            p.setStatus(StatusProductEntity.valueOf(record.get("status", String.class)));
            return p;
        }
        return null;
    }


    public void deleteById(int id) throws SQLException {
        DSLContext dsl = ConnectDb.getDSL();

        dsl.deleteFrom(table("product")
                        .where(field("id").eq(id)))
                .execute();
    }


    public void save(ProductEntity productEntity) throws SQLException {
        DSLContext dsl = ConnectDb.getDSL();

        dsl.insertInto(table("product"),
                        field("id"),
                        field("name"),
                        field("country"),
                        field("status"))
                .values(
                        productEntity.getId(),
                        productEntity.getName(),
                        productEntity.getCountry(),
                        productEntity.getStatus().name())
                .execute();
    }


    public void update(ProductEntity productEntity) throws SQLException {
        DSLContext dsl = ConnectDb.getDSL();

        dsl.update(table("product"))
                .set(field("name"), productEntity.getName())
                .set(field("country"), productEntity.getCountry())
                .set(field("status"), productEntity.getStatus().name())
                .where(field("id").eq(productEntity.getId()))
                .execute();
    }
}