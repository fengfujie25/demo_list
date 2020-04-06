package observer;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @auther: fujie.feng
 * @DateT: 2020-01-03
 */
public class AppTest {

    public static void main(String[] args) {
        Blog blog = new Blog();

        VipObserver vip99 = new VipObserver("vip99");
        VipObserver vip97 = new VipObserver("vip97");

        NormalObserver normal99 = new NormalObserver("noraml99");
        NormalObserver normal97 = new NormalObserver("noraml97");

        new Thread(() -> {
            blog.register(vip99);
            blog.register(vip97);
//            blog.register(normal99);
        }, "register").start();

        new Thread(() -> {
            IntStream.rangeClosed(1, 4).forEach(i -> {
                blog.publish(String.format("新把戏第%s次",i));
            });
        }, "publish").start();

        new Thread(() -> {
            sleep(30);
            blog.remove(vip97);
            sleep(30);
            blog.remove(normal97);
        }, "remove").start();
    }

    private static void sleep(int seconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
