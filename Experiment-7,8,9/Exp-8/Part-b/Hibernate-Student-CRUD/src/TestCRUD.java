import org.hibernate.*;
import java.util.List;

public class TestCRUD {

    public static void main(String[] args) {

        SessionFactory factory = HibernateUtil.getFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        // CREATE
        Student s1 = new Student(101, "Aayush", 85);
        session.save(s1);

        // READ
        Student s = session.get(Student.class, 101);
        System.out.println("Read: " + s.getName() + " - " + s.getMarks());

        // UPDATE
        s.setMarks(95);
        session.update(s);

        // DELETE
        Student del = session.get(Student.class, 101);
        session.delete(del);

        tx.commit();
        session.close();
        factory.close();
    }
}
