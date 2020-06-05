package com.example.util;

import cn.tanzhou.commons.base.exception.BaseException;
import cn.tanzhou.commons.base.exception.ServerCode;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.Formatter;

/**
 * MD5算法
 *
 * @author chenhaibing
 */
@Slf4j
public class MD5 {


    public static String encode(String source) {
        String res = null;
        try {
            res = new String(source);
            MessageDigest md = MessageDigest.getInstance("MD5");
            res = byte2hexString(md.digest(res.getBytes()));

        } catch (Exception ex) {
        }
        return res;
    }

    private static String byte2hexString(byte[] bytes) {
        StringBuffer bf = new StringBuffer(bytes.length * 2);
        for (int i = 0; i < bytes.length; i++) {
            if ((bytes[i] & 0xff) < 0x10) {
                bf.append("0");
            }
            bf.append(Long.toString(bytes[i] & 0xff, 16));
        }
        return bf.toString();
    }

    public static String convertMD5(String inStr) {

        char[] a = inStr.toCharArray();

        for (int i = 0; i < a.length; i++) {

            a[i] = (char) (a[i] ^ 't');

        }

        String s = new String(a);

        return s;

    }

    public static void main(String[] args) throws Exception{
        String md5 = getMD5("C:\\Users\\Administrator\\Desktop\\企业微信截图_15769906759249.png");
        System.out.println(md5);
    }


    /**
     * 获取文件的MD5值
     */
    public static String getMD5(String filePath) {
        InputStream in = null;
        MessageDigest digest = null;
        try {
            File file = new File(filePath);
            file.exists();
            in = new FileInputStream(file);
            byte[] buffer = new byte[1024 * 1024];
            int len;

            digest = MessageDigest.getInstance("MD5");
            while ((len = in.read(buffer, 0, 1024 * 1024)) != -1) {
                digest.update(buffer, 0, len);
            }

        } catch (Exception e) {
            throw new BaseException(ServerCode.SERVER_UNKNOWN_ERROR,"获取文件MD5出错");
        }
        finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    throw new BaseException(ServerCode.SERVER_UNKNOWN_ERROR,"关闭流出错");
                }
            }
        }
        //BigInteger bigInt = new BigInteger(1, digest.digest());
        //return bigInt.toString(16);
        // 不能用以上注释掉的BigInteger转换输出，如果最终md5以0开头，会存在坑
        return toHexString(digest.digest());
    }

    private static String toHexString(byte[] bytes) {
        Formatter formatter = new Formatter();
        for (byte b : bytes) {
            formatter.format("%02x", b);
        }

        String res = formatter.toString();
        formatter.close();

        return res;
    }


    /**
     * 获取文件的MD5值
     */
    /*public static String getImgMD5(String filePath) {
        InputStream in = null;
        MessageDigest digest = null;
        byte[] data = null;
        try {
            File file = new File(filePath);
            file.exists();
            in = new FileInputStream(file);

            data = new byte[in.available()];
            in.read(data);

            digest = MessageDigest.getInstance("MD5");
            digest.update(data, 0, data.length);

        } catch (Exception e) {
            throw new BaseException(ServerCode.SERVER_UNKNOWN_ERROR,"获取文件MD5出错");
        }
        finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    throw new BaseException(ServerCode.SERVER_UNKNOWN_ERROR,"关闭流出错");
                }
            }
        }
        BigInteger bigInt = new BigInteger(1, digest.digest());
        return bigInt.toString(16);
    }*/
}
