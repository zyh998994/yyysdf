package cn.wzzm.order.service.impl;

import cn.wzzm.order.dao.OrderDao;
import cn.wzzm.order.pojo.Orders;
import cn.wzzm.order.service.OrderService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("OrderService")
public class OrderServiceImpl<OrderDao> implements OrderService {


    @Autowired
    @Qualifier("OrderDao")
    private cn.wzzm.order.dao.OrderDao od;


    /**
     * 获取全部订单
     *
     * @return
     */
    @Override
    public String getAllOrder() {
        List<Orders> allOrder = od.getAllOrder();
        String s = JSON.toJSONString(allOrder);
        return s;
    }

    /**
     * 发货
     *
     * @param oid
     * @return
     */
    @Override
    public String fhOrder(Integer sid, Integer oid) {
        String code = "";
        if (sid == null) {
            code = "0000";
        } else {
            int i = od.fhOrder(oid);
            if (i == 1) {
                code = "4421";
            }
        }
        return code;
    }

    /**
     * 根据单号查询订单
     *
     * @param onum
     * @return
     */
    @Override
    public String getOrdersByNum(String onum) {
        String code = "";
//        if (onum == "" || onum == null) {
//            code = "0000";
//        } else {
            Orders ordersByNum = od.getOrdersByNum(onum);
            code = JSON.toJSONString(ordersByNum);
//        }
        return code;
    }

    /**
     * 查询签收订单
     *
     * @return
     */
    @Override
    public String getSiginOrders() {
        Orders siginOrders = od.getSiginOrders();
        String s = JSON.toJSONString(siginOrders);
        return s;
    }
}
