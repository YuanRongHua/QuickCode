package com.yuanronghua.encry;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加解
 * 
 * @author wb-yuanronghua
 *
 */
public class MD5Util {

	/***
	 * MD5加码 生成32位md5
	 * 
	 * @throws NoSuchAlgorithmException
	 */
	public static String MD5Encode(String inStr) throws Exception {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new Exception("_string_md5_encode_error_");
		}
		char[] charArray = inStr.toCharArray();
		byte[] byteArray = new byte[charArray.length];

		for (int i = 0; i < charArray.length; i++)
			byteArray[i] = (byte) charArray[i];
		byte[] md5Bytes = md5.digest(byteArray);
		StringBuffer hexValue = new StringBuffer();
		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16)
				hexValue.append("0");
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();

	}
}
