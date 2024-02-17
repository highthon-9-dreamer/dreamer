package com.highthon.dreamer.global.configs

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


@Configuration
class WebMvcConfig : WebMvcConfigurer {

    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost")
            .allowCredentials(true)
            .exposedHeaders("Auth-Token")
            .allowedMethods(*ALLOWED_METHOD_NAMES.split(",".toRegex()).dropLastWhile { it.isEmpty() }
                .toTypedArray())
    }

    companion object {
        const val ALLOWED_METHOD_NAMES = "GET,HEAD,POST,PUT,DELETE,TRACE,OPTIONS,PATCH"
    }
}