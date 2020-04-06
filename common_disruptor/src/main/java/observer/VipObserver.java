package observer;

/**
 * @auther: fujie.feng
 * @DateT: 2020-01-03
 */
public class VipObserver extends Observer {

    public VipObserver(String name) {
        super(name);
    }

    @Override
    public void update(Object subject, Object args) {
        super.update(subject, args);
        System.out.println("vip用户获取变更消息，" + getName());
    }
}
