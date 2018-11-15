package cn.wzzm.order.service;

public interface OrderService {
    /**
     * 查询全部订单
     *
     * @return
     */
    String getAllOrder();

    /**
     * 发货
     *
     * @param oid
     * @return
     */
    String fhOrder(Integer sid, Integer oid);

    /**
     * 根据订单号查询订单
     *
     * @param onum
     * @return
     */
    String getOrdersByNum(String onum);

    /**
     * 查询全部签收订单
     *
     * @return
     */
    String getSiginOrders();
}
