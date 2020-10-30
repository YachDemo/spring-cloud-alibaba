package com.example.ribbon.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 可以看出使用Ribbon的负载均衡功能非常简单，
 * 和直接使用RestTemplate没什么两样，只需给RestTemplate添加一个@LoadBalanced即可。
 *
 * @author YanCh
 * @version v1.0
 * Create by 2020-10-30 15:47
 **/
@Configuration
public class RibbonConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
