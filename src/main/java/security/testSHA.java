package security;

import java.security.MessageDigest;

import static security.SecurityUtilAndConstant.byte2hex;
import static security.SecurityUtilAndConstant.hex2bytes;

/**
 * Created by keason on 2017/11/5.
 */
public class testSHA {
    public static void main(String[] args) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        byte [] bytes = messageDigest.digest(SecurityUtilAndConstant.msg.getBytes("utf-8"));
        //byte 转化为16进制的字符串
        System.out.println(byte2hex(bytes));

        //16 进制字符串，转化为2进制，再转化为16进制，字符串，校验算法正确性。
        System.out.println(byte2hex(hex2bytes("deb945d3e6fe72db1a290bcfcf53057c1caafde1")));
    }

}
