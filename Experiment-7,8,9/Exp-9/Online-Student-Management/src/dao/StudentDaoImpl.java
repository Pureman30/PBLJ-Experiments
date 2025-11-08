package dao;

import entity.Student;
import org.hibernate.*;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    private SessionFactory sf;

    public StudentDaoImpl(SessionFactory sf) {
        this.sf = sf;
    }

    public void save(Student s) {
        sf.getCurrentSession().save(s);
    }

    public Student get(int id) {
        return sf.getCurrentSession().get(Student.class, id);
    }

    public List<Student> getAll() {
        return sf.getCurrentSession().createQuery("from Student").list();
    }

    public void update(Student s) {
        sf.getCurrentSession().update(s);
    }

    public void delete(int id) {
        Student s = get(id);
        sf.getCurrentSession().delete(s);
    }
}
