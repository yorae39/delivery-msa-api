package com.example.delivery.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.filter.CorsFilter;

/*
 	Esse Filter será invocado no inicio de uma requisição ao Servidor de autorização, 
 	ele permite que uma requisição chegue ao Servidor independente das crendenciais, 
 	origin, header e method.
 */

@Configuration
public class CorsFilterConfiguration {

	
	 private List<String> allowedOrigins = Arrays.asList(CorsConfiguration.ALL);

	    public List<String> getAllowedOrigins() {
	        return allowedOrigins;
	    }

	    public void setAllowedOrigins(List<String> allowedOrigins) {
		this.allowedOrigins = allowedOrigins;
	    }
	/*
	 * @Bean public FilterRegistrationBean corsFilter() {
	 * /*UrlBasedCorsConfigurationSource source = new
	 * UrlBasedCorsConfigurationSource(); CorsConfiguration config = new
	 * CorsConfiguration(); config.setAllowCredentials(true);
	 * config.addAllowedOrigin("*"); config.addAllowedHeader("*");
	 * config.addAllowedMethod("*"); source.registerCorsConfiguration("/**",
	 * config); FilterRegistrationBean bean = new FilterRegistrationBean(new
	 * CorsFilter(source)); bean.setOrder(Ordered.HIGHEST_PRECEDENCE); return bean;
	 * 
	 * 
	 * }
	 */

	@Bean
	public CorsFilter corsFilter() {
	    return new CorsFilter(request -> {
	        String pathInfo = request.getPathInfo();
	        if (pathInfo != null &&
	            (pathInfo.endsWith("/swagger.json") ||
	             pathInfo.endsWith("/swagger.yaml"))) {
	            return new CorsConfiguration().applyPermitDefaultValues();
	        }

	        CorsConfiguration config = new CorsConfiguration();
	        config.setAllowedOrigins(allowedOrigins);
	        config.setAllowedMethods(Arrays.asList("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH"));
	        config.applyPermitDefaultValues();
	        return config;
	    });
	}
}
