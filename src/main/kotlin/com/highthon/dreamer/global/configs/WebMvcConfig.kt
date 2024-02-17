package com.highthon.dreamer.global.configs

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


@Configuration
class WebMvcConfig : WebMvcConfigurer {

    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
            .allowedOrigins("*")
//            .allowCredentials(false)
            .allowedHeaders("*")
            .exposedHeaders("*")
            .allowedMethods("*")
    }
}