package thread.chapter.lru;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author fujie.feng
 * @Date 2020-04-06
 */
public class LRUCache<K, V> {

    /**
     * 存放所有key的链表
     */
    private final LinkedList<K> linkedList = new LinkedList<K>();

    /**
     * 缓存
     */
    private final Map<K, V> cache = new HashMap<>();

    /**
     * 容量
     */
    private final int capacity;

    /**
     * value加载器
     */
    private final CacheLoader<K,V> cacheLoader;

    public LRUCache(int capacity, CacheLoader<K, V> cacheLoader) {
        this.capacity = capacity;
        this.cacheLoader = cacheLoader;
    }

    /**
     * 每次都将新数据放到链表的尾部
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        if (linkedList.size() >= capacity) {
            K oldData = linkedList.removeFirst();
            cache.remove(oldData);
        }
        if (cache.containsKey(key)) {
            linkedList.remove(key);
        }
        linkedList.addLast(key);
        cache.put(key, value);
    }

    /**
     * 每次都判断删除是否成功
     * 成功：证明原来存在 直接返回cache.get(key)
     * 失败：则调用cacheLoader.load(key), 然后放到cache中
     * @param key
     * @return
     */
    public V get(K key) {
        boolean flag = linkedList.remove(key);
        V value;
        if (flag) {
            linkedList.addLast(key);
            value = cache.get(key);
        } else {
            value = cacheLoader.load(key);
            this.put(key, value);
        }
        return value;
    }

    @Override
    public String toString() {
        return this.linkedList.toString();
    }
}
