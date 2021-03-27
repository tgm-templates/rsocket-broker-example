package com.alibaba.spring.boot.rsocket.demo;

import com.alibaba.rsocket.invocation.RSocketRemoteServiceBuilder;
import com.alibaba.rsocket.upstream.UpstreamManager;
import com.alibaba.user.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConsumeConfiguration {
    @Bean
    public UserService userService(UpstreamManager upstreamManager) {
        return RSocketRemoteServiceBuilder
                .client(UserService.class)
                //.sticky(true)
                .upstreamManager(upstreamManager)
                //.endpoint("ip:192.168.1.2") //for testing
                .build();
    }
}
