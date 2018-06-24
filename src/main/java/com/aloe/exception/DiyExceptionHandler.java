package com.aloe.exception;

import com.aloe.constants.UrlConstantsConfig;
import com.aloe.pojo.vo.ExceptionVo;
import com.aloe.utils.HttpRequestUtil;
import com.aloe.utils.JSONParserUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class DiyExceptionHandler {
    /**
     * @param request
     * @param response
     * @param ex
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        ex.printStackTrace();
        String requestUrl = request.getRequestURI();
        String status = String.valueOf(response.getStatus());
        if (ex instanceof NoHandlerFoundException) {
            status = String.valueOf(HttpServletResponse.SC_NOT_FOUND);
        }
        ExceptionVo exceptionVo = new ExceptionVo(requestUrl, ex.getMessage(), status);
        if (HttpRequestUtil.isAjax(request)) {
            return JSONParserUtil.toJSONString(exceptionVo);
        } else {
            ModelAndView model = new ModelAndView();
            model.addObject("url", requestUrl);
            model.addObject("error", ex.getMessage());
            model.setViewName(UrlConstantsConfig.DEFAULT_ERROR_PAGE);
            return model;
        }
    }

}
