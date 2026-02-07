package org.example.repository;
import org.example.config.ConnectDb;
import org.example.entity.ApartmentEntity;
import org.example.entity.ServesLevelEntity;
import org.example.entity.StatusEntity;

import java.sql.*;

public class ApartmentRepository {
    public void saveApartment(ApartmentEntity apartmentEntity) throws SQLException{
        String sql = "INSERT INTO apartment (id, number, class, status) VALUE (?, ?, ?, ?)";

        try(Connection conn = ConnectDb.getConnection();
            PreparedStatement st = conn.prepareStatement(sql)){

            st.setInt(1, apartmentEntity.getId());
            st.setInt(2, apartmentEntity.getNumber());
            st.setString(3, apartmentEntity.getType().name());
            st.setString(4, apartmentEntity.getStatus().name());

            st.executeUpdate();
        }
    }


    public ApartmentEntity findApartment(int id) throws SQLException{
        String sql = "SELECT * FROM apartment WHERE id = ?";

        try(Connection conn = ConnectDb.getConnection();
            PreparedStatement st = conn.prepareStatement(sql)){

            st.setInt(1,id);
            ResultSet rs = st.executeQuery();

            if(rs.next()){
                ApartmentEntity ap = new ApartmentEntity();
                ap.setId(rs.getInt("id"));
                ap.setNumber(rs.getInt("number"));
                ap.setType(ServesLevelEntity.valueOf(rs.getString("class")));
                ap.setStatus(StatusEntity.valueOf(rs.getString("status")));

                return ap;
            }
            return null;
        }

    }



    public void deleteApartment(int id) throws SQLException{
          String sql = "DELETE FROM apartment WHERE id = ?";

          try(Connection conn = ConnectDb.getConnection();
              PreparedStatement st = conn.prepareStatement(sql)){

              st.setInt(1,id);
              st.executeUpdate();
          }

    }
}
