package com.aloe.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.SmartLifecycle;
/**
 * @author liu wp
 * @data  2017年8月11日
 */
public class InitServerConfig implements SmartLifecycle {
	private final Logger logger = LoggerFactory.getLogger(InitServerConfig.class);
	@Override
	public int getPhase() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isAutoStartup() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isRunning() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void start() {
		logger.info("---服务器启动----");

	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

	@Override
	public void stop(final Runnable callback) {
		logger.info("---服务器停止----");
	}

}
