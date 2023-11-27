package net.ysh.nemoo.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.ysh.util.LLog;

@Configuration
@EnableWebMvc
public class XenditWebConfigurer implements WebMvcConfigurer {

	public XenditWebConfigurer() {
		LLog.info(this.getClass().getName() + " is activated.");
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		LLog.info("Allow all origins and methods");

		registry //
				.addMapping("/**") //
				.allowedOrigins("*") //
				.allowedHeaders("*") //
				.allowedMethods("*");
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		LLog.info("Configure Jackson to ignore null value");

		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);

		converters.add(new MappingJackson2HttpMessageConverter(mapper));
	}
}
