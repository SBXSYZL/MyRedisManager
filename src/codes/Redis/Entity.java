package codes.Redis;

import java.io.Serializable;

/**
 * @description:
 * @author: YZL
 * @time: 2020/4/29 21:34
 */
public class Entity implements Serializable {
    private String key;
    private Object value;
    private Long ttl;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Long getTtl() {
        return ttl;
    }

    public void setTtl(Long ttl) {
        this.ttl = ttl;
    }

    @Override
    public String toString() {
        return "[ \n" +
                "\tkey: " + key + "\n" +
                "\tvalue: " + value + "\n" +
                "\tttl: " + ttl + "\n" +
                "]";
    }
}
