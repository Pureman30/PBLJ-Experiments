package entity;

import javax.persistence.*;

@Entity
@Table(name="courses")
public class Course {

    @Id
    private int course_id;

    private String course_name;
    private int duration;

    public Course() {}

    public Course(int course_id, String course_name, int duration) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.duration = duration;
    }
}
