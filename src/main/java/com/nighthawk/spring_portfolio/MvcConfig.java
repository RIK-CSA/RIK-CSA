package com.nighthawk.spring_portfolio;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    // This method sets up a custom index page for the "/login" path
    // Defines how the login page is accessed within app
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }

    // Configures the location for uploaded files outside the app's resources
    // CRUCIAL for file upload functionality -> make sure files stored and can be
    // accessed properly by frontend
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/volumes/uploads/**").addResourceLocations("file:volumes/uploads/");
    }

    // Sets up CORS settings --> allows requests from specified origins
    // This case is GitHub Pages site & local dev site
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("https://nighthawkcoders.github.io", "http://localhost:4000");
    }
}