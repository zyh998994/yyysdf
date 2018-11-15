package cn.wzzm.seller.pojo;


import java.io.Serializable;

/**
 * (Sellerform)实体类
 *
 * @author makejava
 * @since 2018-11-01 20:59:42
 */
public class Seller implements Serializable {
    private static final long serialVersionUID = -34642950069561382L;
    
    private Integer seid;
    
    private String sename;
    
    private String sepwd;
    
    private String sephone;
    
    private String seaddress;


    public Integer getSeid() {
        return seid;
    }

    public void setSeid(Integer seid) {
        this.seid = seid;
    }

    public String getSename() {
        return sename;
    }

    public void setSename(String sename) {
        this.sename = sename;
    }

    public String getSepwd() {
        return sepwd;
    }

    public void setSepwd(String sepwd) {
        this.sepwd = sepwd;
    }

    public String getSephone() {
        return sephone;
    }

    public void setSephone(String sephone) {
        this.sephone = sephone;
    }

    public String getSeaddress() {
        return seaddress;
    }

    public void setSeaddress(String seaddress) {
        this.seaddress = seaddress;
    }

}