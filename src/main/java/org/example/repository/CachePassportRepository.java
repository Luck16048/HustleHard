package org.example.repository;

import org.example.config.ConnectRedis;
import org.example.entity.PassportEntity;
import redis.clients.jedis.*;

public class CachePassportRepository {
    public void saveCache(PassportEntity passportEntity) {
        try (Jedis jedis = ConnectRedis.getConnectionRedis()) {
            jedis.set("passport:" + passportEntity.getId() + ":code", String.valueOf(passportEntity.getCode()));
        }
    }

    public Integer findCache(int id) {
        try (Jedis jedis = ConnectRedis.getConnectionRedis()) {
            String value = jedis.get("passport:" + id + ":code");
            return value != null ? Integer.parseInt(value) : null;
        }
    }

    public void deleteCache(int id) {
        try (Jedis jedis = ConnectRedis.getConnectionRedis()) {
            jedis.del("passport:" + id + ":code");
        }
    }
}
