import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import config.AppConfig;
import dao.StudentDao;
import service.FeeService;
import entity.*;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppConfig.class);

        StudentDao dao = ctx.getBean(StudentDao.class);
        FeeService fs = ctx.getBean(FeeService.class);

        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("\n--- Student Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Pay Fees");
            System.out.println("4. Refund");
            System.out.println("5. Exit");

            int ch = sc.nextInt();

            if(ch == 1) {
                System.out.print("Enter ID: ");
                int id = sc.nextInt();
                System.out.print("Name: ");
                String name = sc.next();
                System.out.print("Course ID: ");
                int cid = sc.nextInt();
                System.out.print("Balance: ");
                int bal = sc.nextInt();

                Course c = new Course(cid, "Java", 6);
                Student s = new Student(id, name, c, bal);

                dao.save(s);
                System.out.println("Student Added!");

            } else if(ch == 2) {
                dao.getAll().forEach(s ->
                    System.out.println(s.getStudent_id()+" "+s.getName()+" "+s.getBalance())
                );

            } else if(ch == 3) {
                System.out.print("Student ID: ");
                int id = sc.nextInt();
                System.out.print("Amount: ");
                int amt = sc.nextInt();

                try {
                    fs.payFees(id, amt);
                    System.out.println("Payment Successful!");
                } catch (Exception e) {
                    System.out.println("Transaction Failed, Rolled back!");
                }

            } else if(ch == 4) {
                System.out.print("Student ID: ");
                int id = sc.nextInt();
                System.out.print("Refund Amount: ");
                int amt = sc.nextInt();

                fs.refund(id, amt);
                System.out.println("Refund Successful!");

            } else {
                System.out.println("Thank you!");
                break;
            }
        }
    }
}

