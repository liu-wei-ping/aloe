package com.aloe.controller.file;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.aloe.controller.BaseController;
import com.aloe.pojo.vo.ResponseResultVo;
import com.aloe.service.file.IFileService;

/**
 * @author liu_wp
 * @date 2017年11月1日
 * @see
 */
@Controller
@RequestMapping("/file")
public class FileController extends BaseController {
	@Autowired
	private IFileService iFileService;

	/**
	 * @param file
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@ResponseBody
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public Map<String, Object> fileDownload(@RequestParam("file") MultipartFile file, HttpServletRequest request)
			throws UnsupportedEncodingException {
		logger.debug("获取上传文件...");
		request.setCharacterEncoding("UTF-8");
		Map<String, Object> json = new HashMap<String, Object>();
		ResponseResultVo vo = iFileService.fileDownload(request);
		json.put("message", vo.getMessage());
		return json;

	}

	/**
	 * @param request
	 * @param response
	 * @return
	 */
	public String fileUpload(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}

	private void validateImage(MultipartFile image) {
	}
}
