package com.example.demo;

/**
 * Created by Edwin Xu on 7/31/2020 11:46 AM
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
// extends WebMvcConfigurerAdapter 已经废弃，java 8开始直接继承就可以
@Configuration
public class IntercepterConfig  implements WebMvcConfigurer {
    @Autowired
    private AccessLimtInterceptor accessLimtInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(accessLimtInterceptor)
                .addPathPatterns("/hello");
    }
}