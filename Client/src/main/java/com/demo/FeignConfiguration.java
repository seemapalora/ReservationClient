package com.demo;

import org.springframework.context.annotation.Bean;

import feign.Logger;

public class FeignConfiguration {
	@Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
