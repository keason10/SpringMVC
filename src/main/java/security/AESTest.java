package security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by keason on 2017/11/5.
 * AES 对称加密
 */
public class AESTest {
    public static void main(String[] args) throws Exception {
        String base64SecretKeyString = genKeyAes();
        SecretKey key = loadKeyAes(base64SecretKeyString);

        String str  = SecurityUtilAndConstant.msg;
        byte[] dataToSend = str.getBytes("utf-8");
        System.out.println("AES 加密前："+new String(dataToSend,"utf-8"));


        byte[] encryptedBytes = encryptAes(dataToSend, key);
        System.out.println("AES 加密后："+new String(encryptedBytes,"utf-8"));


        byte [] decrypteddBytes = decryptAes(encryptedBytes,key);
        String orgStr = new String(decrypteddBytes, "utf-8");

        System.out.println("AES 解密后："+orgStr);

    }

    //生成Aes 秘钥，并用Base64加密
    public static String genKeyAes() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);//生成的秘钥为64位数
        SecretKey key = keyGenerator.generateKey();
        String base64Str = SecurityUtilAndConstant.byte2Base64(key.getEncoded());
        return base64Str;
    }

    //网络传递基于Base64 加密后的字符串，然后解密得到SecretKey
    public static SecretKey loadKeyAes(String base64Key) throws IOException {
        byte[] bytes = SecurityUtilAndConstant.base624Byte(base64Key);
        SecretKey key = new SecretKeySpec(bytes, "AES");
        return key;
    }


    //    用SecretKey加密
    public static byte[] encryptAes(byte[] source, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] bytes = cipher.doFinal(source);
        return bytes;
    }

    // 用 SecretKey解密
    public static byte[] decryptAes(byte[] source, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] bytes = cipher.doFinal(source);
        return bytes;
    }

}
