package thread.active;

/**
 * @author fujie.feng
 * @Date 2020-04-07
 */
public final class OrderServiceFactory {

    private static final ActiveMessageQueue activeMessageQueue = new ActiveMessageQueue();

    private OrderServiceFactory() {

    }

    public static OrderService toActiveObject(OrderService orderService) {
        return new OrderServiceProxy(orderService, activeMessageQueue);
    }
}
