package thread.driven;

/**
 * @author fujie.feng
 * @Date 2020-04-09
 */
public interface Channel<E extends Message> {

    /**
     * 负责调度message
     * @param message
     */
    void dispatcher(E message);
}
