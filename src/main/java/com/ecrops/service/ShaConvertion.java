//package com.ecrops.service;
//
//import java.nio.charset.StandardCharsets;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//
//public class ShaConvertion {
//	public static String encryptSha256Str(String password) {
//		MessageDigest digest;
//		try {
//			digest = MessageDigest.getInstance("SHA-256");
//		} catch (NoSuchAlgorithmException e) {
//			System.err.println(e);
//			return null;
//		}
//		final byte[] hashbytes = digest.digest(password.getBytes(StandardCharsets.UTF_8));
//		return new String(bytesToHex(hashbytes));
//	}
//
//	private static String bytesToHex(byte[] hash) {
//		StringBuilder hexString = new StringBuilder(2 * hash.length);
//		for (int i = 0; i < hash.length; i++) {
//			String hex = Integer.toHexString(0xff & hash[i]);
//			if (hex.length() == 1) {
//				hexString.append('0');
//			}
//			hexString.append(hex);
//		}
//		return hexString.toString();
//	}
//}
