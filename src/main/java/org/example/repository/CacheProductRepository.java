package org.example.repository;

import org.example.config.ConnectRedis;
import org.example.entity.ProductEntity;
import org.example.entity.StatusProductEntity;
import redis.clients.jedis.*;


public class CacheProductRepository {
    public void saveCache(ProductEntity productEntity) {
        try (Jedis jedis = ConnectRedis.getConnectionRedis()) {
            jedis.set("product:" + productEntity.getId() + ":status", productEntity.getStatus().name());
        }
    }

    public StatusProductEntity findCache(int productId) {
        try (Jedis jedis = ConnectRedis.getConnectionRedis()) {
            String value = jedis.get("product:" + productId + ":status");
            return value != null ? StatusProductEntity.valueOf(value) : null;
        }
    }

    public void deleteCache(int productId) {
        try (Jedis jedis = ConnectRedis.getConnectionRedis()) {
            jedis.del("product:" + productId + ":status");
        }

    }
}
