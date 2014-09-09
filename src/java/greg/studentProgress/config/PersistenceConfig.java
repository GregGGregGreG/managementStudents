package greg.studentProgress.config;


import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Objects;
import java.util.Properties;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("greg.studentProgress.persistence.repository")
@PropertySource({"classpath:persistence-mysql.properties"})
@ComponentScan("greg.studentProgress.persistence")
public class PersistenceConfig {
    @Value("#{environment['jdbc.driverClassName']}")
    private String jDbcDriverClassName;
    @Value("#{environment['jdbc.url']}")
    private String jDbcUrl;
    @Value("#{environment['jdbc.user']}")
    private String jDbcUser;
    @Value("#{environment['jdbc.pass']}")
    private String jDbcPass;
    @Value("#{environment['hibernate.hbm2ddl.auto']}")
    private String jDbcHibernateHbm2ddlAuto;
    @Value("#{environment['hibernate.dialect']}")
    private String jDbcHibernateDialect;


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean sessionFactory = new LocalContainerEntityManagerFactoryBean();
        sessionFactory.setDataSource(restDataSource());
        sessionFactory.setPackagesToScan("greg.studentProgress");
        sessionFactory.setJpaVendorAdapter(jpaVendorAdapter());
        sessionFactory.setJpaProperties(jpaProperty());
        return sessionFactory;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        final LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(restDataSource());
        sessionFactory.setPackagesToScan("greg.studentProgress");
        sessionFactory.setHibernateProperties(jpaProperty());
        return sessionFactory;

    }


    @Bean
    public BasicDataSource restDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(Objects.requireNonNull(jDbcDriverClassName));
        dataSource.setUrl(Objects.requireNonNull(jDbcUrl));
        dataSource.setUsername(Objects.requireNonNull(jDbcUser));
        dataSource.setPassword(Objects.requireNonNull(jDbcPass));
        return dataSource;
    }

    private Properties jpaProperty() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", jDbcHibernateHbm2ddlAuto);
        hibernateProperties.setProperty("hibernate.dialect", jDbcHibernateDialect);
        return hibernateProperties;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return txManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    private HibernateJpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setDatabasePlatform(jDbcHibernateDialect);
        vendorAdapter.setShowSql(true);
        return vendorAdapter;
    }
}