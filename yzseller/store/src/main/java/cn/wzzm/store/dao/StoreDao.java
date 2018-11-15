package cn.wzzm.store.dao;

import cn.wzzm.store.pojo.Store;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("StoreDao")
public interface StoreDao {

    /**
     * 开店
     *
     * @return
     */
    int insertStore(@Param("s") Store s, @Param("seller") Integer seid);

    /**
     * 修改店铺等级
     *
     * @param sid
     * @param level
     * @return
     */
    int updateStoreLevel(@Param("sid") Integer sid, @Param("level") Integer level);

    /**
     * 修改店铺头像
     *
     * @return
     */
    int updateStoreImage(@Param("sid") Integer sid, @Param("fileName") String fileName);
}
