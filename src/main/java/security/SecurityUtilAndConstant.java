package security;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * Created by keason on 2017/11/5.
*          byte 到 16进制的编码、解码方式
*           base64编码解码方式。
 */
public class SecurityUtilAndConstant {
    public static String msg  = "hello,i am chenkangxian,good night!";

    //16进制编码
    public static String byte2hex(byte [] bytes) {
        StringBuilder hex = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            byte b = bytes[i];
            boolean nagative =false;//是否为负数
            if (b < 0) {
                nagative = true;
            }
            //负数，则把bit 最高位变成 1
            int inte = Math.abs(b);
            if (nagative) {
                inte = inte | 0x80;
            }

            //负数转为正数（最高位的负号变成数值计算）再转为十六进制
            String temp= Integer.toHexString(inte & 0xff);
            if (temp.length() == 1) {
                hex.append(0);
            }
            hex.append(temp.toLowerCase());
        }
        return hex.toString();
    }


    //16进制解密
    public static byte[] hex2bytes(String hex) {
        byte [] bytes = new byte[hex.length()/2];
        for (int i = 0; i < hex.length(); i = i + 2) {
            String subStr = hex.substring(i, i + 2);
            boolean negative =false;
            int inte = Integer.parseInt(subStr,16);
            if (inte > 127) {
                negative = true;
            }
            if (inte == 128) {
                inte = -128;
            } else if (negative) {
                inte = 0 - (inte & 0x7f);
            }
            byte b = (byte) inte;
            bytes[i / 2] = b;
        }
        return bytes;
    }



    public static String byte2Base64(byte[] bytes) {
        BASE64Encoder base64Encoder = new BASE64Encoder();
        String msg = base64Encoder.encode(bytes);
        return msg;
    }

    public static byte[] base64Byte(String base64) throws IOException {
        BASE64Decoder base64Decoder = new BASE64Decoder();
        byte [] bytes = base64Decoder.decodeBuffer(base64);
        return bytes;
    }
}
