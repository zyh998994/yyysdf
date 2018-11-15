package cn.wzzm.goods.controller;

import cn.wzzm.goods.service.GoodsService;
import cn.wzzm.goods.service.util.JSONUtil;
import cn.wzzm.goods.pojo.Goods;
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


@Api(value = "商品")
@RequestMapping("/goods")
@Controller
public class GoodsController {


    public GoodsService getGs() {
        return gs;
    }

    public void setGs(GoodsService gs) {
        this.gs = gs;
    }

    @Autowired
    @Qualifier("GoodsService")
    private GoodsService gs;

    @ResponseBody
    @RequestMapping("/insertGoods")
    @ApiOperation(value = "商品上新", httpMethod = "GET", notes = "商品上新")
    public String insertGoods(@RequestBody String json) {
        JSONObject jsonObject = JSONObject.parseObject(json);
        String sids = jsonObject.getString("sid");
        int sid = Integer.parseInt(sids);
        String gname = jsonObject.getString("gname");
        String gprice = jsonObject.getString("gprice");
        String ginfo = jsonObject.getString("ginfo");
        String gimage = jsonObject.getString("gimage");
        String ginfoimage = jsonObject.getString("ginfoimage");
        String gdate = jsonObject.getString("gdate");
        String ssid = jsonObject.getString("ssid");
        String tid = jsonObject.getString("tid");

        Goods g = new Goods();
        g.setGid(0);
        g.setGname(gname);
        g.setGprice(gprice);
        g.setGinfo(ginfo);
        g.setGimage(gimage);
        g.setGinfoimage(ginfoimage);
        g.setGdate(gdate);
        int i = Integer.parseInt(ssid);
        g.setSid(i);
        int i1 = Integer.parseInt(tid);
        g.setTid(i1);
        String s = gs.insertGoods(sid, g);
        return s;
    }

    @ResponseBody
    @RequestMapping("/delGoods")
    @ApiOperation(value = "根据id下架商品", httpMethod = "POST", notes = "根据id下架商品")
    public String deleteGoodsByID(@RequestBody String json) {
        JSONObject jsonObject = JSON.parseObject(json);
        String sid = jsonObject.getString("sid");
        String gid = jsonObject.getString("gid");
        String s = gs.deleteGoodsByID(Integer.parseInt(sid), Integer.parseInt(gid));
        return s;
    }


    @ResponseBody
    @RequestMapping("/searchGoods")
    @ApiOperation(value = "搜索商品", httpMethod = "POST", notes = "参数：包含sid,stid,keyword的json字符串")
    public String searchGoodsList(@RequestBody String json) {
        JSONObject jsonObject = JSON.parseObject(json);
        String sid = jsonObject.getString("sid");
        String stid = jsonObject.getString("stid");
        String keyword = jsonObject.getString("keyword");
        if (sid == null || stid == null || keyword == null) {
            return JSONUtil.setResult(1, "\"无数据\"");
        } else {
            String s = gs.searchGoodsList(Integer.parseInt(sid), Integer.parseInt(stid), keyword);
            String s1 = JSONUtil.setResult(0, s);
            return s1;
        }
    }


    @ResponseBody
    @RequestMapping("/updateGoods")
    @ApiOperation(value = "修改商品", httpMethod = "POST", notes = "修改商品")
    public String updateGoods(@RequestBody String json) {
        JSONObject jsonObject = JSONObject.parseObject(json);
        String sids = jsonObject.getString("sid");
        int sid = Integer.parseInt(sids);
        String gids = jsonObject.getString("gid");
        int gid = Integer.parseInt(gids);
        String gname = jsonObject.getString("gname");
        String gprice = jsonObject.getString("gprice");
        String ginfo = jsonObject.getString("ginfo");
        String gimage = jsonObject.getString("gimage");
        String ginfoimage = jsonObject.getString("ginfoimage");
        String gdate = jsonObject.getString("gdate");
        String tid = jsonObject.getString("tid");

        Goods g1 = new Goods();
        g1.setGid(0);
        g1.setGname(gname);
        g1.setGprice(gprice);
        g1.setGinfo(ginfo);
        g1.setGimage(gimage);
        g1.setGinfoimage(ginfoimage);
        g1.setGdate(gdate);
        int i1 = Integer.parseInt(tid);
        g1.setTid(i1);
        String s1 = gs.editGoodsByID(sid, gid, g1);
        return s1;
    }
}
