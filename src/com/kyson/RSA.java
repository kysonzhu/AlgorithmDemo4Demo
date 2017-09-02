package com.kyson;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
public class RSA {

	public static final String PUBLIC_KEY = "publicKey";

	public static final String KEY_ALGORITHM = "RSA";
	
	public static final String PRIVATE_KEY = "privateKey";
	
	public static final String CIPHER_ALGORITHM = "RSA/ECB/PKCS1Padding";

	
	public static final String PLAIN_TEXT = "MANUTD is the greatest club in the world";

	/** RSA密钥长度必须是64的倍数，在512~65536之间。默认是1024 */
	public static final int KEY_SIZE = 2048;

	public static void main(String[] args)
    {
        int[] p = new int[2];
        int a = 47;
        int b = 30;
        RSA(a,b,p);
        System.out.print("p[0] is: " + p[0] + ";p[1] is：" + p[1]);//p1为私钥
        
        
       
        Map<String, byte[]> keyMap = generateKeyBytes();
        
     // 加密
        PublicKey publicKey = restorePublicKey(keyMap.get(PUBLIC_KEY));
        
        byte[] encodedText = RSAEncode(publicKey, PLAIN_TEXT.getBytes());
        System.out.println("RSA encoded: " + encodedText);

    }
    public static  int[] RSA(int a,int b,int[] p)//这里假设a > b
    {
        if(a%b == 1)
        {
            p[0] = 1;
            p[1] = -(a - 1) / b;
            return p;
        }
            else
        {
                RSA(b,a % b,p);
                int t = p[0];
                p[0] = p[1];
                p[1] = t - (a / b) * p[1]; 
                return p;
        }
    }
    
    
    
    /**
     * 生成密钥对。注意这里是生成密钥对KeyPair，再由密钥对获取公私钥
     * 
     * @return
     */
    public static Map<String, byte[]> generateKeyBytes() {
    
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator
                    .getInstance(KEY_ALGORITHM);
            keyPairGenerator.initialize(KEY_SIZE);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
            RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
    
            Map<String, byte[]> keyMap = new HashMap<String, byte[]>();
            keyMap.put(PUBLIC_KEY, publicKey.getEncoded());
            keyMap.put(PRIVATE_KEY, privateKey.getEncoded());
            return keyMap;
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    
    
    
    /**
     * 还原公钥，X509EncodedKeySpec 用于构建公钥的规范
     * 
     * @param keyBytes
     * @return
     */
    public static PublicKey restorePublicKey(byte[] keyBytes) {
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyBytes);
    
        try {
            KeyFactory factory = KeyFactory.getInstance(KEY_ALGORITHM);
            PublicKey publicKey = factory.generatePublic(x509EncodedKeySpec);
            return publicKey;
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    
    /**
     * 加密，三步走。
     * 
     * @param key
     * @param plainText
     * @return
     */
    public static byte[] RSAEncode(PublicKey key, byte[] plainText) {
    
        try {
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            return cipher.doFinal(plainText);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException
                | InvalidKeyException | IllegalBlockSizeException
                | BadPaddingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    
    }
}
