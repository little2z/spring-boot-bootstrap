package com.xyl.autoconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

@Configuration
public class HelloAutoConfiguration {

    @Autowired
    private Environment env;

    @Bean
//    @ConditionalOnProperty(name = "hello")
    @Conditional(MyPropertyCondition.class)
    public String sayHello(){
        String result = "Hello " + env.getProperty("hello");
        System.out.println(result);
        return result;
    }

    static class MyPropertyCondition extends SpringBootCondition {

        @Override
        public ConditionOutcome getMatchOutcome(ConditionContext context, AnnotatedTypeMetadata metadata) {

            String value = context.getEnvironment().getProperty("hello");
            if (value != null) {
                return new ConditionOutcome(true, "hello " + value);
            }
            return new ConditionOutcome(false, "hello null1");
        }

    }

}
