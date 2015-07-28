package com.netease.java.messageDigest;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;

import org.springside.modules.utils.Exceptions;

public class MessageDigestHandler {
	
	private static byte[] digest(byte[] input, String algorithm, byte[] salt, int iterations) {
		try {
			MessageDigest digest = MessageDigest.getInstance(algorithm);

			if (salt != null) {
				digest.update(salt);
			}

			byte[] result = digest.digest(input);

			for (int i = 1; i < iterations; ++i) {
				digest.reset();
				result = digest.digest(result);
			}
			return result;
		} catch (GeneralSecurityException e) {
			throw Exceptions.unchecked(e);
		}
	}
	public static void main(String[] args) {
		System.out.println(digest("zhoushaojun".getBytes(), "sha1", "lengjing".getBytes(), 1024));
	}
}
