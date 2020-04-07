package thread.chapter.lru;

@FunctionalInterface
public interface CacheLoader<K, V> {

    V load(K k);
}
