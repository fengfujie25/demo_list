package thread.eventbus.test;

import thread.eventbus.AsyncEventBus;
import thread.eventbus.Bus;
import thread.eventbus.EventBus;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author fujie.feng
 * @Date 2020-04-08
 */
public class  TestMain {

    public static void main(String[] args) {
        //同步测试代码
//        Bus bus = new EventBus("TestBus");
//        bus.register(new SimpleSubscribe1());
//        bus.register(new SimpleSubscribe2());
//        bus.post("hello");
//        System.out.println("--------------");
//        bus.post("hello", "test");

        //异步测试代码
        Bus bus = new AsyncEventBus("Testbus", (ThreadPoolExecutor) Executors.newFixedThreadPool(10));
        bus.register(new SimpleSubscribe1());
        bus.register(new SimpleSubscribe2());
        bus.post("hello async");
        System.out.println("---------------------");
        bus.post("hello async", "test");
        bus.close();
    }
}
