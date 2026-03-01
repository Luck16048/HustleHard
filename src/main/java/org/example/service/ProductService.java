package org.example.service;

import org.example.entity.PersonEntity;
import org.example.entity.ProductEntity;
import org.example.repository.ProductRepository;

import java.sql.SQLException;
import java.util.Map;

public class ProductService {
    private final ProductRepository rep = new ProductRepository();

    public ProductEntity getById(int id) throws SQLException {
        return rep.getById(id);
    }

    public void deleteById(int id) throws SQLException {
        rep.deleteById(id);
    }

    public void save(ProductEntity productEntity) throws SQLException {
        rep.save(productEntity);
    }

    public void update(ProductEntity productEntity) throws SQLException {
        rep.update(productEntity);
    }

    public void patch(int id, Map<String, Object> updates) throws SQLException{
        ProductEntity productEntity = getById(id);
        rep.update(productEntity);
    }
}
