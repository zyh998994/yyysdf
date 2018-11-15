package cn.wzzm.seller.service.impl;

import cn.wzzm.seller.pojo.Seller;
import cn.wzzm.seller.service.util.ServiceUtil;
import cn.wzzm.seller.service.SellerService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("SellerService")
public class SellerServiceImpl implements SellerService {



    @Autowired
    @Qualifier("SellerDao")
    private cn.wzzm.seller.dao.SellerDao SellerDao;


    /**
     * 用户登录
     *
     * @param sname
     * @param spwd
     * @return
     */
    @Override
    public String getLogin(String sname, String spwd) {
        ServiceUtil su = new ServiceUtil();
        String encode = su.getEncode(spwd);
        Seller logins = SellerDao.getLogin(sname, encode);
        String sellerjson = JSON.toJSONString(logins);
        return sellerjson;
    }

    /**
     * 获取商家总数
     *
     * @return
     */
    @Override
    public int getSellerCount() {
        return SellerDao.getSellerCount();
    }

    /**
     * 注册商家
     *
     * @return
     */
    @Override
    public String getSigin(Seller s) {
        //结果变量
        String sigres = "";

        String sename = s.getSename();
        String sepwd = s.getSepwd();
        String sephone = s.getSephone();
        String seaddress = s.getSeaddress();
        //获取判断结果
        ServiceUtil su = new ServiceUtil();
        //账号判断
        int i = su.judgeByRange(6, 20, sename);
        int i1 = su.judgeChinese(sename);
        //密码判断
        int p = su.judgeByRange(6, 20, sepwd);
        int p1 = su.judgeChinese(sepwd);
        //手机号判断
        int a = su.getTextLength(sephone);
        int a1 = 1;
        if (a != 11) {
            a1 = 0;
        }
        //地址判断
        int ad = su.judgeByRange(6, 50, seaddress);
        int r = i + i1 + p + p1 + a1 + ad;


        if (r == 4) {
            //执行注册
            s.setSepwd(su.getEncode(s.getSepwd()));
            int sigin = SellerDao.getSigin(s);
            if (sigin == 1) {
                sigres = "success";
            } else {
                sigres = "false";
            }
        } else {
            sigres = "注册失败，内部错误";
        }


        return sigres;
    }


}
