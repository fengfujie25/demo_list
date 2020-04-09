package thread.driven;

/**
 * @author fujie.feng
 * @Date 2020-04-09
 */
public class Event implements Message{


    @Override
    public Class<? extends Message> getType() {
        return getClass();
    }
}
