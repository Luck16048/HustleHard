package org.example.repository;
import org.example.config.ConnectRider;
import org.example.entity.PassportEntity;
import redis.clients.jedis.*;

public class CachePassportRepository {
    public void saveCachePassport(PassportEntity passportEntity){
        try(Jedis jedis = ConnectRider.getConnectionRedis()){
            jedis.set("passport:" + passportEntity.getId() + ":code", String.valueOf(passportEntity.getCode()));
        }
    }

    public Integer findCachePassport(int id){
        try(Jedis jedis = ConnectRider.getConnectionRedis()){
            String value = jedis.get("passport:" + id + ":code");
            return  value != null ? Integer.parseInt(value) : null;
        }
    }

    public void deleteCachePassport(int id){
        try(Jedis jedis = ConnectRider.getConnectionRedis()){
            jedis.del("passport:" + id + ":code");
        }
    }
}
