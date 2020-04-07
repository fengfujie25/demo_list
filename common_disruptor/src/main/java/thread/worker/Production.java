package thread.worker;

/**
 * @author fujie.feng
 * @Date 2020-04-07
 */
public class Production extends InstructionBook {

    private final int productId;

    public Production(int productId) {
        this.productId = productId;
    }

    @Override
    protected void secondProcees() {
        System.out.println("execute " + productId + " second process");
    }

    @Override
    protected void firstProcess() {
        System.out.println("execute " + productId + " first process");
    }
}
