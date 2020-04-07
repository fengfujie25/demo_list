package thread.active;

import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author fujie.feng
 * @Date 2020-04-07
 */
public class FindOrderDetailsMessage extends MethodMessage {
    public FindOrderDetailsMessage(Map<String, Object> params, OrderService orderService) {
        super(params, orderService);
    }

    @Override
    public void execute() {
        Future<String> realFuture = orderService.findOrderDetails((Long) params.get("orderId"));
        ActiveFuture<String> activeFuture = (ActiveFuture<String>) params.get("activeFuture");

        try {
            String result = realFuture.get();
            activeFuture.finish(result);
        } catch (InterruptedException | ExecutionException e) {
            activeFuture.finish(null);
        }

    }
}
