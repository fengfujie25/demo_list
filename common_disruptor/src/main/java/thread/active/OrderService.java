package thread.active;

import java.util.concurrent.Future;

public interface OrderService {

    /**
     * 查询详细
     * @param orderId
     * @return
     */
    Future<String> findOrderDetails(long orderId);

    /**
     * 提交订单
     * @param account
     * @param orderId
     */
    void order(String account, long orderId);
}
