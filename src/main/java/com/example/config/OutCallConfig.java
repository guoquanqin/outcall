package com.example.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: 青牛云智能外呼url
 * @Author: QQ
 * @Date: 2020/6/4
 */
@Configuration
@ConfigurationProperties(prefix = "outcall")
@Data
public class OutCallConfig {

    private String host;
}
