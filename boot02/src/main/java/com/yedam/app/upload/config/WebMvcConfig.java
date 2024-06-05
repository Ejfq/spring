package com.yedam.app.upload.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //설정일 경우
public class WebMvcConfig implements WebMvcConfigurer{

	
	@Value("${file.upload.path}") // properties나 환경변수를 통해 들어오는 값 읽음
	private String uploadPath;
	
	//리소스 핸들링
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
				  //어떤 url로 				      실제 경로 맵핑
		registry.addResourceHandler("/images/**").addResourceLocations("file:///" +uploadPath ,"");
	}
	

	
}
