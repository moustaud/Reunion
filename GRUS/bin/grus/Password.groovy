package grus

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;


public final class Password {
	
	public static String getHashWithSalt(String input, String salt, String algo) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(algo);
        digest.reset();
        digest.update(salt.getBytes());
        byte[] hashedBytes = digest.digest(input.getBytes());
        return bytesToHex(hashedBytes);
    }
	
	public static String generateSalt() {
        SecureRandom random = new SecureRandom();
        def bytes = new byte[20];
        random.nextBytes(bytes);
        return bytesToHex(bytes);
    }
	
	final private static char[] hexArray = "0123456789ABCDEF".toCharArray();
	
	public static String bytesToHex(byte[] bytes) {
	    char[] hexChars = new char[bytes.length * 2];
	    for ( int j = 0; j < bytes.length; j++ ) {
	        int v = bytes[j] & 0xFF;
	        hexChars[j * 2] = hexArray[v >>> 4];
	        hexChars[j * 2 + 1] = hexArray[v & 0x0F];
	    }
	    return new String(hexChars);
	}
	
	public static boolean isValidSHA1(String s) {
		return s.matches("[a-fA-F0-9]{40}");
	}
}