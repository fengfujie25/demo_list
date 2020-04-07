package thread.active;

import java.util.Map;

/**
 * @author fujie.feng
 * @Date 2020-04-07
 */
public abstract class MethodMessage {

    protected final Map<String, Object> params;

    protected final OrderService orderService;


    public MethodMessage(Map<String, Object> params, OrderService orderService) {
        this.params = params;
        this.orderService = orderService;
    }


    /**
     * 抽象方法，扮演work thread的说明书
     */
    public abstract void execute();
}
