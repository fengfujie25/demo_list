package thread.active;

import thread.future.FutureTask;

/**
 * @author fujie.feng
 * @Date 2020-04-07
 */
public class ActiveFuture<T> extends FutureTask<T> {

    @Override
    public void finish(T result) {
        super.finish(result);
    }
}
