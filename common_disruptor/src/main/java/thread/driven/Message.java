package thread.driven;

/**
 * @author fujie.feng
 * @Date 2020-04-09
 */
public interface Message {

    /**
     * 返回message类型
     * @return
     */
    Class<? extends Message> getType();
}
