package com.suypower.venus.sys.utils;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RSAUtils {
    protected static final Log log = LogFactory.getLog(RSAUtils.class);
    private static String KEY_RSA_TYPE = "RSA";
    private static int KEY_SIZE = 2048;//JDK方式RSA加密最大只有1024位
    private static int ENCODE_PART_SIZE = KEY_SIZE/8;
    public static final String PUBLIC_KEY_NAME = "public";
    public static final String PRIVATE_KEY_NAME = "private";

    /**
     * 创建公钥秘钥
     * @return
     */
    public static Map<String,String> createRSAKeys(){
        Map<String,String> keyPairMap = new HashMap<>();//里面存放公私秘钥的Base64位加密
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_RSA_TYPE);
            keyPairGenerator.initialize(KEY_SIZE,new SecureRandom());
            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            //获取公钥秘钥
            String publicKeyValue = Base64.encodeBase64String(keyPair.getPublic().getEncoded());
            String privateKeyValue = Base64.encodeBase64String(keyPair.getPrivate().getEncoded());

            //存入公钥秘钥，以便以后获取
            keyPairMap.put(PUBLIC_KEY_NAME,publicKeyValue);
            keyPairMap.put(PRIVATE_KEY_NAME,privateKeyValue);
        } catch (NoSuchAlgorithmException e) {
            log.error("当前JDK版本没找到RSA加密算法！");
            e.printStackTrace();
        }
        return keyPairMap;
    }

    /**
     * 公钥加密
     * 描述：
     *     1字节 = 8位；
     *     最大加密长度如 1024位私钥时，最大加密长度为 128-11 = 117字节，不管多长数据，加密出来都是 128 字节长度。
     * @param sourceStr
     * @param publicKeyBase64Str
     * @return
     */
    public static String encodeByPublicKey(String sourceStr, String publicKeyBase64Str){
        byte [] publicBytes = Base64.decodeBase64(publicKeyBase64Str);
        //公钥加密
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(publicBytes);
        List<byte[]> alreadyEncodeListData = new LinkedList<>();

        int maxEncodeSize = ENCODE_PART_SIZE - 11;
        String encodeBase64Result = null;
        try {
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_RSA_TYPE);
            PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
            Cipher cipher = Cipher.getInstance(KEY_RSA_TYPE);
            cipher.init(Cipher.ENCRYPT_MODE,publicKey);
            byte[] sourceBytes = sourceStr.getBytes("utf-8");
            int sourceLen = sourceBytes.length;
            for(int i=0;i<sourceLen;i+=maxEncodeSize){
                int curPosition = sourceLen - i;
                int tempLen = curPosition;
                if(curPosition > maxEncodeSize){
                    tempLen = maxEncodeSize;
                }
                byte[] tempBytes = new byte[tempLen];//待加密分段数据
                System.arraycopy(sourceBytes,i,tempBytes,0,tempLen);
                byte[] tempAlreadyEncodeData = cipher.doFinal(tempBytes);
                alreadyEncodeListData.add(tempAlreadyEncodeData);
            }
            int partLen = alreadyEncodeListData.size();//加密次数

            int allEncodeLen = partLen * ENCODE_PART_SIZE;
            byte[] encodeData = new byte[allEncodeLen];//存放所有RSA分段加密数据
            for (int i = 0; i < partLen; i++) {
                byte[] tempByteList = alreadyEncodeListData.get(i);
                System.arraycopy(tempByteList,0,encodeData,i*ENCODE_PART_SIZE,ENCODE_PART_SIZE);
            }
            encodeBase64Result = Base64.encodeBase64String(encodeData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encodeBase64Result;
    }
    /**
     * 私钥加密
     * 描述：
     *     1字节 = 8位；
     *     最大加密长度如 1024位私钥时，最大加密长度为 128-11 = 117字节，不管多长数据，加密出来都是 128 字节长度。
     * @param sourceStr
     * @param privateKeyBase64Str
     * @return
     */
    public static String encodeByPrivateKey(String sourceStr, String privateKeyBase64Str){
        byte [] publicBytes = Base64.decodeBase64(privateKeyBase64Str);
        //私钥加密
        PKCS8EncodedKeySpec pKCS8EncodedKeySpec = new PKCS8EncodedKeySpec(publicBytes);
        List<byte[]> alreadyEncodeListData = new LinkedList<>();

        int maxEncodeSize = ENCODE_PART_SIZE - 11;
        String encodeBase64Result = null;
        try {
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_RSA_TYPE);
            PrivateKey privateKey = keyFactory.generatePrivate(pKCS8EncodedKeySpec);

            Cipher cipher = Cipher.getInstance(KEY_RSA_TYPE);
            cipher.init(Cipher.ENCRYPT_MODE,privateKey);

            byte[] sourceBytes = sourceStr.getBytes("utf-8");
            int sourceLen = sourceBytes.length;
            for(int i=0;i<sourceLen;i+=maxEncodeSize){
                int curPosition = sourceLen - i;
                int tempLen = curPosition;
                if(curPosition > maxEncodeSize){
                    tempLen = maxEncodeSize;
                }
                byte[] tempBytes = new byte[tempLen];//待加密分段数据
                System.arraycopy(sourceBytes,i,tempBytes,0,tempLen);
                byte[] tempAlreadyEncodeData = cipher.doFinal(tempBytes);
                alreadyEncodeListData.add(tempAlreadyEncodeData);
            }
            int partLen = alreadyEncodeListData.size();//加密次数

            int allEncodeLen = partLen * ENCODE_PART_SIZE;
            byte[] encodeData = new byte[allEncodeLen];//存放所有RSA分段加密数据
            for (int i = 0; i < partLen; i++) {
                byte[] tempByteList = alreadyEncodeListData.get(i);
                System.arraycopy(tempByteList,0,encodeData,i*ENCODE_PART_SIZE,ENCODE_PART_SIZE);
            }
            encodeBase64Result = Base64.encodeBase64String(encodeData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encodeBase64Result;
    }

    /**
     * 私钥解密
     * @param sourceBase64RSA
     * @param privateKeyBase64Str
     */
    public static String decodeByPrivateKey(String sourceBase64RSA, String privateKeyBase64Str){
        byte[] privateBytes = Base64.decodeBase64(privateKeyBase64Str);
        byte[] encodeSource = Base64.decodeBase64(sourceBase64RSA);
        int encodePartLen = encodeSource.length/ENCODE_PART_SIZE;
        List<byte[]> decodeListData = new LinkedList<>();//所有解密数据
        String decodeStrResult = null;
        //私钥解密
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(privateBytes);
        try {
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_RSA_TYPE);
            PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
            Cipher cipher = Cipher.getInstance(KEY_RSA_TYPE);
            cipher.init(Cipher.DECRYPT_MODE,privateKey);
            int allDecodeByteLen = 0;//初始化所有被解密数据长度
            for (int i = 0; i < encodePartLen; i++) {
                byte[] tempEncodedData = new byte[ENCODE_PART_SIZE];
                System.arraycopy(encodeSource,i*ENCODE_PART_SIZE,tempEncodedData,0,ENCODE_PART_SIZE);
                byte[] decodePartData = cipher.doFinal(tempEncodedData);
                decodeListData.add(decodePartData);
                allDecodeByteLen += decodePartData.length;
            }
            byte [] decodeResultBytes = new byte[allDecodeByteLen];
            for (int i = 0,curPosition = 0; i < encodePartLen; i++) {
                byte[] tempSorceBytes = decodeListData.get(i);
                int tempSourceBytesLen = tempSorceBytes.length;
                System.arraycopy(tempSorceBytes,0,decodeResultBytes,curPosition,tempSourceBytesLen);
                curPosition += tempSourceBytesLen;
            }
            decodeStrResult = new String(decodeResultBytes,"UTF-8");
        }catch (Exception e){
            e.printStackTrace();
        }
        return decodeStrResult;
    }
    /**
     * 公钥解密
     * @param sourceBase64RSA
     * @param publicKeyBase64Str
     */
    public static String decodeByPublicKey(String sourceBase64RSA, String publicKeyBase64Str){
        byte[] privateBytes = Base64.decodeBase64(publicKeyBase64Str);
        byte[] encodeSource = Base64.decodeBase64(sourceBase64RSA);
        int encodePartLen = encodeSource.length/ENCODE_PART_SIZE;
        List<byte[]> decodeListData = new LinkedList<>();//所有解密数据
        String decodeStrResult = null;
        //私钥解密
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(privateBytes);
        try {
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_RSA_TYPE);
            PublicKey  publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
            Cipher cipher = Cipher.getInstance(KEY_RSA_TYPE);
            cipher.init(Cipher.DECRYPT_MODE,publicKey);
            int allDecodeByteLen = 0;//初始化所有被解密数据长度
            for (int i = 0; i < encodePartLen; i++) {
                byte[] tempEncodedData = new byte[ENCODE_PART_SIZE];
                System.arraycopy(encodeSource,i*ENCODE_PART_SIZE,tempEncodedData,0,ENCODE_PART_SIZE);
                byte[] decodePartData = cipher.doFinal(tempEncodedData);
                decodeListData.add(decodePartData);
                allDecodeByteLen += decodePartData.length;
            }
            byte [] decodeResultBytes = new byte[allDecodeByteLen];
            for (int i = 0,curPosition = 0; i < encodePartLen; i++) {
                byte[] tempSorceBytes = decodeListData.get(i);
                int tempSourceBytesLen = tempSorceBytes.length;
                System.arraycopy(tempSorceBytes,0,decodeResultBytes,curPosition,tempSourceBytesLen);
                curPosition += tempSourceBytesLen;
            }
            decodeStrResult = new String(decodeResultBytes,"UTF-8");
        }catch (Exception e){
            e.printStackTrace();
        }
        return decodeStrResult;
    }


    public static void main(String[] args) {
        Map<String, String> rsaKeys = RSAUtils.createRSAKeys();
        String publicKey = rsaKeys.get(RSAUtils.PUBLIC_KEY_NAME);
        String privateKey = rsaKeys.get(RSAUtils.PRIVATE_KEY_NAME);
        System.out.println("publicKey_length"+publicKey.length());
        System.out.println("privateKey_length"+privateKey.length());

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>开始演示:私钥加密，公钥解密");
        String originalText = "我是大内密探009";
        System.out.println("原文:"+originalText);
        String encode = RSAUtils.encodeByPrivateKey(originalText, privateKey);
        System.out.println("加密后:"+encode);
        String decode = RSAUtils.decodeByPublicKey(encode, publicKey);
        System.out.println("解密后:"+decode);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>开始演示:公钥加密，私钥解密");
        String originalText1 = "我是大内密探009";
        System.out.println("原文:"+originalText1);
        String encode1 = RSAUtils.encodeByPublicKey(originalText1, publicKey);
        System.out.println("加密后:"+encode1);
        String decode1 = RSAUtils.decodeByPrivateKey(encode1, privateKey);
        System.out.println("解密后:"+decode1);

    }
}