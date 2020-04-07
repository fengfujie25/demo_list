package thread.premessage;

import netscape.security.UserTarget;
import thread.chapter.lru.LRUCache;

import java.io.IOException;


/**
 * @author fujie.feng
 * @Date 2020-04-06
 */
public class TestMain {

    public static void main(String[] args) throws IOException {
//        new ChatServer().startServer();
        LRUCache<String, Reference> cache = new LRUCache<>(5, key -> new Reference());
        cache.get("Alex");
        cache.get("Jack");
        cache.get("maomao");
        cache.get("Gavin");
        cache.get("Dillon");
        cache.get("Leo");
        System.out.println(cache.toString());
    }

}
