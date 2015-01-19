package uas;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityView;
import org.springframework.web.servlet.view.velocity.VelocityViewResolver;

/**
 * Spring Config
 * 
 * @author percy
 *
 */
@Configuration
//@EnableWebMvc
// @ComponentScan(basePackages = "uas", useDefaultFilters = false,
// includeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, value
// = { Controller.class }) })
//@EnableJpaRepositories("uas.repo")
//@EnableTransactionManagement
//@ComponentScan(basePackages = "uas")
// @EnableJpaAuditing
// @ComponentScan(basePackages = "uas", useDefaultFilters = false,
// excludeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, value
// = { Controller.class }) })
public class MvcConfiguration extends WebMvcConfigurationSupport {
	
	 @Autowired
	 private Environment env;

	@Bean
	public ViewResolver viewResolver() {
		System.out.println("---------------------env" + env.getProperty("jdbc.driverClass"));
//		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//		viewResolver.setPrefix("/WEB-INF/jsp/");
//		viewResolver.setSuffix(".jsp");
		
		VelocityViewResolver viewResolver = new VelocityViewResolver();
		viewResolver.setViewClass(VelocityView.class);
		viewResolver.setCache(true);
		viewResolver.setPrefix("/");
		viewResolver.setSuffix(".html");
		viewResolver.setContentType("text/html;charset=UTF-8");
		viewResolver.setDateToolAttribute("dataTool");
		viewResolver.setNumberToolAttribute("numberTool");
		viewResolver.setExposeRequestAttributes(true);
		viewResolver.setExposeSessionAttributes(true);
		
		return viewResolver;
	}
	
	@Bean
	public VelocityConfigurer velocityConfigure(){
		VelocityConfigurer configure = new VelocityConfigurer();
		configure.setResourceLoaderPath("/WEB-INF/velocity/");
		Properties prop = new Properties();
		prop.put("input.encoding", "UTF-8");
		prop.put("output.encoding", "UTF-8");
		configure.setVelocityProperties(prop);
		return configure;
	}

	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations(
				"/WEB-INF/static/");
	}

}
