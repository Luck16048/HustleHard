package org.example.repository;

import org.example.config.ConnectRedis;
import org.example.entity.PersonEntity;
import redis.clients.jedis.Jedis;

public class CachePersonRepository {
    public void saveCache(PersonEntity person) {
        try (Jedis jedis = ConnectRedis.getConnectionRedis()) {
            jedis.set("person:" + person.getId() + ":age", String.valueOf(person.getAge()));
        }
    }

    public String findCache(int personId) {
        try (Jedis jedis = ConnectRedis.getConnectionRedis()) {
            return jedis.get("person:" + personId + ":age");
        }
    }

    public void deleteCache(int personId) {
        try (Jedis jedis = ConnectRedis.getConnectionRedis()) {
            jedis.del("person:" + personId + ":age");
        }
    }
}
