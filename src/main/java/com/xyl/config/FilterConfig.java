package com.xyl.config;

import com.xyl.filter.RequestResponseLoggingFilter;
import com.xyl.filter.TransactionFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<RequestResponseLoggingFilter> loggingFilter(){

        FilterRegistrationBean<RequestResponseLoggingFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new RequestResponseLoggingFilter());

        registrationBean.addUrlPatterns("/api/*");
        registrationBean.setOrder(2);
        return  registrationBean;

    }

    @Bean
    public FilterRegistrationBean<TransactionFilter> transactionFilter(){

        FilterRegistrationBean<TransactionFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new TransactionFilter());

        registrationBean.addUrlPatterns("/api/books/*");
        registrationBean.setOrder(1);
        return  registrationBean;

    }


}
