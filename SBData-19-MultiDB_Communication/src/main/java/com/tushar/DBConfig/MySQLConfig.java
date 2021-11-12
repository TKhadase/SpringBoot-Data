package com.tushar.DBConfig;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.tushar.repo.MySqlRepo",
													entityManagerFactoryRef = "mysqlEMF",
													transactionManagerRef = "mysqlTXmgr")
public class MySQLConfig {
	
	@Bean
	@ConfigurationProperties(prefix ="mysql.datasource")
	public DataSource createMySqlDS() {
		return  DataSourceBuilder.create().build();
	}
	
	@Bean(name="mysqlEMF")
	public LocalContainerEntityManagerFactoryBean createMySqlLocalContainerEntityManagerFactoryBean(EntityManagerFactoryBuilder  emfBuilder) {
		Map<String, String> mapProperties = new HashMap();
		mapProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		mapProperties.put("hibernate.hbm2ddl.auto", "update");
		mapProperties.put("hibernate.show_sql", "true");
		return emfBuilder.dataSource(createMySqlDS())
				.packages("com.tushar.model.mysql")
				.properties(mapProperties)
				.build();
	}
	
	@Bean(name="mysqlTXmgr")
	public PlatformTransactionManager createTXmanager( @Qualifier("mysqlEMF" )EntityManagerFactory factory){
		return new JpaTransactionManager(factory);
	}

}
