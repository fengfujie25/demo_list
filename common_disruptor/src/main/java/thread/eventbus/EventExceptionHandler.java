package thread.eventbus;

/**
 * @author fujie.feng
 * @Date 2020-04-08
 */
public interface EventExceptionHandler {


    public void handler(Throwable cause, EventContext context);
}
