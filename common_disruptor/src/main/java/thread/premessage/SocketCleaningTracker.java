package thread.premessage;

import java.io.IOException;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.net.Socket;

/**
 * @author fujie.feng
 * @Date 2020-04-07
 */
public class SocketCleaningTracker {

    private static final ReferenceQueue<Object> queue = new ReferenceQueue<>();

    static {
        new Cleaner().start();
    }

    public static void tracker(Socket socket) {
        new Tracker(socket, queue);
    }


    private static class Cleaner extends Thread {

        private Cleaner() {
            super("SocketCleaningTracker");
            setDaemon(true);
        }

        @Override
        public void run() {
            for ( ; ; ) {
                try {
                    Tracker tracker = (Tracker) queue.remove();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class Tracker extends PhantomReference<Object> {


        private Socket socket;


        public Tracker(Socket socket, ReferenceQueue<? super Object> q) {
            super(socket, q);
            this.socket = socket;
        }

        public void close() {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
