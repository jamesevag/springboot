package de.springboot.rest.services.restfulwebservices;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


    private static final Set<String> DEFAULT_PRODUCES=new HashSet<String>(Arrays.asList("application/json","application/xml"));
    //localhost:8080/v2/api-docs
    //localhost:8080/swagger-ui.html
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(ApiInfo.DEFAULT)
                .produces(DEFAULT_PRODUCES);
    }
}
