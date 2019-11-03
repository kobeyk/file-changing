package com.appleyk.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>日志记录辅助类</p>
 *
 * @author appleyk
 * @version V.1.0.1
 * @blob https://blog.csdn.net/appleyk
 * @date created on 2019/11/3 10:32 AM
 */
public class LoggerHelper {

    private static Logger logger = LoggerFactory.getLogger(LoggerHelper.class);

    public static void info(String message){
        logger.info(message);
    }
    public static void debug(String message){
        logger.debug(message);
    }
    public static void warn(String message){logger.warn(message);}
    public static void error(String message,Exception ex){
        logger.error(message,ex);
    }
    public static void error(Integer errCode,String message){
        logger.error("错误码："+errCode+"，错误消息："+message);
    }

    public static void error(Integer errCode,String message,Exception ex){
        logger.error("错误码："+errCode+"，错误消息："+message+",异常信息："+ex.getMessage());
    }

}
