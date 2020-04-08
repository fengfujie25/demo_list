package thread.eventbus;

import javax.swing.*;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author fujie.feng
 * @Date 2020-04-08
 */
public class AsyncEventBus extends EventBus {

    private static final String DEFAULT_NAME = "default-async";

    public AsyncEventBus(String busName, EventExceptionHandler exceptionHandler, ThreadPoolExecutor executor) {
        super(busName, exceptionHandler, executor);
    }

    public AsyncEventBus(String busName, ThreadPoolExecutor executor) {
        this(busName, null, executor);
    }

    public AsyncEventBus(ThreadPoolExecutor executor) {
        this(DEFAULT_NAME, null, executor);
    }

    public AsyncEventBus(EventExceptionHandler exceptionHandler, ThreadPoolExecutor executor) {
        this(DEFAULT_NAME, exceptionHandler, executor);
    }
}
