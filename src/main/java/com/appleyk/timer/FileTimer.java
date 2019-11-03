package com.appleyk.timer;

import com.appleyk.service.LicenseInstall;
import com.appleyk.utils.FileUtils;
import com.appleyk.utils.LoggerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;

/**
 * <p>文件定时器，检测文件是否变动</p>
 *
 * @author appleyk
 * @version V.1.0.1
 * @blob https://blog.csdn.net/appleyk
 * @date created on 2019/11/3 10:26 AM
 */
@Component
public class FileTimer {

    @Autowired
    private LicenseInstall licenseInstall;

    @Value("${gx.license.file.path}")
    private String licPath;

    /**文件唯一身份标识 == 相当于人类的指纹一样*/
    private static String md5 = "";

    /**5秒检测一次，不能太快也不能太慢，自己体会*/
    @Scheduled(cron = "0/5 * * * * ?")
    protected void timer() throws Exception {
        String readMd5 = FileUtils.getMd5(licPath);
        if(FileTimer.md5 == null || "".equals(FileTimer.md5)){
            FileTimer.md5 =readMd5;
        }
        // 不相等，说明lic变化了
        if(!readMd5.equals(FileTimer.md5)){
            LoggerHelper.info("========证书安装开始========");
            licenseInstall.install(licPath);
            LoggerHelper.info("========证书安装结束========");
            FileTimer.md5 = readMd5;
        }
    }


}
