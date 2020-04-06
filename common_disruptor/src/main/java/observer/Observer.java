package observer;

/**
 * 抽象观察者
 * @auther: fujie.feng
 * @DateT: 2020-01-03
 */
public abstract class Observer {

    /**
     * 观察者名称
     */
    private String name;

    public Observer(String name) {
        this.name = name;
    }

    /**
     * 更新状态，由主题调度
     * @param subject
     * @param args
     */
    public void update(Object subject, Object args) {
        System.out.println(name + "_" + args);
    }

    public String getName() {
        return name;
    }
}
