import javax.persistence.*;

@Entity
@Table(name="student")
public class Student {

    @Id
    private int id;

    @Column
    private String name;

    @Column
    private int marks;

    public Student() {}

    public Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Getters & Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getMarks() { return marks; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setMarks(int marks) { this.marks = marks; }
}
