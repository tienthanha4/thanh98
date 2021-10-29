package com.devpro.shop16.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.devpro.shop16.Constants;

@Configuration // -> day la file cau hinh cho mvc
public class MVCConf implements WebMvcConfigurer , Constants{
//	classpath tuong duong voi folder :src/main/résourcés
	@Override

	public void addResourceHandlers(final ResourceHandlerRegistry registry) {

		registry.addResourceHandler("/css/**").addResourceLocations("classpath:/css/");
		registry.addResourceHandler("/js/**").addResourceLocations("classpath:/js/");
		registry.addResourceHandler("/images/**").addResourceLocations("classpath:/images/");
		registry.addResourceHandler("/bootstrap/**").addResourceLocations("classpath:/bootstrap/");
		//dang ki resourcho attach img
		registry.addResourceHandler("/upload/**").addResourceLocations("file:"+UPLOAD_FOLDER_ROOT);
		
		
	}
	@Bean // -> bao spring biet folder
	public ViewResolver viewResolver() {

		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setViewClass(JstlView.class);// view engine de doc data tu controller tra ve va tron voi code
		bean.setPrefix("/WEB-INF/");
		bean.setSuffix(".jsp");
		return bean;

	}
}
