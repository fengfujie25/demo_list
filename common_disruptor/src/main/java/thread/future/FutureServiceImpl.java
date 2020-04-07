package thread.future;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * @author fujie.feng
 * @Date 2020-04-03
 */
public class FutureServiceImpl<In, Out> implements FutureService<In, Out> {

    private static final String FUTURE_THREAD_PREFIX = "FUTURE-";

    private final AtomicInteger atomicInteger = new AtomicInteger(0);


    @Override
    public Future<?> submit(Runnable runnable) {

        final FutureTask<Void> futureTask = new FutureTask<>();

        new Thread(() -> {
            runnable.run();
            futureTask.finish(null);
        }, getNextName()).start();

        return futureTask;
    }

    private String getNextName() {
        return FUTURE_THREAD_PREFIX + atomicInteger.getAndIncrement();
    }

    @Override
    public Future<Out> submit(Task<In, Out> task, In in) {

        final FutureTask<Out> futureTask = new FutureTask<>();

        new Thread(() -> {
            Out result = task.get(in);
            futureTask.finish(result);
        }, getNextName()).start();

        return futureTask;
    }

    @Override
    public Future<Out> submit(Task<In, Out> task, In in, CallBack<Out> callback) {
        final FutureTask<Out> futureTask = new FutureTask<>();

        new Thread(() -> {
            Out result = task.get(in);
            futureTask.finish(result);
            if (callback != null) {
                callback.call(result);
            }
        }, getNextName()).start();

        return futureTask;
    }
}
