package com.config;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.EnumSet;

@Component
public class MyDispatcherServlet extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{MyApplicationConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MyWebMvc.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("utf-8");
        characterEncodingFilter.setForceEncoding(true);
        characterEncodingFilter.setForceResponseEncoding(true);
        characterEncodingFilter.setForceResponseEncoding(true);
        servletContext.addFilter("characterEncodingFilter",characterEncodingFilter).addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
        super.onStartup(servletContext);
    }
}
