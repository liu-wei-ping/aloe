package com.aloe.aop;

import java.util.Arrays;
import java.util.List;

import com.alibaba.druid.util.DruidWebUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.aloe.utils.ExceptionUtil;
import com.aloe.utils.HttpRequestUtil;

/**
 * AOP Controller RestController
 *
 * @author liu wp
 *
 */
@Aspect
@Component
public class AutoControllerAspect {
	/** 日志类 */
	private final Logger logger = LoggerFactory.getLogger(super.getClass());

	/**
	 * AfterReturning 核心业务逻辑调用正常退出后，不管是否有返回值，正常退出后，均执行
	 *
	 * @param joinPoint
	 * @param returnObj
	 *            返回值
	 */
	@AfterReturning(pointcut = "allControllerMethod()||allRestControllerMethod()", returning = "returnObj")
	public void afterReturning(final JoinPoint joinPoint, final Object returnObj) {
		logger.info("返回值：{}", returnObj);

	}

	/**
	 * AfterThrowing 核心业务逻辑调用异常退出后执行，处理错误信息
	 *
	 * @param joinPoint
	 * @param ex
	 *            异常信息
	 */
	@AfterThrowing(value = "allControllerMethod()||allRestControllerMethod()", throwing = "ex")
	public void afterThrowing(final JoinPoint joinPoint, final Exception ex) {
		logger.info("错误信息：{}", ExceptionUtil.getStackTrace(ex));
	}

	/**
	 * 监控所有@Controller的方法
	 */
	@Pointcut("within(@org.springframework.stereotype.Controller *)")
	public void allControllerMethod() {
	}

	@Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
	public void allRestControllerMethod() {
	}

	/**
	 * Around 手动控制调用核心业务逻辑，以及调用前和调用后的处理,
	 *
	 * 注意：当核心业务抛异常后，立即退出，转向afterReturning 执行完afterReturning，再转到AfterThrowing
	 *
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 */
	/*
	 * @Around("allControllerMethod()||allRestControllerMethod()") public Object
	 * Around(final ProceedingJoinPoint joinPoint) throws Throwable { final
	 * Object obj = joinPoint.proceed(); return obj; }
	 */

	/**
	 * 在核心业务执行前执行。
	 *
	 * @param joinPoint
	 * @throws InterruptedException
	 */
	@Before("allControllerMethod()||allRestControllerMethod()")
	public void beforeMethod(final JoinPoint joinPoint) throws InterruptedException {
		String requestUrl = HttpRequestUtil.getRequestUrl();
		String requestIp = HttpRequestUtil.getIp();
		final int jpsHashCode = joinPoint.getSignature().hashCode();
		List<Object> agrs = Arrays.asList(joinPoint.getArgs());
		logger.info("访问序号【{}】，请求IP【{}】，请求路径【{}】", jpsHashCode, requestIp, requestUrl);
		// logger.info("访问请求参数对象 【{}】", JSONParserUtil.toJSONString(agrs));
	}

}
