package com.aloe.service.right;

import java.util.List;

/**
 * @author liu_wp
 * @date 2017年10月9日
 * @see
 */
public interface IRightService {
	/**
	 * @param userNo
	 * @return
	 */
	List<String> getRightCodesByUserNo(String userNo);
}
