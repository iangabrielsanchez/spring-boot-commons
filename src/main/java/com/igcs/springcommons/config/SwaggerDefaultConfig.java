package com.igcs.springcommons.config;

import com.google.common.base.Predicate;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public abstract class SwaggerDefaultConfig {

    protected Docket getDefaultDocket( String basePackage, Predicate<String> pathSelector ) {
        return new Docket( DocumentationType.SWAGGER_2 )
                .select()
                .apis( RequestHandlerSelectors.basePackage( basePackage ) )
                .paths( pathSelector )
                .build();
    }
}
