package com.aloe.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aloe.constants.SysConstantsConfig;

/**
 * 加密算法工具 支持 MD5 MD2 SHA-1 SHA-256 SHA-384 SHA-512<br>
 * 包含Shiro 加密
 *
 * @author liu_wp
 * @date 2017年10月10日
 * @see
 */
public class EncryptionUtil {
	private static final Logger logger = LoggerFactory.getLogger(EncryptionUtil.class);
	private static final String MD5 = "MD5";
	private static final String SHA1 = "SHA-1";
	private static final String SHA256 = "SHA-256";
	private static final String UTF8 = "UTF-8";

	/**
	 * 把字节数组转化成字符串返回
	 *
	 * @param bytes
	 * @return
	 */
	public static String bytesConvertToHexString(byte[] bytes) {
		StringBuffer sb = new StringBuffer();
		for (byte aByte : bytes) {
			String s = Integer.toHexString(0xff & aByte);
			if (s.length() == 1) {
				sb.append("0" + s);
			} else {
				sb.append(s);
			}
		}
		return sb.toString();
	}

	/**
	 * Shiro 加密
	 *
	 * @param source
	 *            需要加密的数据
	 * @param algorithm
	 *            采用的加密算法
	 * @param salt
	 *            加盐
	 * @param hashIterations
	 *            散列的次数
	 * @return
	 */
	public static String encryptionShiro(String source, String algorithm, Object salt, int hashIterations) {
		SimpleHash simpleHash = new SimpleHash(algorithm, source, salt, hashIterations);
		return simpleHash.toHex();
	}

	/**
	 * 采用加密算法加密字符串数据 转成长度为16的字符串
	 *
	 * @param str
	 *            需要加密的数据
	 * @param algorithm
	 *            采用的加密算法
	 * @return 字节数据
	 */
	public static String encryptionStr16(String str, String algorithm) {
		return encryptionStr32(str, algorithm, "").substring(8, 24);
	}

	/**
	 * 采用加密算法加密字符串数据 转成长度为16的字符串
	 *
	 * @param str
	 * @param algorithm
	 *            采用的加密算法
	 * @param charset
	 *            指定转化之后的字符串编码
	 * @return
	 */
	public static String encryptionStr16(String str, String algorithm, String charset) {
		return encryptionStr32(str, algorithm, charset).substring(8, 24);
	}

	/**
	 * 采用加密算法加密字符串数据 转成长度为32的字符串
	 *
	 * @param str
	 *            需要加密的数据
	 * @param algorithm
	 *            采用的加密算法
	 * @return 字节数据
	 */
	public static String encryptionStr32(String str, String algorithm) {
		return encryptionStr32(str, algorithm, "");
	}

	/**
	 * 采用加密算法加密字符串数据 转成长度为32的字符串
	 *
	 * @param str
	 * @param algorithm
	 *            采用的加密算法
	 * @param charset
	 *            指定转化之后的字符串编码
	 * @return
	 */
	public static String encryptionStr32(String str, String algorithm, String charset) {
		// 加密之后所得字节数组
		byte[] bytes = encryptionStrBytes(str, algorithm, charset);
		return bytesConvertToHexString(bytes);
	}

	/**
	 * 采用加密算法加密字符串数据
	 *
	 * @param str
	 *            需要加密的数据
	 * @param algorithm
	 *            采用的加密算法
	 * @param charset
	 *            指定转化之后的字符串编码
	 * @return 字节数据
	 */
	public static byte[] encryptionStrBytes(String str, String algorithm, String charset) {
		byte[] bytes = null;
		try {
			// 获取MD5算法实例 得到一个md5的消息摘要
			MessageDigest md = MessageDigest.getInstance(algorithm);
			// 添加要进行计算摘要的信息
			if (null == charset || "".equals(charset)) {
				md.update(str.getBytes());
			} else {
				md.update(str.getBytes(charset));
			}
			// 得到该摘要
			bytes = md.digest();
		} catch (NoSuchAlgorithmException e) {
			logger.error("加密算法【{}】不存在", algorithm);
		} catch (UnsupportedEncodingException e) {
			logger.error("数据加密指定的编码格式不支持【{}】", charset);
		}
		return null == bytes ? null : bytes;
	}

	/**
	 * Shiro MD5 加密
	 *
	 * @param source
	 *            需要加密的数据
	 * @return
	 */
	public static String md5EncryptionShiro(String source) {
		return encryptionShiro(source, MD5, null, SysConstantsConfig.SHIRO_HASH_ITERATIONS);
	}

	/**
	 * Shiro MD5 加密
	 *
	 * @param source
	 *            需要加密的数据
	 * @param salt
	 *            加盐
	 * @return
	 */
	public static String md5EncryptionShiro(String source, Object salt) {
		return encryptionShiro(source, MD5, salt, SysConstantsConfig.SHIRO_HASH_ITERATIONS);
	}

	/**
	 * 采用MD5加密算法加密字符串数据 转成长度为16的字符串
	 *
	 * @param str
	 *            需要加密的数据
	 * @return
	 */
	public static String md5EncryptionStr16(String str) {
		return encryptionStr32(str, MD5, "").substring(8, 24);
	}

	/**
	 * 采用MD5加密算法加密字符串数据 转成长度为32的字符串
	 *
	 * @param str
	 * @return
	 */
	public static String md5EncryptionStr32(String str) {
		return encryptionStr32(str, MD5, "");
	}

	/**
	 * 采用SHA-1加密算法加密字符串数据 转成长度为16的字符串
	 *
	 * @param str
	 *            需要加密的数据
	 * @return
	 */
	public static String sha1EncryptionStr16(String str) {
		return encryptionStr32(str, SHA1, "").substring(8, 24);
	}

	/**
	 * 采用SHA-1加密算法加密字符串数据 转成长度为32的字符串
	 *
	 * @param str
	 * @return
	 */
	public static String sha1EncryptionStr32(String str) {
		return encryptionStr32(str, SHA1, "");
	}

	/**
	 * 采用SHA-256加密算法加密字符串数据 转成长度为16的字符串
	 *
	 * @param str
	 *            需要加密的数据
	 * @return
	 */
	public static String sha256EncryptionStr16(String str) {
		return encryptionStr32(str, SHA256, "").substring(8, 24);
	}

	/**
	 * 采用SHA-256加密算法加密字符串数据 转成长度为32的字符串
	 *
	 * @param str
	 * @return
	 */
	public static String sha256EncryptionStr32(String str) {
		return encryptionStr32(str, SHA256, "");
	}

}
