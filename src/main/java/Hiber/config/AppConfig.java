package Hiber.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import Hiber.Model.User;

import javax.sql.DataSource;
import java.util.Objects;
import java.util.Properties;

@Configuration
@PropertySource("classpath:db.prorerties")
@EnableTransactionManagement //Эта аннотация позволяет использовать аннотации
// @Transactional для обозначения методов,
// которые должны быть выполнены в рамках транзакции.
@ComponentScan(value = "Hiber")
public class AppConfig {

    @Autowired
    private Environment env;//для инъекции окружения или конфигурации,
    // чтобы можно было легко получать доступ к настройкам приложения из любой части кода.
    // Это обычно осуществляется с помощью
    // инверсии управления (Inversion of Control) и внедрения зависимостей (Dependency Injection)

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(Objects.requireNonNull(env.getProperty("db.driver")));
        //ся строка устанавливает имя JDBC драйвера, который будет использоваться для подключения к базе данных,
        // на основе значения, полученного из конфигурационного файла приложения.
        dataSource.setUrl(env.getProperty("db.url"));
        dataSource.setUsername(env.getProperty("db.username"));
        dataSource.setPassword(env.getProperty("db.password"));
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(getDataSource());

        Properties hibernateProperties = new Properties();//используется для хранения свойств конфигурации Hibernate,
        // таких как диалект базы данных, показывать ли SQL-запросы и другие настройки.
        hibernateProperties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        hibernateProperties.put("hibernate.hbm2bbl.auto", env.getProperty("hibernate.hbm2bbl.auto"));

        sessionFactory.setHibernateProperties(hibernateProperties);
        sessionFactory.setAnnotatedClasses(User.class);
        return sessionFactory;
    }
    @Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;
    }
}
