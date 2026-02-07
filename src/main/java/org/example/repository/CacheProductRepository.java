package org.example.repository;
import org.example.config.ConnectRider;
import org.example.entity.ProductEntity;
import org.example.entity.StatusProductEntity;
import redis.clients.jedis.*;


public class CacheProductRepository {
    public void saveProductCache(ProductEntity productEntity){
        try(Jedis jedis = ConnectRider.getConnectionRedis()){
            jedis.set("product:" + productEntity.getId() + ":status", productEntity.getStatus().name());
        }
    }

    public StatusProductEntity findStatusProdust(int productId) {
        try (Jedis jedis = ConnectRider.getConnectionRedis()) {
            String value = jedis.get("product:" + productId + ":status");
            return value != null ? StatusProductEntity.valueOf(value) : null;
        }
    }

    public void deleteProduct(int productId){
        try(Jedis jedis = ConnectRider.getConnectionRedis()){
            jedis.del("product:" + productId + ":status");
        }

    }
}
