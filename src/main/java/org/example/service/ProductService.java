package org.example.service;
import org.example.entity.ProductEntity;
import org.example.repository.ProductRepository;
import java.sql.SQLException;

public class ProductService {
    private final ProductRepository rep = new ProductRepository();

    public ProductEntity getById(int id) throws SQLException {
        return rep.getById(id);
    }

    public void deleteById(int id) throws SQLException{
        rep.deleteById(id);
    }

    public void save(ProductEntity productEntity) throws SQLException {
        rep.save(productEntity);
    }
}
