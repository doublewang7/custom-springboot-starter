package me.garry.trial;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(Greeter.class)
@EnableConfigurationProperties(GreeterProperties.class)
public class GreeterAutoConfigure {
    @Bean
    @ConditionalOnMissingBean
    public Greeter greeter(GreeterProperties properties) {
        String name = properties.getName();
        return new Greeter(name);
    }
}
