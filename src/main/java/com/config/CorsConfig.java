package com.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.AuthorizationScope;
import io.swagger.models.parameters.Parameter;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.google.common.collect.Lists;
import com.google.common.net.HttpHeaders;

@Configuration
@EnableSwagger2
public class CorsConfig {

    public static final String AUTHORIZATION_HEADER = "Authorization";

    @Bean
    public Docket swaggerConfiguration() {
        List<SecurityScheme> schemeList = new ArrayList<>();
        schemeList.add(new ApiKey("Bearer", AUTHORIZATION_HEADER, "header"));
        // Adding Header
        ParameterBuilder aParameterBuilder = new ParameterBuilder();
        aParameterBuilder.name("Authorization") // name of header
                .modelRef(new ModelRef("string"))
                .parameterType("header") // type - header
                .defaultValue("Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJOYXN0VXNlciIsImlzcyI6Ii9OYXN0IiwianRpIjoiYWRtaW5AYWRtaW4uY29tIiwicm9sZXMiOiJOYXN0VXNlciIsInVzZXJOYW1lIjoiUmFtIFByYXNhZCIsImlhdCI6MTU3NTg2NzE3NSwiZXhwIjoxNTc1OTUzNTc1fQ.B-9Szr2GSre8z3pbORvGNaPO09oD7IESGF2XEVbH0t0").required(true) // for compulsory
                .build();
        List<springfox.documentation.service.Parameter> aParameters = new ArrayList<>();
        aParameters.add((springfox.documentation.service.Parameter) aParameterBuilder.build()); // add parameter
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.controller.rest"))
                .paths(PathSelectors.any())
                .build().pathMapping("")
                .securitySchemes(schemeList)
                .apiInfo(apiInfo())
                .globalOperationParameters(aParameters);
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("NastERP API", "API's for NastERP", "1.0", "",
                new springfox.documentation.service.Contact("bkings bjr", "url", "email"), "Api License", "",
                Collections.emptyList());
    }

    @Bean
    public FilterRegistrationBean corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("HEAD");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");
        source.registerCorsConfiguration("/**", config);
        // return new CorsFilter(source);
        final FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(0);
        return bean;
    }

    @SuppressWarnings("deprecation")
    @Bean
    public WebMvcConfigurer mvcConfigurer() {
        return new WebMvcConfigurerAdapter() {
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("GET", "PUT", "POST", "GET", "OPTIONS");
            }
        };
    }

   
}
