package com.livejournal.xtecuan.samples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class SpringBootWebLogicApplication {

	/*@Value("${db.driver}")
	private String driver;
	@Value("${db.username}")
	private String username;
	@Value("${db.password}")
	private String password;
	@Value("${db.url}")
	private String url;

	@Bean
	DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(this.driver);
		dataSource.setUsername(this.username);
		dataSource.setPassword(this.password);
		dataSource.setUrl(this.url);
		return dataSource;
	}*/

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebLogicApplication.class, args);
	}

}
