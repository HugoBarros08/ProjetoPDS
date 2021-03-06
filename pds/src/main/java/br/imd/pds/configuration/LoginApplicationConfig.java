package br.imd.pds.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan({"br.imd.pds.controllers"})
@Import(value = {LoginSecurityConfig.class})
public class LoginApplicationConfig {

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//		viewResolver.setViewClass(viewClass);
		viewResolver.setPrefix("/templates/");
		viewResolver.setSuffix(".html");
		return viewResolver;
	}
}
