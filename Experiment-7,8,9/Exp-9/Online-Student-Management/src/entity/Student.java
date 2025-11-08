package entity;

import javax.persistence.*;

@Entity
@Table(name="students")
public class Student {

    @Id
    private int student_id;

    private String name;
    private int balance;

    @ManyToOne
    @JoinColumn(name="course_id")
    private Course course;

    public Student() {}

    public Student(int student_id, String name, Course course, int balance) {
        this.student_id = student_id;
        this.name = name;
        this.course = course;
        this.balance = balance;
    }

    // Getters/Setters
}
