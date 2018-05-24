package com.example;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DatabaseConfiguration {
	
	@Bean(name="mysql")
	@ConfigurationProperties(prefix="mysql.datasource")
	@Primary
	public DataSource createProfileDataSource() {
		/*return DataSourceBuilder.create().build();*/
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    dataSource.setUrl("jdbc:mysql://localhost:3306/profileservice?useSSL=false");
	    dataSource.setUsername("root");
	    dataSource.setPassword("$Dec2017");
	    return dataSource;
	}
	
	@Bean(name="oracle")
	@ConfigurationProperties(prefix="oracle.datasource")
	public DataSource createTaskDataSource() {
		/*return DataSourceBuilder.create().build();*/
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    dataSource.setUrl("jdbc:mysql://localhost:3306/taskservice?useSSL=false");
	    dataSource.setUsername("root");
	    dataSource.setPassword("$Dec2017");
	    return dataSource;
	}
	
	@Bean(name="jdbcProfileService")
	@Autowired
	public JdbcTemplate createJdbcTemplate_ProfileService(@Qualifier("mysql") DataSource profileServiceDS) {
		return new JdbcTemplate(profileServiceDS);
	}
	
	@Bean(name="jdbcTaskService")
	@Autowired
	public JdbcTemplate createJdbcTemplate_TaskService(@Qualifier("oracle") DataSource taskServiceDS) {
		return new JdbcTemplate(taskServiceDS);
	}

}
