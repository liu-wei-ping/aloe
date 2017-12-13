package com.aloe.pojo.vo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.aloe.constants.SysConstantsConfig;

/**
 * 统一返回对象
 *
 * @author liu wp
 * @date 2017年9月26日
 */
public class ResponseResultVo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 错误返回
	 *
	 * @param msg
	 * @param obj
	 * @return
	 */
	public static ResponseResultVo generateFailedObject(String msg, Object obj) {
		ResponseResultVo returnObject = new ResponseResultVo();
		returnObject.setCode(SysConstantsConfig.DEFAULT_RETURN_FAIL_CODE);
		returnObject.setMessage(msg);
		returnObject.setObj(obj);
		return returnObject;
	}

	/**
	 * 成功返回
	 *
	 * @param obj
	 * @return
	 */
	public static ResponseResultVo generateSuccessObject(Object obj) {
		ResponseResultVo returnObject = new ResponseResultVo();
		returnObject.setCode(SysConstantsConfig.DEFAULT_RETURN_SUCCESS_CODE);
		returnObject.setMessage(SysConstantsConfig.DEFAULT_RETURN_SUCCESS_MESSAGE);
		returnObject.setObj(obj);
		return returnObject;
	}

	/**
	 * @param code
	 * @param message
	 * @return
	 */
	public static ResponseResultVo getReturnMsg(String code, String message) {
		ResponseResultVo returnObject = new ResponseResultVo();
		returnObject.setCode(code);
		returnObject.setMessage(message);
		return returnObject;
	}

	public static ResponseResultVo respSuccess() {
		ResponseResultVo returnObject = new ResponseResultVo();
		returnObject.setCode(SysConstantsConfig.DEFAULT_RETURN_SUCCESS_CODE);
		returnObject.setMessage(SysConstantsConfig.DEFAULT_RETURN_SUCCESS_MESSAGE);
		return returnObject;
	}

	public static Map<String, String> returnPgeResultMap(ResponseResultVo responseResultVo) {
		Map<String, String> resutMap = new HashMap<>();
		resutMap.put("code", responseResultVo.getCode());
		resutMap.put("message", responseResultVo.getMessage());
		// resutMap.put("obj",
		// null != responseResultVo.getObj() ?
		// JSONParserUtil.toJSONString(responseResultVo.getObj()) : null);
		return resutMap;
	}

	// 返回状态
	private String code;

	// 返回提示信息
	private String message;

	// 返回结果对象
	private Object obj;

	public ResponseResultVo() {
		this.code = SysConstantsConfig.DEFAULT_RETURN_FAIL_CODE;
		this.message = SysConstantsConfig.DEFAULT_RETURN_FAIL_MESSAGE;
	}

	public ResponseResultVo(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public Object getObj() {
		return obj;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

}
