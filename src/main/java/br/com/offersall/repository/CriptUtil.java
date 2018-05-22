package br.com.offersall.repository;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;

public class CriptUtil {

	public static final byte[]  key = "!@#$!@#$%^&**&^%".getBytes();
	final static String algorithm="AES";

	public static String encrypt(Object data){
		String id = String.valueOf(data);
	    byte[] dataToSend = id.getBytes();
	    Cipher c = null;
	    try {
	        c = Cipher.getInstance(algorithm);
	    } catch (NoSuchAlgorithmException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } catch (NoSuchPaddingException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	    SecretKeySpec k =  new SecretKeySpec(key, algorithm);
	    try {
	        c.init(Cipher.ENCRYPT_MODE, k);
	    } catch (InvalidKeyException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	    byte[] encryptedData = "".getBytes();
	    try {
	        encryptedData = c.doFinal(dataToSend);
	    } catch (IllegalBlockSizeException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } catch (BadPaddingException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	    byte[] encryptedByteValue =    new Base64().encode(encryptedData);
	    return  new String(encryptedByteValue);//.toString();
	}

	public static String decrypt(String data){

	    byte[] encryptedData  = new Base64().decode(data);
	    Cipher c = null;
	    try {
	        c = Cipher.getInstance(algorithm);
	    } catch (NoSuchAlgorithmException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } catch (NoSuchPaddingException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	    SecretKeySpec k =
	            new SecretKeySpec(key, algorithm);
	    try {
	        c.init(Cipher.DECRYPT_MODE, k);
	    } catch (InvalidKeyException e1) {
	        // TODO Auto-generated catch block
	        e1.printStackTrace();
	    }
	    byte[] decrypted = null;
	    try {
	        decrypted = c.doFinal(encryptedData);
	    } catch (IllegalBlockSizeException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } catch (BadPaddingException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	    return new String(decrypted);
	}

	public static void main(String[] args){
	    String password=CriptUtil.encrypt("1");
	    System.out.println(password);
	    System.out.println(CriptUtil.decrypt(password));
	}
}

