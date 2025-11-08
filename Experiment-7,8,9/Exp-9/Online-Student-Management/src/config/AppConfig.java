package config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import dao.*;
import service.*;

@Configuration
@EnableTransactionManagement
public class AppConfig {

    @Bean
    public SessionFactory sessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }

    @Bean
    public StudentDao studentDao() {
        return new StudentDaoImpl(sessionFactory());
    }

    @Bean
    public FeeService feeService() {
        return new FeeServiceImpl(studentDao(), sessionFactory());
    }
}
