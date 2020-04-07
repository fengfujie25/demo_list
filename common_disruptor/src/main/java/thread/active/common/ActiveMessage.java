package thread.active.common;

import thread.active.ActiveFuture;
import thread.active.MethodMessage;

import java.lang.reflect.Method;
import java.util.concurrent.Future;

/**
 * @author fujie.feng
 * @Date 2020-04-07
 */
public class ActiveMessage {

    private final Object[] objects;

    private final Method method;

    private final ActiveFuture<Object> future;

    private final Object service;

    public ActiveMessage(Builder builder) {
        this.objects = builder.objects;
        this.method = builder.method;
        this.future = builder.future;
        this.service = builder.service;
    }

    public void execute() {
        try {
            Object result = method.invoke(service, objects);
            if (future != null) {
                Future<?> realFuture = (Future<?>) result;
                Object realResult = realFuture.get();
                //将结果交给ActiveFuture，接口方法的线程会得到返回
                future.finish(realResult);
            }
        } catch (Exception e) {
            if (future != null) {
                future.finish(null);
            }
        }
    }


    static class Builder {

        public Object[] objects;

        public Method method;

        public ActiveFuture<Object> future;

        public Object service;

        public Builder useMethod(Method method) {
            this.method = method;
            return this;
        }

        public Builder returnFuture(ActiveFuture<Object> future) {
            this.future = future;
            return this;
        }

        public Builder withObjects(Object[] objects) {
            this.objects = objects;
            return this;
        }

        public Builder forService(Object service) {
            this.service = service;
            return this;
        }

        public ActiveMessage builder() {
            return new ActiveMessage(this);
        }
    }
}
