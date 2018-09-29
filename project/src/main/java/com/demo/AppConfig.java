package com.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.druid.pool.DruidDataSource;
import com.demo.interceptor.LoginInterceptor;

@Configuration
public class AppConfig extends WebMvcConfigurerAdapter{
	
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
	
	// 权限拦截
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor());//把拦截权限加到拦截器内
		
	}

}
