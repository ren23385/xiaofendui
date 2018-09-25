package com.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class AppConfig {
	
	@Autowired
	public Environment env;
	@Bean(name = "dataSource", destroyMethod = "close")
	public DataSource getDataSource() {
		DruidDataSource dataSource = new DruidDataSource();

		dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name").trim());
		dataSource.setUsername(env.getProperty("spring.datasource.username").trim());
		dataSource.setUrl(env.getProperty("spring.datasource.url").trim());
		dataSource.setPassword(env.getProperty("spring.datasource.password").trim());

		return dataSource;
	}
	

}
