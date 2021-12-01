package com.webcrudsecurityboot.webcrudsecurityboot;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/admin").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("admin/add").setViewName("new");
        //registry.addViewController("/login").setViewName("login");
        registry.addViewController("admin/{id}").setViewName("show");
        registry.addViewController("admin/{id}/edit").setViewName("edit");
    }

}