package com.wang.demo.component.swagger;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.*;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

import static springfox.documentation.builders.PathSelectors.ant;
import static springfox.documentation.builders.PathSelectors.regex;


/**
 * Swagger文档配置
 * @author wangjianhua
 * @date 2021-03-18 17:01
 */
@Configuration
@EnableOpenApi
public class SwaggerConfiguration {

    @Bean
    public Docket createRestApi(){
        //jwt配置 3.0  升级为 securitySchemes() 和securityContexts()的配置形式
        //DocumentationType 设置为OAS_30 security需要放开权限为v3而不是以前版本的v2
        Docket docket = new Docket(DocumentationType.OAS_30);
        docket.apiInfo(apiInfo());
        ApiSelectorBuilder selectorBuilder =  docket.select();
        selectorBuilder.
                apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any());
        docket = selectorBuilder.build();
        List<SecurityScheme> apiKeys = Collections.singletonList(HttpAuthenticationScheme.JWT_BEARER_BUILDER
                .name("JWT").build());
        docket.securitySchemes(apiKeys);
        //用户jwt认证成功后 在swagger中全局有效
        AuthorizationScope authorizationScope = new AuthorizationScope("global","accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[]{authorizationScope};
        //令牌与作用域存储
        SecurityReference reference = new SecurityReference("JWT",authorizationScopes);
        List<SecurityReference> securityReferenceList = new ArrayList<>();
        securityReferenceList.add(reference);
        SecurityContext securityContext = SecurityContext.builder().securityReferences(securityReferenceList).build();
        docket.securityContexts(Collections.singletonList(securityContext));
        return docket;
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("SpringSecurity demo 学习项目api")
                .contact(new Contact("wang","","wangjianhuabox@163.com"))
                .version("0.0.1")
                .description("本文档为后台接口api说明")
                .build();
    }

}
