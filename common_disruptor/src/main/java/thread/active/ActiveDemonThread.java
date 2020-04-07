package thread.active;

import thread.active.common.ActiveMessage;

/**
 * @author fujie.feng
 * @Date 2020-04-07
 */
public class ActiveDemonThread extends Thread {

    private final ActiveMessageQueue queue;

    public ActiveDemonThread(ActiveMessageQueue queue) {
        super("ActiveMemonThread");
        this.queue = queue;
        setDaemon(true);
    }

    @Override
    public void run() {
        for ( ; ; ) {
            ActiveMessage methodMessage = this.queue.take();
            methodMessage.execute();
        }
    }
}
