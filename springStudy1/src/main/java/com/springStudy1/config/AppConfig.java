package com.springStudy1.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class AppConfig {
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUsername("ssw");
		ds.setPassword("1234");
		ds.setUrl("jdbc:mysql://localhost:3306/ssw");
		return ds;
	}

	@Bean
	public JdbcTemplate jdbc(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
}
