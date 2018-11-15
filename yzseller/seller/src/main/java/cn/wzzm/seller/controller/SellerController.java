package cn.wzzm.seller.controller;

import cn.wzzm.seller.pojo.Seller;
import cn.wzzm.seller.service.SellerService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(value = "商家")
@RequestMapping("/user")
@Controller
public class SellerController {

    @Autowired
    private SellerService ss;

    public SellerService getSs() {
        return ss;
    }

    public void setSs(SellerService ss) {
        this.ss = ss;
    }
    /**
     * 登录
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getlogin")
    @ApiOperation(value = "商家登录", httpMethod = "GET", notes = "登录")
    public String getLogin(@RequestBody String json) {
        System.out.println(json);
        JSONObject jsonObject = JSON.parseObject(json);
        String sname = jsonObject.getString("sname");
        String spwd = jsonObject.getString("spwd");
        String login = ss.getLogin(sname, spwd);
        return login;
    }

    @ResponseBody
    @RequestMapping("/getCount")
    @ApiOperation(value = "获取商家总数", httpMethod = "GET", notes = "获取商家总数")
    public int getSellerCount() {
        int count = ss.getSellerCount();
        return count;
    }

    @ResponseBody
    @RequestMapping("/getSigin")
    @ApiOperation(value = "注册", httpMethod = "GET", notes = "注册")
    public String getSigin(@RequestBody Seller s) {
        String sigin = ss.getSigin(s);
        return sigin;
    }
}


