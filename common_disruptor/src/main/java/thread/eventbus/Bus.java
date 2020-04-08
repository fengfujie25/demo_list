package thread.eventbus;

public interface Bus {

    /**
     * 将某个对象注册到bus上
     * @param subscriber
     */
    void register(Object subscriber);

    /**
     * 将某个对象从bus中解除
     * @param subscriber
     */
    void unRegister(Object subscriber);

    /**
     * 提交到bus上
     * @param event
     */
    void post(Object event);

    /**
     * 提交到执行的topic傻姑娘
     * @param event
     * @param topic
     */
    void post(Object event, String topic);

    /**
     * 关闭
     */
    void close();

    /**
     * 获取名称
     * @return
     */
    String getBusName();
}
