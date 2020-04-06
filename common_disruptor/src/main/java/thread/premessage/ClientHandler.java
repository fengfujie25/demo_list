package thread.premessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @author fujie.feng
 * @Date 2020-04-06
 */
public class ClientHandler implements Runnable {

    private final Socket socket;

    private final String clientIdentify;

    public ClientHandler(Socket socket) {
        this.socket = socket;
        this.clientIdentify = socket.getInetAddress().getHostAddress() + ":" + socket.getPort();
    }

    @Override
    public void run() {

    }

    private void chat() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream printStream = new PrintStream(socket.getOutputStream());
        String received;

        while ((received = bufferedReader.readLine()) != null) {
            System.out.printf("client : %s-message:%s\n", clientIdentify, received);
            if ("quit".equals(received)) {
                printStream.println("client will close");
                printStream.flush();
                socket.close();
                break;
            }
            printStream.println("server : " + received);
            printStream.flush();
            printStream.close();
        }
    }
}
