package thread.premessage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author fujie.feng
 * @Date 2020-04-06
 */
public class Operator {

    private final ExecutorService executorService = new ThreadPoolExecutor(2, 6, 4, TimeUnit.SECONDS, new LinkedBlockingDeque<>(1000));

    public void call(String business) {
        TaskHandler task = new TaskHandler(new Request(business));
        executorService.execute(task);
    }
}
