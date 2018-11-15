package cn.wzzm.goods.dao;

import cn.wzzm.goods.pojo.Goods;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("GoodsDao")
public interface GoodsDao {

    /**
     * 上新
     *
     * @param g
     * @return
     */
    int insertGoods(@Param("store") Goods g);

    /**
     * 下架
     *
     * @param gid
     * @return
     */
    int deleteGoodsByID(@Param("gid") Integer gid);

    /**
     * 搜索商品
     *
     * @param keyword
     * @return
     */
    List<Goods> searchGoodsList(@Param("keyword") String keyword, @Param("stid") Integer stid);

    /**
     * 编辑商品
     *
     * @param gid
     * @param g
     * @return
     */
    int editGoodsByID(@Param("gid") Integer gid, @Param("g") Goods g);
}
