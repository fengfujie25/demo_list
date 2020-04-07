package thread.premessage;

/**
 * @author fujie.feng
 * @Date 2020-04-07
 */
public class Reference {

    private final byte[] data = new byte[2 << 19];

    @Override
    protected void finalize() throws Throwable {
        System.out.println("the reference will be GC.");
    }
}
