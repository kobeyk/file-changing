package com.appleyk.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.function.Predicate;

/**
 * <p>证书验证参数</p>
 *
 * @author appleyk
 * @version V.1.0.1
 * @blob https://blog.csdn.net/appleyk
 * @date created on 2019/11/3 10:50 AM
 */
public class LicenseParam {

    /**
     * 证书生效时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date issuedTime = new Date();

    /**
     * 证书失效时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date expiryTime;

    /**最大用户量*/
    private Integer maxUsers;

    public LicenseParam() {
    }

    public LicenseParam(Date issuedTime, Date expiryTime, Integer maxUsers) {
        this.issuedTime = issuedTime;
        this.expiryTime = expiryTime;
        this.maxUsers = maxUsers;
    }

    public Date getIssuedTime() {
        return issuedTime;
    }

    public void setIssuedTime(Date issuedTime) {
        this.issuedTime = issuedTime;
    }

    public Date getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(Date expiryTime) {
        this.expiryTime = expiryTime;
    }

    public Integer getMaxUsers() {
        return maxUsers;
    }

    public void setMaxUsers(Integer maxUsers) {
        this.maxUsers = maxUsers;
    }

    @Override
    public String toString() {
        return "LicenseParam{" +
                ", issuedTime=" + issuedTime +
                ", expiryTime=" + expiryTime +
                ", maxUsers=" + maxUsers +
                '}';
    }


}
