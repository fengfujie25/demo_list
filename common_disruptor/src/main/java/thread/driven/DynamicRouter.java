package thread.driven;

public interface DynamicRouter<E extends Message> {

    /**
     * 针对每一个message类型注册相关的channel，只有找到合适channel的message才会被处理
     * @param messageType
     * @param channel
     */
    void registerChannel(Class<? extends E> messageType, Channel<? extends E> channel);

    /**
     * 为相应的Channel非配message
     * @param message
     */
    void dispatcher(E message);
}
