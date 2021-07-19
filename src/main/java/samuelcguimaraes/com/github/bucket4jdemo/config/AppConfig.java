package samuelcguimaraes.com.github.bucket4jdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import samuelcguimaraes.com.github.bucket4jdemo.filter.RateLimitInterceptor;

@Configuration
public class AppConfig implements WebMvcConfigurer {
	
	private RateLimitInterceptor interceptor;
	
	public AppConfig(RateLimitInterceptor interceptor) {
		this.interceptor = interceptor;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor)
		        .addPathPatterns("/api/v1/area/**");
	}

}
