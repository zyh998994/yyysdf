package cn.wzzm.goods.service.impl;


import cn.wzzm.goods.dao.GoodsDao;
import cn.wzzm.goods.pojo.Goods;
import cn.wzzm.goods.service.GoodsService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("GoodsService")
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    @Qualifier("GoodsDao")
    private GoodsDao gd;

    public GoodsDao getGd() {
        return gd;
    }

    public void setGd(GoodsDao gd) {
        this.gd = gd;
    }

    /**
     * 商品上新
     *
     * @param g
     * @return
     */
    @Override
    public String insertGoods(Integer sid, Goods g) {
        String code;
        if (sid == null || g == null) {
            code = "0000";
        } else {
            if (gd.insertGoods(g) == 1) {
                code = "4421";
            } else {
                code = "4444";
            }

        }
        return code;
    }

    /**
     * 删除商品
     *
     * @param gid
     * @return
     */
    @Override
    public String deleteGoodsByID(Integer sid, Integer gid) {
        String code = "";
        if (sid == null || gid == null) {
            code = "0000";
        } else {
            int i = gd.deleteGoodsByID(gid);
            if (i == 1) {
                code = "4421";
            } else {
                code = "4444";
            }
        }
        return code;
    }

    /**
     * 搜索商品
     *
     * @param keyword
     * @return
     */
    @Override
    public String searchGoodsList(Integer sid, Integer stid, String keyword) {
        String code = "";
        if (sid == null) {
            code = "0000";
        } else {
            List<Goods> goods = gd.searchGoodsList(keyword, stid);
            String s = JSON.toJSONString(goods);
            if (s == "") {
                code = "4444";
            } else {
                code = s;
            }
        }
        return code;
    }

    /**
     * 编辑商品
     *
     * @param gid
     * @param g
     * @return
     */
    @Override
    public String editGoodsByID(Integer sid, Integer gid, Goods g) {
        String code = "";
        if (sid == null || gid == null) {
            code = "0000";
        } else {
            int i = gd.editGoodsByID(gid, g);
            if (i == 1) {
                code = "4421";
            } else {
                code = "4444";
            }
        }
        return code;
    }
}
