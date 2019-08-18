package com.xyl.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;

@Data
@Configuration
@PropertySource("classpath:mail.properties")
@ConfigurationProperties(prefix = "mail")
public class MailConfigProperties {

    @Data
    public static class Credentials {
        private String authMethod;
        private String username;
        private String password;

    }

    @NotBlank
    private String host;
    private int port;
    private String from;
    private Credentials credentials;
    private List<String> defaultRecipients;
    private Map<String, String> additionalHeaders;

}
