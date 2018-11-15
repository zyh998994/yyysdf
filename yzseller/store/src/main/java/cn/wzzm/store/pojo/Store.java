package cn.wzzm.store.pojo;

import java.io.Serializable;

/**
 * (Storeform)实体类
 *
 * @author makejava
 * @since 2018-11-01 20:58:45
 */
public class Store implements Serializable {
    private static final long serialVersionUID = -94037156919940241L;
    
    private Integer sid;
    
    private String sname;
    
    private String simage;


    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSimage() {
        return simage;
    }

    public void setSimage(String simage) {
        this.simage = simage;
    }

}