package com.aloe.service.file.impl;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.aloe.pojo.vo.ResponseResultVo;
import com.aloe.service.BaseService;
import com.aloe.service.file.IFileService;

/**
 * @author liu_wp
 * @date 2017年11月1日
 * @see
 */
@Service
public class FileServiceImpl extends BaseService implements IFileService {

	@Override
	public ResponseResultVo fileDownload(HttpServletRequest request) {
		try {
			// 转换为文件类型的request
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			// 获取对应file对象
			Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
			Iterator<String> fileIterator = multipartRequest.getFileNames();

			String requestURL = request.getRequestURL().toString();

			while (fileIterator.hasNext()) {
				String fileKey = fileIterator.next();
				logger.debug("文件名为：" + fileKey);

				// 获取对应文件
				MultipartFile multipartFile = fileMap.get(fileKey);

				if (multipartFile.getSize() != 0L) {

					validateImage(multipartFile);

					// TODO 保存文件

					return ResponseResultVo.generateSuccessObject(null);
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return ResponseResultVo.generateSuccessObject(null);
	}

	private void validateImage(MultipartFile image) {
	}
}
