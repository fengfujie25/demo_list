package thread.premessage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author fujie.feng
 * @Date 2020-04-06
 */
public class ChatServer {

    private final int port;

    private ThreadPoolExecutor threadPool;

    private ServerSocket serverSocket;

    public ChatServer(int port) {
        this.port = port;
    }

    public ChatServer() {
        this(8080);
    }


    public void startServer() throws IOException {
        this.threadPool = new ThreadPoolExecutor(2,4,6, TimeUnit.SECONDS, new LinkedBlockingDeque<>(100));
        this.serverSocket = new ServerSocket(port);
        this.serverSocket.setReuseAddress(true);
        System.out.println("Chat server is started and listen at port: " + port);
        this.listen();
    }

    private void listen() throws IOException {
        for ( ; ; ){
            Socket socket = serverSocket.accept();
            this.threadPool.execute(new ClientHandler(socket));
        }
    }
}
