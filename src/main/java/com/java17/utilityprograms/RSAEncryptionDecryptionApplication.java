package com.java17.utilityprograms;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class RSAEncryptionDecryptionApplication {
    public static void main(String[] args) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        SpringApplication.run(RSAEncryptionDecryptionApplication.class, args);
        System.out.println("RSA Encryption/Decryption: " + RSAEncryptionDecryption("mypassword"));
    }

    public static Map<Object, Object> RSAEncryptionDecryption(String userString) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

        // 1.
        KeyPairGenerator rsaKeyPairGenerator = KeyPairGenerator.getInstance("RSA");

        // 2.
        SecureRandom secureRandom = new SecureRandom();
        rsaKeyPairGenerator.initialize(2048,secureRandom);
        KeyPair keyPair = rsaKeyPairGenerator.generateKeyPair();


        // 3.

        PublicKey publicKey = keyPair.getPublic();
        String publicKeyString = Base64.getEncoder().encodeToString(publicKey.getEncoded());
        System.out.println("Public Key is : "+ publicKeyString);

        // 4.

        PrivateKey privateKey = keyPair.getPrivate();
        String privateKeyString = Base64.getEncoder().encodeToString(privateKey.getEncoded());
        System.out.println("Private Key is : " + privateKeyString);

        // 5.

        Cipher encryptionCipher = Cipher.getInstance("RSA");
        encryptionCipher.init(Cipher.ENCRYPT_MODE, publicKey);

        // 6. userString to encrypt by PublicKey

        //String userString = "Java8SpringBootSpringFrameworkJPA";
        byte[] encryptedByteArray = encryptionCipher.doFinal(userString.getBytes());
        String encryptedByteArrayToString = Base64.getEncoder().encodeToString(encryptedByteArray);
        Map<Object, Object> encryptedAndDecryptedDataMap = new HashMap<>();
        encryptedAndDecryptedDataMap.put("EncryptedData", encryptedByteArrayToString);
        System.out.println("Encrypted Data By RSA KeyPair and PublicKey : "+ encryptedByteArrayToString);

        // 7. decrypt Data by PrivateKey
        Cipher decryptionCipher = Cipher.getInstance("RSA");
        decryptionCipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedByteArray = decryptionCipher.doFinal(encryptedByteArray);
        String decryptedByteArrayToString = new String(decryptedByteArray);
        encryptedAndDecryptedDataMap.put("DecryptedData", decryptedByteArrayToString);
        System.out.println("Decrypted Data By RSA KeyPair and PrivateKey : "+ decryptedByteArrayToString);



        return encryptedAndDecryptedDataMap;
    }
}
