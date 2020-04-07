package thread.worker;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author fujie.feng
 * @Date 2020-04-07
 */
public class Worker extends Thread {

    private ProductionChannel productionChannel;

    private static final Random rando = new Random(System.currentTimeMillis());

    public Worker(String workerName, ProductionChannel productionChannel) {
        super(workerName);
        this.productionChannel = productionChannel;
    }


    @Override
    public void run() {
        while (true) {
            try {
                Production production = productionChannel.takeProduction();
                System.out.println(getName() + "process the " + production);
                production.create();
                TimeUnit.SECONDS.sleep(rando.nextInt(10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
