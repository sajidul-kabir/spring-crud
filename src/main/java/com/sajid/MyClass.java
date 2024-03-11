package com.sajid;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyClass extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { DispatcherServletConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/products/*","/orders/*" };
    }
}


