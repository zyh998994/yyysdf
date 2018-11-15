package cn.wzzm.goods.service;

import cn.wzzm.goods.pojo.Goods;

public interface GoodsService {
    /**
     * 上新
     *
     * @param g
     * @return
     */
    String insertGoods(Integer sid, Goods g);

    /**
     * 下架
     *
     * @param gid
     * @return
     */
    String deleteGoodsByID(Integer sid, Integer gid);

    /**
     * 搜索商品
     *
     * @param keyword
     * @return
     */
    String searchGoodsList(Integer sid, Integer stid, String keyword);

    /**
     * 编辑商品
     *
     * @param gid
     * @param g
     * @return
     */
    String editGoodsByID(Integer sid, Integer gid, Goods g);
}
