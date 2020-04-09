package thread.driven.async;

import thread.driven.Channel;
import thread.driven.DynamicRouter;
import thread.driven.Event;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author fujie.feng
 * @Date 2020-04-09
 */
public class AsyncEventDispatcher implements DynamicRouter<Event> {

    private final Map<Class<? extends Event>, AsyncChannel> routerTable;

    public AsyncEventDispatcher() {
        this.routerTable = new ConcurrentHashMap<>();
    }

    @Override
    public void registerChannel(Class<? extends Event> messageType, Channel<? extends Event> channel) {
        if ( !(channel instanceof AsyncChannel)) {
            throw new IllegalArgumentException("the channel must be AsyncChannel Type.");
        }
        this.routerTable.put(messageType, (AsyncChannel) channel);
    }

    @Override
    public void dispatcher(Event message) {
        if (routerTable.containsKey(message.getType())) {
            routerTable.get(message.getType()).dispatcher(message);
        } else {
            throw new RuntimeException("can't match the channel for [" + message.getType() + "] type");
        }
    }

    public void shutDown() {
        routerTable.values().forEach(AsyncChannel::stop);
    }
}
