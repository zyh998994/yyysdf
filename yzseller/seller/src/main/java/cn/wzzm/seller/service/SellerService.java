package cn.wzzm.seller.service;


import cn.wzzm.seller.pojo.Seller;

public interface SellerService {

    /**
     * 卖家登录
     * @param sname
     * @param spwd
     * @return
     */
    String getLogin(String sname, String spwd);

    /**
     * 获取商家总数
     * @return
     */
    int getSellerCount();

    /**
     * 注册商家
     * @param s
     * @return
     */
    String getSigin(Seller s);
}
