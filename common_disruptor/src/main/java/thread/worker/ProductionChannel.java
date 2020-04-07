package thread.worker;

/**
 * @author fujie.feng
 * @Date 2020-04-07
 */
public class ProductionChannel {

    //最多可以有多少个代加工产品
    private static final int MAX_PROD = 100;

    //产品加工队列
    private final Production[] productionsQueue;

    //队列尾部
    private int tail;

    //队列头
    private int head;

    //当前在流水线上有多少个待加工的产品
    private int total;

    private final Worker[] workers;

    public ProductionChannel(int workerSize) {
        this.workers = new Worker[workerSize];
        this.productionsQueue = new Production[MAX_PROD];
        for (int i = 0; i < workerSize; i++) {
            workers[i] = new Worker("Worker-" + i, this);
            workers[i].start();
        }
    }

    /**
     * 商品入队列
     * @param production
     */
    public void offerProduction(Production production) {
        synchronized (this) {
            try {
                while (total > productionsQueue.length) {
                    this.wait();
                }
                productionsQueue[tail] = production;
                tail = (tail + 1) % productionsQueue.length;
                total++;
                this.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取商品
     * @return
     */
    public Production takeProduction() {
        synchronized (this) {
            try {
                while (total <= 0) {
                    this.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Production production = productionsQueue[head];
            head = (head + 1) % productionsQueue.length;
            total--;
            this.notifyAll();
            return production;
        }
    }
}
