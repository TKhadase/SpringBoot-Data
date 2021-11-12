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
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.tushar.repo.OracleRepo",
													entityManagerFactoryRef = "orclEMF",
													transactionManagerRef = "orclTXmgr")
public class OracleConfig {
	
	@Bean
	@ConfigurationProperties(prefix ="orcl.datasource")
	@Primary
	public DataSource createOrclDS() {
		return  DataSourceBuilder.create().build();
	}
	
	@Bean(name="orclEMF")
	@Primary
	public LocalContainerEntityManagerFactoryBean createOracleLocalContainerEntityManagerFactoryBean(EntityManagerFactoryBuilder  emfBuilder) {
		Map<String, String> mapProperties = new HashMap();
		mapProperties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		mapProperties.put("hibernate.hbm2ddl.auto", "update");
		mapProperties.put("hibernate.show_sql", "true");
		return emfBuilder.dataSource(createOrclDS())
				.packages("com.tushar.model.oracle")
				.properties(mapProperties)
				.build();
	}
	
	@Bean(name="orclTXmgr")
	@Primary
	public PlatformTransactionManager createTXmanager( @Qualifier("orclEMF" )EntityManagerFactory factory){
		return new JpaTransactionManager(factory);
	}

}
