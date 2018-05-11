package byy.dao.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource(value = {"classpath:hibernate.cfg.properties"})
@ComponentScan(basePackages = "byy")
public class DataBaseConfig {

    @Value("${jdbc.driver}")
    private String driverName;

    @Value("${hibernate.dialect}")
    private String dialect;

    @Value("${hibernate.show_sql}")
    private String show_sql;

    @Value("${hibernate.format_sql}")
    private String format_sql;

    @Value("${hibernate.hbm2ddl.auto}")
    private String hbm2ddl_auto;

    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
       dataSource.setDriverClassName(driverName);
       // dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test" );
        dataSource.setUsername("root");
        dataSource.setPassword("");
        return dataSource;
    };

/*    @Bean
    public PropertyPlaceholderConfigurer placeholderConfigurer(){
        PropertyPlaceholderConfigurer placeholderConfigurer = new PropertyPlaceholderConfigurer();
        return placeholderConfigurer;
    }*/

    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan( new String[] {"byy.entity"});
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean
    public Properties hibernateProperties(){
        Properties properties = new Properties();
       /* properties.setProperty("hibernate.dialect",dialect);
        properties.setProperty("hibernate.show_sql",show_sql);
        properties.setProperty("hibernate.format_sql",format_sql);
        properties.setProperty("hibernate.hbm2ddl.auto",hbm2ddl_auto);*/
        properties.setProperty("hibernate.dialect","org.hibernate.dialect.MariaDB53Dialect");
        properties.setProperty("hibernate.show_sql","true");
        properties.setProperty("hibernate.format_sql","true");
        properties.setProperty("hibernate.hbm2ddl.auto","update");
        return properties;
    }
    @Bean
    public HibernateTransactionManager hibernateTransactionManager(SessionFactory sessionFactory){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }

}
