package org.example.repository;
import org.example.config.ConnectDb;
import org.example.entity.PersonEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PersonRepository {
    public PersonEntity getById(int id) throws  SQLException{
    String sql = "SELECT * FROM person WHERE id = ?";

    try(Connection conn = ConnectDb.getConnection();
        PreparedStatement st = conn.prepareStatement(sql)){

        st.setInt(1,id);
        ResultSet rs = st.executeQuery();

        if(rs.next()){
            PersonEntity p = new PersonEntity();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString("name"));
            p.setAge(rs.getInt("age"));
            return  p;
        }
    }
    return null;
}


    public void deleteById(int id) throws SQLException{
        String sql = "DELETE FROM person WHERE id = ?";

        try(Connection conn = ConnectDb.getConnection();
        PreparedStatement st = conn.prepareStatement(sql)){

            st.setInt(1,id);
            st.executeUpdate();
        }
    }


    public void save(PersonEntity personEntity) throws SQLException{
        String sql ="INSERT INTO person (id, name, age) VALUE (?,?,?)";

        try(Connection conn = ConnectDb.getConnection();
            PreparedStatement st = conn.prepareStatement(sql)){

            st.setInt(1,personEntity.getId());
            st.setString(2,personEntity.getName());
            st.setInt(3,personEntity.getAge());

            st.executeUpdate();
        }
    }

}
