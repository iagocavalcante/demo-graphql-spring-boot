package com.example.graphql.demographql;
import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@Configuration
@EnableSwagger2
public class SwaggerConfig {
  @Bean
  public Docket custoTransporteCargaApi() {
      return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.example.graphql"))
        .paths(regex("/.*"))
        .build()
        .apiInfo(metaData());
  }
  
  private ApiInfo metaData() {
    ApiInfo apiInfo = new ApiInfo(
          "API REST para teste com graphql",
          "",
          "0.0.1",
          "Teste Softplan",
          new Contact("Iago Cavalcante", "", "iagoangelimc@gmail.com"),
          "Free",
          "",
          new ArrayList<VendorExtension>());
            
    return apiInfo;
  }    
}
