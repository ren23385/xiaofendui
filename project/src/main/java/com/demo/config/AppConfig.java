package com.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class AppConfig {
	
	@Autowired
	private Environment env;
	
	@Bean(name="dataSource")
	public DataSource getDataSource() {
		
		DruidDataSource dds = new DruidDataSource();
		dds.setUrl(env.getProperty("spring.datasource.url").trim());
		dds.setUsername(env.getProperty("spring.datasource.username").trim());
		dds.setPassword(env.getProperty("spring.datasource.password").trim());
		dds.setDriverClassName(env.getProperty("spring.datasource.driver-class-name").trim());
		return dds;	
	}
	
	

}
