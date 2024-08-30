package com.assessment.saheed;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@SpringBootApplication
public class SaheedApplication {


		@Value("${server.port}")
		private String startingPort;
		@Bean
		public GroupedOpenApi swiftEntryProcessorOpenApi() {
			String[] packagesToScan = {"com.assessment.saheed.controllers"};
			return GroupedOpenApi.builder()
					.group("saheed-assessment")
					.packagesToScan(packagesToScan)
					.build();
		}

		@Bean
		public OpenAPI springShopOpenAPI() {
			Server devServer = new Server();
			devServer.url("http://localhost:" + startingPort);
			devServer.setDescription("Server URL in dev environment");
			Server stagingServer = new Server();
			return new OpenAPI()
					.components(new Components())
					.info(new Info().title("Saheed Java Test Assessment API")
							.description("Saheed Java Test Assessment API")
							.version("v0.0.1")
							.license(new License().name("Apache 2.0")
									.url("https://www.apache.org/licenses/LICENSE-2.0"))
							.contact(new Contact()
									.name("Tiamiyu Saheed Oluwatosin")
									.url("")
									.email("osaheed@unionbankng.com")
							)
					)
					.externalDocs(new ExternalDocumentation()
							.description("SpringShop Wiki Documentation")
							.url("https://springshop.wiki.github.org/docs"))
					.servers(List.of(devServer,stagingServer));
		}
	public static void main(String[] args) {
		SpringApplication.run(SaheedApplication.class, args);
	}

}
