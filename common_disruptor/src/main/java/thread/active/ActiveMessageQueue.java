package thread.active;

import thread.active.common.ActiveMessage;

import java.util.LinkedList;

/**
 * @author fujie.feng
 * @Date 2020-04-07
 */
public class ActiveMessageQueue {

//    private final LinkedList<MethodMessage> messages = new LinkedList<>();
    private final LinkedList<ActiveMessage> messages = new LinkedList<>();

    public ActiveMessageQueue() {
        new ActiveDemonThread(this).start();
    }

    public void offer(ActiveMessage message) {
        synchronized (this) {
            messages.addLast(message);
            this.notify();
        }
    }

    protected ActiveMessage take() {
        synchronized (this) {
            while (messages.isEmpty()) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //获取其中一个MethodMessage并且从队列中移除
            return messages.removeFirst();
        }
    }
}
