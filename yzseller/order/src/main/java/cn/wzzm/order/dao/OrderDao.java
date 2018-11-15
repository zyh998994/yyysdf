package cn.wzzm.order.dao;


import cn.wzzm.order.pojo.Orders;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("OrderDao")
public interface OrderDao {

    /**
     * 查询全部订单
     * @return
     */
    List<Orders> getAllOrder();

    /**
     * 发货
     * @param oid
     * @return
     */
    int fhOrder(@Param("oid") Integer oid);

    /**
     * 根据订单号查询订单
     * @param onum
     * @return
     */
    Orders getOrdersByNum(@Param("onum") String onum);

    /**
     * 查询全部签收订单
     * @return
     */
    Orders getSiginOrders();


}
