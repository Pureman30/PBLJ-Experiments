import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
    public AccountDao accountDao() {
        return new AccountDaoImpl(sessionFactory());
    }

    @Bean
    public BankService bankService() {
        return new BankServiceImpl(accountDao());
    }
}
