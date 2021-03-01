package it.gr.demo.config;

/**
 * Visit Swagger UI: http://localhost:8080/swagger-ui.html
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	public static final String NOTECONTROLLER = "noteController";

	@Bean
	public Docket api() {

		Docket apiInfo = new Docket(DocumentationType.SWAGGER_2).groupName("noteController-api-server").select()
				.apis(RequestHandlerSelectors.basePackage("it.gr.demo.controllers")).build().apiInfo(new ApiInfoBuilder()
						.title("Notes Api Service").description("Notes Api Service").version("1.0").build());

		apiInfo.tags(

				new Tag(NOTECONTROLLER, "Notes APIs"));

		return apiInfo;
	}
}