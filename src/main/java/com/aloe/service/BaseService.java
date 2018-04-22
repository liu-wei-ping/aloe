package com.aloe.service;

import com.aloe.utils.EncryptionUtil;
import com.aloe.utils.HttpRequestUtil;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author liu_wp
 * @date 2017年10月9日
 * @see
 */
public class BaseService extends DozerBeanMapper {

	/** 日志类 */
	protected final Logger logger = LoggerFactory.getLogger(super.getClass());

	/**
	 * 实体对象集合转换业务对象集合<br>
	 * xxxEntiry->xxxVO
	 *
	 * @param sourceList
	 * @param destinationClass
	 * @return
	 */

	public <B, E> List<B> mapToList(List<E> sourceList, Class<B> destinationClass) {
		final List<B> tagaList = new ArrayList<B>();
		for (E e : sourceList) {
			tagaList.add(super.map(e, destinationClass));
		}
		return tagaList;
	}

	/**
	 * 密码MD5加密
	 *
	 * @param password
	 * @return
	 */
	protected String encryptPwd(String password) {
		return EncryptionUtil.md5EncryptionShiro(password);
	}

	/**
	 * 生成随机的salt
	 *
	 * @return
	 */
	protected String generateSalt() {
		SecureRandomNumberGenerator secureRandom = new SecureRandomNumberGenerator();
		// 一个Byte占两个字节，此处生成的3字节，字符串长度为6
		String hex = secureRandom.nextBytes(3).toHex();
		return hex;
	}

	/**
	 * 获取当前操渠道
	 *
	 * @return
	 */
	protected Integer getRegRource() {
		return Integer.valueOf(HttpRequestUtil.getChannelByRequest());
	}

	/**
	 * 获取异常的堆栈信息
	 *
	 * @param ex
	 * @return
	 */
	protected String getStackTrace(Throwable ex) {
		return ExceptionUtils.getMessage(ex);
	}


	/**
	 * uuid 主键Id
	 *
	 * @return
	 */
	protected String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
