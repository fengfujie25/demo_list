package thread.driven;

import jdk.internal.util.xml.impl.Input;

/**
 * @author fujie.feng
 * @Date 2020-04-09
 */
public class EventDispatcherExample {

    static class InputEvent extends Event {
        private final int x;

        private final int y;

        InputEvent(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    static class ResultEvent extends Event {
        private final int result;

        ResultEvent(int result) {
            this.result = result;
        }

        public int getResult() {
            return result;
        }
    }

    static class ResultEventHandler implements Channel<ResultEvent> {

        @Override
        public void dispatcher(ResultEvent message) {
            System.out.println("the result is :" + message.getResult());
        }
    }

    static class InputEventHandler implements Channel<InputEvent> {

        private final EventDispatcher dispatcher;

        InputEventHandler(EventDispatcher dispatcher) {
            this.dispatcher = dispatcher;
        }

        @Override
        public void dispatcher(InputEvent message) {
            System.out.printf("X:%d, Y:%d\n", message.getX(), message.getY());
            int result = message.getX() + message.getY();
            dispatcher.dispatcher(new ResultEvent(result));
        }
    }

    public static void main(String[] args) {
        EventDispatcher dispatcher = new EventDispatcher();
        dispatcher.registerChannel(InputEvent.class, new InputEventHandler(dispatcher));
        dispatcher.registerChannel(ResultEvent.class, new ResultEventHandler());
        dispatcher.dispatcher(new InputEvent(3, 2));
    }
}
