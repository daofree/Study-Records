package cn.daofree.web.utils;

//import sun.misc.BASE64Encoder;

import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Base64.Decoder;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


// IDEA解决sun.misc.BASE64Encoder找不到jar包的解决方法
public class DownLoadUtils {

    public static String getFileName(String agent, String filename) throws UnsupportedEncodingException {
        if (agent.contains("MSIE")) {
            // IE浏览器
            filename = URLEncoder.encode(filename, "utf-8");
            filename = filename.replace("+", " ");// IE需要+号变空格
        } else if (agent.contains("Firefox")) {
            // 火狐浏览器
            //BASE64Encoder base64Encoder = new BASE64Encoder();
            Encoder encoder = Base64.getEncoder();
//            filename = "=?utf-8?B?" + base64Encoder.encode(filename.getBytes("utf-8")) + "?=";
            filename = "=?utf-8?B?" + encoder.encode(filename.getBytes("utf-8")) + "?=";
        } else {
            // 其它浏览器
            filename = URLEncoder.encode(filename, "utf-8");
        }
        return filename;
    }
}
