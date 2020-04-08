package thread.eventbus.test;

import thread.eventbus.Subscribe;

/**
 * @author fujie.feng
 * @Date 2020-04-08
 */
public class SimpleSubscribe2 {

    @Subscribe
    public void method1(String message) {
        System.out.println("==SimpleSubscriber2==method1==" + message);
    }

    @Subscribe(topic = "test")
    public void method2(String message) {
        System.out.println("==SimpleSubscribe2==method2==" + message);
    }
}
