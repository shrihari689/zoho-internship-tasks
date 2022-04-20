package utils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utils {

	public static String hashSHA(String word) throws NoSuchAlgorithmException  {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		digest.update(word.getBytes(StandardCharsets.UTF_8));
		
		byte[] bytes = digest.digest();
	
		String hex = String.format("%064x", new BigInteger(bytes));		
		return hex;
	}
	
}
