package com.aloe.service.file;

import javax.servlet.http.HttpServletRequest;

import com.aloe.pojo.vo.ResponseResultVo;

/**
 * @author liu_wp
 * @date 2017年11月1日
 * @see
 */
public interface IFileService {
	/**
	 * @param request
	 * @return
	 */
	ResponseResultVo fileDownload(HttpServletRequest request);
}
