package thread.eventbus;

import java.lang.reflect.Method;

/**
 * @author fujie.feng
 * @Date 2020-04-08
 */
public class Subscriber {

    private final Object subscribeObject;

    private final Method subscribeMethod;

    private boolean disable = false;

    public Subscriber(Object subscribeObject, Method subscribeMethod) {
        this.subscribeObject = subscribeObject;
        this.subscribeMethod = subscribeMethod;
    }

    public Object getSubscribeObject() {
        return this.subscribeObject;
    }

    public void setDispatcher(boolean disable) {
        this.disable = disable;
    }

    public boolean isDisable() {
        return disable;
    }

    public Method getSubscribeMethod() {
        return this.subscribeMethod;
    }
}
