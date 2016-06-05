package ua.kharkov.nure.sharaban.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import java.util.Properties;

@Configuration
@Import({ SpringMVCConfig.class })
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "ua.kharkov.nure.sharaban.persistence" })
@PropertySource("classpath:application.properties")
public class SpringApplicationConfig {

    @Value("${db.url}")
    private String dbUrl;

    @Value("${db.driverClassName}")
    private String dbDriverClassName;

    @Value("${db.username}")
    private String dbUsername;

    @Value("${db.password}")
    private String dbPassword;

    @Value("${hibernate.hbm2ddl.auto}")
    private String hibernateHbm2ddl;

    @Value("${hibernate.dialect}")
    private String hibernateDialect;

    @Bean
    public DataSource dataSource() {
        final DataSource dataSource = new DataSource();
        dataSource.setUrl(dbUrl);
        dataSource.setDriverClassName(dbDriverClassName);
        dataSource.setUsername(dbUsername);
        dataSource.setPassword(dbPassword);
        dataSource.setValidationQuery("SELECT 1");
        dataSource.setTestWhileIdle(true);
        dataSource.setTestOnBorrow(true);

        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws Exception {
        final LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setDataSource(dataSource());
        entityManager.setPersistenceUnitName("spring-jpa");
        entityManager.setJpaVendorAdapter(jpaVendorAdapter());
        entityManager.setPersistenceProvider(new HibernatePersistenceProvider());
        Properties jpaProperties = jpaProperties();
        for (Object key : jpaProperties.keySet()) {
            System.err.println("JPA: " + key + " = " + jpaProperties.get(key));
        }
        entityManager.setJpaProperties(jpaProperties);
        entityManager.setPackagesToScan("ua.kharkov.nure.sharaban.model");

        return entityManager;
    }

    @Bean
    public JpaTransactionManager transactionManager(DataSource dataSource, EntityManagerFactory emf) {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setDataSource(dataSource);
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    private Properties jpaProperties() throws Exception {
        Properties jpaProp = new Properties();
        jpaProp.put("hibernate.hbm2ddl.auto", hibernateHbm2ddl);
        jpaProp.put("hibernate.dialect", hibernateDialect);
        return jpaProp;
    }

    private HibernateJpaVendorAdapter jpaVendorAdapter() {
        final HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setGenerateDdl(true);
        return jpaVendorAdapter;
    }
}
