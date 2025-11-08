package service;

import javax.transaction.Transactional;
import dao.StudentDao;
import entity.Student;
import org.hibernate.SessionFactory;

public class FeeServiceImpl implements FeeService {

    private StudentDao dao;
    private SessionFactory sf;

    public FeeServiceImpl(StudentDao dao, SessionFactory sf) {
        this.dao = dao;
        this.sf = sf;
    }

    @Transactional
    public void payFees(int studentId, int amount) {
        Student s = dao.get(studentId);

        if(s.getBalance() < amount)
            throw new RuntimeException("Insufficient balance");

        s.setBalance(s.getBalance() - amount);
        dao.update(s);
    }

    @Transactional
    public void refund(int studentId, int amount) {
        Student s = dao.get(studentId);
        s.setBalance(s.getBalance() + amount);
        dao.update(s);
    }
}
