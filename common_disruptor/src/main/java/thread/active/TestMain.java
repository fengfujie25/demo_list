package thread.active;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author fujie.feng
 * @Date 2020-04-07
 */
public class TestMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        OrderService orderService = OrderServiceFactory.toActiveObject(new OrderServiceImpl());

        orderService.order("hellp", 123);
        System.out.println("return immediately");
//
//        try {
//            new Thread().join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


        Future<String> future = orderService.findOrderDetails(123);
        System.out.println("i will be return immediately");
        System.out.println(future.get());

    }
}
