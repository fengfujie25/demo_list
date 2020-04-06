package observer;

/**
 * Blog主题
 * @auther: fujie.feng
 * @DateT: 2020-01-03
 */
public class Blog extends Subject {

    @Override
    public void publish(String msg) {
        System.out.println("发布blog msg：" + msg);
        getObserverList().forEach(observer -> {
            observer.update(this, msg);
        });
    }
}
