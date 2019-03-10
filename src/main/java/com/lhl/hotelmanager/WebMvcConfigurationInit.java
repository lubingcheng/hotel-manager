package com.lhl.hotelmanager;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.lhl.hotelmanager.tools.ProcessInterceptor;
import com.lhl.hotelmanager.tools.SessionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * @program: hotel-manager
 * @Date: 2018/11/12 0012 下午 1:43
 * @Author: <.*)#)))<
 * @Description:
 */
@Configuration
public class WebMvcConfigurationInit extends WebMvcConfigurationSupport {

    @Autowired
    SessionInterceptor sessionInterceptor;

    @Autowired
    ProcessInterceptor processInterceptor;

    /**
     * 配置 并加载 FastJson
     *
     * @param converters
     */
    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(
//                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteNullStringAsEmpty
        );
        fastConverter.setFastJsonConfig(fastJsonConfig);
        converters.add(fastConverter);

    }

    /**
     * 配置允许跨域 不支持ajxa 跨域访问资源
     *
     * @param registry
     */
   /* @Override
    protected void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedOrigins("*")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "PATCH", "DELETE", "OPTIONS", "TRACE")
                .allowCredentials(true);
    }*/

    /**
     * 加载拦截器
     *
     * @param registry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(processInterceptor).addPathPatterns("/**");
        registry.addInterceptor(sessionInterceptor).addPathPatterns("/**");
    }
}
