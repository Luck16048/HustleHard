package org.example.repository;
import org.example.config.ConnectDb;
import org.example.entity.PassportEntity;

import java.sql.*;

public class PassportRepository {
    public void savePassport(PassportEntity passportEntity) throws SQLException{
        String sql = "INSERT INTO passport (id, fullName, country, code) VALUE(?, ?, ?, ?)";

        try(Connection conn = ConnectDb.getConnection();
            PreparedStatement st = conn.prepareStatement(sql)){

            st.setInt(1, passportEntity.getId());
            st.setString(2, passportEntity.getFullName());
            st.setString(3, passportEntity.getCountry());
            st.setInt(4, passportEntity.getCode());

            st.executeUpdate();
        }
    }

    public PassportEntity findPassport(int id) throws SQLException{
        String sql = "SELECT * FROM passport WHERE id = ?";

        try(Connection conn = ConnectDb.getConnection();
            PreparedStatement st = conn.prepareStatement(sql)){

            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            if(rs.next()){
                PassportEntity p = new PassportEntity();
                p.setId(rs.getInt("id"));
                p.setFullName(rs.getString("fullName"));
                p.setCountry(rs.getString("country"));
                p.setCode(rs.getInt("code"));
                return p;
            }
        }
        return null;
    }

    public void deletePassport(int id) throws SQLException{
        String sql = "DELETE FROM passport WHERE id = ?";

        try(Connection conn = ConnectDb.getConnection();
            PreparedStatement st = conn.prepareStatement(sql)){

            st.setInt(1,id);
            st.executeUpdate();
        }
    }
}
