package com.aloe.config;

import com.aloe.interceptor.ErrorHandlerInterceptor;
import com.aloe.interceptor.SpringBootInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.resource.WebJarsResourceResolver;

/**
 * 注册拦截器
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
//        registry.addInterceptor(new SpringBootInterceptor()).addPathPatterns("/**");
//        registry.addInterceptor(new ErrorHandlerInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    /**
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //配置静态资源映射路径
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }
}
