package com.yunzhi.edu.util;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class EncryptUtil {
	
	private static String hashAlgorithmName = "MD5"; // 加密方式  
	  
    private static int hashIterations = 1024; // 加密次数 
    
    
    private static SecureRandomNumberGenerator secureRandomNumberGenerator = new SecureRandomNumberGenerator();
    
    public static String createCredentialsSalt(){
    	return secureRandomNumberGenerator.nextBytes().toHex();
    }
    
    
    
    public static String encryptMD5(String credentials, String salt){
    	
    	ByteSource credentialsSalt = ByteSource.Util.bytes(salt); 
    	
    	Object obj = new SimpleHash(hashAlgorithmName, credentials, credentialsSalt, hashIterations);
    	
    	return 	obj.toString();
    }
    
}

