package com.test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.context.EnvironmentAware;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:/bootstrap.yml")
@Component
public class Config implements EnvironmentAware{	
	@Autowired
	private Environment env;
	
	private ConfigDTO configDTO;
	
	@Override
	public void setEnvironment(Environment env) {
		this.env = env;	
		configDTO = new ConfigDTO();
		configDTO.setGreeting(env.getProperty("greeting"));
		configDTO.setMessage(env.getProperty("message"));
	}
	
	public ConfigDTO getConfigDTO(){
		return configDTO;
	}
}