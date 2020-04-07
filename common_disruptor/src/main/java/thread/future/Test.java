package thread.future;

import javax.crypto.spec.PSource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author fujie.feng
 * @Date 2020-04-04
 */
public class Test {

    public static void main(String[] args) {
        FutureService<String, Integer> futureService = FutureService.newService();

        futureService.submit(input -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return input.length();
        }, "Hello", System.out::println);
    }
}
