package com.aloe.aop;

import com.aloe.constants.UrlContstantsConfig;
import com.aloe.pojo.vo.ExceptionVo;
import com.aloe.utils.ExceptionUtil;
import com.aloe.utils.HttpRequestUtil;
import com.aloe.utils.JSONParserUtil;
import groovy.util.logging.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class DiyExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        ex.printStackTrace();
        String requestUrl = request.getRequestURI();
        String status = String.valueOf(response.getStatus());
        ExceptionVo exceptionVo = new ExceptionVo(requestUrl, ex.getMessage(), status);
        if (HttpRequestUtil.isAjax(request)) {
            return JSONParserUtil.toJSONString(exceptionVo);
        } else {
            ModelAndView model = new ModelAndView();
            model.addObject("url", requestUrl);
            model.addObject("error", ex.getMessage());
            model.setViewName(UrlContstantsConfig.DEFAULT_ERROR_PAGE);
            return model;
        }
    }

}
