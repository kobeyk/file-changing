package com.appleyk.service;

import com.appleyk.consts.SysConfig;
import com.appleyk.model.LicenseCheck;
import com.appleyk.model.LicenseParam;
import com.appleyk.utils.FileUtils;
import com.appleyk.utils.JsonUtils;
import com.appleyk.utils.LoggerHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.lang.model.element.NestingKind;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * <p>证书安装</p>
 *
 * @author appleyk
 * @version V.1.0.1
 * @blob https://blog.csdn.net/appleyk
 * @date created on 2019/11/3 10:35 AM
 */
@Service
public class LicenseInstall {

    public void install(String licPath) throws Exception{
        LoggerHelper.info("证书安装中.....");
        File licFile = ResourceUtils.getFile(licPath);
        if(!licFile.exists()){
            throw new FileNotFoundException("证书文件不存在！");
        }
        String readContent = FileUtils.readContent(new FileInputStream(licFile));
        LoggerHelper.info("读取内容："+readContent);
        LicenseParam licenseParam = JsonUtils.jsonToPojo(readContent,LicenseParam.class);
        LicenseCheck.check(licenseParam);
        LoggerHelper.info("验证内容通过");
        //验证通过安装 == 模拟证书安装，其实是保存这个值
        SysConfig.licenseParam = licenseParam;
        LoggerHelper.info("证书安装成功！");
    }

}
