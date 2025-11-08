package dao;

import entity.Student;
import java.util.List;

public interface StudentDao {
    void save(Student s);
    Student get(int id);
    List<Student> getAll();
    void update(Student s);
    void delete(int id);
}
