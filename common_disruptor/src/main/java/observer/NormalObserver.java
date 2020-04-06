package observer;

/**
 * @auther: fujie.feng
 * @DateT: 2020-01-03
 */
public class NormalObserver extends Observer {

    public NormalObserver(String name) {
        super(name);
    }

    @Override
    public void update(Object subject, Object args) {
        super.update(subject, args);
        System.out.println("普通用户获取更新通知，" + getName());
    }
}
