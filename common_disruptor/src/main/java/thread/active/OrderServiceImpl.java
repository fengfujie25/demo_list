package thread.active;

import thread.active.common.ActiveMethod;
import thread.future.FutureService;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author fujie.feng
 * @Date 2020-04-07
 */
public class OrderServiceImpl implements OrderService {

    @ActiveMethod
    @Override
    public Future<String> findOrderDetails(long orderId) {
        return FutureService.<Long, String>newService().submit(input -> {
            try {
                TimeUnit.SECONDS.sleep(10);
                System.out.println("process the orderId->" + orderId);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "The order Details information";
        }, orderId, null);
    }

    @ActiveMethod
    @Override
    public void order(String account, long orderId) {
        try {
            TimeUnit.SECONDS.sleep(10);
            System.out.println("process the order for account = " + account + ", orderId = " + orderId);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
