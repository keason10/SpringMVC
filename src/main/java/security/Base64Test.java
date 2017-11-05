package security;

import java.io.IOException;

/**
 * Created by keason on 2017/11/5.
 */
public class Base64Test {
    public static void main(String[] args) throws IOException {
        String str = "id=1&name=keason";
        String encodedStr  = SecurityUtilAndConstant.byte2Base64(str.getBytes("utf-8"));
        System.out.println(encodedStr);

        byte [] bytes = SecurityUtilAndConstant.base624Byte(encodedStr);
        String decodedStr = new String(bytes,"utf-8");
        System.out.println(decodedStr);
    }
}

