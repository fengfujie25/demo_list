package thread.driven;

import thread.driven.Event;
import thread.driven.EventDispatcherExample;
import thread.driven.async.AsyncChannel;
import thread.driven.async.AsyncEventDispatcher;

import java.util.concurrent.TimeUnit;

/**
 * @author fujie.feng
 * @Date 2020-04-09
 */
public class AsyncEventDispatcherExample {

    static class AsyncInputEventHandler extends AsyncChannel {

        private final AsyncEventDispatcher dispatcher;

        AsyncInputEventHandler(AsyncEventDispatcher dispatcher) {
            this.dispatcher = dispatcher;
        }

        @Override
        protected void handler(Event message) {
            EventDispatcherExample.InputEvent inputEvent = (EventDispatcherExample.InputEvent) message;
            System.out.printf("X:%d, Y:%d\n", inputEvent.getX(), inputEvent.getY());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int result = inputEvent.getX() + inputEvent.getY();
            dispatcher.dispatcher(new EventDispatcherExample.ResultEvent(result));
        }
    }

    static class AsyncResultEventHandler extends AsyncChannel {


        @Override
        protected void handler(Event message) {
            EventDispatcherExample.ResultEvent resultEvent = (EventDispatcherExample.ResultEvent) message;
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("The result is :" + resultEvent.getResult());
        }
    }

    public static void main(String[] args) {
        AsyncEventDispatcher dispatcher = new AsyncEventDispatcher();
        dispatcher.registerChannel(EventDispatcherExample.InputEvent.class, new AsyncInputEventHandler(dispatcher));
        dispatcher.registerChannel(EventDispatcherExample.ResultEvent.class, new AsyncResultEventHandler());
        dispatcher.dispatcher(new EventDispatcherExample.InputEvent(1, 2));
    }
}
