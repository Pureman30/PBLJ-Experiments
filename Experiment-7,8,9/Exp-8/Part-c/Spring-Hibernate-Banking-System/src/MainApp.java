import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.BankService;

public class MainApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppConfig.class);

        BankService service = ctx.getBean(BankService.class);

        System.out.println("Transferring 1000 from Acc 1 → Acc 2");
        service.transfer(1, 2, 1000);

        System.out.println("Transfer completed!");
    }
}
