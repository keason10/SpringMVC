package security;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import java.io.IOException;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * Created by keason on 2017/11/5.
 * RSA 非对称加密
 */
public class RSATest {
    public static void main(String[] args) throws Exception {
//       获取keyPair
        KeyPair keyPair = getKeyPair();

//        获取public private key 的string
        String publicKeyStr = getPublicKey(keyPair);
        String  privateKyeStr = getPrivateKye(keyPair);

//        获取public key 获取private key
        PublicKey publicKey = string2PublicKey(publicKeyStr);
        PrivateKey privateKey = string2PrivateKey(privateKyeStr);



//公钥加密，私钥解密
        String str  = SecurityUtilAndConstant.msg;
        byte[] dataToSend = str.getBytes("utf-8");
        System.out.println("RSA 加密前："+new String(dataToSend,"utf-8"));


        byte[] encryptedBytes = publicEncrypt(dataToSend, publicKey);
        System.out.println("RSA 加密后："+new String(encryptedBytes,"utf-8"));


        byte [] decrypteddBytes = privateDecrypt(encryptedBytes,privateKey);
        String orgStr = new String(decrypteddBytes, "utf-8");

        System.out.println("RSA 解密后："+orgStr);
    }







    // 1.   获取KeyPair
    public static KeyPair getKeyPair() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(512);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        return keyPair;
    }


    //2 .得到base64加密的公钥   得到base64加密的私钥
    public static  String getPublicKey(KeyPair keyPair) {
        PublicKey publicKey = keyPair.getPublic();
        byte[] bytes = publicKey.getEncoded();
        return SecurityUtilAndConstant.byte2Base64(bytes);
    }


    public static String getPrivateKye(KeyPair keyPair) {
        PrivateKey privateKey = keyPair.getPrivate();
        byte[] bytes = privateKey.getEncoded();
        return SecurityUtilAndConstant.byte2Base64(bytes);
    }


    //3 网络传输base64的公钥、私钥字符串之后，转化为Public Key 和 Private Key
    public static PublicKey string2PublicKey(String pubStr) throws Exception {
        byte[] keyBytes = SecurityUtilAndConstant.base624Byte(pubStr);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);//区分
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        return publicKey;
    }

    public static PrivateKey string2PrivateKey(String priStr) throws Exception {
        byte[] keyBytes = SecurityUtilAndConstant.base624Byte(priStr);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);//区分
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        return privateKey;
    }



    // 4   使用公钥加密，使用私钥解密
    public static byte[] publicEncrypt(byte[] content, PublicKey publicKey) throws  Exception{
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] bytes = cipher.doFinal(content);
        return bytes;
    }

    public static byte[] privateDecrypt(byte[] content, PrivateKey privateKey) throws  Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] bytes = cipher.doFinal(content);
        return bytes;
    }

}
