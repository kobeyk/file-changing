package com.appleyk.utils;

import org.springframework.util.DigestUtils;
import org.springframework.util.ResourceUtils;

import javax.sound.sampled.Line;
import java.io.*;

/**
 * <p>文件操作通用类</p>
 *
 * @author appleyk
 * @version V.1.0.1
 * @blob https://blog.csdn.net/appleyk
 * @date created on 2019/11/3 10:38 AM
 */
public class FileUtils {

    /**
     * <p>获取文件的md5</p>
     */
    public static String getMd5(String filePath) throws Exception {
        File file;
        String md5 = "";
        try {
            file = ResourceUtils.getFile(filePath);
            if (file.exists()) {
                FileInputStream is = new FileInputStream(file);
                byte[] data = new byte[is.available()];
                is.read(data);
                md5 = DigestUtils.md5DigestAsHex(data);
                is.close();
            }
        } catch (FileNotFoundException e) {

        }
        return md5;
    }

    /**
     * <p>读取文件内容</p>
     *
     * @param is
     * @return
     * @throws IOException
     */
    public static String readContent(InputStream is) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuffer sb = new StringBuffer();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }

}
