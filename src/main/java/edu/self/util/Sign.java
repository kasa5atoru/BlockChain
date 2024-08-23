package edu.self.util;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

public class Sign {
	
    public static KeyPair generateKey() throws NoSuchAlgorithmException {

        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2024);

        return keyGen.generateKeyPair();
    }
    
    public static byte[] sign(String plainText, PrivateKey privatekey) throws GeneralSecurityException {

        Signature sign = Signature.getInstance("SHA256withRSA");
        sign.initSign(privatekey);
        sign.update(plainText.getBytes());

        return sign.sign();
    }

    public static  boolean verify(String plainText, byte[] sign, PublicKey publicKey) throws GeneralSecurityException {

        Signature verify = Signature.getInstance("SHA256withRSA");
        verify.initVerify(publicKey);
        verify.update(plainText.getBytes());

        return verify.verify(sign);
    }
}
