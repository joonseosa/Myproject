package kr.co.sol.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	
	//application.properties에 설정한 변수 값 받아오기 
	@Value("${resources.location}")
	private String resourcesLocation;
		
	@Value("${resources.uri_path}")
	private String resourcesUriPath;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//외부 경로는 서버가 아닌경로(shop)일때는 반드시 file://이 필요 
		registry.addResourceHandler(resourcesUriPath+"/**")
				.addResourceLocations("file:///"+resourcesLocation);
	}
		
	
	
}
