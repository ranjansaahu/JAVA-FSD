package org.cgi.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
public class HibernateConfig {

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/studentdb");
        dataSource.setUsername("ranjan");
        dataSource.setPassword("ranjan");
        return dataSource;
    }

    @Bean
    public Properties properties(){
        Properties properties = new Properties();
        properties.put("hibernate.show_sql","true");
        properties.put("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");
        properties.put("hibernate.hbm2ddl.auto","update");
        return properties;
    }


    @Bean
    @Autowired
    public SessionFactory sessionFactory(DataSource dataSource, Properties properties){

        LocalSessionFactoryBean factory = new LocalSessionFactoryBean();

        factory.setPackagesToScan("org.cgi.model");

        factory.setDataSource(dataSource);
        factory.setHibernateProperties(properties);

        try {
            factory.afterPropertiesSet();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return factory.getObject();
    }
}
