package org.example.repository;
import org.example.config.ConnectRider;
import org.example.entity.ApartmentEntity;
import org.example.entity.StatusEntity;
import redis.clients.jedis.*;

public class CacheApartmentRepository {
    public void saveCache(ApartmentEntity apartmentEntity){
        try(Jedis jedis = ConnectRider.getConnectionRedis()){
            jedis.set("apartment:" + apartmentEntity.getId() + ":status", apartmentEntity.getStatus().name());
        }
    }


    public StatusEntity findCache(int apartmentId){
        try(Jedis jedis = ConnectRider.getConnectionRedis()){
            String value = jedis.get("apartment:" + apartmentId + ":status");
            return  value != null ? StatusEntity.valueOf(value) : null;
        }
    }


    public void deleteCache(int apartmentId){
        try(Jedis jedis = ConnectRider.getConnectionRedis()){
            jedis.del("apartment:" + apartmentId + ":status");
        }
    }
}
