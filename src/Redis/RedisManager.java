package Redis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisConnectionException;

import java.util.HashSet;
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
        jedisPool = new JedisPool(poolConfig, host, port, timeout);
    }

    public RedisManager(String host, int port) {
        this.host = host;
        this.port = port;
        poolConfig = new GenericObjectPoolConfig();
        jedisPool = new JedisPool(poolConfig, host, port, timeout);
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
        try {
//            System.out.println(index);
            jedis = jedisPool.getResource();
            this.currentIndex = index;
            return selectDB();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("数据异常");
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }

    }

    private String selectDB() throws Exception {
        String switchResult = null;
        while (switchResult == null) {
            switchResult = jedis.select(currentIndex);
        }
//            System.out.println("DB:" + jedis.getDB());
        if (!switchResult.equalsIgnoreCase("ok")) {
            throw new Exception("数据库切换失败");
        }
        return switchResult;
    }

    public Set<String> selectAllKeys() throws Exception {
        try {
            jedis = jedisPool.getResource();
            selectDB();
            return jedis.keys("*");
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("数据异常");
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public Entity select(String key) throws Exception {
        try {
            jedis = jedisPool.getResource();
            selectDB();
            Entity entity = new Entity();
            entity.setKey(key);
            entity.setValue(jedis.get(key));
            entity.setTtl(jedis.ttl(key));
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("不存在该键...");
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }

    }

    public String insert(String key, String value) throws Exception {
        try {
            jedis = jedisPool.getResource();
            selectDB();
            return jedis.set(key, value);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("数据异常");
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public long delete(String key) throws Exception {
        try {
            jedis = jedisPool.getResource();
            selectDB();
            return jedis.del(key);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("数据异常");
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public String flushDB() throws Exception {
        try {
            jedis = jedisPool.getResource();
            selectDB();
            return jedis.flushDB();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("数据异常");
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }

    }

    public String getHost() {
        return host;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

}
