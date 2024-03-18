package com.sajid;


import com.sajid.config.DispatcherServletConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class DispatcherServlet extends AbstractAnnotationConfigDispatcherServletInitializer {

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
        return new String[] {
                "/products",
                "/products/new-product",
                "/products/update-product",

                "/orders",
                "/orders/new-order"

        };
    }
}


