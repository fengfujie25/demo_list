package observer;

import java.util.ArrayList;
import java.util.List;


/**
 * 抽象主题
 * @auther: fujie.feng
 * @DateT: 2020-01-03
 */
public abstract class Subject {

    /**
     * 主题订阅者们
     */
    private List<Observer> observerList = new ArrayList<>();

    /**
     * 订阅
     * @param observer
     */
    public void register(Observer observer) {
        observerList.add(observer);
    }

    /**
     * 取消订阅
     * @param observer
     */
    public void remove(Observer observer) {
        observerList.remove(observer);
    }

    /**
     * 发布东西
     * @param msg
     */
    public abstract void publish(String msg);

    public List<Observer> getObserverList() {
        return observerList;
    }
}
