package security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by keason on 2017/11/5
 * DES  对称加密.
 */
public class DESTest {
    public static void main(String[] args) throws Exception {
        String base64SecretKeyString = genKeyDes();
        SecretKey key = loadKeyDes(base64SecretKeyString);

        String str  = SecurityUtilAndConstant.msg;
        byte[] dataToSend = str.getBytes("utf-8");
        System.out.println("des 加密前："+new String(dataToSend,"utf-8"));


        byte[] encryptedBytes = encryptDes(dataToSend, key);
        System.out.println("des 加密后："+new String(encryptedBytes,"utf-8"));


        byte [] decrypteddBytes = decryptDes(encryptedBytes,key);
        String orgStr = new String(decrypteddBytes, "utf-8");

        System.out.println("des 解密后："+orgStr);

    }

    //生成Des 秘钥，并用Base64加密
    public static String genKeyDes() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
        keyGenerator.init(56);//生成的秘钥为64位数
        SecretKey key = keyGenerator.generateKey();
        String base64Str = SecurityUtilAndConstant.byte2Base64(key.getEncoded());
        return base64Str;
    }

    //网络传递基于Base64 加密后的字符串，然后解密得到SecretKey
    public static SecretKey loadKeyDes(String base64Key) throws IOException {
        byte[] bytes = SecurityUtilAndConstant.base624Byte(base64Key);
        SecretKey key = new SecretKeySpec(bytes, "DES");
        return key;
    }


    //    用SecretKey加密
    public static byte[] encryptDes(byte[] source, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] bytes = cipher.doFinal(source);
        return bytes;
    }

    // 用 SecretKey解密
    public static byte[] decryptDes(byte[] source, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] bytes = cipher.doFinal(source);
        return bytes;
    }

}
