package utils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class Utils {
	
	public static String hashSHA(String word) throws NoSuchAlgorithmException  {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		digest.update(word.getBytes(StandardCharsets.UTF_8));
		
		byte[] bytes = digest.digest();
	
		String hex = String.format("%064x", new BigInteger(bytes));		
		return hex;
	}
	
	
	public static int clamp(int val, int min, int max) {
	    return Math.max(min, Math.min(max, val));
	}
	
	public static String generateRandomWord(int wordLength) {
	    Random r = new Random();
	    StringBuilder sb = new StringBuilder(wordLength);
	    for(int i = 0; i < wordLength; i++) {
	        char tmp = (char) ('a' + r.nextInt('z' - 'a'));
	        sb.append(tmp);
	    }
	    return r.nextInt(100) + sb.toString().toUpperCase();
	}
}
