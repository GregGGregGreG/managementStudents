package greg.studentProgress.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@EnableWebMvc
@EnableTransactionManagement
@EnableJpaRepositories("greg.studentProgress.persistence.repository")
@PropertySource({"classpath:persistence-mysql.properties"})
@ComponentScan("greg.studentProgress")
public class WebAppConfig extends WebMvcConfigurerAdapter {
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
    public DataSource restDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(Objects.requireNonNull(jDbcDriverClassName));
//        dataSource.setUrl(Objects.requireNonNull(jDbcUrl));
//        dataSource.setUsername(Objects.requireNonNull(jDbcUser));
//        dataSource.setPassword(Objects.requireNonNull(jDbcPass));
//        return dataSource;
        return new EmbeddedDatabaseBuilder()
                .setName("STUDENT_PROGRESS")
                .setType(EmbeddedDatabaseType.H2)
                .build();
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

    @Bean
    public UrlBasedViewResolver setupViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setPrefix("/WEB-INF/pages/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setCacheSeconds(0);
        return messageSource;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/pages/**").addResourceLocations("/WEB-INF/pages/");
    }

    @Bean
    public ResourceDatabasePopulator initDatabase(DataSource dataSource) throws Exception {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.setSqlScriptEncoding("UTF-8");
        populator.addScript(new ClassPathResource("sql/H2.sql"));
        populator.populate(dataSource.getConnection());
        return populator;
    }
}