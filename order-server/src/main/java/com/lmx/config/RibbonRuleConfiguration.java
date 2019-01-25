package com.lmx.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RibbonRuleConfiguration {

    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }

}