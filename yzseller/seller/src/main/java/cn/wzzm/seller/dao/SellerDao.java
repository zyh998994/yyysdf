package cn.wzzm.seller.dao;

import cn.wzzm.seller.pojo.Seller;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("SellerDao")
public interface SellerDao {

    /**
     * 登录
     * @return
     */
    Seller getLogin(@Param("sname") String sname, @Param("spwd") String spwd);

    /**
     * 注册
     * @param s
     * @return
     */
    int getSigin(@Param("s") Seller s);

    /**
     * 获取商家总数
     * @return
     */
    int getSellerCount();
}
