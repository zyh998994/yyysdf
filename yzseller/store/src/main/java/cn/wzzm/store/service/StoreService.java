package cn.wzzm.store.service;

import cn.wzzm.store.pojo.Store;

public interface StoreService {

    /**
     * 开店
     *
     * @return
     */
    String insertStore(Store s, Integer sid);

    /**
     * 修改店铺等级
     *
     * @param sid
     * @param level
     * @return
     */
    String updateStoreLevel(Integer sid, Integer level);

    /**
     * 修改店铺头像
     *
     * @return
     */
    String updateStoreImage(Integer sid, String fileName);
}
