package thread.driven.async;

import thread.driven.Channel;
import thread.driven.Event;

import java.lang.management.RuntimeMXBean;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author fujie.feng
 * @Date 2020-04-09
 */
public abstract class AsyncChannel implements Channel<Event> {

    private final ExecutorService executorService;


    public AsyncChannel() {
        this(Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2));
    }

    public AsyncChannel(ExecutorService executorService) {

        this.executorService = executorService;
    }

    @Override
    public void dispatcher(Event message) {
        executorService.submit(() -> this.handler(message));
    }

    protected abstract void handler(Event message);

    void stop() {
        if (executorService != null && !executorService.isShutdown()) {
            executorService.shutdown();
        }
    }
}
