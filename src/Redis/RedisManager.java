package Redis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Set;

/**
 * @description:
 * @author: YZL
 * @time: 2020/4/29 12:04
 */
public class RedisManager {
    private GenericObjectPoolConfig poolConfig;
    private JedisPool jedisPool;
    private Jedis jedis;

    private String host = "127.0.0.1";
    private int port = 6379;
    private String password = "";
    private int dbCount = 16;
    private int timeout = 1000;
    private boolean ssl = false;
    private int currentIndex = 0;

    public RedisManager() {
        poolConfig = new GenericObjectPoolConfig();
        jedisPool = new JedisPool(poolConfig, host, port);
    }

    public RedisManager(String host, int port) {
        this.host = host;
        this.port = port;
        poolConfig = new GenericObjectPoolConfig();
        jedisPool = new JedisPool(poolConfig, host, port);
        jedis = jedisPool.getResource();
    }

    public RedisManager(String host, int port, String password) {
        this.host = host;
        this.port = port;
        this.password = password;
        poolConfig = new GenericObjectPoolConfig();
        jedisPool = new JedisPool(poolConfig, host, port, timeout, password);
        jedis = jedisPool.getResource();
    }

    public RedisManager(String host, int port, String password, int timeout, boolean ssl) {
        this.host = host;
        this.port = port;
        this.password = password;
        this.timeout = timeout;
        this.ssl = ssl;
        poolConfig = new GenericObjectPoolConfig();
        jedisPool = new JedisPool(poolConfig, host, port, timeout, password, ssl);
        jedis = jedisPool.getResource();
    }

    public String useDb(int index) throws Exception {
        this.currentIndex = index;
        String switchResult = null;
        while (switchResult == null) {
            switchResult = jedis.select(index);
        }
        if (!switchResult.equalsIgnoreCase("ok")) {
            throw new Exception("数据库切换失败");
        }
        return switchResult;
    }

    public Set<String> selectAllKeys() {
        return jedis.keys("*");
    }

    public Entity select(String key) throws Exception {
        try {
            Entity entity = new Entity();
            entity.setKey(key);
            entity.setValue(jedis.get(key));
            entity.setTtl(jedis.ttl(key));
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("不存在该键...");
        }

    }

    public String insert(String key, String value) {
        return jedis.set(key, value);
    }

    public long delete(String key) {
        return jedis.del(key);
    }

    public String flushDB() {
        return jedis.flushDB();
    }

    public String getHost() {
        return host;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }
}
