package thread.worker;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @author fujie.feng
 * @Date 2020-04-07
 */
public class TestMain {

    public static void main(String[] args) {
        final ProductionChannel channel = new ProductionChannel(5);

        AtomicInteger production = new AtomicInteger();

        IntStream.range(1, 8).forEach(i -> new Thread(() -> {
            while (true) {
                channel.offerProduction(new Production(production.getAndIncrement()));

                try {
                    TimeUnit.SECONDS.sleep(new Random().nextInt(10));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start());
    }
}
