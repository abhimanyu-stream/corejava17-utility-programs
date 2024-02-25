package com.java17.utilityprograms;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import static com.java17.utilityprograms.UsingJava8_GeneratingRandomAlphanumericStringApplication.UsingJava8_GeneratingRandomAlphanumericString;

@SpringBootApplication
public class AES256EncryptionDecryptionApplication {

    public static void main(String[] args) throws InvalidAlgorithmParameterException, IllegalBlockSizeException, NoSuchPaddingException, BadPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        SpringApplication.run(AES256EncryptionDecryptionApplication.class, args);
        System.out.println("AES 256 Encryption/Decryption: " + AES256EncryptionDecryption("mypassword"));
    }

    public static Map<Object, Object> AES256EncryptionDecryption(String userString) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchPaddingException {

        // 1.
        KeyGenerator AES256keyGenrator = KeyGenerator.getInstance("AES");
        AES256keyGenrator.init(256);// 128bits
        SecretKey secretKeyByAES256 = AES256keyGenrator.generateKey();
        byte[] secretKeyByAES256ByteArray = secretKeyByAES256.getEncoded();
        String secretKeyByAES256ByteArrayTOString = Base64.getEncoder().encodeToString(secretKeyByAES256ByteArray);
        System.out.println(secretKeyByAES256ByteArrayTOString);

        // 2. Encryption Data process

        Cipher encryptionCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        IvParameterSpec ivParameterSpec = new IvParameterSpec(new byte[16]);

        encryptionCipher.init(Cipher.ENCRYPT_MODE,secretKeyByAES256,ivParameterSpec);
        //String userString = "Java8SpringBootSpringFrameworkJPA";
        //+UsingJava8_GeneratingRandomAlphanumericString()
        //byte[] encryptedDataBytesArray = encryptionCipher.doFinal((userString+"@"+123).getBytes());
        byte[] encryptedDataBytesArray = encryptionCipher.doFinal((userString).getBytes());
        String encryptedDataBytesArrayToString = Base64.getEncoder().encodeToString(encryptedDataBytesArray);

        Map<Object, Object> encryptedAnddecryptedDataMap = new HashMap<>();
        encryptedAnddecryptedDataMap.put("EncryptedData", encryptedDataBytesArrayToString);
        System.out.println("Encrypted Data using AES256 is = " + encryptedDataBytesArrayToString);

        // 3. Decryption Data process
        Cipher decryptionCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        decryptionCipher.init(Cipher.DECRYPT_MODE,secretKeyByAES256,ivParameterSpec);
        byte[] decryptedDataBytesArray = decryptionCipher.doFinal(encryptedDataBytesArray);
        String decryptedDataBytesArrayToString = new String(decryptedDataBytesArray);
        encryptedAnddecryptedDataMap.put("DecryptedData", decryptedDataBytesArrayToString);
        System.out.println("Decrypted Data using AES256 is " + decryptedDataBytesArrayToString);


        return encryptedAnddecryptedDataMap;
    }
}
