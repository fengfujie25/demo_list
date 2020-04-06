package thread.premessage;

import java.io.IOException;

/**
 * @author fujie.feng
 * @Date 2020-04-06
 */
public class TestMain {

    public static void main(String[] args) throws IOException {
        new ChatServer().startServer();
    }
}
