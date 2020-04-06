package thread.premessage;

import java.util.concurrent.TimeUnit;

/**
 * @author fujie.feng
 * @Date 2020-04-06
 */
public class TaskHandler implements Runnable {

    private final Request request;

    public TaskHandler(Request request) {
        this.request = request;
    }



    @Override
    public void run() {
        System.out.println("begin handler" + request);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end handler " + request);
    }
}
