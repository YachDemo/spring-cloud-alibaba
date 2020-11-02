package com.example.feign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author YanCh
 * @version v1.0
 * Create by 2020-11-02 17:01
 **/
@Configuration
public class FeignConfig {

    /**
     * 日志打印功能
     * <p>
     * Feign提供了日志打印功能，
     * 我们可以通过配置来调整日志级别，从而了解Feign中Http请求的细节
     * <p>
     * <li>NONE：默认的，不显示任何日志；</li>
     * <li>BASIC：仅记录请求方法、URL、响应状态码及执行时间；
     * <li>HEADERS：除了BASIC中定义的信息之外，还有请求和响应的头信息；
     * <li>FULL：除了HEADERS中定义的信息之外，还有请求和响应的正文及元数据。
     *
     * @return
     */
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
