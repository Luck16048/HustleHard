package org.example.repository;
import org.example.config.ConnectDb;
import org.example.entity.ProductEntity;
import org.example.entity.StatusProductEntity;

import java.sql.*;

public class ProductRepository {
    public void saveProduct(ProductEntity productEntity) throws SQLException{
    String sql = "INSERT INTO product (id, name, country, status) VALUE (?, ?, ?, ?)";

    try(Connection conn = ConnectDb.getConnection();
        PreparedStatement st = conn.prepareStatement(sql)){

        st.setInt(1, productEntity.getId());
        st.setString(2, productEntity.getName());
        st.setString(3, productEntity.getCountry());
        st.setString(4, productEntity.getStatus().name());

        st.executeUpdate();
    }
    }

    public ProductEntity findProduct(int id) throws SQLException{
    String sql = "SELECT * FROM product WHERE id = ?";

    try(Connection conn = ConnectDb.getConnection();
        PreparedStatement st = conn.prepareStatement(sql)){

        st.setInt(1, id);
        ResultSet rs = st.executeQuery();

        if(rs.next()){
            ProductEntity p = new ProductEntity();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString("name"));
            p.setCountry(rs.getString("country"));
            p.setStatus(StatusProductEntity.valueOf(rs.getString("status")));
            return p;
        }
    }
        return null;
    }

    public void deleteProduct(int id) throws SQLException{
        String sql = "DELETE FROM product WHERE id = ?";

        try(Connection conn = ConnectDb.getConnection();
            PreparedStatement st = conn.prepareStatement(sql)){

            st.setInt(1,id);
            st.executeUpdate();
        }

    }
}