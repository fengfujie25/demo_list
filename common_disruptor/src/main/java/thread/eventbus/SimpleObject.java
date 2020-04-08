package thread.eventbus;

/**
 * @author fujie.feng
 * @Date 2020-04-08
 */
public class SimpleObject {

    @Subscribe(topic = "alex-topic")
    public void test2(Integer x) {

    }

    @Subscribe(topic = "test-topic")
    public void test3(Integer x) {

    }
}
