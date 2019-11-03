package com.appleyk.model;

import com.appleyk.utils.LoggerHelper;

import java.util.Date;

/**
 * <p>证书参数验证</p>
 *
 * @author appleyk
 * @version V.1.0.1
 * @blob https://blog.csdn.net/appleyk
 * @date created on 2019/11/3 11:01 AM
 */
public class LicenseCheck {

    /**
     * <p>检查证书是否参数正确（证书安装的时候检查）</p>
     * @param param
     * @return
     * @throws Exception
     */
    public synchronized static boolean check(LicenseParam param) throws Exception {

        // 当前时间
        final Date now = new Date();
        // 生效时间
        final Date notBefore = param.getIssuedTime();
        // 失效时间
        final Date notAfter = param.getExpiryTime();

        if (null != notAfter && now.after(notAfter)) {
            LoggerHelper.warn("证书失效时间不能早于当前时间");
            throw new IllegalAccessException("证书失效时间不能早于当前时间");
        }

        if (null != notBefore && null != notAfter && notAfter.before(notBefore)) {
            LoggerHelper.warn("证书生效时间不能晚于证书失效时间");
            throw new IllegalAccessException("证书生效时间不能晚于证书失效时间");
        }

        final Integer maxUsers = param.getMaxUsers();
        if (null == maxUsers || 0 == maxUsers) {
            LoggerHelper.warn("请设置证书的最大用户量");
            throw new IllegalAccessException("最大用户量不能为空");
        }

        return true;

    }

}
