package com.neo.ribbonconfiguration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhaoWenCai
 * @date 2020/5/24 10:09
 * @since 1.0.0
 */
@Configuration
public class RibbonConfiguration {
    @Bean
    public IRule rule() {
        return new RandomRule();
    }
}
