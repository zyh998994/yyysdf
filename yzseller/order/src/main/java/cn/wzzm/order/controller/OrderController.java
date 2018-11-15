package cn.wzzm.order.controller;

import cn.wzzm.order.service.OrderService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/order")
@Api("订单")
public class OrderController {

    @Autowired
    @Qualifier("OrderService")
    private OrderService os;

    public OrderService getOs() {
        return os;
    }

    public void setOs(OrderService os) {
        this.os = os;
    }

    @ResponseBody
    @RequestMapping("/getall")
    @ApiOperation(value = "获取全部订单", httpMethod = "GET", notes = "获取全部订单")
    public String getAllOrders() {
        String allOrder = os.getAllOrder();
        return allOrder;
    }

    @ResponseBody
    @RequestMapping("/fhorder")
    @ApiOperation(value = "获取全部订单", httpMethod = "GET", notes = "获取全部订单")
    public String fhOrder(@RequestBody String json) {
        JSONObject jsonObject = JSON.parseObject(json);
        String sid = jsonObject.getString("sid");
        String oid = jsonObject.getString("oid");
        String allOrder = os.fhOrder(Integer.parseInt(sid), Integer.parseInt(oid));
        return allOrder;
    }

    @ResponseBody
    @RequestMapping("/getordbynum")
    @ApiOperation(value = "获取全部订单", httpMethod = "GET", notes = "获取全部订单")
    public String getOrdersByNum(@RequestBody String onum) {
        JSONObject jsonObject = JSON.parseObject(onum);
        String allOrder = os.getOrdersByNum(jsonObject.getString("onum"));
        return allOrder;
    }

    @ResponseBody
    @RequestMapping("/getsig")
    @ApiOperation(value = "获取全部订单", httpMethod = "GET", notes = "获取全部订单")
    public String getSiginOrders() {
        String allOrder = os.getSiginOrders();
        return allOrder;
    }
}
