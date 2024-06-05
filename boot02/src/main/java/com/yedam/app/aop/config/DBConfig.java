package com.yedam.app.aop.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DBConfig {
	/*
	 * 프레임워크는 TransactionManager 필요 <> 부트는 필요없음
	 * @Bean TransactionManager transactionManager(DataSource dataSource) { return
	 * new DataSourceTransactionManager(dataSource); }
	 */
}	
