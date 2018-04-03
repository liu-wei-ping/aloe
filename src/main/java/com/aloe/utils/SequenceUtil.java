package com.aloe.utils;

import java.util.UUID;

/**
 * @author liu wp
 * @date  2017年9月27日
 */
public class SequenceUtil {

	private static String[] chars = new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
			"o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8",
			"9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
			"U", "V", "W", "X", "Y", "Z" };

	/*** 长度8位 */
	private final static int longer = 8;


	public static String generateShortUuid() {
		StringBuffer shortBuffer = new StringBuffer();
		String uuid = UUID.randomUUID().toString().replace("-", "");
		for (int i = 0; i < longer; i++) {
			String str = uuid.substring(i * 4, i * 4 + 4);
			int x = Integer.parseInt(str, 16);
			shortBuffer.append(chars[x % 0x3E]);
		}
		return shortBuffer.toString();

	}

	public static void main(String[] args) {
		for (int i = 0; i < 10000; i++) {
			String uid = SequenceUtil.generateShortUuid();
			String uid2 = SequenceUtil.generateShortUuid();
			System.out.println(uid);
			if (uid.equals(uid2)) {
				System.out.println(uid);
			}
		}
	}
}