package thread.worker;

/**
 * @author fujie.feng
 * @Date 2020-04-07
 */
public abstract  class InstructionBook {


    public void create() {
        firstProcess();
        secondProcees();
    }

    protected abstract void secondProcees();


    protected abstract void firstProcess();
}
