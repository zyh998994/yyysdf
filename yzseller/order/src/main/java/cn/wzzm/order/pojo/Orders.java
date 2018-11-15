package cn.wzzm.order.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * (Orderform)实体类
 *
 * @author makejava
 * @since 2018-11-01 20:59:46
 */
public class Orders implements Serializable {
    private static final long serialVersionUID = 187654559323437903L;
    
    private Integer oid;
    
    private String onum;
    
    private Integer uid;
    
    private Integer seid;
    
    private Date odatetime;
    
    private Integer aid;

    public String getBianhao() {
        return bianhao;
    }

    public void setBianhao(String bianhao) {
        this.bianhao = bianhao;
    }

    private String bianhao;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getOnum() {
        return onum;
    }

    public void setOnum(String onum) {
        this.onum = onum;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getSeid() {
        return seid;
    }

    public void setSeid(Integer seid) {
        this.seid = seid;
    }

    public Date getOdatetime() {
        return odatetime;
    }

    public void setOdatetime(Date odatetime) {
        this.odatetime = odatetime;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

}