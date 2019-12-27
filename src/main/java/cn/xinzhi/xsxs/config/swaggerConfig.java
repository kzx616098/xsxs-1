package cn.xinzhi.xsxs.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class swaggerConfig {

    @Bean
    public Docket docket(){


        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo());
//                .groupName("用户")
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.xinzhi.swagger2.controller"))
//                .build();
    }


    private ApiInfo apiInfo(){
        Contact contact = new Contact("kzx","http:localhost:8080/swagger-ui.html","kzx616098@163.com");
        return new ApiInfoBuilder()
                .title("使用swagger创建api接口")
                .description("描述信息")
                .termsOfServiceUrl("http:localhost:8080/xinzhi")
                .contact(contact)
                .license("")
                .licenseUrl("")
                .extensions(new ArrayList<>())
                .version("v1.0")
                .build();
    }
}
