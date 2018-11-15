package cn.wzzm.store.service.impl;

import cn.wzzm.store.dao.StoreDao;
import cn.wzzm.store.pojo.Store;
import cn.wzzm.store.service.StoreService;
import cn.wzzm.store.service.util.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl implements StoreService {


    @Autowired
    @Qualifier("StoreDao")
    private StoreDao sd;

    /**
     * 开店
     *
     * @param s
     * @param sid
     * @return
     */
    @Override
    public String insertStore(Store s, Integer sid) {
        String code = "";
        ServiceUtil su = new ServiceUtil();
        int i = su.judgeByRange(6, 20, s.getSname());
        int i1 = su.judgeChinese(s.getSname());
        int flag = i + i1;
        if (sid == null) {
            flag = 0;
            code = "0000";
        }
        if (flag == 2) {
            sd.insertStore(s, sid);
            code = "4421";
        } else {
            code = "4444";
        }
        return code;
    }


    /**
     * 修改店铺等级
     *
     * @param sid
     * @param level
     * @return
     */
    @Override
    public String updateStoreLevel(Integer sid, Integer level) {
        String code = "";

        if (sid == null) {
            code = "0000";
        } else {

            int i = sd.updateStoreLevel(sid, level);

            if (i == 1) {
                code = "4421";
            } else {
                code = "4444";
            }
        }


        return code;
    }

    public String updateStoreImage(Integer sid, String fileName) {
        String code = "";
        if (sid == null) {
            code = "0000";
        } else {
            int i = sd.updateStoreImage(sid, fileName);
            if (i == 1) {
                code = "4421";
            } else {
                code = "4444";
            }
        }

        return code;
    }

}
