package thread.driven;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fujie.feng
 * @Date 2020-04-09
 */
public class EventDispatcher implements DynamicRouter<Message> {

    private final Map<Class<? extends Message>, Channel> routerTable;

    public EventDispatcher() {
        this.routerTable = new HashMap<>();
    }

    @Override
    public void registerChannel(Class<? extends Message> messageType, Channel<? extends Message> channel) {
        this.routerTable.put(messageType, channel);
    }

    @Override
    public void dispatcher(Message message) {
        if (routerTable.containsKey(message.getType())) {
            routerTable.get(message.getType()).dispatcher(message);
        } else {
            throw new RuntimeException("can't match the channel for [" + message.getType() + "] type");
        }
    }
}
