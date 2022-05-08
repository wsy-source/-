package com.config;

import com.converter.DateConverter;
import com.converter.OderStateConverter;
import com.interceptor.PermissionInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;

import java.util.Arrays;
import java.util.List;

@EnableWebMvc
@ComponentScan(basePackages = "com.controller")
public class MyWebMvc implements WebMvcConfigurer {

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/jsp/", ".jsp");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
      registry.addInterceptor(new PermissionInterceptor()).addPathPatterns("/user/*").
              excludePathPatterns(Arrays.asList("/css/*","/js/*","/user/login","/user/register","/user/doCheckTel",
                      "/user/doCheckUsername","/user/doRegister","/user/doLogin","/user/autoLogin"));
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new DateConverter());
        registry.addConverter(new OderStateConverter());
        WebMvcConfigurer.super.addFormatters(registry);
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new MappingJackson2HttpMessageConverter());
        WebMvcConfigurer.super.configureMessageConverters(converters);
    }
}
