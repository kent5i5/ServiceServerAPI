package com.yinkin.AWSConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.amazonaws.services.sns.AmazonSNSClient;

@Configuration
public class AmazonSNSConfig{
    // @Primary
    // @Bean
    // public Class<AmazonSNSClient> amazonSNSConfig(){
    //     return AmazonSNSClient.class;
    // }

}