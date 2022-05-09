package com.web.FinalProject.config.db;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;

import com.web.FinalProject.config.Encrypt;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DatabaseConfig {
	@Value("${db.datasource.dbcp2.driver-class-name}")
	private String driverClassName;
	
	@Value("${db.datasource.url}")
	private String urlDB;
	
	@Value("${db.datasource.username}")
	private String userName;
	
	@Value("${db.datasource.password}")
	private String password;
	
	private String secretkey = "@1aanhasA1!%&n";
	@Bean(name= "dataSource")
	public DataSource dataSource() {
		HikariConfig hikariConfig =  new HikariConfig();
		hikariConfig.setJdbcUrl(Encrypt.decrypt(urlDB, secretkey));
		hikariConfig.setDriverClassName(driverClassName);
		hikariConfig.setUsername(Encrypt.decrypt(userName, secretkey));
		hikariConfig.setPassword(Encrypt.decrypt(password, secretkey));
		HikariDataSource hikariSource =  new HikariDataSource(hikariConfig);
		
		return hikariSource;
	}

	@Bean(name="transactionManager")
	public DataSourceTransactionManager dataSourceTransactionManager() {
		
		return new DataSourceTransactionManager(dataSource());
	}
	@Bean(name="sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory (@Qualifier("dataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean =  new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		
		sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
				.getResources("classpath:/com/web/FinalProject/mapper/sql/*.xml"));
		
		return sqlSessionFactoryBean.getObject();
		
		
	}
	
	
}
