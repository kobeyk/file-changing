package com.appleyk.controller;

import com.appleyk.consts.SysConfig;
import com.appleyk.model.LicenseParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>证书参数校对测试Controller</p>
 *
 * @author appleyk
 * @version V.1.0.1
 * @blob https://blog.csdn.net/appleyk
 * @date created on 2019/11/3 11:11 AM
 */
@CrossOrigin
@RestController
@RequestMapping("/license")
public class HelloController {

    @GetMapping("/users/verify")
    public ResponseEntity verify() {
        LicenseParam licenseParam = SysConfig.licenseParam;
        if (licenseParam == null) {
            return ResponseEntity.ok("证书未安装！");
        }
        if (SysConfig.users > licenseParam.getMaxUsers()) {
            return ResponseEntity.ok("超过最大用户数量限制！");
        }
        return ResponseEntity.ok("用户数量合法，请放心使用！");
    }

}
