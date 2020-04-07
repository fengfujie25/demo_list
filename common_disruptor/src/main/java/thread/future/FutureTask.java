package thread.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author fujie.feng
 * @Date 2020-04-04
 */
public class FutureTask<T> implements Future<T> {

    private T result;

    private boolean isDone = false;

    private final Object lock = new Object();


    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public boolean isDone() {
        return isDone;
    }

    @Override
    public T get() throws InterruptedException, ExecutionException {
        synchronized (lock) {
            while (isDone) {
                lock.wait();
            }
            return result;
        }
    }


    protected void finish(T result) {
        synchronized (lock) {
            if (isDone) {
                return;
            }
            this.result = result;
            this.isDone = true;
            lock.notifyAll();
        }
    }

    @Override
    public T get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }
}
